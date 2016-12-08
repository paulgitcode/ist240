
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
public class enemy extends player implements ActionListener {
    
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
    
    int collisionXmax; // 
    int collisionXmin; //
    
    ImageIcon enem_stand; // icon for enemies, Right
    ImageIcon enem_standL; // icon for enemies, Left
    
    enemy(int inmaxY, int inminY, int inmaxX, int inminX, int indecreaseX, int inenemyDelay){
        super();
        
        maxY = inmaxY;
        minY = inminY;
        maxX = inmaxX;
        minX = inminX;
  
        bWidth = 30;
        bHeight = 32;
        
        enem_stand = new ImageIcon("images/eStand.jpg");
        enem_standL = new ImageIcon("images/eStandL.jpg");
        
        direction = ranDirection();
        
        decreaseX = indecreaseX;
        increaseX = 10;
        
        enemyDelay = inenemyDelay;
        enemyMove = new Timer(enemyDelay, this);
        
        if (direction == 0){
            eX = maxX;
            eY = minY;
            setBounds(eX, eY, bWidth, bHeight);
            setIcon(enem_standL);
        }
        
        if (direction == 1){
            eX = minX;
            eY = minY;
            setBounds(eX,eY, bWidth, bHeight);
            setIcon(enem_stand);
        }
    }
    
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        
        if((obj == enemyMove) && (direction == 0)){
            eX = eX+decreaseX;
            setBounds(eX,eY ,bWidth ,bHeight );
        }
        
        if((obj == enemyMove) && (direction == 1)){
            eX = eX+increaseX;
            setBounds(eX,eY ,bWidth ,bHeight );
        }
    }
    
    int geteX(){
        return eX;
    }
    
    int geteY(){
        return eY;
    }
    
    int ranDirection(){
        randD = Math.random();
        int tempD = (int)(randD*2);
        return tempD;
    }
    
    void setDelayHardest(){
        enemyMove.stop();
        enemyDelay = 20;
        enemyMove = new Timer(enemyDelay, this);
    }
    
    void setDelayHard(){
        enemyMove.stop();
        enemyDelay = 75;
        enemyMove = new Timer(enemyDelay, this);
    }
    
    void setDelayEasy(){
        enemyMove.stop();
        enemyDelay = 500;
        enemyMove = new Timer(enemyDelay, this);
    }
    
    void setDelayNormal(){
        enemyMove.stop();
        enemyDelay = 200;
        enemyMove = new Timer(enemyDelay, this);
    }
    
    public void stopE(){
        enemyMove.stop();
    }
    
    public void startE(){
        enemyMove.start();
    }
    
    public void setupCollision(){
        collisionXmax = eX + 20;
        collisionXmin = eX - 20;
    }
    
    public int getCollisionMax(){
        return collisionXmax;
    }
    
    public int getCollisionMin(){
        return collisionXmin;
    }
}
