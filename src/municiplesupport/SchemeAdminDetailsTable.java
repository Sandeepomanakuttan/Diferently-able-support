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
public class SchemeAdminDetailsTable extends AbstractTableModel {
    
    String[] COL_NAMES = {"Scheme_Catagory","Disability","Scheme_details","Amount","Person","Remove"};
    private AdminController acr = new AdminController();
    private ArrayList<SchemeDataTaker> users = new ArrayList<SchemeDataTaker>();

    public SchemeAdminDetailsTable() {
         users = acr.getScheme();

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
        return 6;
    }

    @Override
    public Object getValueAt(int row, int col) {
       SchemeDataTaker user=users.get(row);
        if(col==0){
        
        return user.getScheme_catagory();
        }
        
        if(col==1){
        
        return user.getDisability();
        }
        
        if(col==2){
         return user.getScheme_criteria();
        }
        if(col==3){
        return user.getAmount();
        }
        
        if(col==4){
            JButton btnf = new JButton("Person");
            btnf.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {int result = JOptionPane.showConfirmDialog(btnf.getParent(), "Do you want to View Person and this Scheme");
                     if (result == JOptionPane.OK_OPTION) {
                        String name=user.getScheme_catagory();
                        String disability=user.getDisability();
                        PersonSchemeStatusFrame personSchemeStatusPanel = new PersonSchemeStatusFrame(name, disability);
                     }
                    
                    
                }
            });
             return btnf;
        }
         if (col==5) {
            JButton btn = new JButton("Remove");
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btn.getParent(), "Do you want to Remove Scheme");
                     if (result == JOptionPane.OK_OPTION) {
                        users.remove(row);
                        String name=user.getScheme_catagory();
                        String disability=user.getDisability();
                        acr.DeleteScheme(name,disability);
                         System.out.println(name);
                         System.out.println(disability);
                        
                        SchemeAdminDetailsTable.this.fireTableDataChanged();
                    }
                }
            });
            return btn;
        
    }
        return null;
    }

}