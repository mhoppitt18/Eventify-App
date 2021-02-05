package GroupAssignment;
import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class RSVP extends Database{
    
    private IntegerProperty rsvpID;
    private StringProperty decision =  new SimpleStringProperty("Pending");
    private StringProperty dietary_requirements =  new SimpleStringProperty("None");
    private ObjectProperty<LocalDate> rsvp_date;
    private IntegerProperty invitationID;
    private StringProperty fname;
    private StringProperty lname;
    
   public RSVP() {
       
   }
    
    public RSVP(int rsvpID, String decision, String dietary_requirements, LocalDate rsvp_date, int invitationID, String fname, String lname) {
        this.rsvpID = new SimpleIntegerProperty(rsvpID);
        this.decision = new SimpleStringProperty(decision);
        this.dietary_requirements = new SimpleStringProperty(dietary_requirements);
        this.rsvp_date = new SimpleObjectProperty(rsvp_date);
        this.invitationID= new SimpleIntegerProperty(invitationID);
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
    }

    //setters
    public void setrsvpID(int rsvpID) {
        this.rsvpID = new SimpleIntegerProperty(rsvpID);
    }
    public void setdecision(String decision){
        this.decision= new SimpleStringProperty(decision);
    }
    public void setdietary_requirements(String dietary_requirements){
        this.dietary_requirements= new SimpleStringProperty(dietary_requirements);
    }
    public void setrsvp_date(LocalDate rsvp_date){
        this.rsvp_date= new SimpleObjectProperty(rsvp_date);
    }
   
    public void setinvitationID(int invitationID){
        this.invitationID= new SimpleIntegerProperty(invitationID);
    }
    
     public void setfname(String fname){
        this.fname= new SimpleStringProperty(fname);
    }
     
      public void setlname(String lname){
        this.lname= new SimpleStringProperty(lname);
    }
       
    //getters
   public int getrsvpID() {
      return this.rsvpID.get(); 
   }
   public String getdecision(){
       return this.decision.get();
   }
   public String getdietary_requirements(){
       return this.dietary_requirements.get();
   }
   public LocalDate getrsvp_date(){
       return this.rsvp_date.get();
   }
    public int getinvitationID(){
        return this.invitationID.get();
    }
    
    public String getfname(){
      return this.fname.get();
    }
       
    public String getlname(){
       return this.lname.get();
    }
    
    //property methods
    public IntegerProperty rsvpIDProperty() {
        return this.rsvpID;
    }
    
    public StringProperty decisionProperty() {
        return this.decision;
        }
    
    public StringProperty dietary_requirementsProperty() {
        return this.dietary_requirements;
    }
    
    public ObjectProperty<LocalDate> rsvp_dateProperty() {
        return rsvp_date;
    }
    
    public IntegerProperty invitationIDProperty() {
        return this.invitationID;
    }
    
    public StringProperty fnameProperty() {
        return this.fname;
    }
        
    public StringProperty lnameProperty() {
        return this.lname;
    }
}

