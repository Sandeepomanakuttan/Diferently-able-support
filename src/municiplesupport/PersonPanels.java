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
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import municiplesupport.Controller.UserController;

/**
 *
 * @author kishore
 */
public final class PersonPanels extends JPanel {

    private UserController acr = new UserController();
    private ArrayList<loginData> users = new ArrayList<loginData>();
    JTextField houseField, nameField, usernameField, tadd, wardfld, relativefld, disabilityfld, passwordField;
    String name, pass, dis, Ages, Genders, idproof, m_idproof, Disability, username1, ward_no, house_no, addresss, relation, photo;
    private final JButton Back;

    GridBagConstraints gbc = new GridBagConstraints();

    public PersonPanels(loginData f) {

        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 40));
        setSize(900, 700);
        users = acr.getLoginid(f);
        acr.CollecteMyInformation(f);
        JLabel ward = new JLabel("Ward");
        ward.setForeground(Color.WHITE);
        assign(0, 1);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(ward, gbc);

        wardfld = new JTextField("", 10);
        wardfld.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(1, 1);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(wardfld, gbc);

        JLabel house = new JLabel("House No");
        house.setForeground(Color.WHITE);
        house.setFont(new Font("Arial", Font.PLAIN, 15));
        houseField = new JTextField("", 10);
        houseField.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(0, 2);

        gbc.anchor = GridBagConstraints.LINE_START;
        add(house, gbc);

        assign(1, 2);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(houseField, gbc);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setForeground(Color.WHITE);
        lbladdress.setFont(new Font("Arial", Font.PLAIN, 15));
        lbladdress.setSize(100, 30);
        assign(0, 3);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lbladdress, gbc);

        tadd = new JTextField(10);
        tadd.setForeground(Color.BLACK);
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(1, 3);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(tadd, gbc);

        JLabel lblrelative = new JLabel("Relation");
        lblrelative.setForeground(Color.WHITE);
        assign(0, 4);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblrelative, gbc);

        relativefld = new JTextField("", 10);
        relativefld.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(1, 4);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(relativefld, gbc);

        JLabel lblPersonName = new JLabel("Person Name");
        lblPersonName.setForeground(Color.WHITE);
        lblPersonName.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.anchor = GridBagConstraints.LINE_START;
        assign(0, 5);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblPersonName, gbc);

        nameField = new JTextField("", 10);
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(1, 5);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gbc);

        JLabel lblPhoto = new JLabel("Photo");
        lblPhoto.setForeground(Color.WHITE);
        assign(0, 6);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblPhoto, gbc);

        JTextArea fldPhoto = new JTextArea();
        fldPhoto.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.anchor = GridBagConstraints.LINE_START;
        assign(1, 6);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(fldPhoto, gbc);

        JLabel lbldob = new JLabel("DoB");
        lbldob.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.LINE_START;
        assign(0, 7);
        add(lbldob, gbc);

        JTextField fldDob = new JTextField("", 10);
        fldDob.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.anchor = GridBagConstraints.LINE_START;
        assign(1, 7);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(fldDob, gbc);

        JLabel Gen = new JLabel("Gender");
        Gen.setForeground(Color.WHITE);
        assign(0, 8);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(Gen, gbc);

        JTextField fldGender = new JTextField("", 10);
        fldDob.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.anchor = GridBagConstraints.LINE_START;
        assign(1, 8);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(fldGender, gbc);

        JLabel lblidProof = new JLabel("ID Proof");
        lblidProof.setForeground(Color.WHITE);
        assign(0, 9);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblidProof, gbc);

        JTextArea fldidProof = new JTextArea();
        fldPhoto.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.anchor = GridBagConstraints.LINE_START;
        assign(1, 9);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(fldidProof, gbc);

        JLabel lblmedicalProof = new JLabel("MedicaliD Proof");
        lblmedicalProof.setForeground(Color.WHITE);
        assign(0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblmedicalProof, gbc);

        JTextArea fldmodicalProof = new JTextArea();
        fldPhoto.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.anchor = GridBagConstraints.LINE_START;
        assign(1, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(fldmodicalProof, gbc);
       // PersonNameSetter h = new PersonNameSetter();

        JLabel disability = new JLabel("Disability");
        disability.setForeground(Color.WHITE);
        assign(0, 11);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(disability, gbc);

        JTextField fldDisability = new JTextField(f.getLogin_id());
        fldDob.setFont(new Font("Arial", Font.PLAIN, 15));
        gbc.anchor = GridBagConstraints.LINE_START;
        assign(1, 11);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(fldDisability, gbc);

        Back = new JButton("Back");
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        Back.setSize(100, 20);
        assign(1, 16);
        add(Back, gbc);
       

        System.out.println(f.getLogin_id());

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new personPage(f);
                ((PersonProfileFrame) getRootPane().getParent()).dispose();
            }
        });

        setVisible(true);
    }

    public void assign(int a, int b) {
        gbc.gridx = a;
        gbc.gridy = b;
    }

}
