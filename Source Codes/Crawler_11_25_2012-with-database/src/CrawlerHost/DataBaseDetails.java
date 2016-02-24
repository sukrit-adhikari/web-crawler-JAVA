/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CrawlerHost;

/**
 *
 * @author Sukrit
 */
public class DataBaseDetails {
    
    String dataBaseURL="";
    String dataBaseUser="";
    String dataBasePassword="";
    String startURL="";
    char ready;
    
    public String getDataBaseURL() {
        return dataBaseURL;
    }

    public void setDataBaseURL(String dataBaseURL) {
        this.dataBaseURL = dataBaseURL;
    }

    public String getDataBaseUser() {
        return dataBaseUser;
    }

    public void setDataBaseUser(String dataBaseUser) {
        this.dataBaseUser = dataBaseUser;
    }

    public String getStartURL() {
        return startURL;
    }

    public void setStartURL(String startURL) {
        this.startURL = startURL;
    }

    public String getDataBasePassword() {
        return dataBasePassword;
    }

    public void setDataBasePassword(String dataBasePassword) {
        this.dataBasePassword = dataBasePassword;
    }

    public char getReady() {
        return ready;
    }

    public void setReady(char ready) {
        this.ready = ready;
    }

}

