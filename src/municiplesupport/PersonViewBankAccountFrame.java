/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import municiplesupport.Table.AdminHospitalDetailsTable;
import municiplesupport.Table.PersonViewBankAccountDetailsTable;

/**
 *
 * @author kishore
 */
public class PersonViewBankAccountFrame extends JFrame {

    public PersonViewBankAccountFrame(String id) {
        super("Bank");
        setLayout(new BorderLayout());
        PersonViewBankAccountDetailsTable model = new PersonViewBankAccountDetailsTable(id);
        JTable tbl = new JTable(model);
        add(new JScrollPane(tbl), BorderLayout.CENTER);

        setSize(900, 700);
        setLocationRelativeTo(null);

        setVisible(true);
    }

}
