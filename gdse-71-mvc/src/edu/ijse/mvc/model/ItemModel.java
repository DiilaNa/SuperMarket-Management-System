/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.ItemDto;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dilan
 */
public class ItemModel {
    
    public ArrayList<ItemDto> getAll() throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        
        while(rst.next()){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemCode(rst.getString("ItemCode"));
            itemDto.setDescription(rst.getString("Description"));
            itemDto.setPackSize(rst.getString("PackSize"));
            itemDto.setUnitPrice(rst.getDouble("UnitPrice"));
            itemDto.setQoh(rst.getInt("QtyOnHand"));
            
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
    
    public String save(ItemDto dto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getItemCode());
        statement.setString(2, dto.getDescription());
        statement.setString(3, dto.getPackSize());
        statement.setDouble(4, dto.getUnitPrice());
        statement.setInt(5, dto.getQoh());
        
        int resp = statement.executeUpdate();
        return resp > 0 ? "Success" : "Fail";
        
    }
     public ItemDto getItem(String itemCode) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemCode);
        
        ResultSet rst = statement.executeQuery();
        
        if(rst.next()){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemCode(rst.getString("ItemCode"));
            itemDto.setDescription(rst.getString("Description"));
            itemDto.setPackSize(rst.getString("PackSize"));
            itemDto.setUnitPrice(rst.getDouble("UnitPrice"));
            itemDto.setQoh(rst.getInt("QtyOnHand"));
            
            return itemDto;
        }
        return null;
    }  
    public String updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
    Connection connection = DBConnection.getInstance().getConnection();
    String updateSql = "UPDATE Item SET Description = ? , PackSize = ? , UnitPrice = ? , QtyOnHand = ? WHERE ItemCode = ? ";
    PreparedStatement updateStatement = connection.prepareStatement(updateSql);
    updateStatement.setString(1, dto.getDescription());
    updateStatement.setString(2, dto.getPackSize());
    updateStatement.setDouble(3, dto.getUnitPrice());
    updateStatement.setInt(4, dto.getQoh());
    updateStatement.setString(5, dto.getItemCode());
    
    int resp = updateStatement.executeUpdate();
    return resp > 0 ? "Success" : "Fail";

    }
    public String deleteItem(ItemDto dto) throws SQLException, ClassNotFoundException {
    Connection connection = DBConnection.getInstance().getConnection();
    String updateSql = "DELETE FROM Item WHERE ItemCode = ? ";
    PreparedStatement statement = connection.prepareStatement(updateSql);
    statement.setString(1, dto.getItemCode());
   
    
    int resp = statement.executeUpdate();
    return resp > 0 ? "Success" : "Fail";

    }      
}