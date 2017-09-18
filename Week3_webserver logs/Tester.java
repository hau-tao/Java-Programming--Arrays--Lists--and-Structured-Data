
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log.txt");
        la.printAll();
    }
    public void  testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println("The number of unique IPs "+ la.countUniqueIPs ());
        
    }
     public void  testAllHigherThanNum(){
          LogAnalyzer la = new LogAnalyzer();
          la.readFile("weblog1_log.txt");
          la.printAllHigherThanNum(400);
        }
        
    public void testuniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println("The number of day visited "+ la.uniqueIPVisitsOnDay("Sep 24").size());
            
        }
    public void testCountUniqueIPsInRange (){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        System.out.println("The number of unique IPs with status code in range "
        + la.countUniqueIPsInRange (400,499));
            
        }
        
   public void testCountVisitsPerIP (){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log.txt");
        HashMap <String,Integer> counts = la.countVisitsPerIP ();
        for(String s: counts.keySet()){
             System.out.println(s +" "+ counts.get(s));
            
        }
       
            
  }
  public void testMostNumberVisitsByIP(){
      LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
         HashMap <String,Integer> counts = la.countVisitsPerIP ();
        int max = la.mostNumberVisitsByIP(counts);
        System.out.println("max number "+ max);
        
      
    }
    
    public void testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        HashMap <String,Integer> counts = la.countVisitsPerIP ();
        int max = la.mostNumberVisitsByIP(counts);
        ArrayList<String> ip = la.iPsMostVisits(counts);
        System.out.println(ip);
        
    }
    public void testiPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log.txt");
        HashMap <String,ArrayList<String>> ipsDay = la.iPsForDays();
        for(String s: ipsDay.keySet()){
           System.out.println(ipsDay.get(s)+ " "+ s);
            
        }
        
        
    }
    
    public void testDayWithMostIPVisits(){
         LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        HashMap <String,ArrayList<String>> ipsDay = la.iPsForDays();
        System.out.println("the most visited "+  la.dayWithMostIPVisits(ipsDay ));
        
    }
     public void testIPsWithMostVisitsOnDay(){
         LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log.txt");
        HashMap <String,ArrayList<String>> ipsDay = la.iPsForDays();
        System.out.println (la.iPsWithMostVisitsOnDay(ipsDay,"Sep 29"));
        }
    
    
}
