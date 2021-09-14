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
public class AcceptScheme_personTable extends AbstractTableModel {

    String[] COL_NAMES = {"Person_id", "Scheme", "Status","Amount","Disability","Date","Reject"};
    private AdminController acr = new AdminController();
    private ArrayList<SchemeDataTaker> users = new ArrayList<SchemeDataTaker>();

    public AcceptScheme_personTable(String name,String Disability) {
       users = acr.getAcceptScheme(name,Disability);

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
        return 7;
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
         return user.getStatus();
        }
        if(col==3){
            return user.getAmount();
        }
        if(col==4){
             return user.getDisability();
        }
   
         if(col==5){
             return user.getDate();
        }
        if(col==6){
              JButton btn = new JButton("Reject");
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btn.getParent(), "Are you sure you want to Reject");
                    if (result == JOptionPane.OK_OPTION) {
                         String id=user.getPerson_id();
                         acr.RejectSchemeAdmin(id);

                        AcceptScheme_personTable.this.fireTableDataChanged();
                    } 
                }
            });
            return btn;

        }
        return null;
    }

}