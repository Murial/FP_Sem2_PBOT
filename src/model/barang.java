/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

public class barang extends Connector{
    private String idBarang;
    private String namaBarang;
    private String satuanBarang;
    private String hargaBarang;
    private String stokBarang;
   
   public String getId(){
       return idBarang;
   }
   
   public void setId(String idBarang){
       this.idBarang = idBarang;
   }
   
   public String getNB(){
       return namaBarang;
   }
   
   public void setNB(String namaBarang){
       this.namaBarang = namaBarang;
   }
   
   public String getSatB(){
       return satuanBarang;
   }
   
   public void setSatB(String satuanBarang){
       this.satuanBarang = satuanBarang;
   }
   
   public String getHB(){
       return hargaBarang;
   }
   
   public void setHB(String hargaBarang){
       this.hargaBarang = hargaBarang;
   }
   
   public String getStokB(){
       return stokBarang;
   }
   
   public void setStokB(String stokBarang){
       this.stokBarang = stokBarang;
   }
   
   public boolean simpanBarang(barang barang) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "INSERT INTO barang (idBarang, namaBarang, satuanBarang, hargaBarang, stokBarang)"
               + "VALUES (?,?,?,?,?)";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, barang.getId());
           pstm.setString( 2, barang.getNB());
           pstm.setString( 3, barang.getSatB());
           pstm.setString( 4, barang.getHB());
           pstm.setString( 5, barang.getStokB());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean updateBarang(barang barang) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "UPDATE barang SET idBarang = ?, namaBarang = ?, satuanBarang = ?, hargaBarang = ?, stokBarang = ? WHERE idBarang = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, barang.getId());
           pstm.setString( 2, barang.getNB());
           pstm.setString( 3, barang.getSatB());
           pstm.setString( 4, barang.getHB());
           pstm.setString( 5, barang.getStokB());
           pstm.setString( 6, barang.getId());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   public boolean hapusBarang(barang barang) throws SQLException{
       PreparedStatement pstm = null;
       Connection conn = (Connection)Connector.configDB();
       
       String sql = "DELETE FROM barang WHERE idBarang = ?";
       
       try{
           pstm = conn.prepareStatement(sql);
           pstm.setString( 1, barang.getId());
           pstm.execute();
           return true;
       } catch(HeadlessException | SQLException e){
           System.out.println(e);
           return false;
       }
   }
   
   
}
