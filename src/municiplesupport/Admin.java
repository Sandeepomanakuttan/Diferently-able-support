/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


/**
 *
 * @author s4ct
 */
public class Admin extends JFrame {

    public Admin() {
        super("Admin Page");

        setLayout(new BorderLayout());
        setSize(900, 700);
        setContentPane(new MainPanel());
        setLocationRelativeTo(null);
        final JPanel j = new JPanel();
        j.setBackground(new Color(0, 0, 0, 50));
        JMenuBar Admin = new JMenuBar();
        JMenu person = new JMenu("Person");
        JMenuItem ps = new JMenuItem("view Person");
        JMenuItem addPerson = new JMenuItem("add Persons");
        person.add(ps);
        person.add(addPerson);
        Admin.add(person);

        JMenu SchemeMenu = new JMenu("Scheme");
        JMenuItem viewScheme = new JMenuItem("view Scheme");
        JMenuItem addScheme = new JMenuItem("Add Scheme");
        SchemeMenu.add(viewScheme);
        SchemeMenu.add(addScheme);
        Admin.add(SchemeMenu);

        JMenu hospitalMenu = new JMenu("Hospital");
        JMenuItem viewhospital = new JMenuItem("view hospital");
        JMenuItem addhospital = new JMenuItem("Add hospital");
        hospitalMenu.add(viewhospital);
        hospitalMenu.add(addhospital);
        Admin.add(hospitalMenu);
        
        JMenu paymentMenu = new JMenu("Payment");
        JMenuItem viewPayment = new JMenuItem("view Payment");
        paymentMenu.add(viewPayment);
        Admin.add(paymentMenu);
        
        viewPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPersonPaymentViewTable();
            }
        });

        JMenu LogOut = new JMenu("LogOut");
        JMenuItem Logout = new JMenuItem("Logout");
        LogOut.add(Logout);
        Admin.add(LogOut);

        setJMenuBar(Admin);
        add(j);
        ps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPersonViewTable();
                
            }
        });

        addPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HouseFrame();
                dispose();
            }
        });
        viewScheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminSchemeViewTable();
                
                
            }
        });
        addScheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShemeAdderFrame();
                dispose();
            }
        });
        addhospital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new addHospital();
            }
            
        });
        viewhospital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminHospitalViewTable();
            }
        });
        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                dispose();
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
