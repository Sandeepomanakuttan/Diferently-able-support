/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author s4ct
 */
public final class LoginFrame extends JFrame {

    //GridBagConstraints gbc=new GridBagConstraints();
    public LoginFrame() {
        super("Login Form");
        setSize(900, 700);
        setLocationRelativeTo(null);
        MainPanel p=new MainPanel();
        p.add(new loginpanel2());
        setContentPane(p);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
