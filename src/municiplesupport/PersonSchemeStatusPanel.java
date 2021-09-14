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
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import municiplesupport.Controller.AdminController;

/**
 *
 * @author RAMESH
 */
class PersonSchemeStatusPanel extends JPanel {

   
    GridBagConstraints gbc = new GridBagConstraints();
    public PersonSchemeStatusPanel(String name, String Disability) {
        
       setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 60));
        JButton Request = new JButton("Request Scheme");
        Request.setForeground(Color.WHITE);
        addgrid(1, 1).anchor = GridBagConstraints.LINE_END;
        add(Request, gbc);
        
        
        JButton Accept = new JButton("Accept Scheme");
        Accept.setForeground(Color.WHITE);
        addgrid(2, 1).anchor = GridBagConstraints.LINE_END;
        add(Accept, gbc);
        
        JButton Reject = new JButton("Reject Scheme");
        Reject.setForeground(Color.WHITE);
        addgrid(3, 1).anchor = GridBagConstraints.LINE_END;
        add(Reject, gbc);
        
        JButton Back = new JButton("Back");
        Back.setBackground(Color.WHITE);
        GridBagConstraints gbcc = addgrid(4, 1);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(Back, gbc);
        
        Request.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
             new RequestScheme_personFrame(name,Disability); 
               
           }
       });
        
          
        Accept.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
             new AcceptScheme_personFrame(name,Disability); 
               
           }
       });
        
         Reject.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
             new RejectScheme_personFrame(name,Disability); 
               
           }
       });
        
          Back.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
             ((PersonSchemeStatusFrame)getRootPane().getParent()).dispose();
               
           }
       });
    }
    
public GridBagConstraints addgrid(int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 2;
        gbc.weighty = 0;
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

    

