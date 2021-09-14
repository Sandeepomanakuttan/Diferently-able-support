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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import municiplesupport.Controller.AdminController;

/**
 *
 * @author kishore
 */
public class SchemeAdderPanel extends JPanel {

    GridBagConstraints gbc = new GridBagConstraints();
    JLabel Disability, Schemecatagory, lblSchemecatagory_criteria,lblAmount;
    JTextField Schemefld, Schemecatagory_criteriafld,Amountfld;
    JComboBox disabilitySelector;

    public SchemeAdderPanel() {

        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 60));
        disabilitySelector = new JComboBox();
        DefaultComboBoxModel m = new DefaultComboBoxModel();
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

        Disability = new JLabel("Disability");
        Disability.setForeground(Color.WHITE);
        assign(0, 1);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(Disability, gbc);

        assign(1, 1);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(disabilitySelector, gbc);

        Schemecatagory = new JLabel("Scheme Name");
        Schemecatagory.setForeground(Color.WHITE);
        Schemecatagory.setFont(new Font("Arial", Font.PLAIN, 15));
        Schemefld = new JTextField("", 10);
        Schemefld.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(0, 2);

        gbc.anchor = GridBagConstraints.LINE_START;
        add(Schemecatagory, gbc);

        assign(1, 2);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(Schemefld, gbc);

        lblSchemecatagory_criteria = new JLabel("Scheme Criteria");
        lblSchemecatagory_criteria.setForeground(Color.WHITE);
        lblSchemecatagory_criteria.setFont(new Font("Arial", Font.PLAIN, 15));
        Schemecatagory_criteriafld = new JTextField("", 10);
        Schemecatagory_criteriafld.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(0, 3);

        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblSchemecatagory_criteria, gbc);

        assign(1, 3);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(Schemecatagory_criteriafld, gbc);
        
        lblAmount = new JLabel("Amount");
        lblAmount.setForeground(Color.WHITE);
        lblAmount.setFont(new Font("Arial", Font.PLAIN, 15));
        Amountfld = new JTextField("", 10);
        Amountfld.setFont(new Font("Arial", Font.PLAIN, 15));
        assign(0, 4);

        gbc.anchor = GridBagConstraints.LINE_START;
        add(lblAmount, gbc);

        assign(1, 4);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(Amountfld, gbc);

        JButton sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setSize(100, 20);
        assign(1, 14);
        add(sub, gbc);

        JButton Back = new JButton("Back");
        Back.setFont(new Font("Arial", Font.PLAIN, 15));
        Back.setSize(100, 20);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        assign(1, 16);
        add(Back, gbc);

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DisabilityChooser = disabilitySelector.getSelectedItem().toString();
                if (DisabilityChooser.equals("")) {
                    JOptionPane.showMessageDialog(null, "select Disability");
                    return;
                }
                String SchemeChooser = Schemefld.getText().toString();
                if (SchemeChooser.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New Scheme");
                    return;
                }
                String criteriaChooser = Schemecatagory_criteriafld.getText().toString();
                if (criteriaChooser.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Criteria");
                    return;
                }
                
                String AmountChooser = Amountfld.getText().toString();
                if (criteriaChooser.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Amount");
                    return;
                }
                SchemeDataTaker SchemeDataTakerObj = new SchemeDataTaker();
                SchemeDataTakerObj.setDisability(DisabilityChooser);
                SchemeDataTakerObj.setScheme_catagory(SchemeChooser);
                SchemeDataTakerObj.setScheme_criteria(criteriaChooser);
                SchemeDataTakerObj.setAmount(AmountChooser);
                AdminController AdminControllerObj = new AdminController();
                if (!AdminControllerObj.ValidateSchemeAlreadyExists(SchemeDataTakerObj)) {
                    AdminControllerObj.insertScheme(SchemeDataTakerObj);
                    JOptionPane.showMessageDialog(null, "Scheme is Succefully inserted");
                } else {
                    JOptionPane.showMessageDialog(null, "Scheme Already Exists");
                }
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((ShemeAdderFrame) getRootPane().getParent()).dispose();
                new Admin();
            }
        });

        //setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void assign(int a, int b) {
        gbc.gridx = a;
        gbc.gridy = b;

    }

}
