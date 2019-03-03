package com.javarush.task.task32.ServiceLocatorPattren;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private List<Service> services = new ArrayList<>();

    public  Service getSecvice(String serviceName) {
        for (Service service :services) {
            if(service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached " + serviceName + " object.");
                return service;
            }
        }
        return null;
    }

    public void addService(Service newService) {
        boolean exists = false;
        for (Service service :services) {
            if(service.getName().equalsIgnoreCase(newService.getName())) {
                exists = true;
            }
        }
        if (!exists) {
            services.add(newService);
        }
    }
}
