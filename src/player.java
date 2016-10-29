
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul
 */
public class player extends JButton
{
   
    ImageIcon char_stand; // image icon of standing character
    ImageIcon char_right; // image of moving right
    ImageIcon char_left; // image of moving left
    
    player()
    {
        super();
        
        char_stand = new ImageIcon("images/char_stand.jpg");
        char_right = new ImageIcon("images/char_walk_right.jpg");
        char_left = new ImageIcon("images/char_walk_left.jpg");
        

        setIcon(char_stand);
        setBorderPainted(false); // remove button border
        
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
