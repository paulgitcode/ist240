/**
 *
 * @author Paul
 * 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainMenu extends JPanel
{
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    titleJLabel la1;
    
    public mainMenu()
    {
        super();
        
        setBackground(Color.gray);
               
        b1 = new JButton("About");
        b2 = new JButton("Team Members");
        b3 = new JButton("Options");
        b4 = new JButton("How to Play");
        b5 = new JButton("Start Game");
        b6 = new JButton("Scores");
        la1 = new titleJLabel("IST Bug Hunter");
              
        add(la1);
        add(b1);
        add(b2);
        add(b4);
        add(b3);
        add(b5);
        add(b6);
    }
}
