/**
 *
 * @author Paul
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class mainJFrame extends JFrame implements ActionListener
{
    gamePanel gameP;
    mainPanel screenP;
    mainMenu menuP;
    
        public mainJFrame()
        {
           super("Main Menu");
             
           menuP = new mainMenu();
           screenP = new mainPanel(menuP);
           gameP = new gamePanel(screenP);
           
           setLayout(new BorderLayout());
           
           menuP.setLayout(new BoxLayout(menuP, BoxLayout.PAGE_AXIS));
           menuP.add(Box.createRigidArea(new Dimension(20,20)));
           menuP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
           
           getContentPane().add(gameP,"Center");
           getContentPane().add(screenP,"Center");
           getContentPane().add(menuP,"West");
           
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           setSize (640, 480);
           setVisible(true);
           
           menuP.b5.addActionListener(this);          
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == menuP.b5) {
           
            screenP.setVisible(false);
            menuP.setVisible(false);
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(gameP,"Center");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize (640, 480);
        }
    }    
}
