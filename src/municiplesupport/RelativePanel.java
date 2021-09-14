/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import municiplesupport.Controller.UserController;

/**
 *
 * @author kishore
 */
public class RelativePanel extends JPanel {

    JLabel lblRelation,lblName,lblAddress,lblContact_No;
    JTextField fldName,fldAddress,fldContact_No;
    JComboBox fldrelative;
    JButton btnSubmit;
    String RelationChooser,NameChooser,AddressChooser,Contact_NoChooser;
    GridBagConstraints gbc = new GridBagConstraints();

    public RelativePanel(String id) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 60));

        fldrelative= new JComboBox();
        DefaultComboBoxModel n = new DefaultComboBoxModel();
        n.addElement("Select Relative");
        n.addElement("Mother");
        n.addElement("Brother");
        n.addElement("Sister");
        n.addElement("Husband");
        n.addElement("Wife");
        n.addElement("Father");
        n.addElement("Friend");
        fldrelative.setModel(n);

        lblRelation = new JLabel("Relation");
        lblRelation.setForeground(Color.WHITE);
        addgrid(0,1).anchor = GridBagConstraints.LINE_END;
        add(lblRelation, gbc);

        addgrid(1, 1);
        add(fldrelative, gbc);
  
        lblName = new JLabel("Name");
        lblName.setForeground(Color.WHITE);
        addgrid(0, 2).anchor = GridBagConstraints.LINE_END;;
        add(lblName, gbc);

        fldName = new JTextField(10);
        increaseFieldHeight(fldName, 25);
        addgrid(1, 2);
        add(fldName, gbc);
        
        lblContact_No = new JLabel("Contact");
        lblContact_No.setForeground(Color.WHITE);
        addgrid(0,3).anchor = GridBagConstraints.LINE_END;;
        add(lblContact_No, gbc);

        fldContact_No = new JTextField(10);
        increaseFieldHeight(fldName, 25);
        addgrid(1, 3);
        add(fldContact_No, gbc);
        
        lblAddress = new JLabel("Address");
        lblAddress.setForeground(Color.WHITE);
        addgrid(0, 4).anchor = GridBagConstraints.LINE_END;;
        add(lblAddress, gbc);

        fldAddress = new JTextField(10);
        increaseFieldHeight(fldName, 25);
        addgrid(1,4);
        add(fldAddress, gbc);

        btnSubmit= new JButton("Submit");
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        GridBagConstraints gbcc = addgrid(1, 6);
        gbc.weighty = 200;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(btnSubmit, gbc);

        btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                 RelationChooser= fldrelative.getSelectedItem().toString();
                if (RelationChooser.equals("")) {
                    JOptionPane.showMessageDialog(null, "Select Relation");
                    return;
                }
                NameChooser = fldName.getText().toString();
                if (NameChooser.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Name");
                    return;
                }
                   
                Contact_NoChooser = fldContact_No.getText().toString();
                if (NameChooser.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Contact No");
                    return;
                }
                AddressChooser = fldAddress.getText().toString();
                if (AddressChooser.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Address");
                    return;
                }
                RelativeDataTacker p = new RelativeDataTacker();
                p.setLblRelation(RelationChooser);
                p.setLblName(NameChooser);
                p.setLblContact_No(Contact_NoChooser);
                p.setLblAddress(AddressChooser);
                p.setId(id);
                UserController userControllerobj=new UserController();
                if (!userControllerobj.isRelativeAlreadyExist(p)) {
                    userControllerobj.insertRelative(p);
                    

                    JOptionPane.showMessageDialog(null, " Succefully Saved");
                    new SetUserName();
                    ((RelativeFrame) getRootPane().getParent()).dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "already Exits");
                }

            }
        });

    }


    public GridBagConstraints addgrid(int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 2;
        gbc.weighty = 2;
        gbc.insets = new Insets(0, 0, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        return gbc;
    }

    private void increaseFieldHeight(JTextField field, int ht) {
        Dimension d = field.getPreferredSize();
        d.height = ht;
        field.setPreferredSize(d);
    }

}