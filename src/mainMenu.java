/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul
 * Testing GitHub 10/20
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
        la1 = new titleJLabel("The Side Scroller");
        
        
        add(la1);
        add(b1);
        add(b2);
        add(b4);
        add(b3);
        add(b5);
        
        
    }
}
