
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul, Jasmeet
 */
public class player extends JButton implements java.io.Serializable
{
   
    ImageIcon char_stand; // image icon of standing character
    ImageIcon char_right; // image of moving right
    ImageIcon char_left; // image of moving left
    String name, difficulty;
    
    player()
    {
        super();
        
        char_stand = new ImageIcon("images/char_stand.jpg");
        char_right = new ImageIcon("images/char_walk_right.jpg");
        char_left = new ImageIcon("images/char_walk_left.jpg");
        

        setIcon(char_stand);
        setBorderPainted(false); // remove button border
        
    }
    
    public void setName(String n){
        this.name=n;
    }
    
    public String getName(){
        return this.name;
    }
      
    public void setDifficulty(String d){
        this.difficulty=d;
    }
    
    public String getDifficulty(){
        return this.difficulty;
    }
      
    void setIconR()
    {
        setIcon(char_right);
    }
    
    void setIconL()
    {
        setIcon(char_left);

    }
    
    void setIconStand()
    {
        setIcon(char_stand);
    }
    

            
            
}
