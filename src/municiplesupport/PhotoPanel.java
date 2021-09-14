 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import municiplesupport.Controller.AdminController;
import municiplesupport.Database.Database;

/**
 *
 * @author kishore
 */
public final class PhotoPanel extends JPanel {
    Database db=new Database();
    JLabel lblperson_img;
    String label=null;
    GridBagConstraints gbc = new GridBagConstraints();

    public PhotoPanel(String id) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 60));
        lblperson_img=new JLabel("",JLabel.RIGHT);
        lblperson_img.setVerticalAlignment(JLabel.TOP);
        lblperson_img.setFont(new Font("Verdana",Font.PLAIN,15));
        lblperson_img.setPreferredSize(new Dimension(100,100));
        lblperson_img.setForeground(new Color(20,90,40));
        lblperson_img.setBackground(new Color(100,20,70));
        javax.swing.border.Border border1 ;
        border1 = BorderFactory.createLineBorder(Color.yellow);
        lblperson_img.setBorder(border1);
        addgrid(4, 11);
        add(lblperson_img,gbc);
        
       JButton btn=new JButton("View Image");
       addgrid(5, 12);
       add(btn,gbc);
       
       btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(id);
                String sql = "select Person_image from Person where Person_id='"+id+"'";
                ResultSet rs = db.execQuery(sql);
        try {

            if (rs.next()) {
                byte[] img=rs.getBytes("Person_image");
                
                ImageIcon image=new ImageIcon(img);
               // Image im=image.getImage();
                //Image myImg=im.getScaledInstance(lblperson_img.getWidth(),lblperson_img.getHeight(),Image.SCALE_SMOOTH);
                //ImageIcon newImage=new ImageIcon(myImg);
                lblperson_img.setIcon(image);
            }
            else{
                JOptionPane.showMessageDialog(null,"No Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            }
        });
    }

    public GridBagConstraints addgrid(int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 2;
        gbc.weighty = 2;
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
