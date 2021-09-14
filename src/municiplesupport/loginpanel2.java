/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import municiplesupport.Controller.UserController;

/**
 *
 * @author s4ct
 */
public class loginpanel2 extends JPanel {

    private UserController userControllerobj = new UserController();
    private ArrayList<loginData> users = new ArrayList<loginData>();
    JLabel lbllogin, lbluser, lblpass;
    JTextField userfld;
    JPasswordField passfld;
    JButton butloginButton, butRegButton;
    String nam, pas, selectvalue;
    loginData p;
    GridBagConstraints gbc = new GridBagConstraints();
    int count = 3;
    String file_name=null;
     JCheckBox select;
    public loginpanel2() {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 60));
        lbluser = new JLabel("Username");
        lbluser.setForeground(Color.WHITE);
        addgrid(1, 2).anchor = GridBagConstraints.LINE_END;
        add(lbluser, gbc);

        userfld = new JTextField(10);
        increaseFieldHeight(userfld, 25);
        userfld.setSize(new Dimension(150, 150));
        GridBagConstraints addgrid = addgrid(2, 2);
        add(userfld, gbc);

        lblpass = new JLabel("Password");
        lblpass.setForeground(Color.WHITE);
        addgrid(1, 3).anchor = GridBagConstraints.LINE_END;
        add(lblpass, gbc);

        passfld = new JPasswordField(10);
        increaseFieldHeight(passfld, 25);

        addgrid(2, 3);
        add(passfld, gbc);
        
        select=new JCheckBox("Show Password");
        addgrid(2, 4);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(select,gbc);
        
        
        
        butRegButton = new JButton("Register");
        butRegButton.setBackground(Color.BLACK);
        butRegButton.setForeground(Color.WHITE);
        GridBagConstraints gbcc = addgrid(2, 6);
        gbc.weighty = 200;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(butRegButton, gbc);

        butRegButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                RegistrationFrame res = new RegistrationFrame();
                ((LoginFrame) getRootPane().getParent()).dispose();
            }
        });
        select.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(select.isSelected()){
                passfld.setEchoChar((char)0);
                }
                else{
                passfld.setEchoChar('"');
                }
                
            }
        });

        butloginButton = new JButton("Login");
        butloginButton.setBackground(Color.BLACK);
        butloginButton.setForeground(Color.WHITE);
        GridBagConstraints gbcd = addgrid(2, 5);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(butloginButton, gbc);

        butloginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                nam = userfld.getText().toString();
                if (nam.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter user name");
                    return;
                }
                pas = passfld.getText().toString();
                if (pas.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter password");
                    return;
                }
                p = new loginData();
                userControllerobj = new UserController();
                users = userControllerobj.getLoginid(p);
                p.setUserName(nam);
                p.setPassword(pas);

                //System.out.println(p.getLogin_id());
                if (count > 0) {
                    if (nam.equals(("Admin")) || pas.equals("Admin")) {
                        ((LoginFrame) getRootPane().getParent()).dispose();
                        new Admin();
                    } else if (userControllerobj.isCheckLoginUserExists(p)) {
                        ((LoginFrame) getRootPane().getParent()).dispose();
                        PersonFrame n = new PersonFrame(p);

                    } else if (!userControllerobj.isCheckLoginUserExists(p)) {
                        JOptionPane.showMessageDialog(null, "invaild User name and password ");
                        count--;
                        if (count == 2) {
                            JOptionPane.showMessageDialog(null, "you have only two change ");
                        } else if (count == 1) {
                            JOptionPane.showMessageDialog(null, "you have only last change ");
                        } else if (count == 0) {
                            System.exit(0);
                        }
                    }

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
