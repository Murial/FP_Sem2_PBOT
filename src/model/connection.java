/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.*;

/**
 *
 * @author ASUS
 */
public class connection {
    private static Connection MySQLConfig;
    public static Connection config() throws SQLException {
        try{
            String url = "jdbc:mysql://localhost/grosir";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil;");
        } catch (Exception e){
            System.out.println("Koneksi gagal"+ e.getMessage());
        }
        return MySQLConfig;
    }
}
