/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudwithjava;
    
import controller.*;
import view.*;

public class CRUDWithJava {
   
    public static void main(String[] args) {
        home_view frm_home = new home_view();
        homeControl ctrl_home = new homeControl(frm_home);
        
//        barang data_barang = new barang();
//        barang_view frm_barang = new barang_view();
//        barangControl ctrl_barang = new barangControl(data_barang, frm_barang);
        
        frm_home.setVisible(true);
        
//        ctrl_barang.kosongkanForm();
//        ctrl_barang.TampilDataBarang();
//        frm_barang.setVisible(true);
        
        
    }
}
