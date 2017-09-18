import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> notRepeatedWords;
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/datalong";
    private static String dataSourceDirectory = "datalong";
    
    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        notRepeatedWords = new ArrayList<String>();
       
        
    }
    
    public GladLibMap(String source){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
        notRepeatedWords = new ArrayList<String>();
       
        
       
       
    }
    
    private void initializeFromSource(String source) {
        String[] labels ={"adjective","noun","color","country","name","animal","timeframe","verb",
            "fruit"};
        for(String s: labels){
          
            ArrayList<String>list = readIt(source+"/"+s+".txt");
            myMap.put(s,list);
            
        }
    }
    
    private String randomFrom(ArrayList<String> source){
        
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        
        return randomFrom(myMap.get(label));
    }
    
    private String processWord(String w){
        //notRepeatedWords.clear();
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        
        while(true){
            int index = notRepeatedWords.indexOf(sub);
            if(index == -1){
                notRepeatedWords.add(sub);
                w = prefix+sub+suffix;
                break;
            
            } 
            else{
                sub = getSubstitute(w.substring(first+1,last));
             
            }
            
            
          }

        return w;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    public int  totalWordsInMap(){
        int total = 0;
        for(String s: myMap.keySet()){
            System.out.println(s);
            total += myMap.get(s).size();
            
        }
        return total;
        
    }
    public int totalWordsConsidered(){
        int total = 0;
        
        for(String s : myMap.keySet()){
            int track =0;
            for( String word: notRepeatedWords){
                 if (myMap.get(s).contains(word)){
                     ++ track;
                     if(track ==1){
                         total += myMap.get(s).size();
                         
                        }
                     
                     
                    }
                 
                
            }
           
            
        }
        return total;
    }
    
    public void makeStory(){
        notRepeatedWords.clear();
        
        System.out.println("\n");
        String story = fromTemplate("datalong/madtemplate2.txt");
       for( int i = 0; i< notRepeatedWords.size();++i){
           System.out.println("the array list: " + notRepeatedWords.get(i));
           
        }
         
        printOut(story, 60);
        System.out.println("\nThe size is " +notRepeatedWords.size());
        System.out.println("The number of words in all catalog are "+totalWordsInMap());
        System.out.println("The number of words in a particula catalog of the template are "
        +totalWordsConsidered());
        
    }
    


}
