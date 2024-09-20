/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.dto;

/**
 *
 * @author dilan
 */
public class OrderDetailDto {
    private String ItemCode;
    private int Qty;
    private double Discount;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String ItemCode, int Qty, double Discount) {
        this.ItemCode = ItemCode;
        this.Qty = Qty;
        this.Discount = Discount;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    @Override
    public String toString() {
        return "OrderDetailDtos{" + "ItemCode=" + ItemCode + ", Qty=" + Qty + ", Discount=" + Discount + '}';
    }
    

}