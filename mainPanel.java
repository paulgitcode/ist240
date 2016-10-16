import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainPanel extends JPanel implements ActionListener
{
    JLabel l;
    JLabel l2;
    
    JLabel l3;
    JLabel l4;
    
    JPanel p2;
    JPanel p3;
    mainMenu mainin;

    int p2Check;
    int p3Check;
    
    public mainPanel(mainMenu informedPanel)
    {
        super();
        setBackground(Color.white);
        mainin = informedPanel;
        
        p2Check = 0;
        p3Check = 0;
        
        p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
        p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.PAGE_AXIS));

        mainin.b1.addActionListener(this);
        mainin.b2.addActionListener(this);
        
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        l = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
        
        
        if(obj == mainin.b1){
        
        if(p3Check == 1)
        {
            remove(p3);
            p3Check = 0;
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
        if(obj == mainin.b2){
            
            if(p2Check == 1){
                remove(p2);
                p2Check = 0;
                revalidate();
                repaint();
            }
        
        add(p3);
        p3.add(l3);
        l3.setText("Paul Williams");
        
        p3Check = 1;
            
        }
        


    }
}
