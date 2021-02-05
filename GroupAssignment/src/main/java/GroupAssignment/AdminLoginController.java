package GroupAssignment;

import static GroupAssignment.Database.openConnection;
import static GroupAssignment.Database.sharedConnection;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;

public class AdminLoginController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;
    
     @FXML
    private Pane thirdPane;

    @FXML
    private TextField textUsername;

    @FXML
    private Label labelUsername;

    @FXML
    private Label labelPassword;

    @FXML
    private PasswordField textPassword;

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
    
    //@FXML
    //private int adminIntID;
    
    Database database = new Database();

    @FXML
    void handleAdminLoginButton(ActionEvent event) throws IOException, SQLException {
        //int adminID = adminID;
        String username = textUsername.getText();
        String password = textPassword.getText();
        //int adminID = AdminSession.getAdminID();
       // System.out.println(adminID);
        
                
        
        //int adminID = adminID.get();
        //int adminID = AdminSession.getAdminID();
        //System.out.println("AdminID: " + adminID);

        
        

        if (database.adminTryLogin(username, password)) {
           //w AdminSession.getInstance(username, password);
        //I've put in 100001 just so the app runs and I can see the tables :)
            App.setRoot("3AdminHome");
        } else {
            loginStatus.setText("Invalid username/password");
        }
    }

    @FXML
    void proceedToWelcomePage(ActionEvent event) throws IOException {
        App.setRoot("1WelcomePage");
    }

    @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("16AdminHelp");
    }
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 


}
