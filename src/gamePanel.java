import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
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
 * @author Team 04
 * 640, 480, size of window
 * 
 * -----Image Library-----
 * Folder: \images
 * 
 * Character Standing: char_stand.jpg
 *
 */
public class gamePanel extends JPanel implements KeyListener
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
    
    int increaseX; // value of increase in movment on x coor
    int decreaseX; // value of decrease in movement on x coor
    int jumpY; // value of jump height
    
    ImageIcon char_stand; // image icon of standing character
    ImageIcon char_right; // image of moving right
    ImageIcon char_left; // image of moving left
    
    gamePanel(mainPanel informedMain)
    {
        super();
        setBackground(Color.white);
        setLayout(null);
        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();
        
        //Set initial icon for character
        
        char_stand = new ImageIcon("images/char_stand.jpg");
        char_right = new ImageIcon("images/char_walk_right.jpg");
        char_left = new ImageIcon("images/char_walk_left.jpg");
        //--------------------------
        
        // set min and max of y and x values
        maxY = 20;
        minY = 360;
        maxX = 560;
        minX = 20;
        //---------------------------------
        
        // set value of amount of movement
        increaseX = 10;
        decreaseX = 10;
        jumpY = -40;
        
        //---------------------------
        
        //set value of width and height of button. Character icon is 30 width, 32 height
        bWidth = 30;
        bHeight = 32;
        //----------------------------------
        
        // set initial values of coordinates for button
        bX = maxX/2;
        bY = minY;
        //----------------------------------
        
        
        // create and add button, with location
        testB = new JButton();
        add(testB);
        //testB.setText("C");
        testB.setIcon(char_stand);
        
        
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
    
    public void keyPressed(KeyEvent e)
    {
        int k = e.getKeyCode();
        
        //arrow movement------------------
        if(k==e.VK_RIGHT){
            
            if(bX+increaseX < maxX){
                
                bX=bX+increaseX;
            }
            
            testB.setBounds(bX,bY ,bWidth ,bHeight );
            testB.setIcon(char_right);
        }
        
        if(k==e.VK_LEFT){
            
            if(bX+increaseX > minX){
                
                bX=bX-decreaseX;
            }

            testB.setBounds(bX,bY ,bWidth ,bHeight );
            testB.setIcon(char_left);
        }
        
        //Jumping------------------------
        
        if(k==e.VK_SPACE){
            
            if((bY + jumpY) == (minY + jumpY)){
            
                bY=bY+jumpY;
                testB.setBounds(bX,bY ,bWidth ,bHeight );
            }
            
            

        }
        
        //---------------------------------------
        
        //-------------------
    }
    
    public void keyReleased(KeyEvent e){
        
        int k = e.getKeyCode();
        
        if(k==e.VK_SPACE){
            
            bY=bY-jumpY;
            testB.setBounds(bX,bY ,bWidth ,bHeight );
        }
        
        if(k==e.VK_RIGHT || k==e.VK_LEFT )
        {
            testB.setIcon(char_stand);
        }
    
    };
    
    public void keyTyped(KeyEvent e){}

}