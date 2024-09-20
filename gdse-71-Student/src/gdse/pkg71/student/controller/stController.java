/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gdse.pkg71.student.controller;

import gdse.pkg71.student.dto.Stdto;
import gdse.pkg71.student.model.stModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anjan
 */
public class stController {
    
    private final stModel ST_MODEL;

    public stController() {
        this.ST_MODEL = new stModel();
    }
    
    public ArrayList<Stdto> getAllItems() throws SQLException, ClassNotFoundException{
        ArrayList<Stdto> StDtos = ST_MODEL.getAll();
        return StDtos;
    }
     public String saveItem(Stdto stDto) throws SQLException, ClassNotFoundException{
        String resp = ST_MODEL.save(stDto);
        return resp;
    }
}