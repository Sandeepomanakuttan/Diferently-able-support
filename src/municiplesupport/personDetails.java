/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import municiplesupport.Controller.AdminController;
import municiplesupport.Controller.UserController;

/**
 *
 * @author kishore
 */
public class personDetails extends AbstractTableModel{
   
    String[] COL_NAMES = {"Ward_No", "House_No", "Address", "Owner_Name","Member_Name","Contact_No"};
    private AdminController acr = new AdminController();
    private ArrayList<AddressCollection> users = new ArrayList<AddressCollection>();

    public personDetails(PersonNameSetter p) {
        users=acr.getDetails(p);
        
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
       AddressCollection user=users.get(row);
        if(col==0){
        
        return user.getWardNo();
        }
        
        if(col==1){
        
        return user.getHouseNo();
        }
        
        if(col==2){
         return user.getAddress();
        }
        if(col==3){
            return user.getHouseowner();
        }
        if(col==4){
             return user.getMemberName();
        }
         if(col==5){
             return user.getContactNo();
        }
         
        return null;
    }

}