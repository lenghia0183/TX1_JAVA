/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lecongnghia_tx1;

/**
 *
 * @author Admin
 */
public class Tour extends Product {

    private static final String DEFAULT_TOUR_DESTINATION = "default_tour_destination";
    private static final int DEFAULT_TOUR_DURATION = 0;
    private static final String DEFAULT_TOUR_TYPE = "default_tour_type";

    private String tour_destination;
    private int tour_duration;
    private String tour_type;

    // get set method
    public String getTour_destination() {
        return tour_destination;
    }

    public void setTour_destination(String tour_destination) {
        this.tour_destination = tour_destination;
    }

    public int getTour_duration() {
        return tour_duration;
    }

    public void setTour_duration(int tour_duration) {
        this.tour_duration = tour_duration;
    }

    public String getTour_type() {
        return tour_type;
    }

    public void setTour_type(String tour_type) {
        this.tour_type = tour_type;
    }

    // contructor
    public Tour(String tour_destination, int tour_duration, String tour_type, String product_id, String product_name, double product_price, int product_total) {
        super(product_id, product_name, product_price, product_total);
        this.tour_destination = tour_destination;
        this.tour_duration = tour_duration;
        this.tour_type = tour_type;
    }

    public Tour() {
        this(DEFAULT_TOUR_DESTINATION, DEFAULT_TOUR_DURATION, DEFAULT_TOUR_TYPE, DEFAULT_PRODUCT_ID, DEFAULT_PRODUCT_NAME, DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_TOTAL);

    }

    @Override
    public String toString() {
        return "Tour{" + super.toString() + ", tour_destination= " + tour_destination + ", tour_duration= " + tour_duration + ", tour_type= " + tour_type + '}';
    }

    //input method
    @Override
    public void input() {
        super.input();

        scanner.nextLine();
        System.out.print("Nhập điểm đến: ");
        this.tour_destination = scanner.nextLine();

        System.out.print("Nhập số ngày của tour: ");
        this.tour_duration = scanner.nextInt();

         scanner.nextLine(); 
        System.out.print("Nhập kiểu tour: ");
        this.tour_type = scanner.nextLine();

    }

}
