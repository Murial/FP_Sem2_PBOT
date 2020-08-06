/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;


public class beli extends Connector{
    private String idBeli;
    private String idBarang;
    private String idSupplier;
    private String tanggalBeli;
    private String jumlahBeli;
   
    
    public String getIdBeli(){
       return idBeli;
   }
   
   public void setIdBeli(String idBeli){
       this.idBeli = idBeli;
   }
   
   public String getIdBarang(){
       return idBarang;
   }
   
   public void setIdBarang(String idBarang){
       this.idBarang = idBarang;
   }
   
   public String getIdSupplier(){
       return idSupplier;
   }
   
   public void setIdSupplier(String idSupplier){
       this.idSupplier = idSupplier;
   }
   
   public String getTanggalBeli(){
       return tanggalBeli;
   }
   
   public void setTanggalBeli(String tanggalBeli){
       this.tanggalBeli = tanggalBeli;
   }
   
   public String getJumlahBeli(){
       return jumlahBeli;
   }
   
   public void setJumlahBeli(String jumlahBeli){
       this.jumlahBeli = jumlahBeli;
   }
   
   
   public boolean simpanBeli(beli beli) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "INSERT INTO beli (idBeli, idBarang, idSupplier, tglBeli, jmlBeli)"
               + "VALUES (?,?,?,?,?)";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, beli.getIdBeli());
           pstm.setString( 2, beli.getIdBarang());
           pstm.setString( 3, beli.getIdSupplier());
           pstm.setString( 4, beli.getTanggalBeli());
           pstm.setString( 5, beli.getJumlahBeli());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean updateBeli(beli beli) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "UPDATE beli SET idBeli = ?, idBarang = ?, idSupplier = ?, tglBeli = ?, jmlBeli = ? WHERE idBeli = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, beli.getIdBeli());
           pstm.setString( 2, beli.getIdBarang());
           pstm.setString( 3, beli.getIdSupplier());
           pstm.setString( 4, beli.getTanggalBeli());
           pstm.setString( 5, beli.getJumlahBeli());
           pstm.setString( 6, beli.getIdBeli());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean hapusBeli(beli beli) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "DELETE FROM beli WHERE idBeli = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, beli.getIdBeli());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
}
