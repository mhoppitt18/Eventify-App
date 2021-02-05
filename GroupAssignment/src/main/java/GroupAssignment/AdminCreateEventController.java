package GroupAssignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class AdminCreateEventController implements Initializable {

    @FXML
    private ScrollPane maniScroll;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonLogOut;

    @FXML
    private Pane pane;

    @FXML
    private DatePicker calendarEventDate;

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
    private AnchorPane secondAnchor;

    @FXML
    private ImageView eventifyLogo1;

    @FXML
    private ImageView imageMyEvents;

    @FXML
    private Label labelMyEvents;

    @FXML
    private Label labelCreateEvent;

    @FXML
    private Label labelOne;

    @FXML
    private ListView<String> listCurrentGuest;

    @FXML
    private Label labelOne1;

    @FXML
    private TableView<Runsheet> tableAddRunsheet;

    @FXML
    private TableColumn columnActivity;

    @FXML
    private TableColumn columnTime;

    @FXML
    private Label labelOne11;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonDeleteActivity;
    
    @FXML
    private Label labelError;
    
    @FXML
    private TextField textRunsheetActivity;
        
    @FXML
    private TextField textRunsheetTime;
    
    Database database = new Database();
    
    ArrayList<Integer> guestArrayList = new ArrayList<>();
    
    @FXML
    private Button buttonSaveActivity;
    
    ArrayList<Runsheet> runsheetArray = new ArrayList<>();

    @FXML
    void handleCreateEventButton(ActionEvent event) throws IOException {
        //insert event into DB
        try {
            Event createEvent = new Event();
            createEvent.setevent_title(textEventTitle.getText());
            createEvent.setevent_date(calendarEventDate.getValue());
            createEvent.setevent_time(Integer.valueOf(textEventTime.getText()));
            createEvent.setevent_location(textEventLocation.getText());
            createEvent.setadminID(AdminSession.getAdminID());
            System.out.println("New Event Title: " + createEvent.getevent_title());
            System.out.println("New Event Time: " + createEvent.getevent_time());
            System.out.println("New Event Location: " + createEvent.getevent_location());
            System.out.println("New Event AdminID: " + createEvent.getadminID());
            
            database.insertIntoEvent(createEvent);
            //System.out.print(database.returnAdminEventView(textEventTitle.getText()).geteventID());
        } catch(NumberFormatException | SQLException e) {
            labelError.setText("Please enter valid Event Detail information");
       //insert runsheet into DB 
        } try { 
            for(int i = 0; i < runsheetArray.size(); i++) {
                runsheetArray.get(i).seteventID(database.returnAdminEventView(textEventTitle.getText()).geteventID()); 
                database.insertIntoRunsheet(runsheetArray.get(i));
            }
        } catch(SQLException e) {
            labelError.setText("Please enter valid Runsheet Detail information");
        //create guest invitation and RSVP
        } try {
            //create invitation and RSVP objects
            ObservableList<Integer> selectedGuests = listCurrentGuest.getSelectionModel().getSelectedIndices();
            int eventID = database.returnAdminEventView(textEventTitle.getText()).geteventID();
            System.out.println("New Event Title: " + eventID);
            for(int i = 0; i<selectedGuests.size(); i++) {
                int guestID = guestArrayList.get(selectedGuests.get(i));
                System.out.print("This Guest ID is: " + guestArrayList.get(selectedGuests.get(i)));
                database.insertIntoInvitation(guestID, 
                eventID , AdminSession.getAdminID());
                int invitationID = database.returnInvitationID(guestID, 
                eventID, AdminSession.getAdminID());
                System.out.println("This invite ID is: " + invitationID);
                //create RSVP object
                database.insertIntoRSVP(invitationID);
                System.out.println("This RSVP ID is: " + database.returnGuestRSVP(guestID,eventID).getrsvpID());
            }
        } catch (SQLException e) {
                labelError.setText("Please Select Guests");    
        }
        App.setRoot("4AdminMyEvents");
    }
    @FXML
    void handleSaveActivityButton(ActionEvent event) throws IOException {
            for(int i = 0; i == 0; i++) {
                Runsheet current = new Runsheet();
                current.setactivity(textRunsheetActivity.getText());
                current.setactivity_time(Integer.valueOf(textRunsheetTime.getText()));
                
                runsheetArray.add(current);
            }
        columnActivity.setCellValueFactory(new PropertyValueFactory<Runsheet, String>("activity"));
        columnTime.setCellValueFactory(new PropertyValueFactory<Runsheet, Integer>("activity_time")); 
        
        tableAddRunsheet.setItems(getRunsheetColumns());
        textRunsheetActivity.setText("");
        textRunsheetTime.setText("");
    }

    @FXML
    void handleDeleteActivityButton (ActionEvent event) throws IOException {
        int selected = tableAddRunsheet.getSelectionModel().getSelectedIndex();
        runsheetArray.remove(selected);
        
        tableAddRunsheet.getItems().clear();
        columnActivity.setCellValueFactory(new PropertyValueFactory<Runsheet, String>("activity"));
        columnTime.setCellValueFactory(new PropertyValueFactory<Runsheet, Integer>("activity_time")); 
        
        tableAddRunsheet.setItems(getRunsheetColumns());
    }
    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        AdminSession.cleanAdminSession();
        App.setRoot("2AdminLogin");
    }

    @FXML
    void handleCancelButton(ActionEvent event) throws IOException {
        runsheetArray.clear();
        App.setRoot("4AdminMyEvents");
    }
    
    @FXML
    void switchToAdminMyEvents(ActionEvent event) throws IOException {
        App.setRoot("4AdminMyEvents");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listCurrentGuest.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for(int i = 0; i< database.returnAdminGuestTable(AdminSession.getAdminID()).size(); i++) {
            listCurrentGuest.getItems().add(database.returnAdminGuestTable(AdminSession.getAdminID()).get(i).toString());
            guestArrayList.add(database.returnAdminGuestTable(AdminSession.getAdminID()).get(i).getguestID());

        }
        
    }
    
    public ObservableList<Runsheet> getRunsheetColumns() throws IOException {
        ObservableList<Runsheet> columns = FXCollections.observableArrayList();
        //add objects from event array into observablearraylist
            for(int i = 0; i < runsheetArray.size(); i++) {
                columns.add(runsheetArray.get(i));
            }
       return columns;
    }    

}


