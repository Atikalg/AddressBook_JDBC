package com.bl.AddressBookJDBC;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
/*
* @author Atik
* Address Book System using MySQL
* UC1- ability to create Table wit name, address, city , phone, email etc..
* */
public class AddressBookMain {
    public static void main(String[] args) throws Exception {
        AddressBookMain addressBookMain = new AddressBookMain();
        System.out.println("Welcome to address book program ☺");
        addressBookMain.connection();
    }

    public void connection() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/addressBookJDBC";
        Connection con = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            //creating jdbc connection object
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "123456");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        AddressBook addressBook = new AddressBook();
        boolean change = true;
        do {
            System.out.println("\n Select the operation you want to perform : ");
            System.out.println(
                    "1.Add Contact To Address Book\n Press Any Key To Exit Address book System");
            switch (scanner.nextInt()) {
                case 1:
                    addressBook.createTable(con);
                    break;
                default:
                    change = false;
                    System.out.println("Exiting Address Book... ");
            }
        } while (change);
    }
}
