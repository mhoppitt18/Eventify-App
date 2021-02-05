package GroupAssignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;

public class AdminAddEventGuestsController implements Initializable{

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;

    @FXML
    private ListView<String> listCurrentEventGuests;

    @FXML
    private Label labelTop1;

    @FXML
    private ListView<String> listAdminCurrentGuests;

    @FXML
    private Label labelTop11;

    @FXML
    private Label labelTop12;
    
    @FXML
    private Label labelError;

    @FXML
    private Label labelTop121;

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
    private Button buttonMyGuests;

    @FXML
    private ImageView imageGuests;

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
    private ToolBar toolNavBar;

    @FXML
    private MenuButton menuEventDetails;

    @FXML
    private MenuItem menuViewEventDetails;

    @FXML
    private MenuItem menuEditGuests;

    @FXML
    private MenuItem menuViewRSVP;

    @FXML
    private Label labelTop;

    @FXML
    private ChoiceBox<String> menuSelectEventTitle;

    @FXML
    private Button buttonSelectEventGuests;

    @FXML
    private Button buttonRemoveGuests;

    @FXML
    private Button buttonAddGuests;
    
    Database database = new Database();
    
    ArrayList<Integer> currentGuests = new ArrayList<>();
    
    ArrayList<Integer> eventGuests = new ArrayList<>();

    @FXML
    void handleAddGuestsButton(ActionEvent event){
         labelError.setText("");
        ObservableList<Integer> selectedGuests = listAdminCurrentGuests.getSelectionModel().getSelectedIndices();
        int eventID = database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID();
        try {
            for(int i = 0; i< selectedGuests.size(); i++) {
                int guestID = currentGuests.get(selectedGuests.get(i));
                    if(database.returnInvitationID(guestID, eventID, AdminSession.getAdminID()) == 0) {

                    database.insertIntoInvitation(guestID, eventID, AdminSession.getAdminID());
                
                    int invitationID = database.returnInvitationID(guestID, eventID, AdminSession.getAdminID());
                
                    database.insertIntoRSVP(invitationID);
                    } else {
                        labelError.setText("Error: Selected Guest/s have already been invited");
                    }
   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    //reload event guest list
        listCurrentEventGuests.getItems().clear();
        eventGuests.clear();
        listCurrentEventGuests.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            for(int i = 0; i< database.returnEventGuests(eventID).size(); i++) {
                listCurrentEventGuests.getItems().add(database.returnEventGuests(eventID).get(i).toString());
                eventGuests.add(database.returnEventGuests(eventID).get(i).getguestID());
        }
    }


    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        AdminSession.cleanAdminSession();
        App.setRoot("2AdminLogin");
    }

    @FXML
    void handleRemoveGuestsButton(ActionEvent event) {
        labelError.setText("");
        //delete guests from event, RSVP and INVITATION
        int eventID = database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID();
        ObservableList<Integer> selectedGuests = listCurrentEventGuests.getSelectionModel().getSelectedIndices();
            for(int i = 0; i<selectedGuests.size(); i++) {
                int guestID = eventGuests.get(selectedGuests.get(i));
                System.out.println("Guest ID: " + guestID);
                int inviteID = database.returnInvitationID(guestID, eventID, AdminSession.getAdminID());
                System.out.println("Invite ID: " + inviteID);
                
                database.deleteRSVP(inviteID);
                //database delete invitation
                database.deleteInvitation(inviteID);
                //database delete from RSVP
            }
        //reload guest list and array list
        listCurrentEventGuests.getItems().clear();
        eventGuests.clear();
        listCurrentEventGuests.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
            for(int i = 0; i< database.returnEventGuests(eventID).size(); i++) {
                listCurrentEventGuests.getItems().add(database.returnEventGuests(eventID).get(i).toString());
                eventGuests.add(database.returnEventGuests(eventID).get(i).getguestID());
        }
        
    }

    @FXML
    void handleSelectEventGuestsButton(ActionEvent event) {
       //set up event guest list
       labelError.setText("");
       listCurrentEventGuests.getItems().clear();
       int eventID = database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID();
        //set up event guests list
        listCurrentEventGuests.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for(int i = 0; i< database.returnEventGuests(eventID).size(); i++) {
           listCurrentEventGuests.getItems().add(database.returnEventGuests(eventID).get(i).toString());
           eventGuests.add(database.returnEventGuests(eventID).get(i).getguestID());
        }
 
    }
       

    @FXML
    void switchToAboutUs(ActionEvent event) throws IOException {
        App.setRoot("17AdminAboutUs");
    }

    @FXML
    void switchToAdminAddEventGuests(ActionEvent event) throws IOException {
        App.setRoot("6AdminAddEventGuests");
    }

    @FXML
    void switchToAdminCreateEvent(ActionEvent event) throws IOException {
        App.setRoot("5AdminCreateEvent");
    }

    @FXML
    void switchToAdminEditEventDetails(ActionEvent event) throws IOException {
        App.setRoot("10AdminEditEventDetails");
    }

    @FXML
    void switchToAdminEventViewRSVP(ActionEvent event) throws IOException {
        App.setRoot("12AdminEventViewRSVP");
    }

    @FXML
    void switchToAdminHome(ActionEvent event) throws IOException {
        App.setRoot("3AdminHome");
    }

    @FXML
    void switchToAdminMyGuests(ActionEvent event) throws IOException {
        App.setRoot("13AdminMyGuests");
    }

    @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("16AdminHelp");
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
         labelError.setText("");
        //set up choice menu
        for(int i = 0; i<getEventColumns().size(); i++) {
            menuSelectEventTitle.getItems().add(getEventColumns().get(i).getevent_title());
        }
        //set up current guest list
        listAdminCurrentGuests.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for(int i = 0; i< database.returnAdminGuestTable(AdminSession.getAdminID()).size(); i++) {
           listAdminCurrentGuests.getItems().add(database.returnAdminGuestTable(AdminSession.getAdminID()).get(i).toString());
           currentGuests.add(database.returnAdminGuestTable(AdminSession.getAdminID()).get(i).getguestID());
        }       
    }
    

    public ObservableList<Event> getEventColumns() {
        ObservableList<Event> columns = FXCollections.observableArrayList();
        //add objects from event array into observablearraylist
        for(int i = 0; i < database.returnAdminEventTable(AdminSession.getAdminID()).size(); i++) {
            columns.add(database.returnAdminEventTable(AdminSession.getAdminID()).get(i));
        }
    return columns;
    }
    
        public ObservableList<Guest> getGuestColumns() {
        ObservableList<Guest> columns = FXCollections.observableArrayList();
        //add objects from event array into observablearraylist
            for(int i = 0; i < database.returnAdminGuestTable(AdminSession.getAdminID()).size(); i++) {
                columns.add(database.returnAdminGuestTable(AdminSession.getAdminID()).get(i));
            }
       return columns;
    }


}

    


