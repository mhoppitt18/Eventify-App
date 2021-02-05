package GroupAssignment;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Admin extends Database {
    
    public static IntegerProperty adminID;
    private StringProperty username;
    private StringProperty password;
    
    public Admin(int adminID, String username, String password) {
        this.adminID = new SimpleIntegerProperty(adminID);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    //setters

    public void setadminID(int adminID) {
        this.adminID = new SimpleIntegerProperty(adminID) ;
    }
    public void setusername(String username){
        this.username= new SimpleStringProperty(username);
    }
    public void setpassword(String password){
        this.password= new SimpleStringProperty(password);
    }
    //getters
   public int getadminID() {
      return this.adminID.getValue().intValue(); 
   }
   public String getusername(){
       return this.username.get();
   }
   public String getpassword(){
       return this.password.get();
   }
    
}
