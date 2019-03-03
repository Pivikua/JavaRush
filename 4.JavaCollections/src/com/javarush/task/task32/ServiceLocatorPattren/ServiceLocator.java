package com.javarush.task.task32.ServiceLocatorPattren;

public class ServiceLocator {
    private static Cache cache = new Cache();
    public static Service getService(String jndiName) {
        Service service = cache.getSecvice(jndiName);
        if (service != null) {
            return service;
        }
        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
}
