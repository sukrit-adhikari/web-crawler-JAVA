// Files are Stored in C Drive

package StoreSourceInFiles;

import java.io.FileWriter;
import java.io.BufferedWriter;

public class StoreSourceInFiles {
    static int noOfWebPages=1;
    
public static void storeSourceInFiles(String webPageURL, String sourceCode){
   
    
  try{
  // Create file 
  FileWriter fstream = new FileWriter("d:\\SourceCodes\\"+noOfWebPages+".txt");
  
  noOfWebPages++;
  
  BufferedWriter out = new BufferedWriter(fstream);
  
  out.write(webPageURL);
  out.newLine();
  out.write(sourceCode);
  
  //Close the output stream
  
  out.close();
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }

}
}
