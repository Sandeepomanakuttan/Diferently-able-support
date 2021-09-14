/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport.Table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import municiplesupport.BankDataTacker;
import municiplesupport.Controller.AdminController;
import municiplesupport.Controller.UserController;
import municiplesupport.DataCollectionClass.HospitalDataTacker;
import municiplesupport.PersonNameSetter;
import municiplesupport.SchemeDataTaker;

/**
 *
 * @author kishore
 */
public class PersonViewBankTransactionDetailsTable extends AbstractTableModel{

    String[] COL_NAMES = {"id", "Scheme_Name", "Amount"};
    private UserController acr = new UserController();
    private ArrayList<SchemeDataTaker> users = new ArrayList<SchemeDataTaker>();
    public PersonViewBankTransactionDetailsTable(String id) {
        users=acr.getPersonAccountDetails(id);
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
        
        return user.getPerson_id();
        }
        
        if(col==1){
        
        return user.getScheme_catagory();
        }
        
        if(col==2){
         return user.getAmount();
        }
        return null;
    }
    
}
