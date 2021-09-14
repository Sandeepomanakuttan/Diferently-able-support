/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

/**
 *
 * @author RAMESH
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.cj.protocol.Resultset;
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
import java.io.File;
import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.Clock.system;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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
import municiplesupport.Controller.AdminController;
import municiplesupport.Controller.UserController;
import municiplesupport.Database.Database;

/**
 *
 * @author s4ct
 */
public final class UserProfile extends JPanel {

    public JLabel houseField, nameField, usernameField, tadd,wardfld, relativefld, disabilityfld;
    public JLabel age;
    public JLabel person_image;
    byte[] person_imag=null,idproof_img=null,medicalid=null;
    public String file_name=null,filename=null,filenames;
    String file_name1,name, pass, dis, Ages, Genders, idproof, m_idproof, Disability, username1, ward_no, house_no, addresss, relation, photo,strDate;
    public JLabel dob,lblperson_img;
    private JLabel lbladdress;
    private JButton Back;
    private final UserController acr = new UserController();
    private ArrayList<PersonNameSetter> users = new ArrayList<>();
    PersonNameSetter c;
    GridBagConstraints gbc = new GridBagConstraints();

    UserProfile(String ward, String house, String address, String relation, String name, String gen, String Dis, String Dof, byte[] perimage) {
     
        setLayout(new GridBagLayout());
        setBackground(new Color(0,0,0,40));
        setSize(900, 700);
        
        wardfld = new JLabel();

        JLabel lblward = new JLabel("Ward No");
        lblward.setForeground(Color.WHITE);
        assign(0, 1);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblward, gbc);

        assign(1, 1);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(wardfld, gbc);

        JLabel lblhouse = new JLabel("House No");
        lblhouse.setForeground(Color.WHITE);
        lblhouse.setFont(new Font("Arial", Font.PLAIN, 15));
        houseField = new JLabel();
        houseField.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(0, 2);

        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblhouse, gbc);

        assign(1, 2);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(houseField, gbc);

        lbladdress = new JLabel("Address");
        lbladdress.setForeground(Color.WHITE);
        lbladdress.setFont(new Font("Arial", Font.PLAIN, 15));
        lbladdress.setSize(100, 30);
        assign(0, 3);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lbladdress, gbc);

        tadd = new JLabel();
        //tadd.setForeground(Color.WHITE);
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(1, 3);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(tadd, gbc);

        relativefld = new JLabel();
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
        nameField = new JLabel();
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

        assign(0, 6);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(Photo, gbc);
        
        lblperson_img=new JLabel("",JLabel.RIGHT);
        lblperson_img.setVerticalAlignment(JLabel.TOP);
        lblperson_img.setFont(new Font("Verdana",Font.PLAIN,15));
        lblperson_img.setPreferredSize(new Dimension(100,100));
        lblperson_img.setForeground(new Color(20,90,40));
        lblperson_img.setBackground(new Color(100,20,70));
        javax.swing.border.Border border=BorderFactory.createLineBorder(Color.yellow);
        lblperson_img.setBorder(border);
        assign(1, 6);
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
        
        JLabel date=new JLabel();
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(1, 7);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(date, gbc);
        
        JLabel g=new JLabel();

        JLabel Gen = new JLabel("Gender");
        Gen.setForeground(Color.WHITE);
        assign(0, 8);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(Gen, gbc);

        assign(1, 8);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(g, gbc);


        JLabel id = new JLabel("ID Proof");
        id.setForeground(Color.WHITE);
        assign(0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(id, gbc);
        
        
        JLabel lblid=new JLabel();
        lblid=new JLabel("",JLabel.RIGHT);
        lblid.setVerticalAlignment(JLabel.TOP);
        lblid.setFont(new Font("Verdana",Font.PLAIN,15));
        lblid.setPreferredSize(new Dimension(100,100));
        lblid.setForeground(new Color(20,90,40));
        lblid.setBackground(new Color(100,20,70));
        javax.swing.border.Border borders=BorderFactory.createLineBorder(Color.yellow);
        lblid.setBorder(borders);
        assign(1, 10);
        add(lblid,gbc);

        //wardfld.setText(c.getWard_no());

        JLabel idm = new JLabel("MedicaliD Proof");
        idm.setForeground(Color.WHITE);

        assign(0, 11);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(idm, gbc);

        
        JLabel lblmedi_img=new JLabel("",JLabel.RIGHT);
        lblmedi_img.setVerticalAlignment(JLabel.TOP);
        lblmedi_img.setFont(new Font("Verdana",Font.PLAIN,15));
        lblmedi_img.setPreferredSize(new Dimension(100,100));
        lblmedi_img.setForeground(new Color(20,90,40));
        lblmedi_img.setBackground(new Color(100,20,70));
        javax.swing.border.Border border1 ;
        border1 = BorderFactory.createLineBorder(Color.yellow);
        lblmedi_img.setBorder(border1);
        assign(1, 11);
        add(lblmedi_img,gbc);


        disabilityfld = new JLabel();

        JLabel disability = new JLabel("Disability");
        disability.setForeground(Color.WHITE);
        assign(0, 12);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(disability, gbc);

        assign(1, 12);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(disabilityfld, gbc);
        
        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        Back.setSize(100, 20);
        assign(1, 16);
        add(Back, gbc); 
        wardfld.setText(ward);
        houseField.setText(house);
        tadd.setText(address);
        nameField.setText(name);
        disabilityfld.setText(Dis);
        g.setText(gen);
        date.setText(Dof);
        System.out.println(perimage);
        ImageIcon imageIcon=new ImageIcon(perimage);
               // Image im=perimage.getImage();
                //Image myImg=im.getScaledInstance(lblperson_img.getWidth(),lblperson_img.getHeight(),Image.SCALE_SMOOTH);
             //ImageIcon imageIcon=new ImageIcon(new ImageIcon(file_name).getImage().getScaledInstance(lblperson_img.getWidth(),lblperson_img.getHeight(),Image.SCALE_SMOOTH));
             lblperson_img.setIcon(imageIcon);
                //lblperson_img.setIcon(newImage);
       //lblperson_img.setIcon(newImage);
               // System.out.println(newImage);
                System.out.println(lblperson_img);

        
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((UserProfileFrame)getRootPane().getParent()).dispose();
              //  new PersonFrame(f);
            }
        });

        setVisible(true);
    }

    public void assign(int a, int b) {
        gbc.gridx = a;
        gbc.gridy = b;
    }

}

