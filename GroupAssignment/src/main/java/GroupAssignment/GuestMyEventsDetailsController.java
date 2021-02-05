package GroupAssignment;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import be.quodlibet.boxable.*;
import be.quodlibet.boxable.line.LineStyle;
//import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * FXML Controller class
 */
public class GuestMyEventsDetailsController implements Initializable {

    @FXML
    private ScrollPane mainScroll;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label labelEventName;

    @FXML
    private Pane pane;

    @FXML
    private DatePicker calendarEventDate;

    @FXML
    private TextField textEventTitle;

    @FXML
    private Label labelEventTitle;

    @FXML
    private Label labelEventDate;

    @FXML
    private TextField textEventTime;

    @FXML
    private Label labelEventTime;

    @FXML
    private TextField textEventLocation;

    @FXML
    private Label labelEventLocation;

    @FXML
    private Label labelMyRSVP;

    @FXML
    private TextField textMyRSVP;

    @FXML
    private Label labelGuestDietaryNotes;

    @FXML
    private TextField textGuestDietaryNotes;
    
    @FXML
    private TextField textEventDate;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLogOut;

    @FXML
    private TableView<Runsheet> tableGuestEventRunsheet;

    @FXML
    private TableColumn colTitle;

    @FXML
    private TableColumn colTime;

    @FXML
    private Label labelEventName1;

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
    private Button buttonAboutUs;

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
    private Button buttonDownloadRunsheet;

    @FXML
    private Button buttonDownloadInvitation;

    @FXML
    private Label labelTop;
    
    @FXML
    private ChoiceBox<String> menuSelectEventTitle;
    
    @FXML
    private Button buttonSelectEvent;
    
    @FXML
    private Label labelGuestDownloadConfirmation;
    
    Database database = new Database();

    @FXML
    void handleDownloadInvitationButton(ActionEvent event) throws IOException {
        try (PDDocument document = new PDDocument()) {
            Database database = new Database();
            document.addPage(new PDPage());   
            PDPage page = document.getPage(0);  
            PDPageContentStream contentStream = new PDPageContentStream(document, page); 
            
            //add background
            contentStream.setNonStrokingColor(176,224,230);
            contentStream.addRect(0, 0, 600, 780);
            //contentStream.setLineWidth(6f);
            contentStream.fill();
            
            
            // add borders
            contentStream.setNonStrokingColor(Color.DARK_GRAY);
            contentStream.addRect(20, 20, 572, 752);
            contentStream.setLineWidth(6f);
            contentStream.closeAndStroke();
            
            contentStream.setNonStrokingColor(Color.DARK_GRAY);
            contentStream.addRect(6, 6, 600, 780);
            contentStream.setLineWidth(12f);
            contentStream.closeAndStroke();

            // draw Eventify logo
            File file = new File("src/main/resources/fxml/Images/EventifyLogoNew.png");
            String imgLogoPath = file.getAbsolutePath();
            PDImageXObject pdLogoImage = PDImageXObject.createFromFile(imgLogoPath, document);
            contentStream.drawImage(pdLogoImage, 192, 535, 250, 250); 

            //add text
            contentStream.beginText();
            contentStream.setNonStrokingColor(Color.BLACK);
            PDFont font = PDType1Font.HELVETICA_BOLD;
            int fontSize = 22;
            int marginTop = 240;
            String text = "You have been invited to:";
            float titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            float titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
            contentStream.drawString(text);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setNonStrokingColor(Color.RED);
            font = PDType1Font.COURIER_BOLD;
            fontSize = 45;
            marginTop = 280;
            //text = "[EVENT_TITLE]";
            text = database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_title();
            //text = Event.getevent_title();
            titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
            contentStream.drawString(text);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setNonStrokingColor(Color.BLACK);
            font = PDType1Font.HELVETICA_BOLD;
            fontSize = 22;
            marginTop = 360;
            text = "This event will be held on:";
            titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
            contentStream.drawString(text);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setNonStrokingColor(Color.RED);
            font = PDType1Font.COURIER_BOLD;
            fontSize = 45;
            marginTop = 400;
           // text = Event.getevent_date().toString();
            text = database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_date().toString();
            titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
            contentStream.drawString(text);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setNonStrokingColor(Color.RED);
            font = PDType1Font.COURIER_BOLD;
            fontSize = 45;
            marginTop = 460;
            //text = String.valueOf(Event.getevent_time());
            text = String.valueOf(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_time());
            titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
            contentStream.drawString(text);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setNonStrokingColor(Color.BLACK);
            font = PDType1Font.HELVETICA_BOLD;
            fontSize = 22;
            marginTop = 540;
            text = "at";
            titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
            contentStream.drawString(text);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setNonStrokingColor(Color.RED);
            font = PDType1Font.COURIER_BOLD;
            fontSize = 45;
            marginTop = 580;
           // text = Event.getevent_location();
            text = database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_location();
            titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
            contentStream.drawString(text);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setNonStrokingColor(Color.BLACK);
            font = PDType1Font.HELVETICA_BOLD;
            fontSize = 22;
            marginTop = 665;
            text = "Please RSVP as soon as you can.";
            titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
            contentStream.drawString(text);
            contentStream.endText();
            
            contentStream.beginText();
            contentStream.setNonStrokingColor(Color.BLACK);
            font = PDType1Font.HELVETICA_BOLD;
            fontSize = 22;
            marginTop = 700;
            text = "Hope to see you at the event!";
            titleWidth = font.getStringWidth(text) / 1000 * fontSize;
            titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
            contentStream.setFont(font, fontSize);
            contentStream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
            contentStream.drawString(text);
            contentStream.endText();
            
            contentStream.close();
            
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setInitialDirectory(new File("src"));

            Stage stage = (Stage) mainAnchor.getScene().getWindow();
            
            File selectedDirectory = directoryChooser.showDialog(stage);

            document.save(selectedDirectory.getAbsolutePath() + "\\" + database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_title() + " Invitation.pdf");
            labelGuestDownloadConfirmation.setText("Invitation has been downloaded");
        }
    }

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
    void switchToGuestMyRSVP(ActionEvent event) throws IOException {
        App.setRoot("23GuestMyRSVP");
    }

