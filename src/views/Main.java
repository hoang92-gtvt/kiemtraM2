package views;

import controller.Manager;
import model.PhoneBook;
import storage.FileManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void showMenu() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ -----");
        System.out.println("Chọn chức năng theo số để tiếp tục");

        System.out.println("1. Xem Danh Sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm ");
        System.out.println("6. Đọc từ File ");
        System.out.println("7. Ghi file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng");

    }

    public static void main(String[] args) {
        Method method = new Method();

        String choice = "";
        do {
            showMenu();
            choice = new Scanner(System.in).nextLine();
            switch (choice) {
                case "1":
                    method.showPhoneBook();
                    break;
                case "2":
                    method.addPhone();
                    break;
                case "3":
                    method.upadtePhoneBookMenu();
                    break;
                case "4":
                    method.deletePhone();
                    break;
                case "5":

                    break;
                case "6":
                    method.getDataInFile();
                    break;
                case "7":
                    method.saveDataOutFile();
                    break;

                case "8":
                    System.exit(-1);
            }
        }while (true);

    }




}