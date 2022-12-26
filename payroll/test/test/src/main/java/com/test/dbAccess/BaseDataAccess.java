package com.test.dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDataAccess {

    protected Connection getConnection() throws SQLException {
        // create database connection 
        //⛔use your mysql database name and password⛔
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/PPS", "root", "root");
        return conn;
    }

}
