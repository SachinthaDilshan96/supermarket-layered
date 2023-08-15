/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.service.custom;
import java.util.ArrayList;
import supermarket.layered.dto.ItemDto;
import supermarket.layered.service.SuperService;
/**
 *
 * @author sachinthadilshan
 */
public interface ItemService extends SuperService{
    
    ItemDto getItem(String itemCode) throws Exception;
    
    ArrayList<ItemDto> getItems()throws Exception;
    
    String addItem(ItemDto item)throws Exception;
    
    String updateItem(ItemDto item)throws Exception;
    
    String deleteItem(String id)throws Exception;
    
    String getLastItemId()throws Exception;
}
