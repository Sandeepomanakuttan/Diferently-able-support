/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author kishore
 */
public class UserProfileFrame extends JFrame {

   public UserProfileFrame(String ward, String house, String address, String relation, String name, String gen, String Dis, String Dof, byte[] perimage) {
        super("Person Profile Form");
        setSize(900, 700);
        setLocationRelativeTo(null);
        MainPanel p = new MainPanel();
        p.add(new UserProfile(ward,house,address,relation,name,gen,Dis,Dof,perimage));
        setContentPane(p);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    
    
    
}

