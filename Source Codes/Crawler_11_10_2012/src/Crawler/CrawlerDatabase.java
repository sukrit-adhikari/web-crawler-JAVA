package Crawler;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import CrawlerHost.DataBaseDetails;

public class CrawlerDatabase {
    
  private Connection connect = null;
  private Statement statement = null;
  //private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
//  private DataBaseDetails dbDetails;
  int numero;
  
public void insert(String insertStatement,DataBaseDetails dbDetails){
    
    try{
        // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(dbDetails.getDataBaseURL(),dbDetails.getDataBaseUser(),dbDetails.getDataBasePassword());

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      statement.executeUpdate(insertStatement);
      //System.out.print(numero);
      //statement.executeUpdate(insertStatement);
      //resultSet = statement.executeUpdate(insertStatement);
    }catch (Exception e) {
      System.out.print("Herererer666");
      System.out.print(e);
    } 
}
public String getLastWebPageID(DataBaseDetails dbDetails){
    ResultSet resultSet_glwi = null;
    try{
        // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(dbDetails.getDataBaseURL(),dbDetails.getDataBaseUser(),dbDetails.getDataBasePassword());

      // Statements allow to issue SQL queries to the database
      
      statement = connect.createStatement();
      resultSet_glwi = statement.executeQuery("SELECT `id` FROM `tbl_webpage` ORDER BY `id` DESC LIMIT 1");
      
      if(resultSet_glwi.next()){
          return Integer.toString( resultSet_glwi.getInt("id")  );
          
      }else{
          return "NOT FOUND";
      }
      
    }catch (Exception e) {
      System.out.print(e);
      System.out.print("Herererer333");
      return "NOT FOUND"; // IMP as REsult SET IS NULL in Initialization ///
    }
}


public String nextWebPageToCrawl(DataBaseDetails dbDetails){
   ResultSet resultSet_nwptc = null; 
   String sltStmt="SELECT `found_in_webpage_url` FROM `tbl_found_in_webpage_url` WHERE `found_in_webpage_url` NOT IN (SELECT `webpage_url` FROM `tbl_webpage`) LIMIT 1"; 
try{
        // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(dbDetails.getDataBaseURL(),dbDetails.getDataBaseUser(),dbDetails.getDataBasePassword());

      //System.out.print(dbDetails.getDataBaseURL());
      
      // Statements allow to issue SQL queries to the database
      
      statement = connect.createStatement();
      
      resultSet_nwptc = statement.executeQuery(sltStmt);
      
      if(checkEmptyTables(dbDetails)==true){
          return dbDetails.getStartURL();
      }
      
      if(resultSet_nwptc.next()){
          return  resultSet_nwptc.getString("found_in_webpage_url");
          
      }else{
          return "NOT FOUND";
      }

    }catch (Exception e) {
      System.out.print(e);
      System.out.print("Herererer");
      return "NOT FOUND"; // IMP as REsult SET IS NULL in Initialization ///
    }

}

public boolean checkEmptyTables(DataBaseDetails dbDetails){
   ResultSet resultSet_cet = null;
    String selectionStmt="SELECT count(*) FROM `tbl_found_in_webpage_url`"; 
try{
        // Thiss will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(dbDetails.getDataBaseURL(),dbDetails.getDataBaseUser(),dbDetails.getDataBasePassword());

      
      //System.out.print(dbDetails.getDataBaseURL());
      // Statements allow to issue SQL queries to the database
      
      statement = connect.createStatement();
      resultSet_cet = statement.executeQuery(selectionStmt);
      
      resultSet_cet.next();
      
      if(resultSet_cet.getInt("count(*)")!=0){
          return  false;
          
      }else{
          return true;
      }

    }catch (Exception e) {
      System.out.print(e);
      System.out.print("Herererer222");
      return false;
    }

}

}