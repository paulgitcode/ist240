import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul
 */
public class gamePanel extends JPanel
{
    
    mainPanel mainPin;
    JLabel testL;
    String testT;
    
    gamePanel(mainPanel informedMain)
    {
        super();
        setBackground(Color.white);
        
        mainPin = informedMain;
       
        
        //testing text in panel
        testT = "Test Text";
        testL = new JLabel();
        testL.setText(testT);
        add(testL);
        
        //testing text in panel
    }

}