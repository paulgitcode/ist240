
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
public class player extends JButton {

    ImageIcon char_stand; // image icon of standing character
    ImageIcon char_right; // image of moving right
    ImageIcon char_left; // image of moving left
    options opt;

    player() {
        super();

        char_stand = new ImageIcon("images/char_idle.jpg");
        char_right = new ImageIcon("images/char_walk_right.jpg");
        char_left = new ImageIcon("images/char_walk_left.jpg");

        setIcon(char_stand);
        setBorderPainted(false); // remove button border

        //sco = 0;
        persistObject persist = new persistObject();

        Object o = persist.readObject();
        opt = new options();
        if (options.class.isInstance(o)) {
            opt = (options) o;
        }
    }

    public void setName(String n) {
        opt.setName(n);
    }

    public String getName() {
        return opt.getName();
    }

    public void setDifficulty(String d) {
        opt.setDifficulty(d);
    }

    public String getDifficulty() {
        return opt.getDifficulty();
    }

    void setIconR() {
        setIcon(char_right);
    }

    void setIconL() {
        setIcon(char_left);

    }

    void setIconStand() {
        setIcon(char_stand);
    }

    public void setScore(int s) {
        opt.setScore(s);
    }

    public int getScore() {
        return opt.getScore();
    }
    
    public options getOptions() {
        return this.opt;
    }
}
