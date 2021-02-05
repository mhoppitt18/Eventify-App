package GroupAssignment;

//UPON LOADING THIS PAGE HAS TO FORM THE TABLE --> fetch event title where host_id = username

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class AdminMyEventsController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;

    @FXML
    private Button buttonCreateEvent;

    @FXML
    private ToolBar mainTool;

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
    private Button buttonViewEvent;

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
    private TableView<Event> tableAdminCurrentEvents;

    @FXML
    private TableColumn columnEventTitle;
    
    @FXML
    private TableColumn columnEventDate;

    @FXML
    private TableColumn  columnEventTime;

    @FXML
    private TableColumn columnEventLocation;

    
    @FXML
    private TableColumn columnEventAdminID;
       
    @FXML
    private TableColumn columnEventID;
    
    @FXML
    private Label labelTable;
    

    Database database = new Database();
    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        AdminSession.cleanAdminSession();
        App.setRoot("2AdminLogin");
    }

    @FXML
    void switchToAboutUs(ActionEvent event) throws IOException {
        App.setRoot("17AdminAboutUs");
    }

    @FXML
    void switchToAdminCreateEvent(ActionEvent event) throws IOException {
        App.setRoot("5AdminCreateEvent");
    }

    @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("16AdminHelp");
    }

    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        App.setRoot("3AdminHome");
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
    void switchToAdminViewEventDetails(ActionEvent event) throws IOException {
            App.setRoot("9AdminViewEventDetails");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnEventID.setCellValueFactory(new PropertyValueFactory<Event, Integer>("eventID"));
        columnEventTitle.setCellValueFactory(new PropertyValueFactory<Event, String>("event_title"));
        columnEventLocation.setCellValueFactory(new PropertyValueFactory<Event, String>("event_location"));
        columnEventDate.setCellValueFactory(new PropertyValueFactory<Event, Object>("event_date"));
        columnEventTime.setCellValueFactory(new PropertyValueFactory<Event, Integer>("event_time"));
        columnEventAdminID.setCellValueFactory(new PropertyValueFactory<Event, Integer>("adminID"));

        tableAdminCurrentEvents.setItems(getEventColumns());


        
    } 
    
    public ObservableList<Event> getEventColumns() {
        ObservableList<Event> columns = FXCollections.observableArrayList();
        //int adminID = AdminSession.getAdminID();
        //System.out.println(adminID);
        
        
        //add objects from event array into observablearraylist
        for(int i = 0; i < database.returnAdminEventTable(AdminSession.getAdminID()).size(); i++) {
            columns.add(database.returnAdminEventTable(AdminSession.getAdminID()).get(i));
        }
        
    return columns;
    }
}
