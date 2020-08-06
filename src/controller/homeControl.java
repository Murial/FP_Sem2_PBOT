/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;



public class homeControl implements ActionListener{
    private home_view frm;
    
    public homeControl(home_view frm){
        this.frm = frm;
        this.frm.buttonCustomer.addActionListener(this);
        this.frm.buttonBarang.addActionListener(this);
        this.frm.buttonSupplier.addActionListener(this);
        this.frm.buttonBeli.addActionListener(this);
        this.frm.buttonJual.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.buttonBarang) {
            barang data_barang = new barang();
            barang_view frm_barang = new barang_view();
            barangControl ctrl_barang = new barangControl(data_barang, frm_barang);
            
            ctrl_barang.kosongkanForm();
            ctrl_barang.TampilDataBarang();
            frm_barang.setVisible(true);
            frm.dispose();
        }
        
        else if(e.getSource() == frm.buttonBeli){
            beli data_beli = new beli();
            beli_view frm_beli = new beli_view();
            beliControl ctrl_beli = new beliControl(data_beli, frm_beli);
            
            ctrl_beli.kosongkanForm();
            ctrl_beli.TampilDataBeli();
            frm_beli.setVisible(true);
            frm.dispose();
        }
        
        else if(e.getSource() == frm.buttonSupplier){
            supplier data_supplier = new supplier();
            supplier_view frm_supplier = new supplier_view();
            supplierControl ctrl_supplier = new supplierControl(data_supplier, frm_supplier);
            
            ctrl_supplier.kosongkanForm();
            ctrl_supplier.TampilDataSupplier();
            frm_supplier.setVisible(true);
            frm.dispose();
        }
        
        else if (e.getSource() == frm.buttonCustomer) {
            customer data_customer = new customer();
            customer_view frm_customer = new customer_view();
            customerControl ctrl_customer = new customerControl(data_customer, frm_customer);
            
            ctrl_customer.kosongkanForm();
            ctrl_customer.TampilDataCustomer();
            frm_customer.setVisible(true);
            frm.dispose();
        }
        
        else if (e.getSource() == frm.buttonJual) {
            jual data_jual = new jual();
            jual_view frm_jual = new jual_view();
            jualControl ctrl_jual = new jualControl(data_jual, frm_jual);
            
            ctrl_jual.kosongkanForm();
            ctrl_jual.TampilDataJual();
            frm_jual.setVisible(true);
            frm.dispose();
        }
        
    }
    
    
}
