package GroupAssignment;

import static GroupAssignment.Database.sharedConnection;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;

public class AdminHomeController implements Initializable {

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
    private Button buttonMyGuests;

    @FXML
    private ImageView imageHelp;

    @FXML
    private Button buttonHelp;
    
    @FXML
    private ToolBar mainTool;

    @FXML
    private ImageView imageMyEvents;

    @FXML
    private Button buttonMyEvents;

    @FXML
    private ImageView imageAboutUs;

    @FXML
    private Button buttonAboutUs;

    @FXML
    private Button buttonLogOut;

    @FXML
    private AnchorPane secondAnchor;

    @FXML
    private ImageView eventifyLogo;

    @FXML
    public Label welcomeLabel;

    @FXML
    private Label clickLabel;

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
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("16AdminHelp");
    }

    @FXML
    void switchToAdminMyEvents(ActionEvent event) throws IOException {
        App.setRoot("4AdminMyEvents");
    }

    @FXML
    void switchToAdminMyGuests(ActionEvent event) throws IOException {
        App.setRoot("13AdminMyGuests");
    }
    
    /*public void setAdminUsername() {
        
    }
    
    public int setAdminUsername(String username, String password) throws SQLException {
        Database.openConnection();
        PreparedStatement admin = sharedConnection.prepareStatement("SELECT adminID FROM ADMIN WHERE username = ? AND password = ?;");
        admin.setString(1, username);
        admin.setString(2, password);
        ResultSet adminrs = admin.executeQuery();
        long adminID = adminrs.getLong(6);
        int adminInt = (int)adminID;
        Admin current = new Admin(adminInt, username, password);
        //current.setusername(adminrs.getString("username"));
        return adminInt;
    }*/
    
    Database database = new Database();
    
    /*public void setWelcomeText() throws SQLException {
        Database.openConnection();
        PreparedStatement ps = sharedConnection.prepareStatement("SELECT adminID FROM ADMIN WHERE adminID = ?;");
        ps.setString(1, adminID);
        ResultSet adminrs = ps.executeQuery();
        long adminLongID = adminrs.getLong(6);
        int adminInt = (int)adminLongID;
        if (database.adminWelcomeText(adminID)) {
            welcomeLabel.setText("Welcome back" + adminInt);
        } else {
            welcomeLabel.setText("FAILED");
        }
        welcomeLabel.setText("Welcome back");
    }*/
    
    public void setWelcomeText() {
        welcomeLabel.setText("Welcome back, " + AdminSession.getUsername() + "!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setWelcomeText();
    } 

}
