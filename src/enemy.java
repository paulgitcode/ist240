
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
    
    int decreaseX; // value of decrease in movement on x coor
    
    Timer enemyMove; //
    int enemyDelay; // delay value for enemy move sequence
    
    enemy(int inmaxY, int inminY, int inmaxX, int inminX, int indecreaseX)
    {
        super();
        
        maxY = inmaxY;
        minY = inminY;
        maxX = inmaxX;
        minX = inminX;
        
        bWidth = 30;
        bHeight = 32;
        
        eX = maxX;
        eY = minY;
        
        decreaseX = indecreaseX;
        
        enemyDelay = 100;
        enemyMove = new Timer(enemyDelay, this);
        enemyMove.start();
        
        setBounds(eX, eY, bWidth, bHeight);
    }
    
    public void actionPerformed(ActionEvent e)
    {

        
        Object obj = e.getSource();
        
        if(obj == enemyMove)
        {
 
            eX = eX+decreaseX;
            setBounds(eX,eY ,bWidth ,bHeight );
              
        }
        
    }
}
