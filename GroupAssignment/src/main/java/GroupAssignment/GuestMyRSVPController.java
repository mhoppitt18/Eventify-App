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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 */
public class GuestMyRSVPController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonLogOut;

    @FXML
    private TableView<GuestEventRSVP> tableGuestPendingRSVP;

    @FXML
    private TableColumn colEventTitle;

    @FXML
    private TableColumn colEventHost;

    @FXML
    private TableColumn colEventDate;

    @FXML
    private TableColumn colRSVP;

    @FXML
    private TableColumn colDietaryNotes;

    @FXML
    private Label labelInstructions;

    @FXML
    private AnchorPane secondAnchor;

    @FXML
    private ImageView eventifyLogo1;

    @FXML
    private Button buttonMyEvents;

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
    private Label labelMyRSVP;
    
    @FXML
    private Button buttonEditRSVP;
    
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
    void switchToGuestHome(ActionEvent event) throws IOException {
        App.setRoot("19GuestHome");
    }

    @FXML
    void switchToGuestMyEvents(ActionEvent event) throws IOException {
        App.setRoot("20GuestMyEvents");
    }

    @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("24GuestHelp");
    }
    
        @FXML
    void switchToGuestEditRSVP(ActionEvent event) throws IOException {
         App.setRoot("22GuestEditRSVP");
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {

        colEventTitle.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, String>("event_title"));
        colEventHost.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, String>("username"));
        colEventDate.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, Object>("event_date"));
        colRSVP.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, String>("decision"));
        colDietaryNotes.setCellValueFactory(new PropertyValueFactory<GuestEventRSVP, String>("dietary_notes"));

        tableGuestPendingRSVP.setItems(getGuestEventColumns());
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

