/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.connect;
import view.barang_view;

/**
 *
 * @author ASUS
 */
public class barang extends connect {
    barang_view barang = new barang_view();
    private int idBarang;
    private String namaBarang;
    private String satuanBarang;
    private int stokBarang;
    
    public void TampilData(){

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID BARANG");
        model.addColumn("NAMA BARANG");
        model.addColumn("SATUAN");
        model.addColumn("STOK");
        
        try{
            String sql = "SELECT * FROM barang";
            java.sql.Connection con = connect.config();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res =  stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
            }
            barang.table_barang.setModel(model);
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }
    }
}