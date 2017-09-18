
/**
 * Write a description of class CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import edu.duke.*;
import java.util.ArrayList;
public class CharactersInPlay
{
    private ArrayList<String> myCharacters;
    private ArrayList<Integer> myFreqs;
    //constructor
    public CharactersInPlay(){
        myCharacters = new ArrayList<String>();
        myFreqs  = new ArrayList<Integer>();     
   
    }
    public void update(String person){
        int index = myCharacters.indexOf(person);
        if(index ==-1){
            myCharacters.add(person);
            myFreqs.add(1);
            
        }
        else{
            int freq = myFreqs.get(index);
            myFreqs.set(index,freq +1);
            
        }
        
        
        
    }
    public void findAllCharacters(){
        myCharacters.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s: fr.lines()){
            int indexPunctuation = s.indexOf(".");
            if( indexPunctuation != -1){
                s= s.substring(0, indexPunctuation);
                update(s);
            }
            
        }
        
    }
    public void tester(){
        findAllCharacters();
        int maxIndex = 0;
        int max = myFreqs.get(0);
        for ( int i =0; i< myCharacters.size(); ++i){
            //System.out.println(myCharacters.get(i) +" " + myFreqs.get(i));
            
            if( myFreqs.get(i) > max){
                max = myFreqs.get(i);
                maxIndex = i;
            }
    
        }
        charactersWithNumParts(10, 15);
        
        for ( int i =0; i< myCharacters.size(); ++i){
            if( myFreqs.get(i) == max){
                System.out.println("The main Character is " + myCharacters.get(i) +" " 
                                + myFreqs.get(i));
                
            }
        }
    }
    public void  charactersWithNumParts(int num1, int num2){
         for ( int i =0; i< myCharacters.size(); ++i){
             if(myFreqs.get(i)>= num1 && myFreqs.get(i)<= num2){
                 System.out.println(myCharacters.get(i) +" " + myFreqs.get(i));
                 
                }
             
            }
        
        
    }
}
