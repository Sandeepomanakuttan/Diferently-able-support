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
public class HousePanels extends JPanel {

    GridBagConstraints gbc = new GridBagConstraints();

    public HousePanels() {

        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 60));
        JLabel Ward_no = new JLabel("Ward_no");
        Ward_no.setForeground(Color.WHITE);
        addgrid(1, 1).anchor = GridBagConstraints.LINE_END;
        add(Ward_no, gbc);

        JTextField Ward_nofld = new JTextField(10);
        increaseFieldHeight(Ward_nofld, 25);
        Ward_nofld.setSize(new Dimension(150, 150));
        GridBagConstraints addgrid = addgrid(2, 1);
        add(Ward_nofld, gbc);

        JLabel member_name = new JLabel("Member Name");
        member_name.setForeground(Color.WHITE);
        addgrid(1, 2).anchor = GridBagConstraints.LINE_END;
        add(member_name, gbc);

        JTextField member_namefld = new JTextField(10);
        increaseFieldHeight(member_namefld, 25);
        member_namefld.setSize(new Dimension(150, 150));
        GridBagConstraints addgrida = addgrid(2, 2);
        add(member_namefld, gbc);

        JLabel memberContactNo = new JLabel("Contact No:");
        memberContactNo.setForeground(Color.WHITE);
        addgrid(1, 3).anchor = GridBagConstraints.LINE_END;;
        add(memberContactNo, gbc);

        JTextField memberContactNofld = new JTextField(10);
        increaseFieldHeight(memberContactNofld, 25);

        addgrid(2, 3);
        add(memberContactNofld, gbc);

        JLabel House_no = new JLabel("House_no");
        House_no.setForeground(Color.WHITE);
        addgrid(1, 4).anchor = GridBagConstraints.LINE_END;
        add(House_no, gbc);

        JTextField houseNofld = new JTextField(10);
        increaseFieldHeight(houseNofld, 25);
        houseNofld.setSize(new Dimension(150, 150));
        GridBagConstraints addgrid2 = addgrid(2, 4);
        add(houseNofld, gbc);

        JLabel lblOwnername = new JLabel("Owner Name");
        lblOwnername.setForeground(Color.WHITE);
        addgrid(1, 5).anchor = GridBagConstraints.LINE_END;
        add(lblOwnername, gbc);

        JTextField lblOwnernamefld = new JTextField(10);
        increaseFieldHeight(houseNofld, 25);
        lblOwnernamefld.setSize(new Dimension(150, 150));
        GridBagConstraints addgrid1 = addgrid(2, 5);
        add(lblOwnernamefld, gbc);

        JLabel HouseAddress = new JLabel("HouseAddress");
        HouseAddress.setForeground(Color.WHITE);
        addgrid(1, 6).anchor = GridBagConstraints.LINE_END;;
        add(HouseAddress, gbc);

        JTextField HouseAddressFld = new JTextField(10);
        increaseFieldHeight(HouseAddressFld, 25);

        addgrid(2, 6);
        add(HouseAddressFld, gbc);

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
               ((HouseFrame)getRootPane().getParent()).dispose();
                new Admin();
               

            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String wardno = Ward_nofld.getText().toString();
                if (wardno.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Ward No");
                    return;
                }
                String mname = member_namefld.getText().toString();
                if (mname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Member Name");
                    return;
                }
                String contactno = memberContactNofld.getText().toString();
                if (contactno.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Contact");
                    return;
                }
                String houseno = houseNofld.getText().toString();
                if (houseno.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter House No");
                    return;
                }
                String name = lblOwnernamefld.getText().toString();
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Owner Name");
                    return;
                }
                String address = HouseAddressFld.getText().toString();
                if (address.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Address");
                    return;
                }
                AddressCollection AddressCollectionobj = new AddressCollection();
                AddressCollectionobj.setAddress(address);
                AddressCollectionobj.setContactNo(contactno);
                AddressCollectionobj.setHouseNo(houseno);
                AddressCollectionobj.setMemberName(mname);
                AddressCollectionobj.setWardNo(wardno);
                AddressCollectionobj.setHouseowner(name);
                AdminController c = new AdminController();
                if (!c.validateAddDetails(AddressCollectionobj)) {
                    c.insertaddress(AddressCollectionobj);
                    JOptionPane.showMessageDialog(getParent(), "Person is Succefully Added");
                    //new Admin();
                } else {
                    JOptionPane.showMessageDialog(getParent(), "Data already exists");
                }
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


