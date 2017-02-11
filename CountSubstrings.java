/**
 * This class contains the main implementation for counting words in a file using ArrayList and LinkedList. 
 * 
 * @author Joe Samuel
 * @version 5.0.0
 */

import java.util.*;
import java.lang.String;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CountSubstrings 
{
    /**
     * Main function to count for sub strings in the given file
     * 
     * @param  args[] Required argument for main function     
     * @return none 
     */        
   public static void main (String [] args)
        {
            while(true){
            ArrayList<String> list1 = new ArrayList<String>();
            LinkedList<String> list2 = new LinkedList<String>();
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the file name you wish to check: ");
            String fileName = input.nextLine();
            System.out.println("What would you like to do today?");
            System.out.println("1. Search for a word using just a array list");
            System.out.println("2. Search for a word using just a Linked List ");
            System.out.println("3. Compare the time between Array List and Linked List implementations");
            System.out.println("4. Quit the program");
            System.out.println("Please choose an option from the above: ");
            int option = input.nextInt();
                
            switch(option){    
            //Using Array List
           case 1: System.out.println("Searching a word using a Array List");
                        try{
                        Scanner scan = new Scanner(new File(fileName));
                        while(scan.hasNextLine())
                        {
                            Scanner so = new Scanner(scan.nextLine());
                            while(so.hasNext())
                            {
                            String s = so.next();
                            list1.add(s);
                        }
                        }
                        }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }                   
                    System.out.println("Please enter a word to track: ");
                    String searchWord = input.next();
                    int initial = (int) System.currentTimeMillis();
                    search(searchWord, list1);
                    int finalV = (int) System.currentTimeMillis();
                    int timeElapsed = finalV - initial;
                    System.out.println("The elapsed time for this process was " + timeElapsed + " ms.");
                    System.out.println();
                    break;
        
           
            //Using LinkedList
           case 2: System.out.println("Searching a word using a Linked List");
                    
                        try{
                        Scanner scan = new Scanner(new File(fileName));
                        while(scan.hasNextLine())
                        {
                            Scanner so = new Scanner(scan.nextLine());
                            while(so.hasNext())
                            {
                            String s = so.next();
                            list2.add(s);
                        }
                        }
                        }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
            
                    System.out.println("Please enter a word to track: ");
                    searchWord = input.next();
                    
                    initial = (int) System.currentTimeMillis();
                    search(searchWord, list2);
                    finalV = (int) System.currentTimeMillis();
                   timeElapsed = finalV - initial;
                    System.out.println("The elapsed time for this process was " + timeElapsed + " ms.");
                    System.out.println();
                    break;
                    
           case 3:  System.out.println("Using both the Linked List and Array list and comparing the speed.");
                     try{
                        Scanner scan = new Scanner(new File(fileName));
                        while(scan.hasNextLine())
                        {
                            Scanner so = new Scanner(scan.nextLine());
                            while(so.hasNext())
                            {
                            String s = so.next();
                            list1.add(s);
                            list2.add(s);
                        }
                        }
                        }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                    System.out.println("Please enter a word to track: ");
                    String searchWordTest = input.next();
                    initial = (int) System.currentTimeMillis();
                    search(searchWordTest, list1);
                    finalV = (int) System.currentTimeMillis();
                    int timeElapsed1 = finalV - initial;
                    System.out.println("The elapsed time for ArrayList process was " + timeElapsed1 + " ms.");
                    System.out.println();
                    initial = (int) System.currentTimeMillis();
                    search(searchWordTest, list2);
                    finalV = (int) System.currentTimeMillis();
                    int timeElapsed2 = finalV - initial;
                    System.out.println("The elapsed time for LinkedList process was " + timeElapsed2 + " ms.");
                    System.out.println();
                    if(timeElapsed1 > timeElapsed2)
                    System.out.println("The Array List implementation was faster by: " + (timeElapsed1-timeElapsed2) + " ms");
                    else
                    System.out.println("The Linked List was faster by " + (timeElapsed2 - timeElapsed1) + " ms");
                    break;
                    
           case 4: System.out.println("Exiting the Program!");
                    System.exit(0);
        }
      }
    }
    
    /**
     * Function to search for an array list 
     * 
     * @param  searchWord Search for this particular word inside the Array list.
     *         List1    the list to search from.
     * @return none 
     */        
   public static void search(String searchWord, ArrayList<String> List1)
    {
        boolean found = false;
        int counter = 0;
        Pattern pattern = Pattern.compile(searchWord);
        for(String currentWord : List1)
        {
            Matcher matcher = pattern.matcher(currentWord);
            while(matcher.find()) 
            {
                counter++;
                found = true;
            }
        }
        
        if(found == false)
        {
            counter = 0;
        }
        
        if(counter!=0)
        {
            System.out.println("Your word " + searchWord + " was found " + counter + " many time(s).");
        }
        else{
            System.out.println("Sorry! Your word " + searchWord + " was not found in the provided document. ");
        }
    }
    
    /**
     * Function to search for an linked list 
     * 
     * @param  searchWord Search for this particular word inside the linked list.
     *         List1    the list to search from.  
     * @return none 
     */     
   public static void search(String searchWord, LinkedList<String> List1)
    {
        boolean found = false;
        int counter = 0;
        Pattern pattern = Pattern.compile(searchWord);
        for(String currentWord : List1)
        {
            Matcher matcher = pattern.matcher(currentWord);
            while(matcher.find()) 
            {
                counter++;
                found = true;
            }
        }
        
        if(found == false)
        {
            counter = 0;
        }
        
        if(counter!=0)
        {
            System.out.println("Your word " + searchWord + " was found " + counter + " many time(s).");
        }
        else{
            System.out.println("Sorry! Your word " + searchWord + " was not found in the provided document. ");
        }
    }
}