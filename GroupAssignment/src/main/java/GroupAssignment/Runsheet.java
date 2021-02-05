package GroupAssignment;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Runsheet extends Database {
    public IntegerProperty runsheetID;
    public IntegerProperty eventID;
    public StringProperty activity;
    public IntegerProperty activity_time;
    
    public Runsheet () {
        
    }
    
    public Runsheet(int runsheetID,int eventID, String activity, int activity_time) {
        this.runsheetID = new SimpleIntegerProperty(runsheetID);
        this.eventID = new SimpleIntegerProperty(eventID);
        this.activity = new SimpleStringProperty(activity);
        this.activity_time = new SimpleIntegerProperty(activity_time);
    }


     //setters
    public void setrunsheetID(int runsheetID) {
        this.runsheetID = new SimpleIntegerProperty(runsheetID) ;
    }
    public void seteventID(int eventID) {
        this.eventID = new SimpleIntegerProperty(eventID) ;
    }
    public void setactivity(String activity){
        this.activity = new SimpleStringProperty(activity);
    }
    public void setactivity_time(int activity_time) {
        this.activity_time = new SimpleIntegerProperty(activity_time);
    }
        
    //getters
    public int getrunsheetID() {
      return this.runsheetID.get(); 
   }
   public int geteventID() {
      return this.eventID.get(); 
   }
   public String getactivity(){
       return this.activity.get();
   }
   public int getactivity_time() {
        return this.activity_time.get();
   }

    
    //Property methods
    public IntegerProperty runsheetIDProperty() {
        return runsheetID;
    }
    public IntegerProperty eventIDProperty() {
        return eventID;
    }
    
    public StringProperty activityProperty() {
        return activity;
    }

    public IntegerProperty activity_timeProperty() {
        return activity_time;
    }  
    
    public int setEditedTime(String time) {
        int i = Integer.parseInt(time);
        return i;
    }
}
