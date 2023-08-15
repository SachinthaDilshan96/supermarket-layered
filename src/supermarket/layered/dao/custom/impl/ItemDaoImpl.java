/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.dao.custom.impl;

import java.util.ArrayList;
import supermarket.layered.entity.ItemEntity;
import supermarket.layered.dao.CrudUtil;
import java.sql.ResultSet;
import supermarket.layered.dao.custom.ItemDao;

public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean add(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("insert into item values (?,?,?,?,?)", t.getItemCode(),t.getDescription(),t.getPackSize(),t.getUnitPrice(),t.getQoh());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("update item set description=?,packsize=?,unitprice=?,qtyonhand=? where itemcode=?", t.getDescription(),t.getPackSize(),t.getUnitPrice(),t.getQoh(),t.getItemCode());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from item where itemcode=?", id);
    }

    @Override
    public ItemEntity get(String id) throws Exception {
        ResultSet results = CrudUtil.executeQuery("select * from item where itemcode=?",id);
        if(results.next()){
            return new ItemEntity(
                    results.getString(1),
                    results.getString(2),
                    results.getString(3),
                    results.getDouble(4),
                    results.getInt(5)
            );
        }else{
            return null;
        }
         
    }

    @Override
    public ArrayList<ItemEntity> getAll() throws Exception {
        ResultSet results = CrudUtil.executeQuery("select * from item");
        ArrayList<ItemEntity> items = new ArrayList<>();
        while(results.next()){
            items.add(new ItemEntity(
                    results.getString(1),
                    results.getString(2),
                    results.getString(3),
                    results.getDouble(4),
                    results.getInt(5)));
        }
        return items;
    }

    @Override
    public String getLastID() throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("select * from item order by itemcode desc limit 1");
        if(resultSet.next()){
            return resultSet.getString(1);
        }else{
            return "P001";
        }
    }
    
}
