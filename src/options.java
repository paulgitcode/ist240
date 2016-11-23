/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jasmeet
 */

public class options 
{
    String name ="James";
    String difficulty="Easy";
    int sco=0; // holds the hits

    public options()
    {
        super();
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
    
    public void setScore(int s)
    {
       sco = s;
    }
    
    public int getScore()
    {
        return sco;
    }
}