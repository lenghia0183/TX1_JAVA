/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lecongnghia_tx1;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LeCongNghia_TX1 {

    static Scanner scanner = new Scanner(System.in);
    static TourManagerImp1 listTour = new TourManagerImp1();

    private static String showSearchMenu() {
        System.out.println("=== Chọn thuộc tính để tìm kiếm ===");
        System.out.println("1. Tên sản phẩm");
        System.out.println("2. Giá sản phẩm");
        System.out.println("3. Điểm đến");
        System.out.println("4. Số ngày");
        System.out.println("5. Loại tour");
        System.out.print("Chọn thuộc tính: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return "product_name";
            case 2:
                return "product_price";
            case 3:
                return "tour_destination";
            case 4:
                return "tour_duration";
            case 5:
                return "tour_type";
            default:
                System.err.println("Lựa chọn không hợp lệ.");
                return null;
        }
    }

    public static void runMenu() {
        boolean isRunning = true;
        while (isRunning) {
            // Hiển thị menu chính
            System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm tour mới");
            System.out.println("2. Chỉnh sửa thông tin tour");
            System.out.println("3. Xóa tour");
            System.out.println("4. Tìm kiếm tour");
            System.out.println("5. Sắp xếp tour");
            System.out.println("6. In danh sách tour");
            System.out.println("7. Thoát");

            // Nhập lựa chọn từ người dùng
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            Tour tour = new Tour();
            switch (choice) {
                case 1:
                    listTour.addTour(tour);
                    break;
                case 2:
                    listTour.editTour(tour);
                    break;
                case 3:
                    listTour.delTour(tour);
                    break;
                case 4:
                    String searchBy = showSearchMenu();
                    if (searchBy != null) {
                        List<Tour> searchResult = listTour.searchTour(searchBy);
                        if (!searchResult.isEmpty()) {
                            System.out.println("Kết quả tìm kiếm:");
                            for (Tour t : searchResult) {
                                System.out.println(t);
                            }
                        } else {
                            System.out.println("Không tìm thấy kết quả nào.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("=== Chọn cách sắp xếp ===");
                    System.out.println("1. Sắp xếp tăng dần theo giá");
                    System.out.println("2. Sắp xếp giảm dần theo giá");
                    System.out.print("Chọn cách sắp xếp: ");
                    int sortChoice = scanner.nextInt();
                    switch (sortChoice) {
                        case 1:
                            // Thực hiện sắp xếp tăng dần theo giá
                            listTour.sortedTour(1);
                            break;
                        case 2:
                            // Thực hiện sắp xếp giảm dần theo giá
                            listTour.sortedTour(0);
                            break;
                        default:
                            System.err.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                    break;
                case 6:
                    listTour.printTours();
                    break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void main(String[] args) {
        // Sử dụng UTF-8 encoding cho việc in ra console
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        runMenu();
    }
}
