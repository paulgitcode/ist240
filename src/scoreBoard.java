import java.util.Vector;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul, Jasmeet
 */
public class scoreBoard {
    
    private Vector scores;
    
    public scoreBoard()
    {
        scores=new Vector();
    }
    
    public void setBoard(Vector v)
    {
        scores=v;
    }

    /**
     * @return the score
     */
    public Vector getScores() {
        return scores;
    }
    
    public void addScore(options o){
        scores.add(o);
    }
            
}