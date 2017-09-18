
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for(String s: fr.lines()){
             
             
             LogEntry le = WebLogParser.parseEntry(s);
             records.add(le);
            
             
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     public int countUniqueIPs (){
         ArrayList<String> uniqueIPs = new ArrayList<String> ();
         for(LogEntry le: records){
             String ipAddr = le.getIpAddress();
             if(!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
                 
                }
             
            }
         return uniqueIPs.size();
        }
    public void printAllHigherThanNum(int num){
        int index =-1;
      
        for(LogEntry le: records){
            ++index;
            if(le.getStatusCode()> num){
               
                System.out.println("The status code are greater than: "
                
                 + num +" " + records.get(index));
            }
            
        }
        
    }
    public ArrayList<String>  uniqueIPVisitsOnDay(String someday){
        ArrayList<String> uniqueIPVisits = new ArrayList<String>();
        ArrayList<String> uniqueIPs = new ArrayList<String> ();
        for( LogEntry le: records){
            String s = le.getAccessTime().toString();
            String ipAddr = le.getIpAddress();
            if(s.contains(someday)&& !uniqueIPs.contains(ipAddr)){
                uniqueIPVisits.add(s); 
                 uniqueIPs.add(ipAddr);
            }
            
        }
        return uniqueIPVisits;
        
    }
    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIPs = new ArrayList<String> ();
        int index =-1;
         for(LogEntry le: records){
             ++index;
             String ipAddr = le.getIpAddress();
             if(!uniqueIPs.contains(ipAddr)&&
             le.getStatusCode()>= low && le.getStatusCode()<= high){
                uniqueIPs.add(ipAddr);
                }
             
            }
            return uniqueIPs.size();
        
    }
    public HashMap <String,Integer> countVisitsPerIP(){
        HashMap <String,Integer> counts = new HashMap <String,Integer>();
        for(LogEntry le: records){
            String ipAddr = le.getIpAddress();
            if(!counts.containsKey(ipAddr)){
                counts.put(ipAddr,1);
                
            }
            else{
                counts.put(ipAddr,counts.get(ipAddr)+1);
                
            }
            
        }
        return counts;
        
    }
    public int mostNumberVisitsByIP(HashMap<String, Integer> myMap)
    {
        int max =0;
        for(String s: myMap.keySet()){
            if(myMap.get(s)> max){
                max = myMap.get(s);
            }
            
        }
        return max;
        
    }
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> myMap){
        int max =  mostNumberVisitsByIP(myMap);
        ArrayList<String> ip = new ArrayList<String>();
        for(String s: myMap.keySet()){
            if(myMap.get(s)== max){
                ip.add(s);
                
            }
            
        }
        return ip;
        
        
    }
    public HashMap<String, ArrayList<String>> iPsForDays(){
     
        HashMap<String, ArrayList<String>> mymap = new HashMap<String, ArrayList<String>>();
        
        
        for (LogEntry le: records){
            String s = le.getAccessTime().toString();
            ArrayList<String> ipAddr = new ArrayList<String>();
            s = s.substring(4,10);
            String ip = le.getIpAddress();
            if( !mymap.containsKey(s)){
                ipAddr.add(ip);
                
                mymap.put(s, ipAddr);
                
            }
            else{
                mymap.get(s).add(ip);
                
            }
           
        }
            
        
        
        return mymap;
        
    }
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> mymap){
        int max = 0;
        String result ="";
        mymap = iPsForDays();
        for (String s : mymap.keySet()){
            if(mymap.get(s).size() > max){
                
                max = mymap.get(s).size();
                result = s;
                
            }
            
        }
        return result;
        
    }
    public ArrayList<String>  iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> mymap, String day){
         mymap = iPsForDays();
         int max = 0;
         //String mostVisited = dayWithMostIPVisits(mymap);
         HashMap<String, Integer> result = new HashMap<String, Integer>();
         ArrayList<String> returnedValue = new ArrayList<String>();
         //if(mostVisited.equals(day)){
            ArrayList<String> temp = mymap.get(day);
            for(String s: temp){
                if(!result.containsKey(s)){
                    result.put(s,1);
                    
                }
                else{
                    result.put(s,result.get(s)+1);
                    
                }
                
            }
        //}
        
        for( String s: result.keySet()){
            if(result.get(s) >=max){
                max = result.get(s);
               returnedValue .add(s);
                
            }
            
        }
        return  returnedValue;
        
    }
     
     
}
