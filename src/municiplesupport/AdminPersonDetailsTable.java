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
public class AdminPersonDetailsTable extends AbstractTableModel {

    String[] COL_NAMES = {"Person_id","Ward_No", "House_No", "Address", "Relative","Person_Name","Gender","Disability","Scheme","Bank","Details","Photo","Proof","Remove"};
    private AdminController acr = new AdminController();
    private ArrayList<PersonNameSetter> users = new ArrayList<PersonNameSetter>();

    public AdminPersonDetailsTable() {
       users = acr.getPerson();

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
        return 14;
    }

    @Override
    public Object getValueAt(int row, int col) {
       PersonNameSetter user=users.get(row);
       if(col==0){
        
        return user.getId();
        }
        if(col==1){
        
        return user.getWard_no();
        }
        
        if(col==2){
        
        return user.getHouse_no();
        }
        if(col==3){
         return user.getAddress();
        }
       if (col == 4) {
            JButton btnrelative = new JButton("Relative");
            btnrelative.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btnrelative.getParent(), "Are you sure you want to View Relative Details");
                    if (result == JOptionPane.OK_OPTION) {
                        String id=user.getId();
                       new AdminRelativeViewFrame(id);
                       
                    } 
                }
            });
            return btnrelative;

        }
        if(col==5){
             return user.getName();
        }
         if(col==6){
             return user.getGender();
        }
         if(col==7){
            return user.getDisability();
        }
        if (col == 8) {
            JButton btn1 = new JButton("Scheme");
            btn1.addActionListener((ActionEvent ae) -> {
                int result = JOptionPane.showConfirmDialog(btn1.getParent(), "Are you sure you want to Sheme");
                if (result == JOptionPane.OK_OPTION) {
                    String Wardno=user.getWard_no();
                    String houseno=user.getHouse_no();
                    AdminPersonSchemeStatusFrame adminPersonSchemeStatusFrame;
                    adminPersonSchemeStatusFrame = new AdminPersonSchemeStatusFrame(Wardno,houseno); 
                }
            });
            return btn1;

        }
         if (col == 9) {
            JButton btn = new JButton("Details");
            btn.addActionListener((ActionEvent ae) -> {
                int result = JOptionPane.showConfirmDialog(btn.getParent(), "Are you sure you want to View Details");
                if (result == JOptionPane.OK_OPTION) {
                    String wardno=user.getWard_no();
                    String houseno=user.getHouse_no();
                    user.setWard_no(wardno);
                    user.setHouse_no(houseno);
                    new personHouseDetails(user);
                }
            });
            return btn;
            }
        if (col == 10) {
            JButton btnn = new JButton("Bank");
            btnn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btnn.getParent(), "Are you sure you want to View Bank");
                    if (result == JOptionPane.OK_OPTION) {
                       
                        new personBankDetails(user.getId());
                    }
                }
            });
            return btnn;
        }
        
         if (col ==11) {
            JButton btnPhoto = new JButton("Photo");
            btnPhoto.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btnPhoto.getParent(), "Are you sure you want to Person image");
                    if (result == JOptionPane.OK_OPTION) {
                        String id=user.getId();
                        new PhotoFrame(id);
                    }
                }
            });
            return btnPhoto;
        }
                  if (col ==12) {
            JButton btnProof = new JButton("Proof");
            btnProof.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btnProof.getParent(), "Are you sure you want to Person image");
                    if (result == JOptionPane.OK_OPTION) {
                        
                        String wardno=user.getWard_no();
                        String houseno=user.getHouse_no();
                    }
                }
            });
            return btnProof;
        }
          if (col == 13) {
            JButton btn = new JButton("Delete");
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    int result = JOptionPane.showConfirmDialog(btn.getParent(), "Are you sure you want to View Proof");
                    if ( result == JOptionPane.OK_OPTION) {
                        users.remove(row);
                        String Wardno=user.getWard_no();
                         String houseno=user.getHouse_no();
                         acr.DeleteUsername(user);
                         acr.DeleteRelative(user);
                         acr.DeleteAddress(user);
                         acr.DeletePerson(user);
                         acr.DeleteBank(user);
                         
                         AdminPersonDetailsTable.this.fireTableDataChanged();
                    } 
                }
            });
            return btn;
          }
        return null;
    }

}