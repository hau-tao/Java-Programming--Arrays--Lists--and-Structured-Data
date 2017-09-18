import edu.duke.*;
import java.util.*;
public class CodonCount
{
    private  HashMap<String,Integer> codon;
    public CodonCount(){
         codon = new HashMap<String,Integer>();
        
    }
    public void buildCodonMap(int start, String dna){
        // key is DNA and value is a start position
        codon.clear();
        dna = dna.substring(start);
        String s="";
        //for(String s : codon.keySet()){
            
            for( int i = 0; i+3 <= dna.length(); i = i+3){
                s = dna.substring(i,i+3);
                if( codon.keySet().contains(s)){
                    codon.put(s,codon.get(s)+ 1);
                    
                    
                }
                else{
                    codon.put(s,1);
                }
                
            }
            System.out.println("Reading frame strating with 0 results in "+ codon.size()
                                                +" unique codons");
        //} 
        
    }
    public String getMostCommonCodon(){
        int max = 0;
        String answer= "";
        for ( String s : codon.keySet()){
            if(codon.get(s) > max){
                max = codon.get(s);
                answer = s;
                
            }
            
        }
        System.out.println("and most common codon is " + answer +" with count "+ max);
        return answer;
          
    }
    public void printCodonCounts(int start, int end){
        System.out.println("Counts of codons between "+start + " and "+ end +" inclusive are:");
        for ( String s : codon.keySet()){
            if(start <= codon.get(s) && codon.get(s) <= end)
            {
                System.out.println(s + " "+ codon.get(s));
            }
        }
        
        
    }
    public void tester(){
        FileResource fr = new FileResource();
        for(String s : fr.lines()){
            s.trim();
            s=s.toUpperCase();
            // reading frame starting from 0                     
            //buildCodonMap(0,s);
           // getMostCommonCodon();
            //printCodonCounts(7,7);
             // reading frame starting from 1   
            //buildCodonMap(1,s);
            //getMostCommonCodon();
           // printCodonCounts(1,5);
             // reading frame starting from 2  
           buildCodonMap(2,s);
            getMostCommonCodon();
          //  printCodonCounts(1,5);
            
           
            
        }
        
    }
        
    
}
