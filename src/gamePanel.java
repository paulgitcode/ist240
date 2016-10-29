import java.awt.Color;
import javax.swing.JButton;
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
 * 640, 480, size of window
 */
public class gamePanel extends JPanel
{
    
    mainPanel mainPin;
    JLabel testL;
    String testT;
    
    
    int maxY; // max y value to check edge of screen
    int minY; // min y value to check edge of screen
    int maxX; // max x value to check edge of screen
    int minX; // min x value to check edge of screen
    
    int bWidth; // value of width of button
    int bHeight; // value of height of button
    
    JButton testB; // test button
    
    int bX; // X coordinate of button
    int bY; // Y coordinate of button
    
    gamePanel(mainPanel informedMain)
    {
        super();
        setBackground(Color.white);
        setLayout(null);
        
        // set min and max of y and x values
        maxY = 20;
        minY = 360;
        maxX = 560;
        minX = 20;
        //---------------------------------
        
        //set value of width and height of button
        bWidth = 60;
        bHeight = 60;
        //----------------------------------
        
        // set initial values of coordinates for button
        bX = maxX/2;
        bY = minY;
        //----------------------------------
        
        
        // create and add button, with location
        testB = new JButton();
        add(testB);
        testB.setText("C");
        
        testB.setBounds(bX,bY ,bWidth ,bHeight ); // set location of button  setBounds(x cor, y cor , width , height )
        //---------------------------------------
        
        mainPin = informedMain;
       
        
        //testing text in panel
        //testT = "Test Text";
        //testL = new JLabel();
        //testL.setText(testT);
        //add(testL);
        
        
        //----------------------
    }

}