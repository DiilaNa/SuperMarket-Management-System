/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gdse.pkg71.student.model;

import gdse.pkg71.student.db.DBConnection;
import gdse.pkg71.student.dto.Stdto;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class stModel {
    
    public ArrayList<Stdto> getAll() throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Stdetails";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<Stdto> StDtos = new ArrayList<>();
        
        while(rst.next()){
            Stdto stDto = new Stdto();
            stDto.setStudentId(rst.getString("id"));
            stDto.setName(rst.getString("name"));
            stDto.setEmail(rst.getString("email"));
            stDto.setDescription(rst.getString("description"));
            
            
            StDtos.add(stDto);
        }
        return StDtos;
    }
    
    public String save(Stdto dto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Stdetails VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getStudentId());
        statement.setString(2, dto.getName());
        statement.setString(3, dto.getEmail());
        statement.setString(4, dto.getDescription());
       
        
        int resp = statement.executeUpdate();
        return resp > 0 ? "Success" : "Fail";
        
    }
}