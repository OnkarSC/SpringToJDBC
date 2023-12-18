package com.qsp.SpringToJdbc;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class Intermediate {
    //    @Value("${driver}")
    private String driver;
    //    @Value("${url}")
    private String url;

    private String userName;
    //    @Value("${DBPassword}")
    private String password;
    //    @Value("${queary}")
//    private String queary;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    @Value("${DBUsername}")

    Connection connection;

//    @PostConstruct
    public void init() throws SQLException, ClassNotFoundException {
        getConnection();
    }
    public void getConnection() throws SQLException, ClassNotFoundException {
        System.out.println("Connected...");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, userName, password);
    }

   // @PreDestroy
    public void closeConnection() throws SQLException, ClassNotFoundException {
        connection.close();
        System.out.println("Connection closed...");
    }

    public void retrieveAllData() throws ClassNotFoundException, SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM facebook.user");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String userName = resultSet.getString(2);
            String userSurName = resultSet.getString(3);
            int age = resultSet.getInt(4);
            System.out.println("User I'D- " + id + " Name- " + userName + " " + userSurName + " Age- " + age);
        }
    }

    public void deleteData(int id) throws ClassNotFoundException, SQLException {
        Statement statement = connection.createStatement();
        int resultSet = statement.executeUpdate("Delete FROM facebook.user where PersonID = "+id);
        System.out.println(resultSet);
        System.out.println("Data deleted...");
    }

}
