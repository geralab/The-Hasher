
package the.hasher;
/*
 * Gerald Blake
 * CS 4343 Program 4
 * This program will read from two files the aproapiate information
 * It will store the lowercase information from the first input file into a hash table accordingly
 * the program will separate the second input file's contents into tokens 
 * and remove punctuation from the second input file.
 * it will output the statistics of the file: comparisons and, token.
 * max, min, and average
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Program4 
{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        String inputString1 = "/usr/share/dict/words";
        String inputString2 = "";
       if(args.length > 0)
        {
            inputString2 = args[0];
        }
        else
        {
             System.out.println("You have not entered the appropiate commandline arguments the program has terminated...");
             return;
        }
        //create new hash table
        int maxSize = 200159;
        SetOfStrings theStrings = new SetOfStrings(maxSize);
       
        
        //REFERENCE FILES
        File input1 = new File(inputString1);
        File input2 = new File(inputString2);
        FileReader fileRead1, fileRead2;
       //SEE IF FILES EXIST
        //IF THEY DONT TERMINATE PROGRAM
        if(input1.exists())
        {
              fileRead1 = new FileReader(input1.getAbsoluteFile());
        }
        else
        {
            System.out.println(inputString1 + " not found the program has terminated...");
            return;
        }
        if(input2.exists())
        {
               fileRead2 = new FileReader(input2.getAbsoluteFile());
        
        }
        else
        {
            System.out.println(inputString2 + " not found the program has terminated...");
            return;
        }
        //CREATE FILE READERS
        BufferedReader reader1 = new BufferedReader(fileRead1);
        BufferedReader reader2 = new BufferedReader(fileRead2);
        String inputFileString;
        //READ FIRST FILE INTO HASH TABLE
        while(reader1.ready())
        {
               inputFileString = reader1.readLine();
               theStrings.add(inputFileString.toLowerCase());
        }
        
       reader1.close();
       inputFileString = "";
       
        //READ SECOND FILE 
       double sum = 0;
       int min = 100000000;
       int max = 0;
       int comparisonTimes = 0;
       int count=0;
        while(reader2.ready())
        {
               inputFileString = reader2.readLine();
               String delims = "[\\s\t]+";
               String[] tokens = inputFileString.split(delims);
               count+=tokens.length;
               for(String t:tokens)
               { 
                    String trimmedString = toLowerAndTrim(t);
                    int contains = theStrings.contains(trimmedString);
                    int positiveContains = Math.abs(contains);
                    sum += positiveContains;
                    comparisonTimes++;
                    
                    printFinds(contains,positiveContains,trimmedString,theStrings,false);

                    if(positiveContains < min)
                    {
                        min = positiveContains;
                    }
              
                    if(positiveContains > max)
                    {
                        max = positiveContains;
                    } 
               }
               
        }
        
        reader2.close();
        //STATISTICS
       System.out.format("%s %d%n","Size of set: ",theStrings.count());
       System.out.format("%s %d%n","Min of set: ",min);
       System.out.format("%s %d%n","Max of set: ",max);
      // System.out.format("%s %f%n","Sum of set: ",sum);
       System.out.format("%s %f%n","Avg of set: ",(sum /count));
       

      
    }
    public static void printFinds(int contains,int positiveContains, String trimmedString, SetOfStrings theStrings, boolean debug)
    {
        if(debug)
        {
             if(contains > 0)
               {
                     
                   System.out.format("TOKEN: %s COMPARISONS: %d HASH: %d%n",trimmedString, positiveContains,theStrings.hash(trimmedString));
               }
               else
               {
                   System.out.format("TOKEN: %s COMPARISONS: %d HASH: %d %s%n",trimmedString,positiveContains,theStrings.hash(trimmedString),"***NOT FOUND***");
               
               }
        }
        else
        {
            if(contains > 0)
               {

                   System.out.format("%s %d%n",trimmedString, positiveContains);
               }
               else
               {
                   System.out.format("%s %d %s%n",trimmedString,positiveContains,"***NOT FOUND***");

               }

            }
    }
    
    /**
     * removes unnecessary punctuation from a string
     * converts to lowercase and trims spaces from input
     * @param theString
     * @return
     */
    public static String toLowerAndTrim(String theString)
    {
         return theString.toLowerCase().replaceFirst("^[`´()“”˝’‘˙…,.?!:;[\'][\"]]+", "").replaceAll("[`´()“”˝’‘˙…,.?!:;[\'][\"]]+$", "").trim();
    }
    
}
