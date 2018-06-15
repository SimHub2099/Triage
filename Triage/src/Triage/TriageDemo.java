/*
 * This is a simulator that simulates a triage solution, taking input from a file
 * and implementing a priority queue to handle the requests in order from worse
 * condition to more milder ones; 
 * Priority 1: Amputated limb or digit, Heart attack, Stroke, or Broken leg. 
 * Priority 2: Infected wound (abscess), Kidney stones, or Other/Unknown.
 * Priority 3: Hangnail
 */
package Triage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Sim
 */
public class TriageDemo {
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("src/Triage/TriageList.txt");
        if (!file.exists())
        {
            System.out.println("The TriageList file is not found.");
            System.exit(0);
        }
        
        TriageSimulator triSim = new TriageSimulator();

        System.out.println("\n*** Initializing... ***\n");
        System.out.println("The contents of the file include: \n");

        Scanner scan = new Scanner(file);
        //String priority; //don't think I need
            
        while (scan.hasNext())
        {
            String x = scan.nextLine();
            System.out.println(x);
            triSim.add(x);
                 
        } //end while
        
       System.out.println("\n*** File-reading complete. ***\n");

       System.out.println("\nHospital Priority Queue:\n");

       while (!triSim.isEmpty())
       {
           System.out.println(triSim.remove());
       }
                   
        scan.close();
        
    } // end main

} // end TriageDemo
