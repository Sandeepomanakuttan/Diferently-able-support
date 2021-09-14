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
public class addHospital extends JFrame {
    
    public addHospital() {
        super("Add Scheme");
        setSize(900, 700);
        setLocationRelativeTo(null);
        MainPanel p=new MainPanel();
        p.add(new newHospitalAdder());
        setContentPane(p);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
