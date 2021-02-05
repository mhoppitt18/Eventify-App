package GroupAssignment;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

public class AdminViewEventDetailsController implements Initializable {

   
    @FXML
    private ScrollPane mainScroll;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;

    @FXML
    private TextField textEventDate;

    @FXML
    private ChoiceBox<String> menuSelectEventTitle;

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
    private ToolBar mainTool;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLogOut;

    @FXML
    private ToolBar toolNavBar;

    @FXML
    private MenuButton menuEventDetails;

    @FXML
    private MenuItem menuViewEventDetails;

    @FXML
    private MenuItem menuEditGuests;

    @FXML
    private MenuItem menuViewRSVP;

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
    private Button buttonSelectEvent;

    @FXML
    private ImageView imageHelp;

    @FXML
    private ImageView imageMyEvents;

    @FXML
    private Label labelMyEvents;
    
    @FXML 
    private Label labelinstruction;

    @FXML
    private TableView<Runsheet> tableAdminEventRunsheet;

    @FXML
    private TableColumn colTitle;

    @FXML
    private TableColumn colTime;
    
    @FXML
    public static Button buttonDownloadInvitation;
    
    @FXML
    private Label labelDownloadConfirmation;

    Database database = new Database();
    
    
    @FXML
    void handleLogOutButton(ActionEvent event) throws IOException {
        AdminSession.cleanAdminSession();
        App.setRoot("2AdminLogin");
    }
    
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
//null pointer exception @ 324
            document.save(selectedDirectory.getAbsolutePath() + "\\" + database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_title() + " Invitation.pdf");
            labelDownloadConfirmation.setText("Invitation has been downloaded");
        }
    }

    @FXML
    void switchToAboutUs(ActionEvent event) throws IOException {
        App.setRoot("17AdminAboutUs");
    }
    
    @FXML
    void switchToAdminEditEventDetails(ActionEvent event) throws IOException {
        App.setRoot("10AdminEditEventDetails");
    }

    @FXML
    void switchToAdminAddEventGuests(ActionEvent event) throws IOException {
        App.setRoot("6AdminAddEventGuests");
    }


    @FXML
    void switchToAdminEventViewRSVP(ActionEvent event) throws IOException {
        App.setRoot("12AdminEventViewRSVP");
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

    @FXML
    void switchToAdminMyEvents(ActionEvent event) throws IOException {
        App.setRoot("4AdminMyEvents");
    }
    
    @FXML
    void handleSelectEventButton(ActionEvent event) throws IOException {
        //set text fields 
        textEventTime.setText(String.valueOf(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_time()));
        textEventLocation.setText(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_location());
        textEventDate.setText(String.valueOf(database.returnAdminEventView(menuSelectEventTitle.getValue()).getevent_date()));
        //set runsheet table
        colTitle.setCellValueFactory(new PropertyValueFactory<Runsheet, String>("activity"));
        colTime.setCellValueFactory(new PropertyValueFactory<Runsheet, Integer>("activity_time")); 
        
        tableAdminEventRunsheet.setItems(getRunsheetColumns());
    }
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        //menuSelectEventTitle.setItems(getEventColumns());
        for(int i = 0; i<getEventColumns().size(); i++) {
            menuSelectEventTitle.getItems().add(getEventColumns().get(i).getevent_title());
        }
      //  menuSelectEventTitle.getSelectionModel().select(0);
        
    }

    public ObservableList<Event> getEventColumns() {
        ObservableList<Event> columns = FXCollections.observableArrayList();
        //add objects from event array into observablearraylist
        for(int i = 0; i < database.returnAdminEventTable(AdminSession.getAdminID()).size(); i++) {
            columns.add(database.returnAdminEventTable(AdminSession.getAdminID()).get(i));
        }
       // ObservableList<String> titles = FXCollections.observableArrayList();
       //     for(int i =0; i < columns.size(); i++) {
       //     titles.add(columns.get(i).getevent_title());
       // }
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


