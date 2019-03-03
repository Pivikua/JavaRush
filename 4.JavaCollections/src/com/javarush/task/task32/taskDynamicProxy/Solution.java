package com.javarush.task.task32.taskDynamicProxy;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

public class Solution {
    public static void main(String[] args) throws IOException {
        CustomInvocationHandler customInvocationHandler = new CustomInvocationHandler();
        Class[] classes = new Class[] {Comparable.class, Callable.class};
        Reader reader = (Reader)Proxy.newProxyInstance(null, classes, customInvocationHandler);
        reader.close();
    }
    static class CustomInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("yes!");
            return null;
        }
    }
}
