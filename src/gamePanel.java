import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

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
public class gamePanel extends JPanel implements KeyListener, ActionListener
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
    
    //JButton testB; // test button
    
    player testP; // test player class
    
    player testE; // test enemy object
    int eX; // x coordinate of enemy
    int eY; // y coordinate of enemy
    
    int bX; // X coordinate of button
    int bY; // Y coordinate of button
    
    int increaseX; // value of increase in movment on x coor
    int decreaseX; // value of decrease in movement on x coor
    int jumpY; // value of jump height
    Timer jump; // timer for jump sequence
    int jumpDelay; // delay value for jump sequence
    int jumpIncrement; // increment of jump
    int jumpItotal; // add up increments to compare to min value
    
    Timer enemyMove; //
    int enemyDelay; // delay value for enemy move sequence
    
    enemy testE2; // testing enemy class
    
    
    gamePanel(mainPanel informedMain)
    {
        super();
        setBackground(Color.white);
        setLayout(null);
        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();
        
        // set min and max of y and x values
        maxY = 20;
        minY = 360;
        maxX = 560;
        minX = 20;
        //---------------------------------
        
        // set value of amount of movement
        increaseX = 10;
        decreaseX = -10;
        jumpY = -60;
        jumpDelay = 500;
        jumpIncrement = jumpY/3;
        jumpItotal = 0;
        enemyDelay = 100;
        
        //---------------------------
        
        //set up timer for jump
        
        //jump = new Timer(jumpDelay,this);
        
        //-------------------------
        
        // set up timer for enemy move
        
        enemyMove = new Timer(enemyDelay, this);
        
        //
        
        //set value of width and height of button. Character icon is 30 width, 32 height
        bWidth = 30;
        bHeight = 32;
        //----------------------------------
        
        // set initial values of coordinates for button
        bX = maxX/2;
        bY = minY;
        //----------------------------------
        
        // set initial values of coorinates for enemy
        
        eX = maxX;
        eY = minY;
                
                
        
        //--------------------------------------
        
        // create and add button, with location

        testP = new player();
        add(testP);
        testP.setBounds(bX,bY ,bWidth ,bHeight ); // set location of button  setBounds(x cor, y cor , width , height )
        //---------------------------------------
        
        // create and add enemy button, with location
        
        //testE = new player();
        //add(testE);
        //testE.setBounds(eX,eY ,bWidth ,bHeight );
        
        enemyMove.start();
        
        //---------------------------------------------
        
        // create and add enemy button, testing enemy class
        
        testE2 = new enemy(maxY, minY, maxX, minX, decreaseX, enemyDelay);   // enemy(int inmaxY, int inminY, int inmaxX, int inminX, int indecreaseX)
        add(testE2);
        
        //-----------------------------------------
        
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
            
            testP.setBounds(bX,bY ,bWidth ,bHeight );
            testP.setIconR(); // use method to set icon right facing
        }
        
        if(k==e.VK_LEFT){
            
            if(bX+increaseX > minX){
                
                bX=bX+decreaseX;
            }

            testP.setBounds(bX,bY ,bWidth ,bHeight );
            testP.setIconL(); // use method to set icon left facing
        }
        
        //Jumping------------------------
        
        if(k==e.VK_SPACE){
            
       
            if((bY + jumpY) == (minY + jumpY)){
            
                bY=bY+jumpY;
                testP.setBounds(bX,bY ,bWidth ,bHeight );
            }
            
            

        }
        
        //---------------------------------------
        
        //-------------------
    }
    
    public void keyReleased(KeyEvent e){
        
        int k = e.getKeyCode();
        
        if(k==e.VK_SPACE){

            bY=bY-jumpY;
            testP.setBounds(bX,bY ,bWidth ,bHeight );
           
        }
        
        if(k==e.VK_RIGHT || k==e.VK_LEFT )
        {
            testP.setIconStand();
        }
    
    };
    
    public void keyTyped(KeyEvent e){}
    
    public void actionPerformed(ActionEvent e)
    {
           //bY=bY+jumpIncrement;
           //testP.setBounds(bX,bY ,bWidth ,bHeight );
        
        Object obj = e.getSource();
        
        if(obj == enemyMove)
        {
            
            if(testE2.geteX() < (minX-60) || ((testE2.geteX()) > (maxX + 60)))
            {
                remove(testE2);
                validate();
                repaint();
                testE2 = new enemy(maxY, minY, maxX, minX, decreaseX, enemyDelay);
                add(testE2);
            }
            
            
        }
        
        
    }

}