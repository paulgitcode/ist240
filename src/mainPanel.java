/**
 *
 * @author Paul, Matt, Brad
 * IST 240 
 * L08 First Final Project Deliverable
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainPanel extends JPanel implements ActionListener
{
    JLabel l; // about screen label
    JLabel l2; // about screen label
    JLabel l3; // team member name
    JLabel l4; // unused
    JLabel l5; // team member name
    JLabel l6; // "insert text later" label
    JLabel l7; // team member name
    JLabel l8; // unused
    JLabel l9; // team member name
    
    JPanel p2; // about panel
    JPanel p3; // team panel
    JPanel p4; // options panel
    JPanel p5; // how to play panel
    
    mainMenu mainin;

    int p2Check;
    int p3Check;
    int p4Check;
    int p5Check;
    
    public mainPanel(mainMenu informedPanel)
    {
        super();
        setBackground(Color.white);
        mainin = informedPanel;
        
        p2Check = 0;
        p3Check = 0;
        p4Check = 0;
        p5Check = 0;
        
        p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
        p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.PAGE_AXIS));
        p4 = new JPanel();
        p4.setLayout(new BoxLayout(p4, BoxLayout.PAGE_AXIS));
        p5 = new JPanel();
        p5.setLayout(new BoxLayout(p5, BoxLayout.PAGE_AXIS));
        
        mainin.b1.addActionListener(this);
        mainin.b2.addActionListener(this);
        mainin.b3.addActionListener(this);
        mainin.b4.addActionListener(this);

        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        l = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        l5 = new JLabel();
        l6 = new JLabel();
        l7 = new JLabel();
        l8 = new JLabel();
        l9 = new JLabel();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
        
        
        if(obj == mainin.b1){
        
        if(p2Check != 1)
        {
            remove(p3);
            p3Check = 0;
            remove(p4);
            p4Check = 0;
            remove(p5);
            p5Check = 0;
            
            revalidate();
            repaint();
        }
        
        add(p2);
        p2.add(l);
        p2.add(l2);
        l.setText("IST 240 - Final Project");
        l2.setText("Team 4");
        p2Check = 1;

        }
        //Team menu
        if(obj == mainin.b2){
            
            if(p3Check != 1){
                remove(p2);
                p2Check = 0;
                remove(p4);
                p4Check = 0;
                remove(p5);
                p5Check = 0;
                
                revalidate();
                repaint();
            }
        
        add(p3);
        p3.add(l3);
        p3.add(l5);
        p3.add(l7);
        p3.add(l9);
        l3.setText("Paul Williams");
        l5.setText("Brad Reamer");
        l7.setText("Matthew Calderon");
        l9.setText("Jasmeet Singh");
        
        p3Check = 1;
            
        }
        //Options menu
       if(obj == mainin.b3) {
           if (p4Check != 1){
               remove(p2);
               p2Check = 0;
               remove(p3);
               p3Check = 0;
               remove(p5);
               p5Check = 0;
               
               revalidate();
               repaint();
           }
         add(p4);
         p4.add(l6);
         l6.setText("Insert options later");
         
         p4Check = 1;
  
            
        }
       // How to Play menu
        if(obj == mainin.b4) {
           if (p5Check != 1){
               remove(p2);
               p2Check = 0;
               remove(p3);
               p3Check = 0;
               remove(p4);
               p4Check = 0;
               
               revalidate();
               repaint();
           }
         add(p5);
         p5.add(l6);
         l6.setText("Insert Directions later");
         
         p5Check = 1;
  
        }
    }
}
