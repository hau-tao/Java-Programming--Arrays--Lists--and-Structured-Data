import edu.duke.*;

public class CaesarBreaker
{   //count the occurence of each letter in a string 
   public int[] countLetters (String message){
       String alph ="abcdefghijklmnopqrstuvwxyz";
       int[] counts = new int[26];
       for(int k =0; k < message.length(); k++){
           char ch = Character.toLowerCase(message.charAt(k));
           int dex = alph.indexOf(ch);
           if(dex !=-1){
               counts[dex] +=1;
            }
            
        }
       return counts;
    }
    // find maximum occurence of eachletetr in an encrypted string
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k=0; k<vals.length;++k){
            if(vals[k]>vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
        
    }
    // decrypt the string
    public String decrypt (String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex -4;
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        return cc.encrypt(encrypted,26-dkey);
    }
    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String firstHalf = halfOfString (encrypted, 0);
        String secondHalf = halfOfString (encrypted, 1);
        // get encrypted key for first Half String
        int maxDex = getKey(encrypted);
        int maxDex1 = getKey(firstHalf);
        int maxDex2 = getKey(secondHalf);
        int dkey1 = maxDex1 -4;
            if(maxDex1 < 4){
                dkey1 = 26 - (4-maxDex1);
            }
        int dkey2 = maxDex2 -4;
            if(maxDex2 < 4){
                     dkey2 = 26 - (4-maxDex2);
                    }
                    System.out.println("The key 1st half " + dkey1 + " The key for 2nd half "+ dkey2);

        return cc.encryptTwoKeys(encrypted, 26-17, 26-4);
    }

    public String halfOfString(String message, int start){
        String s ="";
        for ( int i = start; i< message.length();i +=2)
        {
            s+= message.charAt(i);
            
        }
        return s;
        
    }
    public int getKey(String s){
        int[] freqs = countLetters(s);
         int maxDex = maxIndex(freqs);
         return maxDex;
        
    }
    public void testDecrypt(){
        CaesarCipher cc = new CaesarCipher();
        String  s ="Just a test string with lots of eeeeeeeeeeeeeeeees ";
       String st ="";
        //String a ="Top ncmy qkff vi vguv vbg ycpx";
        String f= "Top ncmy qkff vi vguv vbg ycpx";
       String c ="Xifqvximt tsdtlxzrx iijirvtl ek Uybi";
       String d ="Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
       
       String a= "Akag tjw Xibhr awoa aoee xakex znxag xwko";
       String b="Top ncmy qkff vi vguv vbg ycpx";
       String test="Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin";
        s = cc.encrypt(s, 14);
        //for ( int i = 0; i< 26;++i){
        System.out.println("the decrypted message " + decrypt(s));
        System.out.println("half of string at 0 " + halfOfString("Qbkm Zgis",0));
         System.out.println("half of string at 1 " + halfOfString("Qbkm Zgis",1));
       //  System.out.println("the maximum occurence letter in getkey " + getKey(s));
           //decryptTwoKeys(a);
        System.out.println("The dycrpted for 2 key(test): "+ decryptTwoKeys(test));
        FileResource fil = new FileResource();
        for( String k: fil.lines()){
            st += k;
        }
         System.out.println("the input string is: "+ st);
         System.out.println("The dycrpted for 2 key: "+ decryptTwoKeys(st));
         System.out.println(getKey(st));
    }
    
}
