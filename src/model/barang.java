/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

public class barang extends connection{
    private int idBarang;
    private String namaBarang;
    private String satuanBarang;
    private int hargaBarang;
    private int stokBarang;
   
   public int getId(){
       return idBarang;
   }
   
   public void setId(int idBarang){
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
   
   public int getHB(){
       return idBarang;
   }
   
   public void setHB(int hargaBarang){
       this.hargaBarang = hargaBarang;
   }
   
   public int getStokB(){
       return stokBarang;
   }
   
   public void setStokB(int stokBarang){
       this.stokBarang = stokBarang;
   }
   
   
}
