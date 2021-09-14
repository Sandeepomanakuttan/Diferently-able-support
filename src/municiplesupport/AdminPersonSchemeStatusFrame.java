/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author kishore
 */
public class AdminPersonSchemeStatusFrame extends JFrame {

    public AdminPersonSchemeStatusFrame(String Ward_no,String house_no) {
        super("Person Scheme Status Form");
        setSize(900, 700);
        setLocationRelativeTo(null);
        MainPanel p = new MainPanel();
        p.add(new AdminPersonSchemeStatusPanel(Ward_no,house_no));
        setContentPane(p);
        setVisible(true);
    }

}


