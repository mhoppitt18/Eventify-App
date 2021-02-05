package GroupAssignment;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;


/**
 * FXML Controller class
 */
public class GuestEditRSVPController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label labelEventName;

    @FXML
    private Pane pane;

    @FXML
    private TextField textEventDate;

    @FXML
    private TextField textEventTitle;

    @FXML
    private Label labelEventTitle;

    @FXML
    private Label labelEventDate;

    @FXML
    private TextField textEventTime;

    @FXML
    private Label labelEventTime;

    @FXML
    private TextField textEventLocation;

    @FXML
    private Label labelEventLocation;

    @FXML
    private Label labelMyRSVP;
    
    @FXML
    private ChoiceBox<String> choiceRSVP;

    @FXML
    private Label labelGuestDietaryNotes;

    @FXML
    private TextField textGuestDietaryNotes;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLogOut;

    @FXML
    private AnchorPane secondAnchor;

    @FXML
    private ImageView eventifyLogo1;

    @FXML
    private Button buttonMyRSVP;

    @FXML
    private ImageView imageRSVP;

    @FXML
    private Button buttonHome;

    @FXML
    private ImageView imageHome;

    @FXML
    private Button buttonAbousUs;

    @FXML
    private ImageView imageAboutUs;

    @FXML
    private Button buttonHelp;

    @FXML
    private ImageView imageHelp;

    @FXML
    private ImageView imageMyEvents;

    @FXML
    private Label labelMyEvents;
  
    @FXML
    private Label labelError;

    @FXML
    private Button buttonDownloadInvitation;

    @FXML
    private Button buttonSaveResponse;
    
    @FXML
    private Label labelTop;

    @FXML
    private ChoiceBox<String> menuSelectTitle;

    @FXML
    private Button buttonSelectEvent;
    
    Database database = new Database();

    @FXML
    void handleSelectEventButton(ActionEvent event) {
        textEventTitle.setText(menuSelectTitle.getValue());
        textEventTime.setText(String.valueOf(database.returnAdminEventView(menuSelectTitle.getValue()).getevent_time()));
        textEventLocation.setText(database.returnAdminEventView(menuSelectTitle.getValue()).getevent_location());
        textEventDate.setText(String.valueOf(database.returnAdminEventView(menuSelectTitle.getValue()).getevent_date())); 
    }

    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        GuestSession.cleanGuestSession();
        App.setRoot("18GuestLogin");
    }

    @FXML
    void handleSaveResponseButton(ActionEvent event)  {
        String RsvpDecision = choiceRSVP.getValue();
        int eventID = database.returnAdminEventView(menuSelectTitle.getValue()).geteventID();
        int adminID = database.returnGuestAdminInt(GuestSession.getGuestID());
        int invitationID =  database.returnInvitationID(GuestSession.getGuestID(), eventID, adminID);
        String notes = textGuestDietaryNotes.getText();
        //try {
            if(RsvpDecision.equals("No")) {
                notes = "Null";
            } else {
                notes = textGuestDietaryNotes.getText();
            }
        try{   
            database.updateGuestRSVP(invitationID, RsvpDecision, notes);  
            App.setRoot("23GuestMyRSVP");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    void switchToAboutUs(ActionEvent event) throws IOException {
        App.setRoot("25GuestAboutUs");
    }

    @FXML
    void switchToGuestHome(ActionEvent event) throws IOException {
        App.setRoot("19GuestHome");
    }

    @FXML
    void switchToGuestMyRSVP(ActionEvent event) throws IOException {
        App.setRoot("23GuestMyRSVP");
    }

    @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("24GuestHelp");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // set up choice box
        for(int i = 0; i<getGuestEventColumns().size(); i++) {
            menuSelectTitle.getItems().add(getGuestEventColumns().get(i).getevent_title());
        }
        //set up RSVP choice box
        choiceRSVP.getItems().add("Yes");
        choiceRSVP.getItems().add("No");
    }

     public ObservableList<GuestEventRSVP> getGuestEventColumns() {
        ObservableList<GuestEventRSVP> columns = FXCollections.observableArrayList();
        //add objects from event array into observablearraylist
        for(int i = 0; i <database.returnGuestEventTable(GuestSession.getGuestID()).size(); i++) {
            columns.add(database.returnGuestEventTable(GuestSession.getGuestID()).get(i));
        }

    return columns;
    }     
    

}

