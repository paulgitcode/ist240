/**
 *
 * @author Paul
 */

import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class mainJFrame extends JFrame
{
    gamePanel gameP;
    
        public mainJFrame()
        {
           super("Main Menu");
           
           
           mainMenu menuP = new mainMenu();
           mainPanel screenP = new mainPanel(menuP);
           gamePanel gameP = new gamePanel(screenP);
           
           setLayout(new BorderLayout());
           
           menuP.setLayout(new BoxLayout(menuP, BoxLayout.PAGE_AXIS));
           menuP.add(Box.createRigidArea(new Dimension(20,20)));
           menuP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
           
           //getContentPane().add(screenP,"Center");
           //getContentPane().add(menuP,"West");
           
           //testing game panel
           getContentPane().add(gameP,"Center");
           //testing game panel
           
          
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           setSize (640, 480);
           setVisible(true);
        }
        
    
    
}
