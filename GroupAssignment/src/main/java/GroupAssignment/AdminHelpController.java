package GroupAssignment;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class AdminHelpController implements Initializable {

    @FXML
    private ScrollPane mainScroll;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;
    
    @FXML
    private Label labelFAQ;

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
    private ImageView imageHome;

    @FXML
    private Button buttonAbousUs;

    @FXML
    private ImageView imageAboutUs;

    @FXML
    private Button buttonMyEvents;

    @FXML
    private ImageView imageHelp;

    @FXML
    private ImageView imageMyEvents;

    @FXML
    private Label labelMyEvents;

    @FXML
    private Label labelTitle;

    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        AdminSession.cleanAdminSession();
        App.setRoot("2AdminLogin");
    }

    @FXML
    void switchToAdminAboutUs(ActionEvent event) throws IOException {
        App.setRoot("17AdminAboutUs");
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
    void switchToAdminMyEvents(ActionEvent event) throws IOException {
        App.setRoot("4AdminMyEvents");
    }
    
         @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelFAQ.setText("How do I create events on Eventify?\n"
                + "To create an event on Eventify, you need to create an Admin account. Through this account, you are able to add guests\n"
                + "and create events that include them!\n\n"
                + "How do I add guests?\n"
                + "You can add guests in the My Guest tab, through the Add Guest link in the toolbar. All you need to add a guest is their\n"
                + "name and email. They will receive an email with their Access Code and password so they can access the invitations you\n"
                + "send them.\n\n"
                + "How can I add guests to my events?\n"
                + "Guests can be added when you create or edit your event. Note that only current guests can be added to your event, in order\n"
                + "to add a new guest to your event, create a guest profile in the My Guest tab.\n\n"
                + "When do guests receive their invitations?\n"
                + "Guests will receive their invitation once the event has been created or when they have been added to an existing event.\n"
                + "Guests will get a notification in the RSVP table and will then RSVP to your event.\n\n"
                + "Do you still have a question?\n"
                + "Contact us at customerinfo@eventify.com.au and we can help you out!");
    }  

}

