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
        }
        return res;
    }

    public int createWishList(String name, String description) {
        String insstr = "INSERT INTO email(email) values (?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insstr);
            preparedStatement.executeUpdate();
        } catch (SQLException err) {
            System.out.println("bad happened:" + err.getMessage());
            return 400;
        }
        System.out.println("good happened");
        return 200;
    }
}