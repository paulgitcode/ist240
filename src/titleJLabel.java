/**
 *
 * @author Paul
 */
import java.awt.Font;
import javax.swing.JLabel;

public class titleJLabel extends JLabel
{
    String text;
    
    public titleJLabel(String informedText){
         super(); 
         text = informedText;
         setFont(new Font("Serif", Font.BOLD, 16));
         setText(text);
    }
}
