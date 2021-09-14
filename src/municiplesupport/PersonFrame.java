/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.AWTEventMulticaster;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import municiplesupport.Controller.AdminController;
import municiplesupport.Controller.UserController;
import municiplesupport.MainPanel;

/**
 *
 * @author kishore
 */
public class PersonFrame extends JFrame {

    UserController acr = new UserController();
    ArrayList<loginData> users = new ArrayList<>();
    UserController obj=new UserController();
    JMenuBar Person;
    JMenu Myperson;
    JMenuItem ps;

    public PersonFrame() {

    }

    public PersonFrame(loginData f) {
        super("Person Page");
        users = acr.getLoginid(f);
        setLayout(new BorderLayout());
        setSize(900, 700);
        setContentPane(new MainPanel());
        setLocationRelativeTo(null);
        final JPanel j = new JPanel();
        j.setBackground(new Color(0, 0, 0, 50));
        Person = new JMenuBar();
        Myperson = new JMenu("My Profile");
        ps = new JMenuItem("view Profile");
        Myperson.add(ps);
        Person.add(Myperson);

        JMenu SchemeMenu = new JMenu("Scheme");
        JMenuItem viewScheme = new JMenuItem("View Scheme");
        JMenuItem MyScheme = new JMenuItem("My Agreed Scheme");
        SchemeMenu.add(viewScheme);
        SchemeMenu.add(MyScheme);
        Person.add(SchemeMenu);

        JMenu hospitalMenu = new JMenu("Hospital");
        JMenuItem viewhospital = new JMenuItem("view hospital");
        hospitalMenu.add(viewhospital);
        Person.add(hospitalMenu);
        
        JMenu BankMenu = new JMenu("Bank");
        JMenuItem viewAccount = new JMenuItem("view Account");
        JMenuItem viewTransaction = new JMenuItem("viewTransaction");
        JMenuItem AddAcount = new JMenuItem("Add Account");
        BankMenu.add(viewAccount);
        BankMenu.add(viewTransaction);
        BankMenu.add(AddAcount);
        Person.add(BankMenu);

        JMenu LogOut = new JMenu("LogOut");
        JMenuItem Logout = new JMenuItem("Logout");
        LogOut.add(Logout);
        Person.add(LogOut);
        setJMenuBar(Person);
        add(j);
        viewScheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonSchemeViewTable(f);
            }
        });
        ps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonNameSetter p=new PersonNameSetter();
                p.setId(f.getLogin_id());
                obj.CollecteMyperInformation(p);
                //new UserProfileFrame(f);

            }
        });

        viewhospital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonViewHospitalTable(f);
            }
        });
        MyScheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyAgreeSchemeTableFrame(f);
            }
        });
        
        AddAcount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBankAccountFrame(f);
                dispose();
            }
        });
        
        viewAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonViewBankAccountFrame(f.getLogin_id());
            }
        });
        viewTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonViewBankTransactionFrame(f.getLogin_id());
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
