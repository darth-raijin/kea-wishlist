package com.example.demo.utility;

import java.sql.*;

public class Database {

    public Database() {
    }

    private Connection connection = null;

    public boolean setConnection() {
        final String url = "sql11.freemysqlhosting.net:3306/sql11448225"; // TODO FIX LOGIN
        boolean res = false;
        try {
            connection = DriverManager.getConnection(url, "sql11448225", "qKAVsCQ78i");
            res = true;
            System.out.println("Connection made!");
        } catch (SQLException ioerr) {
            System.out.println(ioerr);
            throw new RuntimeException(ioerr);
        } 
        return res;
    }

    public String createWishList(String name, String description) {
        setConnection();
        String insstr = "INSERT INTO Wishlist(name, description) values (?, ?)";
        PreparedStatement preparedStatement;
        String result = "";
        try {
            // Result bliver brugt til at skaffe det korrekte ID efter at der bliver indsat
            preparedStatement = connection.prepareStatement(insstr, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();

            ResultSet column = preparedStatement.getGeneratedKeys();
            if (column.next()) {
                result = column.getString(1);
                System.out.println("Created column " + result);
            }

        } catch (SQLException err) {
            System.out.println("bad happened:" + err.getMessage());
            return "400";
        }
        System.out.println("good happened");
        System.out.println(result);
        return result;
    }
}