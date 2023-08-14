/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.dao.custom;

import java.util.ArrayList;
import supermarket.layered.dao.CrudDao;
import supermarket.layered.entity.CustomerEntity;

/**
 *
 * @author sachinthadilshan
 */
public interface CustomerDao extends CrudDao<CustomerEntity, String>{
    
    boolean add(CustomerEntity customerEntity) throws Exception;

    boolean update(CustomerEntity customerEntity) throws Exception;
    
    boolean delete(String customerId) throws Exception;
    
    CustomerEntity get(String customerId)throws Exception;
    
    ArrayList<CustomerEntity> getAll() throws Exception;
    
    String getLastID() throws Exception;
    
}
