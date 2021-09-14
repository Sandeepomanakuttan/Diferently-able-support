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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import municiplesupport.Controller.AdminController;

/**
 *
 * @author kishore
 */
public class DatePanels extends JPanel {

    GridBagConstraints gbc = new GridBagConstraints();

    public DatePanels(String id,String name) {

        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 60));
        JLabel lblDate = new JLabel("Date");
        lblDate.setForeground(Color.WHITE);
        addgrid(1, 1).anchor = GridBagConstraints.LINE_END;
        add(lblDate, gbc);

        JTextField fldDate = new JTextField(10);
        increaseFieldHeight(fldDate, 25);
        fldDate.setSize(new Dimension(150, 150));
        GridBagConstraints addgrid = addgrid(2, 1);
        add(fldDate, gbc);

      
        JButton submit = new JButton("submit");
        submit.setBackground(Color.WHITE);
        GridBagConstraints gbcc = addgrid(2, 7);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submit, gbc);

        JButton Back = new JButton("Back");
        Back.setBackground(Color.WHITE);
        GridBagConstraints gb = addgrid(2, 8);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(Back, gbc);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //((DataFrame)getRootPane().getParent()).dispose();
                new Admin();
               

            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               
                String Date = fldDate.getText().toString();
                if (Date.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Date");
                    return;
                }
               
               SchemeDataTaker obj=new SchemeDataTaker();
                obj.setDate(Date);
                AdminController c = new AdminController();
                String dat=obj.getDate();
                String Person_id=id;
                    c.insertDate(id,dat,name);
                    JOptionPane.showMessageDialog(getParent(), "Date is Succefully Added");
                SchemeAdminDetailsTable schemeAdminDetailsTable = new SchemeAdminDetailsTable();
                
            }

        }
        );
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


