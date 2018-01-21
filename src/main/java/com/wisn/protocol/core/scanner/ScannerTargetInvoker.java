package com.wisn.protocol.core.scanner;

import com.wisn.protocol.handle.SocketCmd;
import com.wisn.protocol.handle.SocketModule;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class ScannerTargetInvoker implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       // scanner(bean, beanName);
        return bean;
    }

    public void scanner(Object object, String beanName) {
        System.out.println("object:"+object+" beanName:"+beanName);
        Class<? extends Object> clazz = object.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println("interfaces:"+interfaces );
        if (interfaces != null && interfaces.length > 0) {
            for (Class<?> one : interfaces) {
                SocketModule socketModule = one.getAnnotation(SocketModule.class);
                System.out.println("socketModule:"+socketModule );

                if (socketModule == null) {
                    continue;
                }
                Method[] methods = one.getMethods();
                System.out.println("methods:"+methods );

                if (methods != null && methods.length > 0) {
                    for (Method method : methods) {
                        SocketCmd socketCmd = method.getAnnotation(SocketCmd.class);
                        System.out.println("socketCmd:"+socketCmd );

                        if (socketCmd == null) {
                            continue;
                        }
                        short module = socketModule.module();
                        short cmd = socketCmd.cmd();
                        System.out.println("module :"+module+" cmd"+ cmd);

                        Invoker invoker = InvokerHolder.getInvoker(module, cmd);
                        if (invoker == null) {
                            InvokerHolder.addInvoker(module, cmd, Invoker.valueOf(method, object));
                        } else {
                            System.out.println("重复beanName:" + beanName + " module" + module + " cmd" + cmd);
                        }
                    }
                }
            }
        }
    }
}
