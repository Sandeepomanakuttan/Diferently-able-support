/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import municiplesupport.Table.AdminHospitalDetailsTable;

/**
 *
 * @author kishore
 */
public class AdminPersonPaymentStatusFrame extends JFrame{

    public AdminPersonPaymentStatusFrame(String id) {
        super("My Profile");
        setLayout(new BorderLayout());
        AdminPersonPaymentDetailsTable model = new AdminPersonPaymentDetailsTable(id);
        JTable tbl = new JTable(model);
        add(new JScrollPane(tbl), BorderLayout.CENTER);

        setSize(900, 700);
        setLocationRelativeTo(null);

        setVisible(true);
    }
}