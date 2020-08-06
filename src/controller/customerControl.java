/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.customer;
import model.Connector; 
import view.customer_view;
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

public class customerControl implements ActionListener, MouseListener{
    private customer customer;
    private customer_view customer_view;

    public customerControl(customer customer, customer_view customer_view){
        this.customer = customer;
        this.customer_view = customer_view;
        this.customer_view.tambah.addActionListener(this);
        this.customer_view.simpan.addActionListener(this);
        this.customer_view.edit.addActionListener(this);
        this.customer_view.hapus.addActionListener(this);
        this.customer_view.reset.addActionListener(this);
        this.customer_view.kembali.addActionListener(this);
        this.customer_view.tabelCustomer.addMouseListener(this);
    }
    
    public void TampilDataCustomer(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID SUPPLIER");
        model.addColumn("NAMA SUPPLIER");
        model.addColumn("ALAMAT SUPPLIER");
        model.addColumn("TELP SUPPLIER");
        
        try{
            String sql = "SELECT * FROM customer";
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
            customer_view.tabelCustomer.setModel(model);
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public void kosongkanForm(){
        customer_view.input_idcustomer.setText(null);
        customer_view.input_namacustomer.setText(null);
        customer_view.input_alamatcustomer.setText(null);
        customer_view.input_telpcustomer.setText(null);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customer_view.tambah) {
            kosongkanForm();
            customer_view.input_idcustomer.setEditable(true);
        } 
        
        else if (e.getSource() == customer_view.reset) {
            kosongkanForm();
            customer_view.input_idcustomer.setEditable(true);
        } 
        
        else if(e.getSource() == customer_view.simpan){
            customer.setIdCustomer(customer_view.input_idcustomer.getText());
            customer.setNamaCustomer(customer_view.input_namacustomer.getText());
            customer.setAlamatCustomer(customer_view.input_alamatcustomer.getText());
            customer.setTelpCustomer(customer_view.input_telpcustomer.getText());
            
            try {
                if (customer.simpanCustomer(customer)) {
                    JOptionPane.showMessageDialog(null, "Simpan data baru berhasil");
                    kosongkanForm();
                    TampilDataCustomer();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        } 
        
        else if(e.getSource() == customer_view.edit){
            customer.setIdCustomer(customer_view.input_idcustomer.getText());
            customer.setNamaCustomer(customer_view.input_namacustomer.getText());
            customer.setAlamatCustomer(customer_view.input_alamatcustomer.getText());
            customer.setTelpCustomer(customer_view.input_telpcustomer.getText());
            
            try {
                if (customer.updateCustomer(customer)) {
                    JOptionPane.showMessageDialog(null, "Update data baru berhasil");
                    kosongkanForm();
                    TampilDataCustomer();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        else if(e.getSource() == customer_view.kembali){
            home_view home_frm = new home_view();
            homeControl home_ctrl = new homeControl(home_frm);
            home_frm.setVisible(true);
            customer_view.dispose();
        }
        
        else {
            customer.setIdCustomer(customer_view.input_idcustomer.getText());
            
            try {
                if (customer.hapusCustomer(customer)) {
                    JOptionPane.showMessageDialog(null, "Hapus data berhasil");
                    kosongkanForm();
                    TampilDataCustomer();
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    } 

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == customer_view.tabelCustomer) {
            customer_view.input_idcustomer.setEditable(false);
            
            int baris = customer_view.tabelCustomer.rowAtPoint(me.getPoint());
            
            String idCustomer = customer_view.tabelCustomer.getValueAt(baris, 0).toString();
            customer_view.input_idcustomer.setText(idCustomer);
            
            String namaCustomer = customer_view.tabelCustomer.getValueAt(baris, 1).toString();
            customer_view.input_namacustomer.setText(namaCustomer);
            
            String alamatCustomer = customer_view.tabelCustomer.getValueAt(baris, 2).toString();
            customer_view.input_alamatcustomer.setText(alamatCustomer);
            
            String telpCustomer = customer_view.tabelCustomer.getValueAt(baris, 3).toString();
            customer_view.input_telpcustomer.setText(telpCustomer);
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
