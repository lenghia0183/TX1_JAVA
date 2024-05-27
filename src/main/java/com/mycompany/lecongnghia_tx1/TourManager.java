/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.lecongnghia_tx1;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface TourManager {

    boolean addTour(Tour t);

    boolean editTour(Tour t);

    boolean delTour(Tour t);

    List<Tour> searchTour(String name);

    List<Tour> sortedTour(double price);
    
    void printTours();
}
