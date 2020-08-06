/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.beli;
import model.Connector; 
import view.beli_view;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import view.home_view;

public class beliControl implements ActionListener, MouseListener{
    
    private beli beli;
    private beli_view beli_view;

    public beliControl(beli beli, beli_view beli_view){
        this.beli = beli;
        this.beli_view = beli_view;
        this.beli_view.tambah.addActionListener(this);
        this.beli_view.simpan.addActionListener(this);
        this.beli_view.edit.addActionListener(this);
        this.beli_view.hapus.addActionListener(this);
        this.beli_view.reset.addActionListener(this);
        this.beli_view.kembali.addActionListener(this);
        this.beli_view.tabelBeli.addMouseListener(this);
    }
    
    public void TampilDataBeli(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID BELI");
        model.addColumn("ID BARANG");
        model.addColumn("ID SUPPLIER");
        model.addColumn("TANGGAL BELI");
        model.addColumn("JUMLAH");
        
        try{
            String sql = "SELECT * FROM beli";
            java.sql.Connection conn = (Connection)Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res =  stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5)
                });
            }
            beli_view.tabelBeli.setModel(model);
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public void kosongkanForm(){
        beli_view.input_idbeli.setText(null);
        beli_view.input_idbarang.setText(null);
        beli_view.input_idsupplier.setText(null);
        beli_view.input_tanggalbeli.setText(null);
        beli_view.input_jumlahbeli.setText(null);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == beli_view.tambah) {
            kosongkanForm();
            beli_view.input_idbeli.setEditable(true);
        } 
        
        else if (e.getSource() == beli_view.reset) {
            kosongkanForm();
            beli_view.input_idbeli.setEditable(true);
        } 
        
        else if(e.getSource() == beli_view.simpan){
            beli.setIdBeli(beli_view.input_idbeli.getText());
            beli.setIdBarang(beli_view.input_idbarang.getText());
            beli.setIdSupplier(beli_view.input_idsupplier.getText());
            beli.setTanggalBeli(beli_view.input_tanggalbeli.getText());
            beli.setJumlahBeli(beli_view.input_jumlahbeli.getText());
            
            try {
                if (beli.simpanBeli(beli)) {
                    JOptionPane.showMessageDialog(null, "Simpan data baru berhasil");
                    kosongkanForm();
                    TampilDataBeli();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        } 
        
        else if(e.getSource() == beli_view.edit){
            beli.setIdBeli(beli_view.input_idbeli.getText());
            beli.setIdBarang(beli_view.input_idbarang.getText());
            beli.setIdSupplier(beli_view.input_idsupplier.getText());
            beli.setTanggalBeli(beli_view.input_tanggalbeli.getText());
            beli.setJumlahBeli(beli_view.input_jumlahbeli.getText());
            
            try {
                if (beli.updateBeli(beli)) {
                    JOptionPane.showMessageDialog(null, "Update data baru berhasil");
                    kosongkanForm();
                    TampilDataBeli();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        else if(e.getSource() == beli_view.kembali){
            home_view home_frm = new home_view();
            homeControl home_ctrl = new homeControl(home_frm);
            home_frm.setVisible(true);
            beli_view.dispose();
        }
        
        else {
            beli.setIdBarang(beli_view.input_idbeli.getText());
            
            try {
                if (beli.hapusBeli(beli)) {
                    JOptionPane.showMessageDialog(null, "Hapus data berhasil");
                    kosongkanForm();
                    TampilDataBeli();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    } 

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == beli_view.tabelBeli) {
            beli_view.input_idbeli.setEditable(false);
            
            int baris = beli_view.tabelBeli.rowAtPoint(me.getPoint());
            
            String idBeli = beli_view.tabelBeli.getValueAt(baris, 0).toString();
            beli_view.input_idbeli.setText(idBeli);
            
            String idBarang = beli_view.tabelBeli.getValueAt(baris, 1).toString();
            beli_view.input_idbarang.setText(idBarang);
            
            String idSupplier = beli_view.tabelBeli.getValueAt(baris, 2).toString();
            beli_view.input_idsupplier.setText(idSupplier);
            
            String tanggalBeli = beli_view.tabelBeli.getValueAt(baris, 3).toString();
            beli_view.input_tanggalbeli.setText(tanggalBeli);
            
            String jumlahBeli = beli_view.tabelBeli.getValueAt(baris, 4).toString();
            beli_view.input_jumlahbeli.setText(jumlahBeli);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
