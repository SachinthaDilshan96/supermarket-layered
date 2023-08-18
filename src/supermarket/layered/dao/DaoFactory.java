/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.dao;

import supermarket.layered.dao.custom.impl.ItemDaoImpl;
import supermarket.layered.dao.custom.impl.CustomerDaoImpl;
import supermarket.layered.dao.custom.impl.OrderDaoImpl;
import supermarket.layered.dao.custom.impl.OrderDetailDaoImpl;

/**
 *
 * @author sachinthadilshan
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoType daoType) {
        switch (daoType) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAIL:
                return new OrderDetailDaoImpl();
            default:
                return null;
        }
    }

    public enum DaoType {
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }
}
