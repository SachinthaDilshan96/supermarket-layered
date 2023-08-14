/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.dao.custom.impl;

import java.util.ArrayList;
import supermarket.layered.dao.CrudUtil;
import supermarket.layered.dao.custom.CustomerDao;
import supermarket.layered.entity.CustomerEntity;
import java.sql.ResultSet;

/**
 *
 * @author sachinthadilshan
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean add(CustomerEntity customerEntity) throws Exception {
        return CrudUtil.executeUpdate(
                "insert into customer values (?,?,?,?,?,?,?,?,?)",
                customerEntity.getId(),
                customerEntity.getTitle(),
                customerEntity.getName(),
                customerEntity.getDob(),
                customerEntity.getSalary(),
                customerEntity.getAddress(),
                customerEntity.getCity(),
                customerEntity.getProvince(),
                customerEntity.getZip());
    }

    @Override
    public boolean update(CustomerEntity customerEntity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String customerId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("select * from customer where custid = ?", id);
        if(resultSet.next()){
            return new CustomerEntity(
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getString(4),
            resultSet.getDouble(5),
            resultSet.getString(6),
            resultSet.getString(7),
            resultSet.getString(8),
            resultSet.getString(9));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("select * from customer");
        ArrayList<CustomerEntity> customers = new ArrayList<>();
        while(resultSet.next()){
            CustomerEntity customer = new CustomerEntity(
                       resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)                                      
            );
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public String getLastID() throws Exception {
            ResultSet resultSet = CrudUtil.executeQuery("select custid from customer order by custid desc limit 1");
            if(resultSet.next()){
                return resultSet.getString(1);
            }else{
                return "C001";
            }
           
    }


  
}
