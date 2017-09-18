import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            char upperCurrChar = Character.toUpperCase(encrypted.charAt(i));
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            int idxUpper = alphabet.indexOf(upperCurrChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            else if (idxUpper != -1)
            {
                char newChar = shiftedAlphabet.charAt(idxUpper);
                char toLower = Character.toLowerCase(newChar);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, toLower);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabetKey1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabetKey2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        for(int i =0; i< encrypted.length();i+=2){
               char currChar = encrypted.charAt(i);
               char upperCurrChar = Character.toUpperCase(encrypted.charAt(i));
               int idx = alphabet.indexOf(currChar);
               int idxUpper = alphabet.indexOf(upperCurrChar);
               if(idx != -1){
                   //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetKey1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else if (idxUpper != -1)
                {
                    char newChar = shiftedAlphabetKey1.charAt(idxUpper);
                    char toLower = Character.toLowerCase(newChar);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, toLower);
                }
           
             
               
        }
        for(int i =1; i< encrypted.length();i+=2){
               char currChar = encrypted.charAt(i);
               char upperCurrChar = Character.toUpperCase(encrypted.charAt(i));
               int idx = alphabet.indexOf(currChar);
               int idxUpper = alphabet.indexOf(upperCurrChar);
               if(idx != -1){
                   //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetKey2.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else if (idxUpper != -1)
                {
                    char newChar = shiftedAlphabetKey2.charAt(idxUpper);
                    char toLower = Character.toLowerCase(newChar);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, toLower);
                }
           
             
               
        }
         
       return encrypted.toString();
        
    }
    
   
    public void testCaesar() {
       // int key = 17;
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15));
        System.out.println(encrypt("First Legion", 17));
         System.out.println(encryptTwoKeys("First Legion", 23,17));
          System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
           System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
    }
}

