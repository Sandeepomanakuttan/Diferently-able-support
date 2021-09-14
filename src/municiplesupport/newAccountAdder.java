/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import municiplesupport.Controller.AdminController;
import municiplesupport.Controller.UserController;
import municiplesupport.DataCollectionClass.HospitalDataTacker;

/**
 *
 * @author kishore
 */
public class newAccountAdder extends JPanel{
   
    
    GridBagConstraints gbc=new GridBagConstraints();
    JLabel lblAccount_No,lblRe_Enter_Account_No,lblName,lblIFSC_Code,lblBank_Name,lblPlace;
    JTextField Account_Nofld,Placefld,Re_Enter_Account_Nofld,IFSC_Codefld,Bank_Namefld,Namefld;
    JComboBox disabilitySelector,disctrictfld;
    public newAccountAdder(loginData f) {
    setLayout(new GridBagLayout());
    setSize(900,700);
    setBackground(new Color(0, 0, 0, 50));
    lblAccount_No=new JLabel("Account No");
    lblAccount_No.setForeground(Color.WHITE);
    assign(0,1);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(lblAccount_No,gbc);
     
    Account_Nofld=new JTextField("",10); 
    Account_Nofld.setFont(new Font("Arial", Font.PLAIN, 15));
    assign(1,1);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(Account_Nofld,gbc);
    
    lblRe_Enter_Account_No=new JLabel("Re Enter Account No");
    lblRe_Enter_Account_No.setForeground(Color.WHITE);
    lblRe_Enter_Account_No.setFont(new Font("Arial", Font.PLAIN, 15)); 
    Re_Enter_Account_Nofld=new JTextField("",10); 
    Re_Enter_Account_Nofld.setFont(new Font("Arial", Font.PLAIN, 15));
    assign(0,2);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(lblRe_Enter_Account_No,gbc);
    assign(1,2);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(Re_Enter_Account_Nofld,gbc);
    
   
    
    lblName=new JLabel("Name");
    lblName.setForeground(Color.WHITE);
    assign(0,3);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(lblName,gbc);
     
    Namefld=new JTextField("",10); 
    Namefld.setFont(new Font("Arial", Font.PLAIN, 15));
    assign(1,3);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(Namefld,gbc);
    
    lblIFSC_Code=new JLabel("IFSC Code");
    lblIFSC_Code.setForeground(Color.WHITE);
    lblIFSC_Code.setFont(new Font("Arial", Font.PLAIN, 15)); 
    IFSC_Codefld=new JTextField("",10); 
    IFSC_Codefld.setFont(new Font("Arial", Font.PLAIN, 15));
    assign(0,4);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(lblIFSC_Code,gbc);
    assign(1,4);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(IFSC_Codefld,gbc);
    
    lblBank_Name=new JLabel("Bank Name");
    lblBank_Name.setForeground(Color.WHITE);
    lblBank_Name.setFont(new Font("Arial", Font.PLAIN, 15)); 
    Bank_Namefld=new JTextField("",10); 
    Bank_Namefld.setFont(new Font("Arial", Font.PLAIN, 15));
    assign(0,5);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(lblBank_Name,gbc);
    assign(1,5);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(Bank_Namefld,gbc);
    
    lblPlace=new JLabel("Place");
    lblPlace.setForeground(Color.WHITE);
    lblPlace.setFont(new Font("Arial", Font.PLAIN, 15)); 
    Placefld=new JTextField("",10); 
    Placefld.setFont(new Font("Arial", Font.PLAIN, 15));
    assign(0,6);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(lblPlace,gbc);
    assign(1,6);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(Placefld,gbc);
    
    JButton sub = new JButton("Submit"); 
    sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
    sub.setSize(100, 20); 
    assign(1,14); 
    add(sub,gbc);
    
    JButton Back = new JButton("Back"); 
    sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
    sub.setSize(100, 20); 
    assign(1,16); 
    add(Back,gbc);
    
    sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String ac=Account_Nofld.getText().toString();
           if(ac.equals("")){
               JOptionPane.showMessageDialog(null, "please Enter Acount No");
               return;
           }
           String Reac=Re_Enter_Account_Nofld.getText().toString();
           if(Reac.equals("")){
               JOptionPane.showMessageDialog(null, "please Enter Acount No");
               return;
           }
           if(!ac.equals(Reac)){
               JOptionPane.showMessageDialog(null, "Does not match Account No");
               return;
           }
           
           String name=Namefld.getText().toString();
           if(name.equals("")){
               JOptionPane.showMessageDialog(null, "Enter The Name Place");
               return;
           }
           String placeChooser=Placefld.getText().toString();
           if(placeChooser.equals("")){
               JOptionPane.showMessageDialog(null, "Enter Place");
               return;
           }
           
            String ifscChooser=IFSC_Codefld.getText().toString();
           if(ifscChooser.equals("")){
               JOptionPane.showMessageDialog(null, "Enter IFSC");
               return;
           }
           
           String BankChooser=Bank_Namefld.getText().toString();
           if(BankChooser.equals("")){
               JOptionPane.showMessageDialog(null, "Enter Bank Name");
               return;
           }
           String id=f.getLogin_id();
           BankDataTacker p=new BankDataTacker();
           p.setLblAccount_No(ac);
           p.setId(id);
           p.setLblName(name);
           p.setLblIFSC_Code(ifscChooser);
           p.setLblBank_Name(BankChooser);
           p.setLblPlace(placeChooser);
           UserController UserControllerobj=new UserController();
           if(!UserControllerobj.AccountAlreadyExist(p)){
               UserControllerobj.insertAccount(p);
               JOptionPane.showMessageDialog(null, "Succefully Insert");
           }
           else{
               JOptionPane.showMessageDialog(null, "Account Already Exists");
           }
           }
           
            
            
        });
    Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ((AddBankAccountFrame)getRootPane().getParent()).dispose();
                new PersonFrame(f);
            }
        });
        setVisible(true);
        
        
        
    }
      public void assign(int a,int b){
        gbc.gridx=a;
        gbc.gridy=b;
    }
}

