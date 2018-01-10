package com.wisn.protocol.core.scanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invoker {
    private Method method;
    private Object target;

    public static Invoker valueOf(Method method, Object object) {
        Invoker invoker = new Invoker();
        invoker.setMethod(method);
        invoker.setTarget(object);
        return invoker;
    }

    public Object invoke(Object... paramValues) {
        try {
            return method.invoke(target, paramValues);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Invoker{" +
                "method=" + method +
                ", target=" + target +
                '}';
    }
}
