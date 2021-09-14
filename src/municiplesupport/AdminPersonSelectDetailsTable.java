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
public class AdminPersonSelectDetailsTable extends AbstractTableModel {

    String[] COL_NAMES = {"Person_id","Person_Name","Payment"};
    private AdminController acr = new AdminController();
    private ArrayList<PersonNameSetter> users = new ArrayList<PersonNameSetter>();

    public AdminPersonSelectDetailsTable() {
       users = acr.getPersonInformation();

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
       PersonNameSetter user=users.get(row);
        if(col==0){
        
        return user.getId();
        }
        
        if(col==1){
        
        return user.getName();
        }
               if (col ==2) {
            JButton btn1 = new JButton("Payment");
            btn1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btn1.getParent(), "Are you sure you want to Payment");
                    if (result == JOptionPane.OK_OPTION) {
                        String id=user.getId();
                       new AdminPersonPaymentStatusFrame(id);
                    } 
                }
            });
            return btn1;
               }
        return null;
    }

}