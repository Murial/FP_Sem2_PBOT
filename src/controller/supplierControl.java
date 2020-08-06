/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.supplier;
import model.Connector; 
import view.supplier_view;
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

public class supplierControl implements ActionListener, MouseListener{
    private supplier supplier;
    private supplier_view supplier_view;

    public supplierControl(supplier supplier, supplier_view supplier_view){
        this.supplier = supplier;
        this.supplier_view = supplier_view;
        this.supplier_view.tambah.addActionListener(this);
        this.supplier_view.simpan.addActionListener(this);
        this.supplier_view.edit.addActionListener(this);
        this.supplier_view.hapus.addActionListener(this);
        this.supplier_view.reset.addActionListener(this);
        this.supplier_view.kembali.addActionListener(this);
        this.supplier_view.tabelSupplier.addMouseListener(this);
    }
    
    public void TampilDataSupplier(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID SUPPLIER");
        model.addColumn("NAMA SUPPLIER");
        model.addColumn("ALAMAT SUPPLIER");
        model.addColumn("TELP SUPPLIER");
        
        try{
            String sql = "SELECT * FROM supplier";
            java.sql.Connection conn = (Connection)Connector.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res=  stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
            }
            supplier_view.tabelSupplier.setModel(model);
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public void kosongkanForm(){
        supplier_view.input_idsupplier.setText(null);
        supplier_view.input_namasupplier.setText(null);
        supplier_view.input_alamatsupplier.setText(null);
        supplier_view.input_telpsupplier.setText(null);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == supplier_view.tambah) {
            kosongkanForm();
            supplier_view.input_idsupplier.setEditable(true);
        } 
        
        else if (e.getSource() == supplier_view.reset) {
            kosongkanForm();
            supplier_view.input_idsupplier.setEditable(true);
        } 
        
        else if(e.getSource() == supplier_view.simpan){
            supplier.setIdSupplier(supplier_view.input_idsupplier.getText());
            supplier.setNamaSupplier(supplier_view.input_namasupplier.getText());
            supplier.setAlamatSupplier(supplier_view.input_alamatsupplier.getText());
            supplier.setTelpSupplier(supplier_view.input_telpsupplier.getText());
            
            try {
                if (supplier.simpanSupplier(supplier)) {
                    JOptionPane.showMessageDialog(null, "Simpan data baru berhasil");
                    kosongkanForm();
                    TampilDataSupplier();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        } 
        
        else if(e.getSource() == supplier_view.edit){
            supplier.setIdSupplier(supplier_view.input_idsupplier.getText());
            supplier.setNamaSupplier(supplier_view.input_namasupplier.getText());
            supplier.setAlamatSupplier(supplier_view.input_alamatsupplier.getText());
            supplier.setTelpSupplier(supplier_view.input_telpsupplier.getText());
            
            try {
                if (supplier.updateSupplier(supplier)) {
                    JOptionPane.showMessageDialog(null, "Update data baru berhasil");
                    kosongkanForm();
                    TampilDataSupplier();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        else if(e.getSource() == supplier_view.kembali){
            home_view home_frm = new home_view();
            homeControl home_ctrl = new homeControl(home_frm);
            home_frm.setVisible(true);
            supplier_view.dispose();
        }
        
        else {
            supplier.setIdSupplier(supplier_view.input_idsupplier.getText());
            
            try {
                if (supplier.hapusSupplier(supplier)) {
                    JOptionPane.showMessageDialog(null, "Hapus data berhasil");
                    kosongkanForm();
                    TampilDataSupplier();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    } 

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == supplier_view.tabelSupplier) {
            supplier_view.input_idsupplier.setEditable(false);
            
            int baris = supplier_view.tabelSupplier.rowAtPoint(me.getPoint());
            
            String idSupplier = supplier_view.tabelSupplier.getValueAt(baris, 0).toString();
            supplier_view.input_idsupplier.setText(idSupplier);
            
            String namaSupplier = supplier_view.tabelSupplier.getValueAt(baris, 1).toString();
            supplier_view.input_namasupplier.setText(namaSupplier);
            
            String alamatSupplier = supplier_view.tabelSupplier.getValueAt(baris, 2).toString();
            supplier_view.input_alamatsupplier.setText(alamatSupplier);
            
            String telpSupplier = supplier_view.tabelSupplier.getValueAt(baris, 3).toString();
            supplier_view.input_telpsupplier.setText(telpSupplier);
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