
import java.awt.Font;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul
 */
public class titleJLabel extends JLabel
{
    
    String text;
    
    public titleJLabel(String informedText)
    {
         super(); 
         text = informedText;
         setFont(new Font("Serif", Font.BOLD, 16));
         setText(text);
    
    }
    
    
}
