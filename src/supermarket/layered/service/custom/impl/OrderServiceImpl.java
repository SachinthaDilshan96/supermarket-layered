/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.service.custom.impl;

import supermarket.layered.dao.DaoFactory;
import supermarket.layered.dao.custom.ItemDao;
import supermarket.layered.dao.custom.OrderDao;
import supermarket.layered.dao.custom.OrderDetailDao;
import supermarket.layered.dto.OrderDto;
import supermarket.layered.service.custom.OrderService;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import supermarket.layered.db.DBConnection;
import supermarket.layered.dto.OrderDetailDto;
import supermarket.layered.entity.ItemEntity;
import supermarket.layered.entity.OrderDetailEntity;
import supermarket.layered.entity.OrderEntity;

/**
 *
 * @author sachinthadilshan
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

    @Override
    public String placeOrder(OrderDto orderDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (orderDao.add(new OrderEntity(orderDto.getOrderId(), sdf.format(new Date()), orderDto.getCustomerId()))) {
                boolean isOrderSaved = true;
                for (OrderDetailDto dto : orderDto.getOrderDetailDtos()) {
                    if (!orderDetailDao.add(new OrderDetailEntity(
                            orderDto.getOrderId(),
                            dto.getItemId(),
                            dto.getQty(),
                            dto.getDiscount()))) {
                        isOrderSaved = false;
                    }
                }
                if (isOrderSaved) {
                    boolean isItemUpdated = true;
                    for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()) {
                        ItemEntity entity = itemDao.get(orderDetailDto.getItemId()); 
                        entity.setQoh(entity.getQoh() - orderDetailDto.getQty());
                        if (!itemDao.update(entity)) {
                            isItemUpdated = false;
                        }
                    }
                    if (isItemUpdated) {
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Transaction Failed";
                    }
                } else {
                    connection.rollback();
                    return "Order Details Save Error";
                }
            } else {
                connection.rollback();
                return "Order Saving Failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }

    }

    @Override
    public String getNewOrderId() throws Exception {
        return "D" + String.format("%03d", Integer.parseInt(orderDao.getLastID().substring(1)) + 1);
    }

}
