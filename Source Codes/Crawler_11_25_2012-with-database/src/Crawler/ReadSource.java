/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Crawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import StoreSourceInFiles.StoreSourceInFiles;
/**
 *
 * @author Sukrit
 */
public class ReadSource {

    public String returnSource(String hostPageURL) {
                        String inputLine;
			String pageSource="";           
                        
    try {
			
                        
        
        URL URL = new URL(hostPageURL);
        
        URLConnection yc = URL.openConnection();
        
        //yc.setConnectTimeout(2);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			
                        
                        
                        while ( (inputLine = in.readLine()) != null) {
				pageSource=pageSource+inputLine;

			}
        
        in.close();
                     
        
        
                            
                              /*
                               for (String linkFound : linksArray){
                                    System.out.print(linkFound+"\n");
                               }
                               */
        /// File ma Write GARNE CAll /// 
        StoreSourceInFiles.storeSourceInFiles(hostPageURL,pageSource);
        /// File ma Write GARNE CAll ///
        
        
        return pageSource;
        } 
    catch (Exception e) {
        System.out.println(e);
        pageSource="";
        return pageSource;                 
    }
}

}
