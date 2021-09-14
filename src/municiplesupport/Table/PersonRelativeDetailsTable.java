/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport.Table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import municiplesupport.Controller.AdminController;
import municiplesupport.DataCollectionClass.HospitalDataTacker;
import municiplesupport.PersonNameSetter;
import municiplesupport.RelativeDataTacker;

/**
 *
 * @author kishore
 */
public class PersonRelativeDetailsTable extends AbstractTableModel{

    String[] COL_NAMES = {"Relation","Name", "Contact_No","Address"};
    private AdminController acr = new AdminController();
    private ArrayList<RelativeDataTacker> users = new ArrayList<RelativeDataTacker>();
    public PersonRelativeDetailsTable(String id) {
        users=acr.getRelative(id);
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
       RelativeDataTacker user=users.get(row);
        if(col==0){
        
        return user.getLblRelation();
        }
        if(col==1){
        
        return user.getLblName();
        }
        
        if(col==2){
        
        return user.getLblContact_No();
        }
        
        if(col==3){
         return user.getLblAddress();
        }
        return null;
    }
    
}
