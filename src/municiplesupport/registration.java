/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.time.format.DateTimeFormatter;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import municiplesupport.Controller.UserController;

/**
 *
 * @author s4ct
 */
public final class registration extends JPanel {

    JTextField houseField, nameField, usernameField, tadd;
    JPasswordField passwordField;
    JComboBox wardfld, relativefld, disabilityfld;
    JList age;
    int s=0;
    byte[] person_image=null,idproof_img=null,medicalid=null;
    String file_name=null,filename=null,filenames;
    ButtonGroup group;
    String name, pass, dis, Ages, Genders, idproof, m_idproof, Disability, username1, ward_no, house_no, addresss, relation, photo,strDate;
    public JLabel dob,lblperson_img,lblmedi_img,lblid;
    private final JLabel address;
    private final JButton sub, Back;
    public PersonNameSetter obj=new PersonNameSetter();

    GridBagConstraints gbc = new GridBagConstraints();

    public registration() {

        setLayout(new GridBagLayout());
        setBackground(new Color(0,0,0,40));
        setSize(900, 700);
        wardfld = new JComboBox();
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        m.addElement("Select WardNo");
        m.addElement("1");
        m.addElement("2");
        m.addElement("3");
        m.addElement("4");
        m.addElement("5");
        m.addElement("6");
        m.addElement("7");
        m.addElement("8");
        m.addElement("9");
        m.addElement("10");
        m.addElement("11");
        m.addElement("12");
        wardfld.setModel(m);

        JLabel ward = new JLabel("Ward");
        ward.setForeground(Color.WHITE);
        assign(0, 1);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(ward, gbc);

        assign(1, 1);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(wardfld, gbc);

        JLabel house = new JLabel("House No");
        house.setForeground(Color.WHITE);
        house.setFont(new Font("Arial", Font.PLAIN, 15));
        houseField = new JTextField("", 15);
        houseField.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(0, 2);

        gbc.anchor = GridBagConstraints.LINE_START;
        add(house, gbc);

        assign(1, 2);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(houseField, gbc);

        address = new JLabel("Address");
        address.setForeground(Color.WHITE);
        address.setFont(new Font("Arial", Font.PLAIN, 15));
        address.setSize(100, 30);
        assign(0, 3);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(address, gbc);

        tadd = new JTextField("", 15);
        //tadd.setForeground(Color.WHITE);
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(1, 3);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(tadd, gbc);

        relativefld = new JComboBox();
        DefaultComboBoxModel n = new DefaultComboBoxModel();
        n.addElement("Select Relative");
        n.addElement("Mother");
        n.addElement("Brother");
        n.addElement("Sister");
        n.addElement("Husband");
        n.addElement("Wife");
        n.addElement("Father");
        n.addElement("Friend");
        relativefld.setModel(n);

        JLabel relative = new JLabel("Relation");
        relative.setForeground(Color.WHITE);
        assign(0, 4);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(relative, gbc);

        assign(1, 4);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(relativefld, gbc);

        JLabel nameLabel1 = new JLabel("Person Name");
        nameLabel1.setForeground(Color.WHITE);
        nameLabel1.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField = new JTextField("", 15);
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.anchor = GridBagConstraints.LINE_START;
        assign(0, 5);

        gbc.anchor = GridBagConstraints.LINE_START;
        add(nameLabel1, gbc);

        assign(1, 5);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gbc);
    
        JLabel Photo = new JLabel("Photo");
        Photo.setForeground(Color.WHITE);
        JButton pho = new JButton("Upload Image");

        assign(0, 6);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(Photo, gbc);
        
        

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(pho, gbc);
        
        lblperson_img=new JLabel("",JLabel.RIGHT);
        lblperson_img.setVerticalAlignment(JLabel.TOP);
        lblperson_img.setFont(new Font("Verdana",Font.PLAIN,15));
        lblperson_img.setPreferredSize(new Dimension(100,100));
        lblperson_img.setForeground(new Color(20,90,40));
        lblperson_img.setBackground(new Color(100,20,70));
        javax.swing.border.Border border=BorderFactory.createLineBorder(Color.yellow);
        lblperson_img.setBorder(border);
        assign(4, 6);
        add(lblperson_img,gbc);

        dob = new JLabel("DoB");
        dob.setForeground(Color.WHITE);
        assign(0, 7);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(dob,gbc);
        
