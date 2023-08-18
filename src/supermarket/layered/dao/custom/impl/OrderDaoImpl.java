/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.dao.custom.impl;

import java.util.ArrayList;
import supermarket.layered.dao.CrudUtil;
import supermarket.layered.dao.custom.OrderDao;
import supermarket.layered.entity.OrderEntity;
import java.sql.ResultSet;

/**
 *
 * @author sachinthadilshan
 */
public class OrderDaoImpl implements OrderDao{

    @Override
    public boolean add(OrderEntity t) throws Exception {
        return CrudUtil.executeUpdate("insert into orders values (?,?,?)", t.getId(),t.getDate(),t.getCustID());
    }

    @Override
    public boolean update(OrderEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrderEntity get(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OrderEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getLastID() throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("select orderid from orders order by orderid desc limit 1");
        if(resultSet.next()){
            return resultSet.getString(1);
        }else{
            return "D001";
        }
    }
    
}
