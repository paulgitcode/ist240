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
    
    XML_240 readScore; // XML reader for score
    
    String mainScoreFile = "scoresheet.xml";
    
    public scoreBoard()
    {
        readScore = new XML_240();
        readScore.openReaderXML(mainScoreFile);
        Object v = readScore.ReadObject();
        scores=new Vector();
        if(Vector.class.isInstance(v))
            scores=(Vector) v;
        
        readScore.closeReaderXML();
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