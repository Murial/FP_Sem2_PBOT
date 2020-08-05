/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudwithjava;

import controller.barangControl;
import model.barang;
import view.barang_view;

public class CRUDWithJava {
    
    public static void main(String[] args) {
        barang data = new barang();
        barang_view frm = new barang_view();
        barangControl ctrl = new barangControl(data, frm);
        
        ctrl.kosongkanForm();
        ctrl.TampilData();
        frm.setVisible(true);
        
        
    }
}
