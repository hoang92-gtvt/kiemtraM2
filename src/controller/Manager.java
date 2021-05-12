package controller;

import model.PhoneBook;
import storage.FileManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private ArrayList<PhoneBook> phoneBooks;
    FileManager<PhoneBook> fileManager = FileManager.getInstance();
    private static final String phoneBookList= "phoneBookList.csv";

    public Manager() {
    }

    public Manager(ArrayList<PhoneBook> phoneList) {
        phoneBooks = phoneList;
    }

    public ArrayList<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public void setPhoneBooks(ArrayList<PhoneBook> phoneBooks) {
        this.phoneBooks = phoneBooks;
    }


    public void add(PhoneBook phoneBook){
        phoneBooks.add(phoneBook);

    }
    public void delete(PhoneBook phoneBook){
        phoneBooks.remove(phoneBook);

    }
    public void update(PhoneBook phoneBook){
        phoneBooks.remove(phoneBook);

    }




}
