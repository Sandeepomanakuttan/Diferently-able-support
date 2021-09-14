/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author kishore
 */
public class PersonProfileFrame extends JFrame {

    public PersonProfileFrame(loginData f) {
        super("Person Profile Form");
        setSize(900, 700);
        setLocationRelativeTo(null);
        MainPanel p = new MainPanel();
        p.add(new PersonPanels(f));
        setContentPane(p);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    
}
