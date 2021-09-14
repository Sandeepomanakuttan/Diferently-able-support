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
import municiplesupport.Controller.UserController;

/**
 *
 * @author kishore
 */
public class PersonViewProfileTable  extends AbstractTableModel{
   
    String[] COL_NAMES = {"Ward_No", "House_No", "Address", "Relation","Person_Name","Gender","Disability"};
    private UserController acr = new UserController();
    private ArrayList<PersonNameSetter> users = new ArrayList<PersonNameSetter>();
    String id;

    public PersonViewProfileTable(loginData p) {
        users=acr.CollecteMyInformation(p);
        id=p.getLogin_id();
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
       PersonNameSetter user=users.get(row);
        if(col==0){
        
        return user.getWard_no();
        }
        
        if(col==1){
        
        return user.getHouse_no();
        }
        
        if(col==2){
         return user.getAddress();
        }
        if(col==3){
           
              JButton btn = new JButton("Relative");
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                         new PersonRelativeFrame(id);
                   
                }
            });
            return btn;

        } 
        if(col==4){
             return user.getName();
        }
         if(col==5){
             return user.getGender();
        }
         if(col==6){
            return user.getDisability();
        }
        return null;
    }

}