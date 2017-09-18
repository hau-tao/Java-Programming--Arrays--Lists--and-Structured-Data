import edu.duke.*;
public class WordPlay
{
    public boolean isVowel(char ch){
        String vowel ="aeiou";
        String upperVowl ="AEIOU";
        boolean result = true;
        for(int i = 0; i< vowel.length();++i){
            if( ch == vowel.charAt(i) || ch == upperVowl.charAt(i))
           { result = true;
            break;}
            else
            {result = false;
             }
        }
        return result;
    }
    public void testWordPlay()
        {
            System.out.println(isVowel('F'));
            System.out.println(isVowel('a'));
            System.out.println(isVowel('I'));
            System.out.println(isVowel('e'));
            System.out.println(isVowel('o'));
            System.out.println(isVowel('U'));
            System.out.println(isVowel('K'));
        }
    public String replaceVowels (String phrase, char ch){
        StringBuilder sb= new StringBuilder(phrase);
   
        for(int i = 0; i< sb.length();++i){
            if(isVowel(sb.charAt(i))){
                sb.setCharAt(i, ch);
                
            }
        }
        return sb.toString();
        
    }
    public void testReplaceVowels ()
    {
        System.out.println (replaceVowels ("Hello World",'*'));
        
    }
    public String  emphasize( String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        
        for ( int i =0; i< phrase.length();++i){
            if(((phrase.charAt(i)== ch )|| (phrase.charAt(i)== Character.toUpperCase(ch))) &&( i%2 == 0)){
                //System.out.println(phrase.charAt(i)+ "at "+ i);
               sb.setCharAt(i,'*');
                
            }
            else if(((phrase.charAt(i)== ch) || (phrase.charAt(i)== Character.toUpperCase(ch))) && (i%2 != 0)){
                //System.out.println(phrase.charAt(i)+ "at "+ i);
                 sb.setCharAt(i,'+');
                
            }
            
        }
        return sb.toString();
        
    }
    public void testEmphasize()
    {
        System.out.println(emphasize("dna ctgaaactga", 'a'));
         System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
   
}
