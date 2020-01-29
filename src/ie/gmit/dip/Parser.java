package ie.gmit.dip;
import java.util.*;
import java.io.*;

public class Parser {
    

    public String parse(String file, Cypher c) throws FileNotFoundException{
        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        
        while((line = br.readLine()) != null) {
            //String s = c.encrypt(line);
        
        }
        br.close();
        } catch (Exception e) {
            System.out.println (e.toString());
            System.out.println("Could not find file " + file);
        }finally {
            System.out.println("\n\nCleaning up....");
            
        }
        return null;
    }
}




    
    







///main = parse(file) - main is the caller main handles the filenotfound exception