package GroupAssignment;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Invitaiton extends Database {
    public IntegerProperty invitationID;
    public IntegerProperty eventID;
    public IntegerProperty guestID;
    public IntegerProperty adminID;

    
    public Invitaiton () {
        
    }
    
    public Invitaiton(int eventID, String activity, int activity_time) {
        this.invitationID = new SimpleIntegerProperty(eventID);
        this.eventID = new SimpleIntegerProperty(eventID);
        this.guestID = new SimpleIntegerProperty(eventID);
        this.eventID = new SimpleIntegerProperty(eventID);

    }


     //setters
    public void setinvitationID(int invitationID) {
        this.invitationID = new SimpleIntegerProperty(invitationID) ;
    }
    public void setguestID(int guestID) {
        this.guestID = new SimpleIntegerProperty(guestID) ;
    }
    public void seteventID(int eventID) {
        this.eventID = new SimpleIntegerProperty(eventID) ;
    }
    public void setadminID(int adminID) {
        this.adminID = new SimpleIntegerProperty(adminID) ;
    }
  
    //getters
   public int geteventID() {
      return this.eventID.get(); 
   }
   public int getinvitationID() {
      return this.invitationID.get(); 
   }
   public int getguestID() {
      return this.guestID.get(); 
   }
   public int getadminID() {
      return this.adminID.get(); 
   }


    
    //Property methods
    public IntegerProperty getinvitationIDProperty() {
        return invitationID;
    }
    
    public IntegerProperty eventIDProperty() {
        return eventID;
    }
        
    public IntegerProperty guestIDProperty() {
        return guestID;
    }
    
    public IntegerProperty adminIDProperty() {
        return adminID;
    }

}

