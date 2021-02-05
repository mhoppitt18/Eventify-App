package GroupAssignment;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class GuestLoginController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;
    
      @FXML
    private Pane thirdPane;

    @FXML
    private TextField textGuestID;

    @FXML
    private Label labelGuestID;

    @FXML
    private Button buttonLogin;

    @FXML
    private ImageView eventifyLogo;

    @FXML
    private Label labelSlogan;

    @FXML
    private Hyperlink linkHelp;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonBack;
    
    @FXML
    private Label loginStatus;
    
    Database database = new Database();

    @FXML
    void handleGuestLoginButton(ActionEvent event) throws IOException {
        String access_code = textGuestID.getText();
        if (database.guestTryLogin(access_code)) {
            App.setRoot("19GuestHome");

            System.out.print(GuestSession.getGuestID());

            //System.out.println(GuestSession.getGuestID());
            //System.out.println(GuestSession.getAccessCode());

        } else {
            loginStatus.setText("Invalid guest ID");
        }
    }

    @FXML
    void proceedToWelcomePage(ActionEvent event) throws IOException {
        App.setRoot("1WelcomePage");
    }

    @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("24GuestHelp");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

}
