/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.jual;
import model.Connector; 
import view.jual_view;
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

public class jualControl implements ActionListener, MouseListener{
    
    private jual jual;
    private jual_view jual_view;

    public jualControl(jual jual, jual_view jual_view){
        this.jual = jual;
        this.jual_view = jual_view;
        this.jual_view.tambah.addActionListener(this);
        this.jual_view.simpan.addActionListener(this);
        this.jual_view.edit.addActionListener(this);
        this.jual_view.hapus.addActionListener(this);
        this.jual_view.reset.addActionListener(this);
        this.jual_view.kembali.addActionListener(this);
        this.jual_view.tabelJual.addMouseListener(this);
    }
    
    public void TampilDataJual(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID JUAL");
        model.addColumn("ID BARANG");
        model.addColumn("ID CUSTOMER");
        model.addColumn("TANGGAL BELI");
        model.addColumn("JUMLAH");
        
        try{
            String sql = "SELECT * FROM jual";
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
            jual_view.tabelJual.setModel(model);
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public void kosongkanForm(){
        jual_view.input_idjual.setText(null);
        jual_view.input_idbarang.setText(null);
        jual_view.input_idcustomer.setText(null);
        jual_view.input_tanggaljual.setText(null);
        jual_view.input_jumlahjual.setText(null);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jual_view.tambah) {
            kosongkanForm();
            jual_view.input_idjual.setEditable(true);
        } 
        
        else if (e.getSource() == jual_view.reset) {
            kosongkanForm();
            jual_view.input_idjual.setEditable(true);
        } 
        
        else if(e.getSource() == jual_view.simpan){
            jual.setIdJual(jual_view.input_idjual.getText());
            jual.setIdBarang(jual_view.input_idbarang.getText());
            jual.setIdCustomer(jual_view.input_idcustomer.getText());
            jual.setTanggalJual(jual_view.input_tanggaljual.getText());
            jual.setJumlahJual(jual_view.input_jumlahjual.getText());
            
            try {
                if (jual.simpanJual(jual)) {
                    JOptionPane.showMessageDialog(null, "Simpan data baru berhasil");
                    kosongkanForm();
                    TampilDataJual();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        } 
        
        else if(e.getSource() == jual_view.edit){
            jual.setIdJual(jual_view.input_idjual.getText());
            jual.setIdBarang(jual_view.input_idbarang.getText());
            jual.setIdCustomer(jual_view.input_idcustomer.getText());
            jual.setTanggalJual(jual_view.input_tanggaljual.getText());
            jual.setJumlahJual(jual_view.input_jumlahjual.getText());
            
            try {
                if (jual.updateJual(jual)) {
                    JOptionPane.showMessageDialog(null, "Update data baru berhasil");
                    kosongkanForm();
                    TampilDataJual();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        else if(e.getSource() == jual_view.kembali){
            home_view home_frm = new home_view();
            homeControl home_ctrl = new homeControl(home_frm);
            home_frm.setVisible(true);
            jual_view.dispose();
        }
        
        else {
            jual.setIdBarang(jual_view.input_idjual.getText());
            
            try {
                if (jual.hapusJual(jual)) {
                    JOptionPane.showMessageDialog(null, "Hapus data berhasil");
                    kosongkanForm();
                    TampilDataJual();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    } 

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == jual_view.tabelJual) {
            jual_view.input_idjual.setEditable(false);
            
            int baris = jual_view.tabelJual.rowAtPoint(me.getPoint());
            
            String idJual = jual_view.tabelJual.getValueAt(baris, 0).toString();
            jual_view.input_idjual.setText(idJual);
            
            String idBarang = jual_view.tabelJual.getValueAt(baris, 1).toString();
            jual_view.input_idbarang.setText(idBarang);
            
            String idCustomer = jual_view.tabelJual.getValueAt(baris, 2).toString();
            jual_view.input_idcustomer.setText(idCustomer);
            
            String tanggalJual = jual_view.tabelJual.getValueAt(baris, 3).toString();
            jual_view.input_tanggaljual.setText(tanggalJual);
            
            String jumlahJual = jual_view.tabelJual.getValueAt(baris, 4).toString();
            jual_view.input_jumlahjual.setText(jumlahJual);
        }
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
