/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;


public class jual extends Connector{
    private String idJual;
    private String idBarang;
    private String idCustomer;
    private String tanggalJual;
    private String jumlahJual;
   
    
    public String getIdJual(){
       return idJual;
   }
   
   public void setIdJual(String idJual){
       this.idJual = idJual;
   }
   
   public String getIdBarang(){
       return idBarang;
   }
   
   public void setIdBarang(String idBarang){
       this.idBarang = idBarang;
   }
   
   public String getIdCustomer(){
       return idCustomer;
   }
   
   public void setIdCustomer(String idCustomer){
       this.idCustomer = idCustomer;
   }
   
   public String getTanggalJual(){
       return tanggalJual;
   }
   
   public void setTanggalJual(String tanggalJual){
       this.tanggalJual = tanggalJual;
   }
   
   public String getJumlahJual(){
       return jumlahJual;
   }
   
   public void setJumlahJual(String jumlahJual){
       this.jumlahJual = jumlahJual;
   }
   
   
   public boolean simpanJual(jual jual) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "INSERT INTO jual (idJual, idBarang, idCustomer, tglJual, jmlJual)"
               + "VALUES (?,?,?,?,?)";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, jual.getIdJual());
           pstm.setString( 2, jual.getIdBarang());
           pstm.setString( 3, jual.getIdCustomer());
           pstm.setString( 4, jual.getTanggalJual());
           pstm.setString( 5, jual.getJumlahJual());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean updateJual(jual jual) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "UPDATE jual SET idJual = ?, idBarang = ?, idCustomer = ?, tglJual = ?, jmlJual = ? WHERE idJual = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, jual.getIdJual());
           pstm.setString( 2, jual.getIdBarang());
           pstm.setString( 3, jual.getIdCustomer());
           pstm.setString( 4, jual.getTanggalJual());
           pstm.setString( 5, jual.getJumlahJual());
           pstm.setString( 6, jual.getIdJual());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean hapusJual(jual jual) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "DELETE FROM jual WHERE idJual = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, jual.getIdJual());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
}
