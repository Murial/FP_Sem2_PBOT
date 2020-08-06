/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

public class customer extends Connector{
    private String idCustomer;
    private String namaCustomer;
    private String alamatCustomer;
    private String telpCustomer;
   
   public String getIdCustomer(){
       return idCustomer;
   }
   
   public void setIdCustomer(String idCustomer){
       this.idCustomer = idCustomer;
   }
   
   public String getNamaCustomer(){
       return namaCustomer;
   }
   
   public void setNamaCustomer(String NamaCustomer){
       this.namaCustomer = NamaCustomer;
   }
   
   public String getAlamatCustomer(){
       return alamatCustomer;
   }
   
   public void setAlamatCustomer(String AlamatCustomer){
       this.alamatCustomer = AlamatCustomer;
   }
   
   public String getTelpCustomer(){
       return telpCustomer;
   }
   
   public void setTelpCustomer(String TelpCustomer){
       this.telpCustomer = TelpCustomer;
   }  
   
   
   public boolean simpanCustomer(customer customer) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "INSERT INTO customer (idCustomer, namaCustomer, alamatCustomer, telpCustomer)"
               + "VALUES (?,?,?,?)";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, customer.getIdCustomer());
           pstm.setString( 2, customer.getNamaCustomer());
           pstm.setString( 3, customer.getAlamatCustomer());
           pstm.setString( 4, customer.getTelpCustomer());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean updateCustomer(customer customer) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "UPDATE customer SET idCustomer = ?, namaCustomer = ?, alamatCustomer = ?, telpCustomer = ? WHERE idCustomer = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, customer.getIdCustomer());
           pstm.setString( 2, customer.getNamaCustomer());
           pstm.setString( 3, customer.getAlamatCustomer());
           pstm.setString( 4, customer.getTelpCustomer());
           pstm.setString( 5, customer.getIdCustomer());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean hapusCustomer(customer customer) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "DELETE FROM customer WHERE idCustomer = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, customer.getIdCustomer());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
}