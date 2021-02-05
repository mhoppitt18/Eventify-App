package GroupAssignment;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;

public class WelcomePageController implements Initializable  {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane secondPane;

    @FXML
    private Pane thirdPane;

    @FXML
    private Button adminLoginButton;

    @FXML
    private Button guestLoginButton;

    @FXML
    private ImageView eventifyLogo1;

    @FXML
    private Label labelSlogan;

    @FXML
    private ToolBar mainTool;

    @FXML
    void switchToAdminLogin(ActionEvent event) throws IOException {
        App.setRoot("2AdminLogin");
    }

    @FXML
    void switchToGuestLogin(ActionEvent event) throws IOException {
        App.setRoot("18GuestLogin");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   

}


