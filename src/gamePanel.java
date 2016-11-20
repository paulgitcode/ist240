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
import java.io.*;

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
    JLabel testL; // label for player name
    JLabel diffL; // label for difficulty level
    String testT;
    
    
    int maxY; // max y value to check edge of screen
    int minY; // min y value to check edge of screen
    int maxX; // max x value to check edge of screen
    int minX; // min x value to check edge of screen
    
    int bWidth; // value of width of button
    int bHeight; // value of height of button
    
    //JButton testB; // test button
    
    player testP; // test player class
    
    
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
    int jumpNumber;
    int jumpNumberDown;
    int jumpInProgress; // 0 is no, 1 is yes
    
    Timer moveR;
    int moveDelay;
    Timer moveL;
   
    
    Timer enemyMove; //
    int enemyDelay; // delay value for enemy move sequence
    
    enemy testE2; // testing enemy class
    enemy testE3; // another enemy
    
    int eCount; // determine if additional enemies are added. 1 = one, 2 = two.
    
    String pName;// Holds player name from mainPanel
    String dText; // Holds difficulty from mainPanel
    
    int sX; // X coor for a sword button
    int sY; // Y coor for a sword button
    int sW; // widght of sword button
    int sH; // height of sword button
    
    JButton swordB; //
    
    int pDirect; // set direction of character based on movement - 0: right, 1: left
    
    XML_240 scoreStore; // xml reader and writer class object to store score data
    String scoreFile ; // string to hold score xml file name
    scoreBoard scoreB; // create scoreboard class to store scores and other data
    
    ImageIcon floorI;
    JButton floorB;
    
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
        
        // set value of amount of movement and other settings
        increaseX = 10;
        decreaseX = -10;
        jumpY = -60;
        jumpDelay = 100;
        jumpIncrement = jumpY/3;
        jumpItotal = 0;
        jumpNumber = 0;
        jumpNumberDown = 0;
        moveDelay = 75;
       
        enemyDelay = 50;
        pDirect = 0;
        eCount = 0;
        scoreB = new scoreBoard();
        scoreFile = "scoresheet.xml";
        scoreStore = new XML_240();
        
        //scoreStore.closeWriterXML();
        
        //---------------------------
        
        //set up timer for jump
        
        
        
        //-------------------------
        
        //Floor--------
        
        floorI = new ImageIcon("images/floor.jpg");
        floorB = new JButton();
        floorB.setBorderPainted(false);
        floorB.setBounds(minX-30, 390, 670, 61);
        floorB.setIcon(floorI);
        add(floorB);
        
        
        //------------
        
        // set up timer for enemy move
        
        enemyMove = new Timer(enemyDelay, this);
        
        //
        
        moveR = new Timer(moveDelay,this);
        moveL = new Timer(moveDelay,this);
        
        pName = "Not Set";
        dText = "Not Set";
        
        //set value of width and height of button. Character icon is 30 width, 32 height
        bWidth = 30;
        bHeight = 32;
        sW = 15;
        sH = 5;
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
        persistObject persist= new persistObject();

        testP= (player) persist.DeSerialize();
        if(testP == null){
            testP= new player(); 
        }
        

        
        //System.out.println("game - Name="+testP.getName());
        //System.out.println("game - Difficulty="+testP.getDifficulty());
        
        testE3 = new enemy(maxY, minY, maxX, minX, decreaseX, enemyDelay);
        
        if(testP.getDifficulty().equals("Easy")){
            enemyDelay = 250;
        }
        
        if(testP.getDifficulty().equals("Normal")){
            enemyDelay = 200;
        }
        
        if(testP.getDifficulty().equals("Hard")){
            enemyDelay = 100;
            eCount = 2;
            add(testE3);
            testE3.setDelayHard();
            
        }
        
        if(testP.getDifficulty().equals("Hardest")){
            enemyDelay = 50;
            eCount = 2;
            add(testE3);
            testE3.setDelayHardest();
        }
        

        // testP = new player();
        add(testP);
        testP.setBounds(bX,bY ,bWidth ,bHeight ); // set location of button  setBounds(x cor, y cor , width , height )
        
        //-----Set Score to 0-----
        
        //testP.setScore(0);
        
        //------------------------
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
        testT = "Test Text";
        testL = new JLabel();
        diffL = new JLabel();
        testL.setText("Player: " + testP.getName());
        diffL.setText("Difficulty: " + testP.getDifficulty());
        
        diffL.setLocation(minX + 105, 30);
        testL.setLocation(minX, 30);
        testL.setSize(100, 40);
        diffL.setSize(100, 40);
        add(testL);
        add(diffL);
        
        swordB = new JButton();
        add(swordB);
        swordB.setVisible(false);
        
        
        mainPin.save.addActionListener(this);
        
        //if(bX == testE2.geteX() && bY == testE2.geteY()){
           //     System.out.print("Collision!");
          //  }

        
        //----------------------
    }
    
    public void keyPressed(KeyEvent e)
    {
        int k = e.getKeyCode();
        
        //arrow movement------------------
        if(k==e.VK_RIGHT){
            
            //if(bX+increaseX < maxX){
                
               // bX=bX+increaseX;
                
                
           // }
            
            //testP.setBounds(bX,bY ,bWidth ,bHeight );
            
            testP.setIconR(); // use method to set icon right facing
            pDirect = 0;
            moveR.start();
            
             //Test collision with enemies
            //checkCollision();
        }
        
        if(k==e.VK_LEFT){
            
            //if(bX+increaseX > minX){
                
                //bX=bX+decreaseX;
            //}

            //testP.setBounds(bX,bY ,bWidth ,bHeight );
            testP.setIconL(); // use method to set icon left facing
            
            pDirect = 1;
            moveL.start();
            
            // Test collision with enemies
            //checkCollision();
        }
        
        if(k==e.VK_DOWN){
            
            if (pDirect == 0){
                
               sX = bX+40;
               sY = bY+10;
                swordB.setBounds(sX,sY , sW, sH);
                
            }if(pDirect == 1){
                
                sX = bX-20;
                sY = bY+10;
                swordB.setBounds(sX,sY , sW, sH);
            }
            swordB.setVisible(true);
            checkAttack();
            
            
            
            
        }
        
        //Jumping------------------------
        
        if(k==e.VK_SPACE){
            
       //----Original jump code
            //if((bY + jumpY) == (minY + jumpY)){
            
                
                //bY=bY+jumpY;
                //testP.setBounds(bX,bY ,bWidth ,bHeight );
            
            if (jumpInProgress == 0)
            {
                jumpInProgress = 1;
                bY=bY+(jumpY/3);
                testP.setBounds(bX,bY ,bWidth ,bHeight );       
                jumpNumber++;  
                jump = new Timer(jumpDelay,this);
                jump.start();
            }
 
                
            //}
        
        //-----
            

            // test collision
            //checkCollision();
            
            

        }
        
        //---------------------------------------
        
        //-------------------
    }
    
    public void keyReleased(KeyEvent e){
        
        int k = e.getKeyCode();
        
        //if(k==e.VK_SPACE){

           // bY=bY-jumpY;
            //testP.setBounds(bX,bY ,bWidth ,bHeight );
           // checkCollision();
           
        //}
        
        if(k==e.VK_RIGHT || k==e.VK_LEFT )
        {
            testP.setIconStand();
            moveR.stop();
            moveL.stop();
            checkCollision();
        }
        
        if(k==e.VK_DOWN){
            swordB.setVisible(false);
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
            
            if(eCount == 2)
            {
            if(testE3.geteX() < (minX-60) || ((testE3.geteX()) > (maxX + 60)))
            {
                remove(testE3);
                validate();
                repaint();
                
                if(testP.getDifficulty().equals("Hard"))
                {
                
                testE3 = new enemy(maxY, minY, maxX, minX, decreaseX, enemyDelay);
                add(testE3);
                testE3.setDelayHard();
            
                }
                
                if(testP.getDifficulty().equals("Hardest"))
                {
                
                testE3 = new enemy(maxY, minY, maxX, minX, decreaseX, enemyDelay);
                add(testE3);
                testE3.setDelayHardest();
            
                }

            }
                            
            }
            
            
        }
        
        if(obj == jump)
        {
                    

                    if(jumpNumber <= 3)
                    {
                    bY=bY+(jumpY/3);
                    testP.setBounds(bX,bY ,bWidth ,bHeight );
                    checkCollision();
                    jumpNumber++;
                    
                    }
                    if(jumpNumber == 4)
                    {
                    
                    if(jumpNumberDown <= 3)
                        {   
                        bY=bY-(jumpY/3);
                        testP.setBounds(bX,bY ,bWidth ,bHeight );
                        checkCollision();
                        jumpNumberDown++;
                        }
                    }
                    
                    if(jumpNumberDown == 4)
                    {
                        stopJump();
                    }
                    
                    
        }
        
        if(obj == moveR)
        {
            if(bX+increaseX < maxX){
                
                bX=bX+increaseX; 
            }
            
            testP.setBounds(bX,bY ,bWidth ,bHeight );
            checkCollision();
        }
        
        if(obj == moveL)
        {
            if(bX+increaseX > minX){
                
                bX=bX+decreaseX;
            }
            
            testP.setBounds(bX,bY ,bWidth ,bHeight );
            checkCollision();
        }
        
        if(obj == mainPin.save)
        {
            pName = mainPin.player.getText();
            System.out.println("Name in Game Panel =" + pName);
            testP.setName(pName);
            
            dText = (String)mainPin.difficulty.getSelectedItem();
            System.out.println("Difficulty in Game Panel =" + dText);
            testP.setDifficulty(dText);
            
            testL.setText("Player: " + testP.getName());
            diffL.setText("Difficulty: " + testP.getDifficulty());
            
            //----------Set Difficulty Speed------------
            
        if(testP.getDifficulty().equals("Easy")){
            enemyDelay = 250;
        }
        
        if(testP.getDifficulty().equals("Normal")){
            enemyDelay = 200;
        }
        
        if(testP.getDifficulty().equals("Hard")){
            enemyDelay = 100;
            eCount = 2;
            add(testE3);
            testE3.setDelayHard();
            
        }
        
        if(testP.getDifficulty().equals("Hardest")){
            enemyDelay = 50;
            eCount = 2;
            add(testE3);
            testE3.setDelayHardest();
        }
        
        //--------------------------------------------------

        }
        
        
        
    }
    
    void checkCollision(){
        
        if(bX == testE2.geteX() && bY == testE2.geteY())
        {
        System.out.print("Collision!");
        scoreB.setBoard(testP.getScore());
        scoreStore.openWriterXML(scoreFile);
        scoreStore.writeObject(scoreB);
        scoreStore.closeWriterXML();
        }
        
        if(bX == testE3.geteX() && bY == testE3.geteY())
        {
        System.out.print("Collision!");
        scoreB.setBoard(testP.getScore());
        scoreStore.openWriterXML(scoreFile);
        scoreStore.writeObject(scoreB);
        scoreStore.closeWriterXML();
        }
    }
    
    void checkAttack()
    {
        
        
      
        if(sX < (testE2.geteX() + bWidth/2) && sX > (testE2.geteX() - bHeight/2))
        {
        System.out.print("Successful Hit!");

        testP.setScore(testP.getScore()+1);
        System.out.print(testP.getScore());
        
        
        }
        
        if(sX < (testE3.geteX() + bWidth/2) && sX > (testE3.geteX() - bHeight/2))
        {
        System.out.print("Successful Hit!");
        
        testP.setScore(testP.getScore()+1);
        System.out.print(testP.getScore());
        
        
        }
    }
    
    void stopJump()
    {
        jump.stop();
        jumpNumberDown = 0;
        jumpNumber = 0;
        jumpInProgress = 0;
    }

}