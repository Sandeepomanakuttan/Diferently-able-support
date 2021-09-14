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

/**
 *
 * @author kishore
 */
public class AdminPersonViewBankAccountDetailsTable extends AbstractTableModel{

    String[] COL_NAMES = {"id", "Name", "Account_no", "Ifsc_code","Bank_Name","Place"};
    private UserController acr = new UserController();
    private ArrayList<BankDataTacker> users = new ArrayList<BankDataTacker>();
    public AdminPersonViewBankAccountDetailsTable(String id) {
        users=acr.getPersonBank(id);
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
       BankDataTacker user=users.get(row);
        if(col==0){
        
        return user.getId();
        }
        
        if(col==1){
        
        return user.getLblName();
        }
        
        if(col==2){
         return user.getLblAccount_No();
        }
        if(col==3){
            return user.getLblIFSC_Code();
        }
        if(col==4){
             return user.getLblBank_Name();
        }
         if(col==5){
             return user.getLblPlace();
        }
        return null;
    }
    
}
