package GroupAssignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class GuestAboutUsController implements Initializable {

    @FXML
    private ScrollPane mainScroll;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;

    @FXML
    private Label labelAboutUs;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonLogOut;

    @FXML
    private Label labelTitle;

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
    private Button buttonGuestHelp;

    @FXML
    private ImageView imageAboutUs;

    @FXML
    private Button buttonMyEvent;

    @FXML
    private ImageView imageHelp;

    @FXML
    private ImageView imageMyEvents;

    @FXML
    private Label labelMyEvents;

    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        GuestSession.cleanGuestSession();
        App.setRoot("18GuestLogin");
    }

    @FXML
    void switchToGuestHelp(ActionEvent event) throws IOException {
        App.setRoot("24GuestHelp");
        
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
    void switchToGuestMyRSVP(ActionEvent event) throws IOException {
        App.setRoot("23GuestMyRSVP");
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelAboutUs.setText("Copyright © 2020.\n"
                + "We, the developers of this software application, declare that it is our work towards an assessment item submitted to fulfill\n"
                + "the requirements of INFS2605 (UNSW Sydney).\n"
                + "We declare that it is our own work, except where acknowledged, and has not been submitted for academic credit elsewhere.\n"
                + "We acknowledge that the assessor of this item may, for the purpose of assessing this item:\n"
                + "- Reproduce this assessment item and provide a copy to another member of the University; and/or,\n"
                + "- Communicate a copy of this assessment item to a plagiarism checking service (which may then retain a copy of the\n"
                + "assessment item on its database for the purpose of future plagiarism checking).\n"
                + "We certify that we have read and understood the UNSW University Rules in respect of Student Academic Misconduct.\n"
                + "We also acknowledge the fxdbdemo package in providing the database structure from which the EVENTIFY database was\n"
                + "modelled.\n"
                + "We also recognise the PDFBox library for providing a platform to download PDF files.");
    }  


}

