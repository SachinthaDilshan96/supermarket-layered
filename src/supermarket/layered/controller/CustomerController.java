/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.controller;

import java.util.ArrayList;
import supermarket.layered.dto.CustomerDto;
import supermarket.layered.service.ServiceFactory;
import supermarket.layered.service.custom.CustomerService;

/**
 *
 * @author sachinthadilshan
 */
public class CustomerController {
    
    CustomerService customerService =(CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public CustomerDto getCustomer(String customerID) throws Exception{
        return customerService.getCustomer(customerID);
    }
    
    public ArrayList<CustomerDto> getAllCustomers() throws Exception{
        return customerService.getAllCustomers();
    }
    
    public String addCustomer(CustomerDto customer) throws Exception{
        return customerService.addCustomer(customer);
    }
    
    public String updateCustomer(CustomerDto customer) throws Exception{
        return customerService.updateCustomer(customer);
    }
    
    public String deleteCustomer(String customerId) throws Exception{
        return customerService.deleteCustomer(customerId);
    }
    
    public String getLastId() throws Exception{
        return customerService.getLastId();
    }
   
}
