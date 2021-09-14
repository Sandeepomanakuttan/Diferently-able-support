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
import municiplesupport.DataCollectionClass.HospitalDataTacker;

/**
 *
 * @author kishore
 */
    
public class PersonViewHospitalDetailsTable extends AbstractTableModel{

    String[] COL_NAMES = {"Hospital Name", "Disapility", "District", "Place","About"};
    private UserController acr = new UserController();
    private ArrayList<HospitalDataTacker> users = new ArrayList<HospitalDataTacker>();
    public PersonViewHospitalDetailsTable(loginData p) {
        users=acr.CollecteMyHospital(p);
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
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
       HospitalDataTacker user=users.get(row);
        if(col==0){
        
        return user.getHospitalName();
        }
        
        if(col==1){
        
        return user.getDisability();
        }
        
        if(col==2){
         return user.getDisctrict();
        }
        if(col==3){
            return user.getPlace();
        }
        if(col==4){
             return user.getAbout();
        }
        return null;
    }
    
}

