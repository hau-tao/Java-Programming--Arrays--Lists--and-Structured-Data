import edu.duke.*;
public class WordLength
{   // count the wordlength of each word in  a file
    public void countWordLengths(FileResource resource, int[] counts){
        String[] s = new String[100];
        for( int i = 0; i<s.length; ++i)
        {
            s[i] =" ";
        }
        
       
            for(String word : resource.words()){
                //word = word.toLowerCase();
                //StringBuilder w = new StringBuilder(word);
                 int wordlength = word.length();
                //System.out.println(word);
               // for(int  i =0; i < size ;++i){
                   if (Character.isLetter(word.charAt(word.length()-1)) == false) {
                        wordlength--;
                        word = word.substring(0,wordlength);
                    }
                   
                 
               // }
                s[wordlength] += " "+ word  ;
                if (wordlength >= counts.length){                 
                            wordlength = counts.length - 1;       
                }  
                if (wordlength > 0 ) {  	   	   
                        counts[wordlength] ++;  	  	
                    }
                
                
                
        } 
        for( int i =0; i< counts.length; ++i)
                {
                    if(counts[i] != 0)
                    System.out.println(counts[i] +"  words of length "+ i +" "+ s[i] );
                }

}

   public void testCountWordLengths(){
        FileResource f = new FileResource();
        int[] counts = new int[131];
        countWordLengths(f, counts);
        
    }
}
       
       
        
        
    