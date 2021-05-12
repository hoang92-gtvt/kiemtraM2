package views;

import controller.Manager;
import model.PhoneBook;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Method {
    private ArrayList<PhoneBook> phoneBooks;
    private Scanner scanner = new Scanner(System.in);
    FileManager<PhoneBook> fileManager = FileManager.getInstance();
    private static final String phoneBookList= "phoneBookList.csv";
    Manager manager = new Manager();



    public void showPhoneBook(){
        for (PhoneBook p: phoneBooks
        ) {
            System.out.println(p);
        }
    }

    public String createPhoneNumber(){
        System.out.println("mời nhập số điện thoại");
        String phoneNumber = scanner.nextLine();
        return phoneNumber;

    }
    public String createGroup(){
        System.out.println("mời nhập nhóm danh bạ ví dụ: gia đình, công việc");
        String group = scanner.nextLine();
        return group;
    }
    public String createFullName(){
        System.out.println("mời nhập họ tên");
        String fullName = scanner.nextLine();
        return fullName;
    }
    public String createGender(){
        System.out.println("mời nhập giới tính");
        String gender = scanner.nextLine();
        return gender;
    }
    public String createAddress(){
        System.out.println("mời nhập địa chỉ");
        String address = scanner.nextLine();
        return address;
    }
    public String createDoB(){
        System.out.println("mời nhập ngày sinh");
        String dateOfBirth = scanner.nextLine();
        return dateOfBirth;
    }
    public String createEmail(){
        System.out.println("mời nhập Email");
        String email = scanner.nextLine();
        return email;
    }
    public void addPhone(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setPhoneNumber(createPhoneNumber());
        phoneBook.setGroup(createGroup());
        phoneBook.setFullName(createFullName());
        phoneBook.setGender(createGender());
        phoneBook.setAddress(createAddress());
        phoneBook.setDateOfBirth(createDoB());
        phoneBook.setEmail(createEmail());
        manager.add(phoneBook);
    }




    public void deletePhone(){
        PhoneBook phoneBook = getPhoneByPhoneNumber();
        System.out.println("Nhấn Y để xoá hoặc phím bất kỳ để thoát");
        String choose = scanner.nextLine();
        if(choose.equalsIgnoreCase("y")){
            manager.delete(phoneBook);
        }
    }
    public PhoneBook getPhoneByPhoneNumber(){
        System.out.println("mời nhập số điện thoại muốn sửa");
        Boolean check = false;
        PhoneBook phoneBook=null;
        while (!check){
            String numberPhone = scanner.nextLine();
            for (PhoneBook p: phoneBooks
            ) {
                if(p.getPhoneNumber().equals(numberPhone)){
                    phoneBook = p;
                    check=true;
                    break;
                }
            }
            if(numberPhone.equals("")) break;
            if(!check) System.out.println(" ko tìm thấy số điện thoại trên mời nhập lai");
        }
        return phoneBook;
    }

    public void upadtePhoneBookMenu(){
        PhoneBook phoneBook = getPhoneByPhoneNumber();
        if(phoneBook!=null){
            Scanner scanner = new Scanner(System.in);
            String choose;
            System.out.println("Mời nhập thông tin muốn sửa");
            do {
                System.out.println("1.Nhóm danh bạ");
                System.out.println("2.Họ và tên");
                System.out.println("3.Giới tính");
                System.out.println("4.Địa chỉ");
                System.out.println("5.Ngày sinh");
                System.out.println("6.Thoát");
                choose = scanner.nextLine();
                switch (choose){
                    case "1":
                        phoneBook.setGroup(createGroup());
                        break;
                    case "2":
                        phoneBook.setFullName(createFullName());
                        break;
                    case "3":
                        phoneBook.setGender(createGender());
                        break;
                    case "4":
                        phoneBook.setAddress(createAddress());
                        break;
                    case "5":
                        phoneBook.setDateOfBirth(createDoB());
                        break;
                    case "6":
                        break;
                    default:
                        System.err.println("sai tuỳ chọn");
                        break;
                }
            }while (!choose.equals("6"));
        }
    }



    public void getDataInFile(){
        try {
            phoneBooks= fileManager.readFile(phoneBookList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(phoneBooks==null){
            System.out.println("file chưa có dữ liệu!!");
        }
    }
    public void saveDataOutFile(){
        try {
            fileManager.writeFile(phoneBooks,phoneBookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
