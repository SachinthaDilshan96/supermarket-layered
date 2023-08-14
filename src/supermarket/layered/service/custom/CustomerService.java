/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarket.layered.service.custom;

import java.util.ArrayList;
import supermarket.layered.dto.CustomerDto;
import supermarket.layered.service.SuperService;

/**
 *
 * @author sachinthadilshan
 */
public interface CustomerService extends SuperService{
    
    String addCustomer(CustomerDto customer) throws Exception;
    
    ArrayList<CustomerDto> getAllCustomers() throws Exception;
    
    CustomerDto getCustomer(String customerId) throws Exception;
    
    String updateCustomer(CustomerDto customer) throws Exception;
    
    String deleteCustomer(String customerId) throws Exception;

    String getLastId() throws Exception;
}
