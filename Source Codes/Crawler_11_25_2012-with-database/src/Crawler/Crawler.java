package Crawler;
import CrawlerHost.CrawlerWindow;
public class Crawler {
    
    Crawler(){
        
    }
    
	public static void main( String[] args) {
          
          //DataBaseDetails dbDetailsArg = new DataBaseDetails();
          //DataBaseDetails dbDetails = new DataBaseDetails();
          //CrawlStarter cS = new CrawlStarter();
          
          CrawlerWindow dbDetailsFrame=new CrawlerWindow();
          
          dbDetailsFrame.setSize(800,600);
          dbDetailsFrame.setVisible(true);
          dbDetailsFrame.setResizable(false);
          
          
          
         

        }
}