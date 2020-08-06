/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

public class supplier extends Connector{
    private String idSupplier;
    private String namaSupplier;
    private String alamatSupplier;
    private String telpSupplier;
   
   public String getIdSupplier(){
       return idSupplier;
   }
   
   public void setIdSupplier(String idSupplier){
       this.idSupplier = idSupplier;
   }
   
   public String getNamaSupplier(){
       return namaSupplier;
   }
   
   public void setNamaSupplier(String NamaSupplier){
       this.namaSupplier = NamaSupplier;
   }
   
   public String getAlamatSupplier(){
       return alamatSupplier;
   }
   
   public void setAlamatSupplier(String AlamatSupplier){
       this.alamatSupplier = AlamatSupplier;
   }
   
   public String getTelpSupplier(){
       return telpSupplier;
   }
   
   public void setTelpSupplier(String TelpSupplier){
       this.telpSupplier = TelpSupplier;
   }  
   
   
   public boolean simpanSupplier(supplier supplier) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "INSERT INTO supplier (idSupplier, namaSupplier, alamatSupplier, telpSupplier)"
               + "VALUES (?,?,?,?)";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, supplier.getIdSupplier());
           pstm.setString( 2, supplier.getNamaSupplier());
           pstm.setString( 3, supplier.getAlamatSupplier());
           pstm.setString( 4, supplier.getTelpSupplier());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean updateSupplier(supplier supplier) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "UPDATE supplier SET idSupplier = ?, namaSupplier = ?, alamatSupplier = ?, telpSupplier = ? WHERE idSupplier = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, supplier.getIdSupplier());
           pstm.setString( 2, supplier.getNamaSupplier());
           pstm.setString( 3, supplier.getAlamatSupplier());
           pstm.setString( 4, supplier.getTelpSupplier());
           pstm.setString( 5, supplier.getIdSupplier());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean hapusSupplier(supplier supplier) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "DELETE FROM supplier WHERE idSupplier = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, supplier.getIdSupplier());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
}