        JLabel cmd = new JLabel("yyyy/mm/dd");
        cmd.setForeground(Color.WHITE);
        assign(2, 7);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(cmd,gbc);
        
        JTextField date=new JTextField(15);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(1, 7);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(date, gbc);
        
        JRadioButton male = new JRadioButton("Male");
        male.setActionCommand("Male");
        JRadioButton female = new JRadioButton("Female");
        female.setActionCommand("Female");

        JLabel Gen = new JLabel("Gender");
        Gen.setForeground(Color.WHITE);
        assign(0, 8);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(Gen, gbc);

        assign(1, 8);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(male, gbc);

        assign(1, 9);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(female, gbc);

        group = new ButtonGroup();
        group.add(male);
        group.add(female);

        JLabel id = new JLabel("ID Proof");
        id.setForeground(Color.WHITE);
        JButton upid = new JButton("Upload Image");

        assign(0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(upid, gbc);
        
        
        lblid=new JLabel();
        lblid=new JLabel("",JLabel.RIGHT);
        lblid.setVerticalAlignment(JLabel.TOP);
        lblid.setFont(new Font("Verdana",Font.PLAIN,15));
        lblid.setPreferredSize(new Dimension(100,100));
        lblid.setForeground(new Color(20,90,40));
        lblid.setBackground(new Color(100,20,70));
        javax.swing.border.Border borders=BorderFactory.createLineBorder(Color.yellow);
        lblid.setBorder(borders);
        assign(4, 10);
        add(lblid,gbc);



        JLabel idm = new JLabel("MedicaliD Proof");
        idm.setForeground(Color.WHITE);
        JButton upmid = new JButton("Upload Image");

        assign(0, 11);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(idm, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(upmid, gbc);
        
        lblmedi_img=new JLabel("",JLabel.RIGHT);
        lblmedi_img.setVerticalAlignment(JLabel.TOP);
        lblmedi_img.setFont(new Font("Verdana",Font.PLAIN,15));
        lblmedi_img.setPreferredSize(new Dimension(100,100));
        lblmedi_img.setForeground(new Color(20,90,40));
        lblmedi_img.setBackground(new Color(100,20,70));
        javax.swing.border.Border border1 ;
        border1 = BorderFactory.createLineBorder(Color.yellow);
        lblmedi_img.setBorder(border1);
        assign(4, 11);
        add(lblmedi_img,gbc);


        disabilityfld = new JComboBox();
        DefaultComboBoxModel D = new DefaultComboBoxModel();
        D.addElement("Select Different Ability");
        D.addElement("Blindness");
        D.addElement("Low vision");
        D.addElement("Cerebal Palsy");
        D.addElement("Hearing impairment");
        D.addElement("Leprosy cured");
        D.addElement("Locomotor disability");
        D.addElement("Mental illness");
        D.addElement("Dyslexia");
        D.addElement("Handicap");
        disabilityfld.setModel(D);

        JLabel disability = new JLabel("Disability");
        disability.setForeground(Color.WHITE);
        assign(0, 12);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(disability, gbc);

        assign(1, 12);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(disabilityfld, gbc);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setSize(100, 20);
        assign(1, 14);
        add(sub, gbc);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        Back.setSize(100, 20);
        assign(1, 16);
        add(Back, gbc); 
        
         pho.addActionListener((ActionEvent ae) -> {
             JFileChooser Chooser = new JFileChooser();
             Chooser.showOpenDialog(null);
             File f=Chooser.getSelectedFile();
             file_name=f.getAbsolutePath();
             //lblperson_img.setText(file_name);
             ImageIcon imageIcon=new ImageIcon(new ImageIcon(file_name).getImage().getScaledInstance(lblperson_img.getWidth(),lblperson_img.getHeight(),Image.SCALE_SMOOTH));
             lblperson_img.setIcon(imageIcon);
             System.out.println(lblperson_img);
             try{
                 File image=new File(file_name);
                 FileInputStream fis=new FileInputStream(image);
                 ByteArrayOutputStream bos=new ByteArrayOutputStream();
                 byte[] buf=new byte[1024];
                 for(int readNum;(readNum=fis.read(buf))!=-1;){
                     bos.write(buf,0,readNum);
                 }
                 person_image=bos.toByteArray();
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null, e);
             }
        });


         upid.addActionListener((ActionEvent ae) -> {
             JFileChooser fileChooser = new JFileChooser();
             fileChooser.showOpenDialog(null);
             File f=fileChooser.getSelectedFile();
             filename=f.getAbsolutePath();
             ImageIcon imageIcon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblid.getWidth(),lblid.getHeight(),Image.SCALE_SMOOTH));
             lblid.setIcon(imageIcon);
             try{
                 File image=new File(filename);
                 FileInputStream fis=new FileInputStream(image);
                 ByteArrayOutputStream bos=new ByteArrayOutputStream();
                 byte[] buf=new byte[1024];
                 for(int readNum;(readNum=fis.read(buf))!=-1;){
                     bos.write(buf,0,readNum);
                 }
                 idproof_img=bos.toByteArray();
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null, e);
             }
        });


          upmid.addActionListener((ActionEvent ae) -> {
              JFileChooser fileChooser = new JFileChooser();
              fileChooser.showOpenDialog(null);
              File f=fileChooser.getSelectedFile();
              filenames=f.getAbsolutePath();
              ImageIcon imageIcon=new ImageIcon(new ImageIcon(filenames).getImage().getScaledInstance(lblmedi_img.getWidth(),lblmedi_img.getHeight(),Image.SCALE_SMOOTH));
              lblmedi_img.setIcon(imageIcon);
              try{
                  File image=new File(filenames);
                  FileInputStream fis=new FileInputStream(image);
                  ByteArrayOutputStream bos=new ByteArrayOutputStream();
                  byte[] buf=new byte[1024];
                  for(int readNum;(readNum=fis.read(buf))!=-1;){
                      bos.write(buf,0,readNum);
                  }
                  medicalid=bos.toByteArray();
              }
              catch(Exception e){
                  JOptionPane.showMessageDialog(null, e);
              }
        });

        
       
      

        sub.addActionListener((ActionEvent ae) -> {
            ward_no = wardfld.getSelectedItem().toString();
            if (ward_no.equals("")) {
                JOptionPane.showMessageDialog(null, "select Ward_no");
                return;
            }
            house_no = houseField.getText().toString();
            if (house_no.equals("")) {
                JOptionPane.showMessageDialog(null, "select house no");
                return;
            }
            addresss = tadd.getText().toString();
            if (addresss.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter address");
                return;
            }
            
            relation = relativefld.getSelectedItem().toString();
            if (relation.equals("")) {
                JOptionPane.showMessageDialog(null, "Select relation");
                return;
            }
            name = nameField.getText().toString();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter user name");
                return;
            }
            
            strDate = date.getText().toString();
            if (strDate.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter user date of birth");
                return;
            }
            
            
            Genders = group.getSelection().getActionCommand().toString();
            if (Genders.equals("")) {
                JOptionPane.showMessageDialog(null, "Select gender");
                return;
            }
            Disability = disabilityfld.getSelectedItem().toString();
            if (Disability.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Disability");
                return;
            }
            
            
            
            
            obj.setIdpicture(idproof_img);
            obj.setMedicalpicture(medicalid);
            obj.setPicture(person_image);
            obj.setWard_no(ward_no);
            obj.setHouse_no(house_no);
            obj.setAddress(addresss);
            obj.setRelation(relation);
            obj.setName(name);
            obj.setGender(Genders);
            obj.setDisability(Disability);
            obj.setDob(strDate);
            UserController c = new UserController();
            if (c.checkPersonInMuniciple(obj)) {
                if (!c.checkPersonAlreadyExists(obj)) {
                    c.insertUser(obj);
                    c.getPerson_id(obj);
                    ((RegistrationFrame)getRootPane().getParent()).dispose();
                    new RelativeFrame(obj.getId());
                    //new SetUserName();
                    //System.out.println(setobj.getLogin_id());
                }
                else{
                    JOptionPane.showMessageDialog(getParent(), "User Already Exist");
                }
            } else {
                JOptionPane.showMessageDialog(getParent(), "invalid Registration");
            }
        });

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((RegistrationFrame)getRootPane().getParent()).dispose();
                new LoginFrame();
            }
        });

        setVisible(true);
    }

    public void assign(int a, int b) {
        gbc.gridx = a;
        gbc.gridy = b;
    }

}
