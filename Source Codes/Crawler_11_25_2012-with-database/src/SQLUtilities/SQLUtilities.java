package SQLUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CrawlerHost.DataBaseDetails;

public class SQLUtilities {
    
public boolean testValidSQL(String URL, String user, String password){
Connection connect =null;
    try{
        // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager.getConnection(URL,user,password);
      if(connect!=null){
          return true;
      }else{
          return false;
      }
    }catch (Exception e) {
         return false;
    } 
}

public boolean backUpTables(DataBaseDetails dbDetails){
    
    Connection connect;
    Statement statement;
    
    
    try{
        // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection(dbDetails.getDataBaseURL(),dbDetails.getDataBaseUser(),dbDetails.getDataBasePassword());

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      statement.executeUpdate("SELECT * INTO `tbl_webpage` FROM `tbl_webpage_backup`");
      statement.executeUpdate("SELECT * INTO `tbl_found_in_webpage_url_backup` FROM `tbl_found_in_webpage_url`");
      
      return true;
      
      
    }catch (Exception e) {
      System.out.print("Herererer666");
      System.out.print(e);
      return false; 
    }
    
    
}

}
