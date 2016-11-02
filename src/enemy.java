
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul
 */
public class enemy extends player implements ActionListener 
{
    
    int maxY; // max y value to check edge of screen
    int minY; // min y value to check edge of screen
    int maxX; // max x value to check edge of screen
    int minX; // min x value to check edge of screen
    
    int bWidth; // value of width of button
    int bHeight; // value of height of button
    
    int eX; // x coordinate of enemy
    int eY; // y coordinate of enemy
    
    double randD; // random direction
    
    int decreaseX; // value of decrease in movement on x coor
    int increaseX; // value of increase in movement on x coor
    
    Timer enemyMove; //
    int enemyDelay; // delay value for enemy move sequence
    
    int direction; // set direction of movement, 0 left moving, 1 right moving
    
    enemy(int inmaxY, int inminY, int inmaxX, int inminX, int indecreaseX, int inenemyDelay)
    {
        super();
        
        maxY = inmaxY;
        minY = inminY;
        maxX = inmaxX;
        minX = inminX;
        
        bWidth = 30;
        bHeight = 32;
 
        //randD = Math.random();
        //direction = (int)(randD*1);
        direction = ranDirection();
        
        decreaseX = indecreaseX;
        increaseX = 10;
        
        enemyDelay = inenemyDelay;
        enemyMove = new Timer(enemyDelay, this);
        enemyMove.start();
        
        if (direction == 0){
            eX = maxX;
            eY = minY;
            setBounds(eX, eY, bWidth, bHeight);
        }
        
        if (direction == 1){
            
            eX = minX;
            eY = minY;
            setBounds(eX,eY, bWidth, bHeight);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {

        
        Object obj = e.getSource();
        
        if((obj == enemyMove) && (direction == 0))
        {
 
            eX = eX+decreaseX;
            setBounds(eX,eY ,bWidth ,bHeight );
              
        }
        
        if((obj == enemyMove) && (direction == 1))
        {
            eX = eX+increaseX;
            setBounds(eX,eY ,bWidth ,bHeight );
        }
        
    }
    
    int geteX()
    {
        return eX;
    }
    
    int geteY()
    {
        return eY;
    }
    
    int ranDirection()
    {
        randD = Math.random();
        int tempD = (int)(randD*2);
        return tempD;
    }
    
    void setDelayHardest()
    {
        
        enemyMove.stop();
        enemyDelay = 20;
        enemyMove = new Timer(enemyDelay, this);
        enemyMove.start();
    }
    
    void setDelayHard()
    {
        enemyMove.stop();
        enemyDelay = 75;
        enemyMove = new Timer(enemyDelay, this);
        enemyMove.start();
    }
}
