/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import javax.swing.JFrame;

/**
 *
 * @author RAMESH
 */
public class RelativeFrame extends JFrame{

    public RelativeFrame(String id) {
         super("Relative Form");
        setSize(900, 700);
        setLocationRelativeTo(null);
        MainPanel p=new MainPanel();
        p.add(new RelativePanel(id));
        setContentPane(p);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
