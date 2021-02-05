package GroupAssignment;
import java.awt.Color;
import java.io.File;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.io.IOException;
import javafx.application.Application;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Invitation extends Database {
    private IntegerProperty invitationID;
    private IntegerProperty eventID;
    private IntegerProperty guestID;
    private IntegerProperty adminID; 
 

    public Invitation(int eventID, int guestID, int adminID, int invitationID) {
        this.invitationID= new SimpleIntegerProperty(invitationID);
        this.eventID = new SimpleIntegerProperty(eventID);
        this.guestID= new SimpleIntegerProperty(guestID);
        this.adminID= new SimpleIntegerProperty(adminID);
        
    }

    //setters
    public void setinvitationID(IntegerProperty invitationID){
        this.invitationID= invitationID;
    }
       
    public void seteventID(IntegerProperty eventID) {
        this.eventID = eventID ;
    }
    public void setguestID(IntegerProperty guestID){
        this.guestID= guestID;
    }
    public void setadminID(IntegerProperty adminID){
        this.adminID= adminID;
    }
    
    
    //getters
    public IntegerProperty getinvitationID(){
        return invitationID;
    }
   public IntegerProperty geteventID() {
      return eventID; 
   }
   public IntegerProperty getguestID(){
       return guestID;
   }
    public IntegerProperty getadminID(){
        return adminID;
    }
    
    
}