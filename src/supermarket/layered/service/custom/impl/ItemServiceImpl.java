/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.service.custom.impl;

import java.util.ArrayList;
import supermarket.layered.dto.ItemDto;
import supermarket.layered.service.custom.ItemService;
import supermarket.layered.dao.custom.ItemDao;
import supermarket.layered.dao.DaoFactory;
import supermarket.layered.entity.ItemEntity;

/**
 *
 * @author sachinthadilshan
 */
public class ItemServiceImpl implements ItemService {

    ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

    @Override
    public ItemDto getItem(String itemCode) throws Exception {
        ItemEntity itemEntity = itemDao.get(itemCode);
        return new ItemDto(
                itemEntity.getItemCode(),
                itemEntity.getDescription(),
                itemEntity.getPackSize(),
                itemEntity.getUnitPrice(),
                itemEntity.getQoh());
    }

    @Override
    public ArrayList<ItemDto> getItems() throws Exception {
        ArrayList<ItemEntity> items = itemDao.getAll();
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        for (ItemEntity i : items) {
            itemDtos.add(new ItemDto(
                    i.getItemCode(),
                    i.getDescription(),
                    i.getPackSize(),
                    i.getUnitPrice(),
                    i.getQoh()));
        }
        return itemDtos;
    }

    @Override
    public String addItem(ItemDto item) throws Exception {
        ItemEntity itemEntity = new ItemEntity(
                item.getItemCode(),
                item.getDescription(),
                item.getPackSize(),
                item.getUnitPrice(),
                item.getQoh()
        );
        if (itemDao.add(itemEntity)) {
            return "Item Saved Successfully";
        } else {
            return "Item Saving Failed";
        }
    }

    @Override
    public String updateItem(ItemDto item) throws Exception {
        ItemEntity itemEntity = new ItemEntity(
                item.getItemCode(),
                item.getDescription(),
                item.getPackSize(),
                item.getUnitPrice(),
                item.getQoh()
        );
        if(itemDao.update(itemEntity)){
            return "Item Updated Successfully";
        }else{
            return "Item Updating failed";
        }
    }

    @Override
    public String deleteItem(String id) throws Exception {
        if(itemDao.delete(id)){
            return "Item Deleted Successfully";
        }else{
            return "Item Deletion failed";
        }
    }

    @Override
    public String getLastItemId() throws Exception {
        return "P" + String.format("%03d", Integer.parseInt(itemDao.getLastID().substring(1)) + 1);
    }

}
