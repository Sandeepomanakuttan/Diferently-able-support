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
import municiplesupport.Table.AdminPersonViewBankAccountDetailsTable;
import municiplesupport.Table.PersonViewBankAccountDetailsTable;

/**
 *
 * @author RAMESH
 */
class personBankDetails extends JFrame{

    public personBankDetails(String id) {
         super("Bank");
        setLayout(new BorderLayout());
        AdminPersonViewBankAccountDetailsTable model = new AdminPersonViewBankAccountDetailsTable(id);
        JTable tbl = new JTable(model);
        add(new JScrollPane(tbl), BorderLayout.CENTER);

        setSize(900, 700);
        setLocationRelativeTo(null);

        setVisible(true);
    }
    
}
