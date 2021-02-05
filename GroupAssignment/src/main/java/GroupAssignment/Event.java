package GroupAssignment;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;


public class Event extends Database {
    public IntegerProperty eventID;
    public StringProperty event_location;
    public StringProperty event_title;
    public ObjectProperty<LocalDate> event_date;
    public IntegerProperty event_time;
    public IntegerProperty adminID; 
    
   public Event () {
       
   }
    
    public Event(int eventID, String event_location, String event_title, LocalDate event_date, int event_time, int adminID) {
        this.eventID = new SimpleIntegerProperty(eventID);
        this.event_location = new SimpleStringProperty(event_location);
        this.event_title = new SimpleStringProperty(event_title);
        this.event_date = new SimpleObjectProperty(event_date);
        this.event_time = new SimpleIntegerProperty(event_time);
        this.adminID= new SimpleIntegerProperty(adminID);
    }


     //setters
    public void seteventID(int eventID) {
        this.eventID = new SimpleIntegerProperty(eventID) ;
    }
    public void setevent_location(String event_location){
        this.event_location = new SimpleStringProperty(event_location);
    }
    public void setevent_title(String event_title){
        this.event_title = new SimpleStringProperty(event_title);
    }
    public void setevent_date(LocalDate event_date){
        this.event_date= new SimpleObjectProperty(event_date);
    }
    public void setevent_time(int event_time) {
        this.event_time = new SimpleIntegerProperty(event_time);
    }
    public void setadminID(int adminID){
        this.adminID= new SimpleIntegerProperty(adminID);
    }

        
    //getters
   public int geteventID() {
      return eventID.get(); 
   }
   public String getevent_location(){
       return event_location.get();
   }
   public String getevent_title(){
       return event_title.get();
   }
   public LocalDate getevent_date(){
      return event_date.get();
   }
   
   public int getevent_time() {
        return event_time.get();
   }
    public int getadminID(){
        return adminID.get();
    }
    
    //Property methods
    public IntegerProperty eventIDProperty() {
        return eventID;
    }
    
    public StringProperty event_locationProperty() {
        return event_location;
    }
    
    public StringProperty event_titleProperty() {
        return event_title;
    }
    
    public IntegerProperty event_timeProperty() {
        return event_time;
    }
    
    public IntegerProperty adminIDProperty() {
        return adminID;
    }
    
    public ObjectProperty<LocalDate> event_dateProperty() {
        return event_date;
    }

    
}
