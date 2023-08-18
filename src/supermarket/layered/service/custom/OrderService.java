/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarket.layered.service.custom;

import supermarket.layered.dto.OrderDto;
import supermarket.layered.service.SuperService;

/**
 *
 * @author sachinthadilshan
 */
public interface OrderService extends SuperService{
    
    public String placeOrder(OrderDto orderDto) throws Exception;
    
    public String getNewOrderId() throws Exception;
}