    @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("24GuestHelp");
    }
    
    @FXML
    void handleSelectEventButton(ActionEvent event) {        
        try {//set text fields 
            colTitle.setCellValueFactory(new PropertyValueFactory<Runsheet, String>("activity"));
            colTime.setCellValueFactory(new PropertyValueFactory<Runsheet, Integer>("activity_time")); 
            
            tableGuestEventRunsheet.setItems(getRunsheetColumns());
            
            textEventTime.setText(String.valueOf(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_time()));
            textEventLocation.setText(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_location());
            textEventDate.setText(String.valueOf(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_date()));
            textEventTitle.setText(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_title());
            textMyRSVP.setText((database.returnGuestRSVP(GuestSession.getGuestID(), database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID())).getdecision());
            textGuestDietaryNotes.setText((database.returnGuestRSVP(GuestSession.getGuestID(), database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID())).getdietary_requirements());

        //set runsheet table
            
        
            //tableGuestEventRunsheet.setItems(getRunsheetColumns());
            
            //System.out.println(Runsheet.getactivity());
            //System.out.println(Runsheet.getactivity_time());
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up choice box menu
        //for(int i = 0; i<database.returnGuestEventTable(GuestSession.getGuestID()).size(); i++) {
          //  menuSelectEventTitle.getItems().add(database.returnGuestEventTable(GuestSession.getGuestID()).get(i).getevent_title());
        //}
        for(int i = 0; i<getGuestEventColumns().size(); i++) {
        menuSelectEventTitle.getItems().add(getGuestEventColumns().get(i).getevent_title());

        }
    }
    
    
     public ObservableList<GuestEventRSVP> getGuestEventColumns() {
        ObservableList<GuestEventRSVP> columns = FXCollections.observableArrayList();
        //add objects from event array into observablearraylist
        for(int i = 0; i <database.returnGuestEventTable(GuestSession.getGuestID()).size(); i++) {
            columns.add(database.returnGuestEventTable(GuestSession.getGuestID()).get(i));
        }

    return columns;
    }
    
        
    public ObservableList<Runsheet> getRunsheetColumns() throws IOException {
        int eventID = database.returnAdminEventView(menuSelectEventTitle.getValue()).geteventID();
        ObservableList<Runsheet> columns = FXCollections.observableArrayList();
        //add objects from event array into observablearraylist
            for(int i = 0; i < database.returnEventRunsheetTable(eventID).size(); i++) {
                columns.add(database.returnEventRunsheetTable(eventID).get(i));
            }
       return columns;
    } 
    
}

