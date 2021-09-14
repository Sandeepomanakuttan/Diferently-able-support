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
import javax.swing.JButton;
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
public class SetUserNamePasswordPanel extends JPanel {

    JLabel lbluser, lblpass;
    JTextField userfld;
    JPasswordField passfld;
    JButton butRegButton;
    String nam, pas, selectvalue;
    private UserController userControllerobj = new UserController();
    private ArrayList<loginData> users = new ArrayList<loginData>();
    GridBagConstraints gbc = new GridBagConstraints();

    public SetUserNamePasswordPanel() {
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
        addgrid(1, 3).anchor = GridBagConstraints.LINE_END;;
        add(lblpass, gbc);

        passfld = new JPasswordField(10);
        increaseFieldHeight(passfld, 25);

        addgrid(2, 3);
        add(passfld, gbc);

        butRegButton = new JButton("Register");
        butRegButton.setBackground(Color.BLACK);
        butRegButton.setForeground(Color.WHITE);
        GridBagConstraints gbcc = addgrid(2, 4);
        gbc.weighty = 200;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(butRegButton, gbc);

        butRegButton.addActionListener(new ActionListener() {

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
                SetUserNamePasswordData p = new SetUserNamePasswordData(nam, pas);
                if (!userControllerobj.isUserAlreadyExist(p)) {
                    userControllerobj.SetUsernamePassword(p);
                    userControllerobj.getLogin(p);

                    JOptionPane.showMessageDialog(null, "Username and Password is Succefully Saved");
                    new LoginFrame();
                    ((SetUserName) getRootPane().getParent()).dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Username and Password already Exits");
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
