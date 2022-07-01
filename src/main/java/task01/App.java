package task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) throws IOException {

        String path = "C:/Users/T1me/Desktop/codingRevision/assessmentTask1/tour_packages.csv";
        String line = " ";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null ){
                // System.out.println(line);
                String [] column = line.split(",");
                List<String> mylist = Arrays.asList(column);
                //print the list
                System.out.println("");
                for(String a : mylist){
                   System.out.print(a + " ");
                //This should solve the read file issue
                }
            for(int i=0; i<=column.length;i++){
            }
            //Store the words under the specific headers 
            //Replace the column with row
            //Read Files
            //Everytime the program reads a word with the specific header it can replace it with a word that is available

                }


            }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

