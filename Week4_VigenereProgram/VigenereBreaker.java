import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String result ="";
        for(int i = whichSlice; i< message.length();i = i+ totalSlices){
            result += message.charAt(i);
            
        }
            
        
        return result;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        
        //WRITE YOUR CODE HERE
       
        CaesarCracker[] cracker = new CaesarCracker[klength];
        
        for(int i = 0; i <klength; ++i){
            cracker[i] = new CaesarCracker(mostCommon);
            String s = sliceString(encrypted, i, klength);
          
            
            key[i] =cracker[i].getKey(s)  ;
            //System.out.println(key[i]);
            
        }
        /*int i =0;
        for(char c: encryptedMessage.toCharArray()){
            int crackerIndex= i% klength;
            CaesarCracker thisCracker = cracker[crackerIndex];
             key[crackerIndex] =cracker[crackerIndex].getKey(c)  ;
            ++i;
            
            
        }*/
        return key;
    }

    public void breakVigenere () {
       /* //read from encrypted file
       FileResource fr = new FileResource();
       String s = fr.asString();
       // read from dictionary
       FileResource dict = new FileResource("dictionaries/English");
       HashSet<String> mySet = readDictionary(dict);
       System.out.println(breakForLanguage(s,mySet));*/
       HashMap<String, HashSet<String>> myMap = new  HashMap<String, HashSet<String>>();
       HashSet<String> Set = new HashSet<String> ();
       String[] labels ={"Danish","Dutch","English","French","German","Italian",
            "Portuguese","Spanish"};
               
        for(String s: labels){
            FileResource fr = new FileResource("dictionaries/"+s);
            Set = readDictionary(fr);
            myMap.put(s,Set);
            
        }
        FileResource fr = new FileResource();
        String s = fr.asString();
        System.out.println(breakForAllLanguages(s,myMap));
     
       
      
    }
    public HashSet<String> readDictionary(FileResource fr){
         HashSet<String> hs =  new  HashSet<String>();
         
             for(String s: fr.lines()){
                    s = s.toLowerCase();       
                hs.add(s);
   
        }
            
        
        
        return hs;
    }
    public int countWords(String message, HashSet<String> dictionary){
        int[]keys ={5,11,20,19,4};
        int count  = 0;
  
        for(String s:  message.split("\\W")){
            s = s.toLowerCase();
            s= s.trim();
           
           if(dictionary.contains(s)){
                    ++count;
                  
                }
            }

        return count;
        
    }
    public String breakForLanguage(String encrypted,  HashSet<String> dictionary){
        
            String decrypted =" ";
            int max  =0;
            int count =0;
            int keyLength = 0;
         // System.out.println(count);
         
            
           
        
          
        
          for(int i = 6; i<7; ++i){
            int[] keys = tryKeyLength(encrypted, i, mostCommonCharIn(dictionary));
            VigenereCipher vc = new VigenereCipher(keys);
            decrypted = vc.decrypt(encrypted);
            count = countWords(decrypted,dictionary);
          
            if( count > max)
            {
                max = count;
                keyLength = i;
            }
            
        }
        
        System.out.println("the valid word is  "+count);
        System.out.println(keyLength);
        return decrypted;
        
    }
    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char commonChar = 'c';
        for(String s :dictionary){
            for(int i =0; i< s.length(); ++i){
                if(!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),1);
                    
                }
                else{
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    
                }
                
            }
            
            
        }
        int max  = 0;
        for(char c: map.keySet()){
            if(map.get(c) > max){
                max = map.get(c);
                commonChar = c;
                
            }
            
        }
        return commonChar;
        
    }
    public String breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>>languages){
        //create hasMAp from String to HashSet
        String decrypted =" ";
        
        for(String s: languages.keySet()){
            decrypted = breakForLanguage(encrypted, languages.get(s));
            
        }
        return decrypted;
        
    }
    
}
