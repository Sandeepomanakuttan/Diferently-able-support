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
import javax.swing.table.TableModel;
import municiplesupport.Controller.AdminController;
import municiplesupport.Controller.UserController;

/**
 *
 * @author kishore
 */
    
public class PersonSchemeDetailsTable extends AbstractTableModel {
    
    String[] COL_NAMES = {"Scheme_Catagory","Disability","Amount","Scheme_details","interest","not_interest"};
    private UserController acr = new UserController();
    private ArrayList<SchemeDataTaker> users = new ArrayList<SchemeDataTaker>();
    public ArrayList<PersonNameSetter> user = new ArrayList<PersonNameSetter>();
    loginData f;
    public PersonSchemeDetailsTable(loginData p) {
         users = acr.CollecteMyScheme(p);
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
         return user.getAmount();
        }
        
         if(col==3){
         return user.getScheme_criteria();
        }
        if (col == 4) {
            JButton btn = new JButton("interest");
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btn.getParent(), "Do you want to interest");
                     if (result == JOptionPane.OK_OPTION) {
                        users.remove(row);
                        String name=user.getScheme_catagory();
                        String id=f.getLogin_id();
                        String Dis=user.getDisability();
                        String Amounts=user.getAmount();
                        if(!acr.AgreeUserAlready(name,id)){
                             
                             acr.AgreeUser(name,id,Amounts,Dis);
                        } else {
                           JOptionPane.showMessageDialog(null, "Already Exists");
                        }
                        
                         System.out.println(name);
                         System.out.println(id);
                        
                        PersonSchemeDetailsTable.this.fireTableDataChanged();
                    }
                }
            });
            return btn;
        
    }
         if (col == 5) {
            JButton btn1 = new JButton("not_interest");
            btn1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btn1.getParent(), "Do you want to not interest");
                     if (result == JOptionPane.OK_OPTION) {
                        users.remove(row);
                        String name=user.getScheme_catagory();
                        String id=f.getLogin_id();
                        String Dis=user.getDisability();
                        String Amounts=user.getAmount();
                        if(!acr.AgreeUserAlready(name,id)){
                             
                        }
                        PersonSchemeDetailsTable.this.fireTableDataChanged();
                    }
                }
            });
            return btn1;
        
    }
        return null;
    }

}