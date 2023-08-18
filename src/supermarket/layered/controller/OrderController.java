/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.controller;

import supermarket.layered.dto.OrderDto;
import supermarket.layered.service.ServiceFactory;
import supermarket.layered.service.custom.OrderService;

/**
 *
 * @author sachinthadilshan
 */
public class OrderController {
    
    private OrderService orderService =(OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
    
    public String placeOrder(OrderDto orderDto) throws Exception{
        //return orderService.placeOrder(orderDto);
        return orderService.placeOrder(orderDto);
    }
    
    public String getNewOrderID() throws Exception{
        return orderService.getNewOrderId();
    }
}
