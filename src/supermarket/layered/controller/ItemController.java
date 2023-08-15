/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.controller;

import java.util.ArrayList;
import supermarket.layered.dto.ItemDto;
import supermarket.layered.service.ServiceFactory;
import supermarket.layered.service.custom.ItemService;

/**
 *
 * @author sachinthadilshan
 */
public class ItemController {
    
    private ItemService itemService =(ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);
    
    public ItemDto getItem(String itemCode) throws Exception{
       return itemService.getItem(itemCode);
    }
    
    public ArrayList<ItemDto> getItems() throws Exception{
        return itemService.getItems();
    }
    
    public String addItem(ItemDto item) throws Exception{
        return itemService.addItem(item);
    }
    
    public String updateItem(ItemDto item) throws Exception{
        return itemService.updateItem(item);
    }
    
    public String deleteItem(String id) throws Exception{
        return itemService.deleteItem(id);
    }
    
    public String getLastItemId() throws Exception{
        return itemService.getLastItemId();
    }
}
