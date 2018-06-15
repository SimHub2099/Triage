/*
 * This TriageSimulator parses and makes
 * sense of the names and codes in the file, placing the 
 * names (not the conditions) in the appropriate queue.
 */

package Triage;

import java.util.*;

/**
 * @author Sim
 */

public class TriageSimulator{
    
    Queue<String> highPriQueue;
    Queue<String> midPriQueue;
    Queue<String> thirdPriQueue; 

    public TriageSimulator() {
        this.highPriQueue = new LinkedList();
        this.midPriQueue = new LinkedList();
        this.thirdPriQueue = new LinkedList();
    }

    @Override
    public String toString() {
        return "TriageSimulator{" + "highPriQueue=" + highPriQueue
                + ", midPriQueue=" + midPriQueue + ", thirdPriQueue=" 
                + thirdPriQueue + '}';
    }
    
    // add method doesn't return anything
    public void add(String lineFromFile)
    {
        //System.out.println("Testing add method: " + lineFromFile);
        if(lineFromFile.contains("AL") || lineFromFile.contains("HA") || 
                lineFromFile.contains("ST"))
        {
            highPriQueue.add(lineFromFile); //replaced "this" with "fileLine
            //setHighPriQueue();
            
        }
        else if (lineFromFile.contains("BL") || lineFromFile.contains("IW") ||
                lineFromFile.contains("KS") || lineFromFile.contains("OT"))
        { 
            midPriQueue.add(lineFromFile); //replaced "this" with "fileLine
        }
        else if(lineFromFile.contains("HN"))
        {
            thirdPriQueue.add(lineFromFile); //replaced "this" with "fileLine
        }
        
    } // end add method

    //returns name of next patient to be seen, removes him from appropriate queue
    public String remove() 
    {
        String itemToReturn = "";
        
        if(!highPriQueue.isEmpty())
        {
            itemToReturn = highPriQueue.remove();
        }
        else if(!midPriQueue.isEmpty())
        {
            itemToReturn = midPriQueue.remove();
        }
        else if(!thirdPriQueue.isEmpty()) //last queue
        {
            itemToReturn = thirdPriQueue.remove();
        }
        
        return itemToReturn;
        
    } // end remove method

    // returns boolean, indicating all three queues are empty
//    @Override
    public boolean isEmpty()
    { 
        return highPriQueue.isEmpty() && midPriQueue.isEmpty() && thirdPriQueue.isEmpty();
    } // end isEmpty method

} // end TriageSimulator method
