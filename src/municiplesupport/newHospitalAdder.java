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
import municiplesupport.DataCollectionClass.HospitalDataTacker;

/**
 *
 * @author kishore
 */
public class newHospitalAdder extends JPanel{
   
    
    GridBagConstraints gbc=new GridBagConstraints();
    JLabel Disability,hospitalName,disctrict,Place,about;
    JTextField hospitalfld,Placefld,aboutfld;
    JComboBox disabilitySelector,disctrictfld;
    public newHospitalAdder() {
    setLayout(new GridBagLayout());
    setSize(900,700);
    setBackground(new Color(0, 0, 0, 50));
    disabilitySelector=new JComboBox();
    DefaultComboBoxModel m=new DefaultComboBoxModel();
    m.addElement("Select Different Ability");
    m.addElement("Blindness");
    m.addElement("Low vision");
    m.addElement("Cerebal Palsy");
    m.addElement("Hearing impairment");
    m.addElement("Leprosy cured");
    m.addElement("Locomotor disability");
    m.addElement("Mental illness");
    m.addElement("Dyslexia");
    m.addElement("Handicap");
    disabilitySelector.setModel(m);
    
    Disability=new JLabel("Disability");
    Disability.setForeground(Color.WHITE);
    assign(0,1);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(Disability,gbc);
     
    assign(1,1);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(disabilitySelector,gbc);
    
    hospitalName=new JLabel("Hospital Name");
    hospitalName.setForeground(Color.WHITE);
    hospitalName.setFont(new Font("Arial", Font.PLAIN, 15)); 
    hospitalfld=new JTextField("",10); 
    hospitalfld.setFont(new Font("Arial", Font.PLAIN, 15));
    assign(0,2);
    
    gbc.anchor=GridBagConstraints.LINE_START;
    add(hospitalName,gbc);
    
    
    
    assign(1,2);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(hospitalfld,gbc);
    
    disctrictfld=new JComboBox();
    DefaultComboBoxModel n=new DefaultComboBoxModel();
    n.addElement("Idukki");
    n.addElement("Eranakulam");
    n.addElement("Thrisur");
    n.addElement("Kannur");
    disctrictfld.setModel(n);
    
    disctrict=new JLabel("Distict");
    disctrict.setForeground(Color.WHITE);
    assign(0,3);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(disctrict,gbc);
     
    assign(1,3);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(disctrictfld,gbc);
    
    Place=new JLabel("Place");
    Place.setForeground(Color.WHITE);
    Place.setFont(new Font("Arial", Font.PLAIN, 15)); 
    Placefld=new JTextField("",10); 
    Placefld.setFont(new Font("Arial", Font.PLAIN, 15));
    assign(0,4);
    
    gbc.anchor=GridBagConstraints.LINE_START;
    add(Place,gbc);
    
    
    
    assign(1,4);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(Placefld,gbc);
    
    about=new JLabel("About");
    about.setForeground(Color.WHITE);
    about.setFont(new Font("Arial", Font.PLAIN, 15)); 
    aboutfld=new JTextField("",10); 
    aboutfld.setFont(new Font("Arial", Font.PLAIN, 15));
    assign(0,5);
    
    gbc.anchor=GridBagConstraints.LINE_START;
    add(about,gbc);
    
    
    
    assign(1,5);
    gbc.anchor=GridBagConstraints.LINE_START;
    add(aboutfld,gbc);
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
            String dis=disabilitySelector.getSelectedItem().toString();
           if(dis.equals("")){
               JOptionPane.showMessageDialog(null, "select Disability");
               return;
           }
           String HospitalNameChooser=hospitalfld.getText().toString();
           if(HospitalNameChooser.equals("")){
               JOptionPane.showMessageDialog(null, "Enter Hospital Name");
               return;
           }
           String districtChooser=disctrictfld.getSelectedItem().toString();
           if(districtChooser.equals("")){
               JOptionPane.showMessageDialog(null, "Select District");
               return;
           }
           String placeChooser=Placefld.getText().toString();
           if(placeChooser.equals("")){
               JOptionPane.showMessageDialog(null, "Enter Place");
               return;
           }
            String aboutChooser=aboutfld.getText().toString();
           if(aboutChooser.equals("")){
               JOptionPane.showMessageDialog(null, "Enter Address");
               return;
           }
           HospitalDataTacker p=new HospitalDataTacker();
           p.setDisability(dis);
           p.setHospitalName(HospitalNameChooser);
           p.setDisctrict(districtChooser);
           p.setPlace(placeChooser);
           p.setAbout(aboutChooser);
           AdminController AdminControllerobj=new AdminController();
           if(!AdminControllerobj.ValidateHospitalAlreadyExists(p)){
               AdminControllerobj.insertHospital(p);
               JOptionPane.showMessageDialog(null, "Succefully Insert");
           }
           else{
               JOptionPane.showMessageDialog(null, "Hospital Already Exists");
           }
           }
           
            
            
        });
    Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ((addHospital)getRootPane().getParent()).dispose();
                new Admin();
            }
        });
        setVisible(true);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }
      public void assign(int a,int b){
        gbc.gridx=a;
        gbc.gridy=b;
    }
}

