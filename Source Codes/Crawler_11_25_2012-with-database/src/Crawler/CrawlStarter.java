package Crawler;

import java.util.ArrayList;
import CrawlerHost.DataBaseDetails;
import java.sql.ResultSet;

public class CrawlStarter {

    /*
Crawl Starter Does the following things:
1. BAckUPs DATABASE if Crawl Fails.(Not Now)
2. Empties DATABASE tables for New Crawl Values
3. Crawls the START Page and then passes Control to CrawlFromDatabase
    */
    
public String startCrawling(String startURL,DataBaseDetails dbDetails){

    String pageSource;
    String webPageInsertStmt;
    pageSourceLinks pSL = new pageSourceLinks();
    ArrayList<String> pageSourceLinks= new ArrayList();
    ReadSource rS = new ReadSource() ;
    CrawlerDatabase cB = new CrawlerDatabase();
    String contentDownloadedAndLinksFound;
    String selectLastID;
    String lastWebPageID;

    
    
    ///////////Insertion into Webpage of the STARTING page /////////////    
        webPageInsertStmt="INSERT INTO `tbl_webpage` (`id`,`webpage_url`) VALUES(NULL,'"+startURL+"')";
        cB.insert(webPageInsertStmt,dbDetails);
    ///////////Insertion into Webpage of the STARTING page /////////////
    
    pageSource = rS.returnSource(startURL);

    contentDownloadedAndLinksFound= Integer.toString(pageSource.length());

    lastWebPageID = cB.getLastWebPageID(dbDetails);
    
    if(!pageSource.equals("")){
        pageSourceLinks=pSL.sourceToLinks(pageSource, startURL);
        contentDownloadedAndLinksFound+="$"+Integer.toString(pageSourceLinks.size());   
        
        /////////////////////////////////////////////////////////
        while(!pageSourceLinks.isEmpty()){
            String foundPage=pageSourceLinks.get(0);
            String foundPageInsertStmt="INSERT INTO `tbl_found_in_webpage_url` (`id`,`webpage_id`,`found_in_webpage_url`) VALUES(NULL,'"+lastWebPageID+"','"+foundPage+"')";
            cB.insert(foundPageInsertStmt,dbDetails);
            
            // Main Print of Links HERE //
            System.out.print(pageSourceLinks.remove(0)+"\n");
            // End of main Print //
        }
        /////////////////////////////////////////////////////////
    }else {
        
     contentDownloadedAndLinksFound+="$"+"0";
    }
    return contentDownloadedAndLinksFound;
}

}