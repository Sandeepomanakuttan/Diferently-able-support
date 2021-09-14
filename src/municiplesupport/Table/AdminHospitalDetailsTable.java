/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport.Table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import municiplesupport.Controller.AdminController;
import municiplesupport.DataCollectionClass.HospitalDataTacker;
import municiplesupport.PersonNameSetter;
import municiplesupport.SchemeAdminDetailsTable;

/**
 *
 * @author kishore
 */
public class AdminHospitalDetailsTable extends AbstractTableModel{

    String[] COL_NAMES = {"Hospital Name", "Disapility", "District", "Place","About","Remove"};
    private AdminController acr = new AdminController();
    private ArrayList<HospitalDataTacker> users = new ArrayList<HospitalDataTacker>();
    public AdminHospitalDetailsTable() {
        users=acr.getHospital();
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
         if (col==5) {
            JButton btn = new JButton("Remove");
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btn.getParent(), "Do you want to Remove Hospital");
                     if (result == JOptionPane.OK_OPTION) {
                        users.remove(row);
                        String name=user.getHospitalName();
                        String disability=user.getDisability();
                        acr.DeleteHospital(name,disability);
                         
                        
                        AdminHospitalDetailsTable.this.fireTableDataChanged();
                    }
                }
            });
            return btn;
        
    }
        return null;
    }
    
}
