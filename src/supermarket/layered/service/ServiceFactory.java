/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.service;

import supermarket.layered.service.custom.impl.CustomerServiceImpl;
import supermarket.layered.service.custom.impl.ItemServiceImpl;
import supermarket.layered.service.custom.impl.OrderDetailServiceImpl;
import supermarket.layered.service.custom.impl.OrderServiceImpl;

/**
 *
 * @author sachinthadilshan
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType serviceType) {
        switch (serviceType) {
            case CUSTOMER:
               return new CustomerServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            case ORDER:
                return new OrderServiceImpl();
            case ORDER_DETAIL:
                return new OrderDetailServiceImpl();
            default:
                return null;
                
        }
    }

    public enum ServiceType {
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }
}
