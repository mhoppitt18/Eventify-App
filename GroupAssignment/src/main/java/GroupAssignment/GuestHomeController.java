package GroupAssignment;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class GuestHomeController implements Initializable{

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;
    
    @FXML
    private Pane paneTwo;
    
    @FXML
    private Pane paneThree;
        
    @FXML
    private Pane paneFour;
        
    @FXML
    private Pane paneFive;
        
    @FXML
    private ImageView imageMyGuests;

    @FXML
    private Button buttonMyRSVP;

    @FXML
    private ImageView imageHelp;

    @FXML
    private Button buttonHelp;

    @FXML
    private ImageView imageMyEvents;

    @FXML
    private Button buttonMyEvents;

    @FXML
    private ImageView imageAboutUs;

    @FXML
    private Button buttonAboutUs;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonLogOut;

    @FXML
    private AnchorPane secondAnchor;

    @FXML
    private ImageView eventifyLogo;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label clickLabel;

    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        GuestSession.cleanGuestSession();
        App.setRoot("18GuestLogin");
    }

    @FXML
    void switchToGuestAboutUs(ActionEvent event) throws IOException {
        App.setRoot("25GuestAboutUs");
    }

    @FXML
    void switchToGuestHelp(ActionEvent event) throws IOException {
        App.setRoot("24GuestHelp");
    }

    @FXML
    void switchToGuestMyEvents(ActionEvent event) throws IOException {
        App.setRoot("20GuestMyEvents");
    }

    @FXML
    void switchToGuestMyRSVP(ActionEvent event) throws IOException {
        App.setRoot("23GuestMyRSVP");
    }
    
    public void setGuestWelcomeText() {
        welcomeLabel.setText("Welcome back, " + GuestSession.getAccessCode() + "!");
    }
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        setGuestWelcomeText();
    }  

}

