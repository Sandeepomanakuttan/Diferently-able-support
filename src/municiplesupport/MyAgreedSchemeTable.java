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
import municiplesupport.Controller.UserController;

/**
 *
 * @author kishore
 */
    
public class MyAgreedSchemeTable extends AbstractTableModel {
    
    String[] COL_NAMES = {"Scheme_Catagory","Amount","Status"};
    private UserController acr = new UserController();
    private ArrayList<SchemeDataTaker> users = new ArrayList<SchemeDataTaker>();
    loginData f;
    public MyAgreedSchemeTable(loginData p) {
         users = acr.CollecteMyAgreedScheme(p);
         f=p;
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
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
       SchemeDataTaker user=users.get(row);
        if(col==0){
        
        return user.getScheme_catagory();
        }
       if(col==1){
        
        return user.getAmount();
        }
        if(col==2){
        
        return user.getStatus();
        }
        return null;
    }

}
