/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import municiplesupport.Controller.AdminController;

/**
 *
 * @author kishore
 */
public class AdminPersonPaymentDetailsTable extends AbstractTableModel {

    String[] COL_NAMES = {"id","Scheme_Name","Amount","Date"};
    private AdminController acr = new AdminController();
    private ArrayList<SchemeDataTaker> users = new ArrayList<SchemeDataTaker>();

    public AdminPersonPaymentDetailsTable(String id) {
       users =acr.getPersonPayment(id);

    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public String getColumnName(int i) {
        return COL_NAMES[i]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col) {
       SchemeDataTaker user=users.get(row);
        if(col==0){
        
        return user.getPerson_id();
        }
        
        if(col==1){
        
        return user.getScheme_catagory();
        }
         if(col==2){
        
        return user.getAmount();
        }
        if(col==3){
        
        return user.getDate();
        }
        return null;
    }

}