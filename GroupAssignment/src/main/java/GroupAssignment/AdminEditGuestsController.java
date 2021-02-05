package GroupAssignment;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 */
public class AdminEditGuestsController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonLogOut;

    @FXML
    private AnchorPane secondAnchor;

    @FXML
    private ImageView eventifyLogo1;

    @FXML
    private Button buttonMyEvents;

    @FXML
    private Button buttonHome;

    @FXML
    private ImageView imageHome;

    @FXML
    private Button buttonAbousUs;

    @FXML
    private ImageView imageAboutUs;

    @FXML
    private Button buttonDeleteGuest;
    
    @FXML
    private Button buttonHelp;

    @FXML
    private ImageView imageHelp;

    @FXML
    private ImageView imageMyEvents;

    @FXML
    private Label labelMyGuests;

    @FXML
    private ImageView imageGuests;

    @FXML
    private TableView<Guest> tableAdminCurrentGuests;

    @FXML
    private TableColumn colGuestFirstName;
        //select guest.fname from guest join invitation i on ADMIN LOGGED IN, i.invitation_id
    @FXML
    private TableColumn colGuestLastName;
    
    @FXML
    private TableColumn colGuestCode;

    @FXML
    private TableColumn colGuestEmail;
       
    @FXML
    private TableColumn colAdminID; 
    
    @FXML
    private TableColumn colGuestID; 

    @FXML
    private ToolBar toolNavBar;

    @FXML
    private MenuButton menuGuests;

    @FXML
    private MenuItem menuViewCurrentGuests;

    @FXML
    private MenuItem menuAddGuests;
    
    Database database = new Database();

    @FXML
    void handleDeleteGuestButton (ActionEvent envent) throws IOException {
        Guest selected = tableAdminCurrentGuests.getSelectionModel().getSelectedItem();
        
        database.deleteGuest(selected.getguestID());
        
      tableAdminCurrentGuests.getItems().clear();
        colGuestFirstName.setCellValueFactory(new PropertyValueFactory<Guest, String>("fname"));
        colGuestLastName.setCellValueFactory(new PropertyValueFactory<Guest, String>("lname")); 
        colGuestCode.setCellValueFactory(new PropertyValueFactory<Guest, String>("access_code"));
        colGuestEmail.setCellValueFactory(new PropertyValueFactory<Guest, String>("email_address"));
        colAdminID.setCellValueFactory(new PropertyValueFactory<Guest, Integer>("adminID"));
        colGuestID.setCellValueFactory(new PropertyValueFactory<Guest, Integer>("guestID"));

        tableAdminCurrentGuests.setItems(getGuestColumns());
      
    }
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
    void switchToAdminAddGuests(ActionEvent event) throws IOException {
        App.setRoot("15AdminAddGuests");
    }

    @FXML
    void switchToAdminMyGuests(ActionEvent event) throws IOException {
        App.setRoot("13AdminMyGuests");
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
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("16AdminHelp");
    }
    
    public void changeFirstNameCellEvent(CellEditEvent edittedCell) {
        Guest selected = tableAdminCurrentGuests.getSelectionModel().getSelectedItem();
        selected.setfname(edittedCell.getNewValue().toString());
        //update DB
        database.updateAdminGuestTable(selected);
        
    }
    
        public void changeLastNameCellEvent(CellEditEvent edittedCell) {
        Guest selected = tableAdminCurrentGuests.getSelectionModel().getSelectedItem();
        selected.setlname(edittedCell.getNewValue().toString());
        
        database.updateAdminGuestTable(selected);
    }
        
        public void changeGuestEmailCellEvent(CellEditEvent edittedCell) {
        Guest selected = tableAdminCurrentGuests.getSelectionModel().getSelectedItem();
        selected.setemail_address(edittedCell.getNewValue().toString());
        
        database.updateAdminGuestTable(selected);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colGuestFirstName.setCellValueFactory(new PropertyValueFactory<Guest, String>("fname"));
        colGuestLastName.setCellValueFactory(new PropertyValueFactory<Guest, String>("lname")); 
        colGuestCode.setCellValueFactory(new PropertyValueFactory<Guest, String>("access_code"));
        colGuestEmail.setCellValueFactory(new PropertyValueFactory<Guest, String>("email_address"));
        colAdminID.setCellValueFactory(new PropertyValueFactory<Guest, Integer>("adminID"));
        colGuestID.setCellValueFactory(new PropertyValueFactory<Guest, Integer>("guestID"));

        tableAdminCurrentGuests.setItems(getGuestColumns());
        
        //update table to allow for columns to be editable
        tableAdminCurrentGuests.setEditable(true);
        colGuestFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        colGuestLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        colGuestEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        
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

