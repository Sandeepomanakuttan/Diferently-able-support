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
public class PersonSchemeStatusFrame extends JFrame {

    public PersonSchemeStatusFrame(String name,String Disability) {
        super("Person Scheme Status Form");
        setSize(900, 700);
        setLocationRelativeTo(null);
        MainPanel p = new MainPanel();
        p.add(new PersonSchemeStatusPanel(name,Disability));
        setContentPane(p);
        setVisible(true);
    }

}


