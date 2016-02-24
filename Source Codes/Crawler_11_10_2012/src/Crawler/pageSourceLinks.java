/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Crawler;
import java.util.ArrayList;
import java.net.URL;
/**
 *
 * @author Sukrit
 */
public class pageSourceLinks {
    


pageSourceLinks(){
        
    }

    public ArrayList sourceToLinks(String pageSource,String hostPageURL){
        pageSource=pageSource.toLowerCase();
        ArrayList links =new ArrayList();
        String linkFound;
        char[] pageSourceChrArray;
        char tagStart='n';
        
        String tagBuffer="";
 
        pageSourceChrArray = pageSource.toCharArray();
        
        for(char pageSourceChr : pageSourceChrArray){
            
            if(pageSourceChr=='<'){
                tagStart='y';
            }else if(pageSourceChr=='>'){
                tagStart='n';
            }
            
            if(tagStart=='y' && pageSourceChr!='<'){
                tagBuffer=tagBuffer+pageSourceChr;
            }
            
            if(tagStart=='n' && !tagBuffer.equals("")){
                
              //  System.out.println("TagBuffer:"+tagBuffer); // TEST verified
                
                linkFound=tagToLinkProcessor(tagBuffer,hostPageURL);
                
                if(!linkFound.equals("NOT FOUND")){
                    
                    links.add(linkFound);
                }
                tagBuffer="";
            }
            
          
        }
        return links;
    }
    
    
    private String tagToLinkProcessor(String tagContent, String hostPageURL){
       
        
        String linkFound;       
        
        if(tagContent.length()>3){
                    if(tagContent.indexOf(" href=")!=-1){
                        linkFound =tagContent.split("href=")[1];
                
                    if(linkFound.indexOf(' ')!=-1){
                        linkFound=linkFound.substring(0,linkFound.indexOf(' ') ) ;
                    }
                
                
                 
                //////////MAIN RETURN///////////////
                    if(validLink(linkFound)){
                       // System.out.print(linkFound);
                       return fullLink(cleanFoundLink(linkFound),cleanHostPageURL(hostPageURL)) ;
                //////////MAIN RETURN/////////////// 
                    }else{
                        return "NOT FOUND";
                    }
     
                
                }else{
                    return "NOT FOUND";
                }
                   
        }else{
            return "NOT FOUND";
        }   
    }

private boolean validLink(String linkFound){
    
    if(linkFound.indexOf(".php")!=-1){
        return true;
    }else if(linkFound.indexOf(".html")!=-1){
       return true; 
    }else if(linkFound.indexOf(".htm")!=-1){
       return true; 
    }else if(linkFound.indexOf("://")!=-1){
       return true;
    }
    else{
        return false;
    }
}


private String fullLink(String linkFound,String hostPageURL){
    if(linkFound.indexOf("://")!=-1){//FULL LINK Found
        return linkFound ;
    }else {
        return linkFound = hostPageURL+"/"+linkFound;
    }
}

private String cleanFoundLink(String linkFound){
    int stringLength=linkFound.length();
    int status=1;

   while(status==1){// Loop Until Fully Clean   http://google.com/ http://google.com////
    
      
       
    
    status = 0;
    
    if(linkFound.indexOf('"')==0 || linkFound.indexOf("'")==0){
        linkFound=linkFound.substring(1);
        stringLength=linkFound.length();
        status = 1;
    }
    
    if( (linkFound.indexOf('"')==(stringLength-1) || linkFound.indexOf("'")==(stringLength-1) ) && stringLength!=1 ){
        if( (stringLength) > 1){
        linkFound=linkFound.substring(0, stringLength-1);
        }
        stringLength=linkFound.length();
        status = 1;
    }
    
    if(linkFound.indexOf('/')==0){
        if( (stringLength) != 1){
        linkFound=linkFound.substring(1);
        }
        status = 1;
    }
    
}
return linkFound;    
}

// HostPage = Page we are currently Crawling to find links

private String cleanHostPageURL(String hostPageURL){
   String newHostPageURL="";
   
   try{
    URL URL = new URL(hostPageURL) ;
    
    newHostPageURL+= URL.getProtocol()+"://";
    newHostPageURL+=URL.getHost();
    return newHostPageURL;
    
} catch(Exception e) {
    System.exit(2);    
    return "NOT FOUND"; //redundant
}

}

}
