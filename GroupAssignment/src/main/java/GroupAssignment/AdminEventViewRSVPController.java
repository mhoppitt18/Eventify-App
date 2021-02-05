package GroupAssignment;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminEventViewRSVPController implements Initializable  {


    @FXML
    private ScrollPane mainScroll;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;

    @FXML
    private PieChart pieCurrentRSVP;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonLogOut;

    @FXML
    private TableView<RSVP> tableAdminCurrentRSVP;

    @FXML
    private TableColumn columnGuestFirstName;

    @FXML
    private TableColumn columnGuestLastName;

    @FXML
    private TableColumn columnGuestDecision;

    @FXML
    private TableColumn columnDietaryNotes;

    @FXML
    private TableColumn columnRSVPDate;

    @FXML
    private TableColumn columnRSVPID;

    @FXML
    private TableColumn columnInvitationID;

    @FXML
    private ToolBar toolNavBar;

    @FXML
    private MenuButton menuEventDetails;

    @FXML
    private MenuItem menuViewEventDetails;

    @FXML
    private MenuItem menuEditGuests;

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
    private ChoiceBox<String> menuSelectEventTitle;

    @FXML
    private Button buttonSelectEvent;
    
    @FXML
    private Label labelTable;
    
    @FXML
    private Label labelPieLabel;
    
    @FXML 
    private Label labelinstruction;
    
    
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
    void switchToAdminAddEventGuests(ActionEvent event) throws IOException {
        App.setRoot("6AdminAddEventGuests");
    }

    @FXML
    void switchToAdminEditEventDetails(ActionEvent event) throws IOException {
        App.setRoot("10AdminEditEventDetails");
    }

    @FXML
    void switchToAdminEventViewDetails(ActionEvent event) throws IOException {
        App.setRoot("9AdminViewEventDetails");
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
    
    @FXML
    void handleSelectEventButton(ActionEvent event) {
        //set up table
        columnGuestFirstName.setCellValueFactory(new PropertyValueFactory<RSVP, String>("fname"));
        columnGuestLastName.setCellValueFactory(new PropertyValueFactory<RSVP, String>("lname"));
        columnGuestDecision.setCellValueFactory(new PropertyValueFactory<RSVP, String>("decision"));
        columnDietaryNotes.setCellValueFactory(new PropertyValueFactory<RSVP, String>("dietary_requirements"));
        columnRSVPDate.setCellValueFactory(new PropertyValueFactory<RSVP, LocalDate>("rsvp_date"));
        columnRSVPID.setCellValueFactory(new PropertyValueFactory<RSVP, Integer>("rsvpID"));
        columnInvitationID.setCellValueFactory(new PropertyValueFactory<RSVP, Integer>("invitationID"));

        tableAdminCurrentRSVP.setItems(getRSVPColumns(database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID()));
        
        //set up pie chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Yes", getPieDataYes()),
            new PieChart.Data("No", getPieDataNo()),
            new PieChart.Data("Pending", getPieDataPending()));
        
        pieCurrentRSVP.setData(pieChartData);

        //set up labels
        labelPieLabel.setText("RSVP Chart for " + menuSelectEventTitle.getValue());
        labelTable.setText("RSVP Details for " + menuSelectEventTitle.getValue());
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
       // ObservableList<String> titles = FXCollections.observableArrayList();
       //     for(int i =0; i < columns.size(); i++) {
       //     titles.add(columns.get(i).getevent_title());
       // }
    return columns;
    }
    
    public ObservableList<RSVP> getRSVPColumns(int eventID) {
        ObservableList<RSVP> rsvp = FXCollections.observableArrayList();
        //add objects from event array into observablearraylist
        for(int i = 0; i < database.returnAdminEventRSVP(eventID).size(); i++) {
            rsvp.add(database.returnAdminEventRSVP(eventID).get(i));
        }
        
    return rsvp;
    }
    
    public int getPieDataYes() {
        int yesCount = 0;
        for(int i =0; i < getRSVPColumns(database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID()).size(); i++) {
            if((getRSVPColumns(database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID()).get(i).getdecision()).equals("Yes")) {
                yesCount++;
            }
        }
        return yesCount;
    }

    public int getPieDataNo() {
        int noCount = 0;
        for(int i =0; i < getRSVPColumns(database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID()).size(); i++) {
            if((getRSVPColumns(database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID()).get(i).getdecision()).equals("No")) {
                noCount++;
            }
        }
        return noCount;
    }
    
    public int getPieDataPending() {
        int pendingCount = 0;
        for(int i =0; i < getRSVPColumns(database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID()).size(); i++) {
            if((getRSVPColumns(database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID()).get(i).getdecision()).equals("Pending")) {
                pendingCount++;
            }
        }
        return pendingCount;
    }
    
    
    

}


