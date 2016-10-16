


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul
 */

import javax.swing.*;
import java.awt.*;

public class mainJFrame extends JFrame
{
    
        public mainJFrame()
        {
           super("Main Menu");
           
           
           mainMenu menuP = new mainMenu();
           mainPanel screenP = new mainPanel(menuP);
           
           setLayout(new BorderLayout());
           
           menuP.setLayout(new BoxLayout(menuP, BoxLayout.PAGE_AXIS));
           menuP.add(Box.createRigidArea(new Dimension(20,20)));
           menuP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
           
           getContentPane().add(screenP,"Center");
           getContentPane().add(menuP,"West");
           
          
           setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize (640, 480);
            setVisible(true);
        }
        
    
    
}
