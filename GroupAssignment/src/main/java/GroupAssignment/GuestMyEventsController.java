package GroupAssignment;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 */
public class GuestMyEventsController implements Initializable {


    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonLogOut;

    @FXML
    private TableView<GuestEventRSVP> tableGuestCurrentEvents;

    @FXML
    private TableColumn colEventTitle;

    @FXML
    private TableColumn colEventDate;

    @FXML
    private TableColumn colAdminFirstName;

    @FXML
    private TableColumn colEventLocation;

    @FXML
    private TableColumn colGuestRSVP;
    
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
    private Button buttonShowEventDetails;
    
    Database database = new Database();

    
    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        GuestSession.cleanGuestSession();
        App.setRoot("18GuestLogin");
    }

    @FXML
    void switchToAboutUs(ActionEvent event) throws IOException {
        App.setRoot("25GuestAboutUs");
    }

    @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("24GuestHelp");
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
    void switchToGuestMyEventsDetails(ActionEvent event) throws IOException {
        App.setRoot("21GuestMyEventsDetails");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colEventTitle.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, String>("event_title"));
        colEventDate.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, Object>("event_date"));
        colAdminFirstName.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, String>("username"));
        colEventLocation.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, String>("event_location"));
        colGuestRSVP.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, String>("decision"));

        tableGuestCurrentEvents.setItems(getEventColumns());

    }
    
    public ObservableList<GuestEventRSVP> getEventColumns() {
        ObservableList<GuestEventRSVP> columns = FXCollections.observableArrayList();
        
        for(int i = 0; i < database.returnGuestEventTable(GuestSession.getGuestID()).size(); i++) {
            columns.add(database.returnGuestEventTable(GuestSession.getGuestID()).get(i));
        }
        
    return columns;
    }

   

}


