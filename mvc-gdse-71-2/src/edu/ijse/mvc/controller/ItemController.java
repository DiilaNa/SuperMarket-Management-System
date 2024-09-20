/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.dto.ItemDto;
import edu.ijse.mvc.model.ItemModel;
import java.util.List;

/**
 *
 * @author User
 */
public class ItemController {
    private ItemModel customerModel = new ItemModel();

    public String saveItem(ItemDto itemDto) throws Exception {
        String resp = customerModel.saveItem(itemDto);
        return resp;
    }

    public String updateItem(ItemDto itemDto) throws Exception {
        String resp = customerModel.updateItem(itemDto);
        return resp;
    }

    public String deleteItem(String itemCode) throws Exception {
        String resp = customerModel.deleteItem(itemCode);
        return resp;
    }

    public ItemDto searchItem(String itemCode) throws Exception{
        ItemDto dto = customerModel.searchItem(itemCode);
        return dto;
    }

    public List<ItemDto> getAllItem() throws Exception{
        List<ItemDto> dtos = customerModel.getAllItem();
        return dtos;
    }
}
