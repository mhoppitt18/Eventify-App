package GroupAssignment;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
//import javafx.scene.paint.Color;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
//import javax.imageio.ImageIO;

public class AdminCreateEventInviteController implements Initializable  {

    @FXML
    private Pane pane;
    
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button buttonViewEventInvite;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonBack;

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
    private Button buttonHelp;

    @FXML
    private ImageView imageHelp;

    @FXML
    private ImageView imageMyEvents;

    @FXML
    private Label labelMyEvents;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private Line progressLine;

    @FXML
    private Ellipse circleOne;

    @FXML
    private Label labelCreateEvent;

    @FXML
    private Ellipse circleTwo;

    @FXML
    private Ellipse circle3;

    @FXML
    private Label labelEventDetails;

    @FXML
    private Label labelCreateInvites;

    @FXML
    private Label labelCreateRunsheet;

    @FXML
    private Button buttonNext;

    @FXML
    private Ellipse circleThree;

    @FXML
    private Label labelAddGuests;

    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        AdminSession.cleanAdminSession();
        App.setRoot("2AdminLogin");
    }

    @FXML
    void handleViewEventInvite(ActionEvent event) throws IOException {  
        
    }

    @FXML
    void switchToAboutUs(ActionEvent event) throws IOException {
        App.setRoot("17AdminAboutUs");
    }

    @FXML
    void switchToAdminAddGuests(ActionEvent event) throws IOException {
        App.setRoot("6AdminAddEventGuests");
    }

    @FXML
    void switchToAdminCreateEventRunsheet(ActionEvent event) throws IOException {
        App.setRoot("8AdminCreateEventRunsheet");
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

}
