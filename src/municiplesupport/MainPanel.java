/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author kishore
 */
public class MainPanel extends picPanel {

    public MainPanel() {
        super("src/images/nn.png");
        setLayout(new BorderLayout());
        JPanel heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 80));
        heading.setSize(getWidth(), getHeight());
        add(heading, BorderLayout.NORTH);
        JLabel Name = new JLabel("Muncipal Differently Abled People Authority", SwingConstants.CENTER);
        Font f = new Font("serif", Font.BOLD, 30);
        Name.setFont(f);
        Name.setForeground(Color.WHITE);
        add(Name, BorderLayout.NORTH);
    }

    public void add(Container c) {
        add(c, BorderLayout.CENTER);
    }

}
