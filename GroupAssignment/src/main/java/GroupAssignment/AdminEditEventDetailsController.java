package GroupAssignment;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class AdminEditEventDetailsController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;
    
    @FXML
    private Label labelError;
    
    @FXML
    private Label labelRunsheetError;

    @FXML
    private DatePicker calendarEventDate;

    @FXML
    private ChoiceBox<String> menuSelectEventTitle;

    @FXML
    private Label labelEventTitle;

    @FXML
    private Label labelEventDate;

    @FXML
    private TextField textEventTime;
    
    @FXML
    private TextField textEventTitle;

    @FXML
    private Label labelEventTime;
    
    @FXML
    private Label labelEditEventTitle;

    @FXML
    private TextField textEventLocation;

    @FXML
    private Label labelEventLocation;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLogOut;

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
    private TableView<Runsheet> tableAdminEventRunsheet;

    @FXML
    private TableColumn colTitle;

    @FXML
    private TableColumn colTime;

    @FXML
    private Label labelEventName1;

    @FXML
    private Button buttonNext;
    
    @FXML
    private Button buttonSelectEvent;
    
    @FXML
    private DatePicker calanderEventDate;
    
    @FXML 
    private Label labelinstruction;
    
    @FXML 
    private Label labelSuccess;
    
    @FXML
    private Button buttonDeleteEvent;
    
    @FXML
    private Button buttonAddToRunsheet;
    
    @FXML
    private Button buttonDeleteFromRunsheet;
    
    @FXML
    private Label labelAddActivity;
    
    @FXML
    private Label labelAddTime;
    
    @FXML
    private TextField textAddActivity;
    
    @FXML
    private TextField textAddTime;
    
    Database database = new Database();
    
    @FXML
    void handleDeleteFromRunsheetButton (ActionEvent envent) throws IOException {
        Runsheet selected = tableAdminEventRunsheet.getSelectionModel().getSelectedItem();
        
        database.deleteRunsheet(selected.getrunsheetID());
        
      tableAdminEventRunsheet.getItems().clear();
      colTitle.setCellValueFactory(new PropertyValueFactory<Runsheet, String>("activity"));
      colTime.setCellValueFactory(new PropertyValueFactory<Runsheet, Integer>("activity_time")); 
      tableAdminEventRunsheet.setItems(getRunsheetColumns());
      
    }
    
    @FXML
    void handleAddToRunsheetButton (ActionEvent envent) throws IOException {
        try {
        Runsheet runsheet = new Runsheet();
        runsheet.setactivity(textAddActivity.getText());
        runsheet.setactivity_time(Integer.valueOf(textAddTime.getText()));
        runsheet.seteventID(database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID());
        
        database.insertIntoRunsheet(runsheet);
        } catch (SQLException e) {
        labelRunsheetError.setText("Please enter valid runsheet details");
        }
      tableAdminEventRunsheet.getItems().clear();
      colTitle.setCellValueFactory(new PropertyValueFactory<Runsheet, String>("activity"));
      colTime.setCellValueFactory(new PropertyValueFactory<Runsheet, Integer>("activity_time")); 
      tableAdminEventRunsheet.setItems(getRunsheetColumns());
      
    }

    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        AdminSession.cleanAdminSession();
        App.setRoot("2AdminLogin");
    }
    
    @FXML
    void handleDeleteEventButton(ActionEvent event) throws IOException {
        int eventID = database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID();
        database.deleteEventView(eventID);
        App.setRoot("4AdminMyEvents");
    }

    @FXML
    void handleSaveEventDetailsButton(ActionEvent event) throws IOException {
            Event update = new Event();
            update.seteventID(database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID());
            update.setevent_location(textEventLocation.getText());
            update.setevent_date(calanderEventDate.getValue());
            update.setevent_time(Integer.valueOf(textEventTime.getText()));
            update.setadminID(database.returnAdminEventView(menuSelectEventTitle.getValue()).getadminID());
            update.setevent_title(textEventTitle.getText());
            database.updateEventView(update); 

    }
    
    
    @FXML
    void handleSelectEventButton(ActionEvent event) throws IOException {
        //set text fields
        labelSuccess.setText("");
        textEventTime.setText(String.valueOf(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_time()));
        textEventLocation.setText(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_location());
        textEventTitle.setText(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_title());
        calanderEventDate.setValue(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_date());
        
        //set runsheet table
        colTitle.setCellValueFactory(new PropertyValueFactory<Runsheet, String>("activity"));
        colTime.setCellValueFactory(new PropertyValueFactory<Runsheet, Integer>("activity_time")); 
        tableAdminEventRunsheet.setItems(getRunsheetColumns());

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
    void switchToAdminEventViewRSVP(ActionEvent event) throws IOException {
        App.setRoot("12AdminEventViewRSVP");
    }

    @FXML
    void switchToAdminHome(ActionEvent event) throws IOException {
        App.setRoot("3AdminHome");
    }

    @FXML
    void switchToAdminMyEvents(ActionEvent event) throws IOException {
        App.setRoot("4AdminMyEvents");
    }

    @FXML
    void switchToAdminMyGuests(ActionEvent event) throws IOException {
        App.setRoot("13AdminMyGuests");
    }

   @FXML
    void switchToAdminViewEventDetails(ActionEvent event) throws IOException {
        App.setRoot("9AdminViewEventDetails");
    }

     @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("16AdminHelp");
    }
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        //menuSelectEventTitle.setItems(getEventColumns());
        for(int i = 0; i<getEventColumns().size(); i++) {
            menuSelectEventTitle.getItems().add(getEventColumns().get(i).getevent_title());
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

    public ObservableList<Runsheet> getRunsheetColumns() throws IOException {
        int eventID = database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID();
        ObservableList<Runsheet> columns = FXCollections.observableArrayList();
        //add objects from event array into observablearraylist
            for(int i = 0; i < database.returnEventRunsheetTable(eventID).size(); i++) {
                columns.add(database.returnEventRunsheetTable(eventID).get(i));
            }
       return columns;
    } 


}

