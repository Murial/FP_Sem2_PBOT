/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.barang;
import model.connection; 
import view.barang_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class barangControl implements ActionListener, MouseListener{
    private barang barang;
    private barang_view barang_view;

    public barangControl(barang barang, barang_view barang_view){
        this.barang = barang;
        this.barang_view = barang_view;
        this.barang_view.tambah.addActionListener(this);
        this.barang_view.simpan.addActionListener(this);
        this.barang_view.edit.addActionListener(this);
        this.barang_view.hapus.addActionListener(this);
        this.barang_view.reset.addActionListener(this);
//        this.barang_view.tabelBarang.addMouseListener(this);
    }
    
    public void TampilData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID BARANG");
        model.addColumn("NAMA BARANG");
        model.addColumn("SATUAN BARANG");
        model.addColumn("HARGA");
        model.addColumn("STOK");
        
        try{
            String sql = "SELECT * FROM barang";
            java.sql.Connection con = connection.config();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res=  stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{
                    res.getInt(1),
                    res.getString(2),
                    res.getString(3),
                    res.getInt(4),
                    res.getInt(5)
                });
            }
            barang_view.tabelBarang.setModel(model);
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public void kosongkanForm(){
        barang_view.input_idbarang.setText(null);
        barang_view.input_namabarang.setText(null);
        barang_view.input_satuan.setText(null);
        barang_view.input_harga.setText(null);
        barang_view.input_stok.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}