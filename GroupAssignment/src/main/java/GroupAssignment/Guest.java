package GroupAssignment;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Guest extends Database {
    private IntegerProperty guestID;
    private StringProperty access_code;
    private StringProperty email_address;
    private StringProperty fname;
    private StringProperty lname; 
    private IntegerProperty adminID;
    
    public Guest () {
        
    }
    
    public Guest(int guestID, String access_code, String email_address, String fname, String lname, int adminID) {
        this.guestID = new SimpleIntegerProperty(guestID);
        this.access_code = new SimpleStringProperty(access_code);
        this.email_address = new SimpleStringProperty(email_address);
        this.fname= new SimpleStringProperty(fname);
        this.lname= new SimpleStringProperty(lname);
        this.adminID= new SimpleIntegerProperty(adminID);
    }

    //setters
    public void setguestID(int guestID) {
        this.guestID = new SimpleIntegerProperty(guestID);
    }
    public void setaccess_code(String access_code){
        this.access_code =  new SimpleStringProperty(access_code);
    }
    public void setemail_address(String email_address){
        this.email_address= new SimpleStringProperty(email_address);
    }
    public void setfname(String fname){
        this.fname= new SimpleStringProperty(fname);
    }
    public void setlname(String lname){
        this.lname= new SimpleStringProperty(lname);
    }
    public void setadminID(int adminID){
        this.adminID=  new SimpleIntegerProperty(adminID);
    }
        
    //getters
   public int getguestID() {
      return guestID.get(); 
   }
   public String getaccess_code(){
       return access_code.get();
   }
   public String getemail_address(){
       return email_address.get();
   }
   public String getfname(){
       return fname.get();
   }
    public String getlname(){
        return lname.get();
    }
    public int getadminID(){
        return adminID.get();
    }
    
    //Property methods
    public IntegerProperty guestIDProperty() {
        return guestID;
    }
    
    public StringProperty access_codeProperty() {
        return access_code;
    }
    
    public StringProperty email_addressProperty() {
        return email_address;
    }
    
    public StringProperty fnameProperty() {
        return fname;
    }
    
    public StringProperty lnameProperty() {
        return lname;  
    }
    
    public IntegerProperty adminIDProperty() {
        return adminID;
    }
    
    @Override
    public String toString() {
        String output = getfname() + " " + getlname();
        return output;
    }
    
}

