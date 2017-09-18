import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsInFiles
{
   private HashMap<String, ArrayList<String>> map ;
   public WordsInFiles(){
       map = new HashMap<String, ArrayList<String>>();
    }
    private void addWordsFromFile(File f){
        String name = f.getName();
        FileResource fr = new FileResource(f);
        
        for(String s : fr.words()){
            if(!map.keySet().contains(s)){
                ArrayList<String> fileName = new ArrayList<String>();
                fileName.add(name);
                map.put(s, fileName);    
            }
            else{
                if(!map.get(s).contains(name)){
                     map.get(s).add(name);
                    
                }
                
                
            }
            
        }
        
    }
    public void buildWordFileMap (){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for( File f: dr.selectedFiles()){
            addWordsFromFile(f);
            
        }
        
    }
    public int maxNumber(){
        int max  = 0;
        for(String word: map.keySet()){
           if( map.get(word).size()>= max){
               max = map.get(word).size();
               
            }
            
        }
        
        return max;
        
    }
    public ArrayList<String> wordsInNumFiles( int number){
        ArrayList<String> words = new ArrayList<String>();
        int total = 0;
        for ( String s: map.keySet()){
            if(map.get(s).size()== number){
                words.add(s);
                ++total;
            }
            
        }
        for(String s: words){
            System.out.println(s);
        }
        System.out.println(total);
        
        return words;    
    }
    public void printFilesIn(String word){
        for( String s: map.keySet()){
            if (s.equals(word)){
                for( String x: map.get(s)){
                    System.out.println(x);
                    
                }
                
            }
                   
        }
        
    }
    public void printOutput(){
        int max  = maxNumber();
        int total =0;
        for (String s: map.keySet()){
            if(map.get(s).size() == max){
                ++total;
                System.out.print("\""+s+"\""+" appears in the files: ");
                for ( String file: map.get(s)){
                    System.out.print(file+", ");
                    
                }
                System.out.println("\n");
                
            }
           
        }
         System.out.println(total);
        
    }
    public void test(){
        
        buildWordFileMap();
      // printOutput();
        printFilesIn("laid");
      //  printFilesIn("tree");
     // System.out.println("Words appear 4 times in files "); wordsInNumFiles(4);
        //System.out.println("Words appear 3 times in files "); wordsInNumFiles(3);
       
      
        
    }
}
