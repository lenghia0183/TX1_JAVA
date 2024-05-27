/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lecongnghia_tx1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class TourManagerImp1 implements TourManager {

    static Scanner scanner = new Scanner(System.in);
    private List<Tour> tours = new ArrayList<>();

    @Override
    public boolean addTour(Tour t) {
        // Nhập thông tin cho tour mới
        System.out.println("Nhập thông tin cho tour mới:");
        t.input();

        // Kiểm tra xem tour đã tồn tại trong danh sách hay chưa
        boolean isExisted = false;
        for (Tour tour : tours) {
            if (tour.getProduct_id().equals(t.getProduct_id())) {
                isExisted = true;
                break;
            }
        }

        // Nếu tour không tồn tại, thêm vào danh sách và trả về true
        if (!isExisted) {
            tours.add(t);
            System.out.println("Tour đã được thêm vào danh sách thàng công.");
            return true;
        } else {
            System.err.println("Tour đã tồn tại trong danh sách.");
            return false;
        }
    }

    @Override
    public boolean editTour(Tour t) {

        // Nhập thông tin cho tour cần chỉnh sửa
        System.out.print("Nhập id của tour cần sửa: ");
        String editTourID = scanner.nextLine();

        // Kiểm tra xem tour có tồn tại trong danh sách hay không
        boolean isExisted = false;
        for (Tour tour : tours) {
            if (tour.getProduct_id().equals(editTourID)) {
                isExisted = true;
                // Nếu tour tồn tại, yêu cầu người dùng nhập lại thông tin cho tour
                System.out.println("Nhập thông tin mới cho tour");
                t.input();
                // Cập nhật thông tin cho tour trong danh sách
                tours.set(tours.indexOf(tour), t);
                System.out.println("Tour đã được sửa thành công");
                break;
            }
        }

        // Nếu tour không tồn tại, thông báo và không thực hiện chỉnh sửa
        if (!isExisted) {
            System.err.println("Tour không tồn tại trong danh sách.");
        }

        return isExisted;

    }

    @Override
    public boolean delTour(Tour t) {
//        scanner.nextLine();

        // Nhập ID của tour cần xóa
        System.out.print("Nhập ID của tour cần xóa: ");
        String delTourID = scanner.nextLine();

        // Kiểm tra xem tour có tồn tại trong danh sách hay không
        boolean isExisted = false;
        for (Tour tour : tours) {
            if (tour.getProduct_id().equals(delTourID)) {
                isExisted = true;
                // Nếu tour tồn tại, xóa nó khỏi danh sách
                tours.remove(tour);
                System.out.println("Tour đã được xóa khỏi danh sách.");
                break;
            }
        }

        // Nếu tour không tồn tại, thông báo và không thực hiện xóa
        if (!isExisted) {
            System.err.println("Tour không tồn tại trong danh sách.");
        }

        return isExisted;
    }

    @Override
    public List<Tour> searchTour(String name) {
        List<Tour> result = new ArrayList<>();
        // Khai báo biến để lưu giá trị cần tìm kiếm
        String value;

        // Yêu cầu người dùng nhập giá trị cần tìm kiếm dựa trên thuộc tính được chọn
        switch (name) {
            case "product_name":
                System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
                break;
            case "product_price":
                System.out.print("Nhập giá sản phẩm cần tìm kiếm: ");
                break;
            case "tour_destination":
                System.out.print("Nhập điểm đến của tour cần tìm kiếm: ");
                break;
            case "tour_duration":
                System.out.print("Nhập số ngày của tour cần tìm kiếm: ");
                break;
            case "tour_type":
                System.out.print("Nhập loại tour cần tìm kiếm: ");
                break;
            default:
                System.err.println("Thuộc tính không hợp lệ.");
                return result;
        }

        // Nhận giá trị cần tìm kiếm từ người dùng
        value = scanner.nextLine();

        // Duyệt qua danh sách các tour
        for (Tour tour : tours) {
            // Kiểm tra xem thuộc tính cần tìm kiếm có chứa thông tin cần tìm không
            switch (name) {
                case "product_name":
                    if (tour.getProduct_name().toLowerCase().contains(value.toLowerCase())) {
                        result.add(tour);
                    }
                    break;
                case "product_price":
                    if (Double.toString(tour.getProduct_price()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(tour);
                    }
                    break;
                case "tour_destination":
                    if (tour.getTour_destination().toLowerCase().contains(value.toLowerCase())) {
                        result.add(tour);
                    }
                    break;
                case "tour_duration":
                    if (Integer.toString(tour.getTour_duration()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(tour);
                    }
                    break;
                case "tour_type":
                    if (tour.getTour_type().toLowerCase().contains(value.toLowerCase())) {
                        result.add(tour);
                    }
                    break;
                default:
                    System.err.println("Thuộc tính không hợp lệ.");
            }
        }

        return result;
    }

    @Override
    public List<Tour> sortedTour(double price) {
        Comparator<Tour> comparator;

        // Nếu price == 0, sắp xếp giảm dần, ngược lại sắp xếp tăng dần
        if (price == 0) {
            comparator = Comparator.comparingDouble(Tour::getProduct_price).reversed();
        } else {
            comparator = Comparator.comparingDouble(Tour::getProduct_price);
        }

        // Sắp xếp danh sách tour bằng Comparator đã tạo
        tours.sort(comparator);

        // Trả về danh sách tour đã sắp xếp
        return tours;

    }

    @Override
   public void printTours() {
    if (tours.isEmpty()) {
        System.out.println("Không có tour nào trong danh sách.");
    } else {
        System.out.println("Danh sách các tour:");
        System.out.println("+-----------+----------------------+---------------+------------+----------------+--------------+");
        System.out.println("|   ID      |      Tên sản phẩm    |   Giá         | Số lượng   |  Điểm đến     |   Thời gian  |");
        System.out.println("+-----------+----------------------+---------------+------------+----------------+--------------+");
        for (Tour tour : tours) {
            String formattedString = String.format("| %-10s| %-21s| %-14.2f| %-11d| %-14s| %-12d|",
                    tour.getProduct_id(), tour.getProduct_name(), tour.getProduct_price(), tour.getProduct_total(), tour.getTour_destination(), tour.getTour_duration());
            System.out.println(formattedString);
        }
        System.out.println("+-----------+----------------------+---------------+------------+----------------+--------------+");
    }
}

}
