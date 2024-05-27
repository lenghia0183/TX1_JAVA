/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lecongnghia_tx1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Product {

    static Scanner scanner = new Scanner(System.in);

    protected static final String DEFAULT_PRODUCT_ID = "default_id";
    protected static final String DEFAULT_PRODUCT_NAME = "default_name";
    protected static final double DEFAULT_PRODUCT_PRICE = 0.0;
    protected static final int DEFAULT_PRODUCT_TOTAL = 0;

    protected String product_id;
    protected String product_name;
    protected double product_price;
    protected int product_total;

    // get set method
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getProduct_total() {
        return product_total;
    }

    public void setProduct_total(int product_total) {
        this.product_total = product_total;
    }

    // contructor method
    public Product(String product_id, String product_name, double product_price, int product_total) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_total = product_total;
    }

    public Product() {
        this(DEFAULT_PRODUCT_ID, DEFAULT_PRODUCT_NAME, DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_TOTAL);
    }

    //toString method
    @Override
    public String toString() {
        return "product_id= " + product_id + ", product_name= " + product_name + ", product_price= " + product_price + ", product_total= " + product_total;
    }

    // input method
    public void input() {

        System.out.print("Nhâp ID: ");
        this.product_id = scanner.nextLine();

        System.out.print("Nhâp tên: ");
        this.product_name = scanner.nextLine();

        System.out.print("Nhập giá: ");
        this.product_price = scanner.nextDouble();

        System.out.print("Nhập tổng tiền: ");
        this.product_total = scanner.nextInt();
    }
}
