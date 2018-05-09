// Day 1 exercise to compute the discrepancy in head counts between GTA sections.
// Compile with the command line
// 
// $> javac Discrepancy.java
// 
// Run the main method with the command line
// 
// $> java Discrepancy
// 
import java.util.*;

public class Discrepancy{

  // Compute the discrepancy in head count for the given GTAs; the
  // secs array is ignored. This version uses ArrayLists to track the
  // GTAs that have been seen.
  public static int discrepancy(String [] secs, String [] gtas, int [] counts){
    ArrayList<String> gtaNames = new ArrayList<>();
    ArrayList<Integer> gtaTotals = new ArrayList<>();
    for(int i=0; i<gtas.length; i++){
      String gta = gtas[i];     // current gta
      int count = counts[i];    // current count
      // Ensure the arrays contains the current gta
      if(!gtaNames.contains(gta)){
        gtaNames.add(gta);
        gtaTotals.add(0);
      }
      int gtaIndex = gtaNames.indexOf(gta);
      int curTotal = gtaTotals.get(gtaIndex);
      int newTotal = curTotal + count;
      gtaTotals.set(gtaIndex,newTotal);
    }

    // gtaTotals now contains total counts for each GTA
    // Scan through and find the min and max totals
    int minTotal=Integer.MAX_VALUE;
    int maxTotal=Integer.MIN_VALUE;
    for(Integer total : gtaTotals){
      if(total < minTotal){
        minTotal = total;
      }
      if(total > maxTotal){
        maxTotal = total;
      }
    }
    // discrepancy is the difference between max/min total.
    int discrepancy = maxTotal - minTotal;
    return discrepancy;
  }

  // Compute the discrepancy in head count for the given GTAs; the
  // secs array is ignored. This version uses a HashMap to ease the
  // accumulation of head counts
  public static int discrepancy2(String [] secs, String [] gtas, int [] counts){
    // Map gta names to total counts
    Map<String,Integer> gtaTotals = new HashMap<String,Integer>();
    for(int i=0; i<gtas.length; i++){
      String gta = gtas[i];      // current gta
      int count = counts[i];    // current count
      // Ensure the map contains the current gta
      if(!gtaTotals.containsKey(gta)){
        gtaTotals.put(gta,0);
      }
      int curTotal = gtaTotals.get(gta);
      int newTotal = curTotal + count;
      gtaTotals.put(gta,newTotal);
    }

    // gtaTotals now contains total counts for each GTA
    // Scan through and find the min and max totals
    int minTotal=Integer.MAX_VALUE;
    int maxTotal=Integer.MIN_VALUE;
    for(Integer total : gtaTotals.values()){
      if(total < minTotal){
        minTotal = total;
      }
      if(total > maxTotal){
        maxTotal = total;
      }
    }
    // discrepancy is the difference between max/min total.
    int discrepancy = maxTotal - minTotal;
    return discrepancy;
  }


  // Main method to test the discrepancy method
  public static void main(String args[]){
    String secs [] ={"211", "219", "208", "222", "220", "2H1", "205", "207", "206", "209", "210", "212", "221", "218", "214"};
    String gtas [] = {"Fardina", "Lubaba", "Yue", "Umang", "Lubaba", "Maryam", "Mingrui", "Yue", "Mingrui", "Parastoo", "Parastoo", "Fardina", "Umang", "Maryam", "Umang"};
    int counts [] = {21, 24, 14, 12, 24, 15, 11, 16, 14, 24, 24, 23, 23, 24, 11, };

    int discrepancy = discrepancy(secs,gtas,counts);
    System.out.println(discrepancy);

    discrepancy = discrepancy2(secs,gtas,counts);
    System.out.println(discrepancy);

  }


}
