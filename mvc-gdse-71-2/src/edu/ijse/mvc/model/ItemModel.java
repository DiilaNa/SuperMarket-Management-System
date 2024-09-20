/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.ItemDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ItemModel {
    public String saveItem(ItemDto itemDto) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, itemDto.getItemCode());
        statement.setString(2, itemDto.getDescription());
        statement.setString(3, itemDto.getPackSize());
        statement.setDouble(4, itemDto.getUnitPrice());
        statement.setInt(5, itemDto.getQoh());

        int result = statement.executeUpdate();
        return result > 0 ? "Successfully Saved" : "Fail";
    }
    
    public String updateItem(ItemDto itemDto) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Item SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, itemDto.getDescription());
        statement.setString(2, itemDto.getPackSize());
        statement.setDouble(3, itemDto.getUnitPrice());
        statement.setInt(4, itemDto.getQoh());
        statement.setString(5, itemDto.getItemCode());

        int result = statement.executeUpdate();
        return result > 0 ? "Successfully Updated" : "Fail";
    }
    
    public String deleteItem(String itemCode) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, itemCode);

        int result = statement.executeUpdate();
        return result > 0 ? "Successfully Deleted" : "Fail";
    }
    
    public ItemDto searchItem(String itemCode) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemCode);

        ResultSet rst = statement.executeQuery();
        if(rst.next()){
            ItemDto dto = new ItemDto(rst.getString(1),
                rst.getString(2), rst.getString(3),
                rst.getDouble(4), rst.getInt(5));

            return  dto;
        }

        return null;
    }

    public List<ItemDto> getAllItem() throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        PreparedStatement statement = connection.prepareStatement(sql);

        List<ItemDto> itemDtos = new ArrayList<>();

        ResultSet rst = statement.executeQuery();
        while(rst.next()){
            ItemDto dto = new ItemDto(rst.getString(1),
                rst.getString(2), rst.getString(3),
                rst.getDouble(4), rst.getInt(5));
            
            itemDtos.add(dto);
        }

        return itemDtos;
    }
}
