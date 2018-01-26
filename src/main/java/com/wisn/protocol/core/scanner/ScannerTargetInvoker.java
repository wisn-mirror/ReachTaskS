package com.wisn.protocol.core.scanner;

import com.wisn.protocol.handle.SocketCmd;
import com.wisn.protocol.handle.SocketModule;
import com.wisn.tools.LogUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class ScannerTargetInvoker implements BeanPostProcessor {
    public static final String TAG="ScannerTargetInvoker";
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        scanner(bean, beanName);
        return bean;
    }

    public void scanner(Object object, String beanName) {
        LogUtils.d(TAG,"object:"+object+" beanName:"+beanName);
        Class<? extends Object> clazz = object.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();
      LogUtils.d(TAG,"interfaces:"+interfaces );
        if (interfaces != null && interfaces.length > 0) {
            for (Class<?> one : interfaces) {
                SocketModule socketModule = one.getAnnotation(SocketModule.class);
              LogUtils.d(TAG,"socketModule:"+socketModule );

                if (socketModule == null) {
                    continue;
                }
                Method[] methods = one.getMethods();
              LogUtils.d(TAG,"methods:"+methods );

                if (methods != null && methods.length > 0) {
                    for (Method method : methods) {
                        SocketCmd socketCmd = method.getAnnotation(SocketCmd.class);
                      LogUtils.d(TAG,"socketCmd:"+socketCmd );

                        if (socketCmd == null) {
                            continue;
                        }
                        short module = socketModule.module();
                        short cmd = socketCmd.cmd();
                      LogUtils.d(TAG,"module :"+module+" cmd"+ cmd);

                        Invoker invoker = InvokerHolder.getInvoker(module, cmd);
                        if (invoker == null) {
                            InvokerHolder.addInvoker(module, cmd, Invoker.valueOf(method, object));
                        } else {
                          LogUtils.d(TAG,"重复beanName:" + beanName + " module" + module + " cmd" + cmd);
                        }
                    }
                }
            }
        }
    }
}
