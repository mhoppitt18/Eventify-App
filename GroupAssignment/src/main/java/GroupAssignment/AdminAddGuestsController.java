package GroupAssignment;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javax.swing.JLabel;




public class AdminAddGuestsController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;

    @FXML
    private TextField textGuestFirstName;
     
    @FXML
    private Label labelGuestFirstName;
   
    @FXML
    private Label labelGuestLastName;

    @FXML
    private TextField textGuestEmail;
    
    @FXML
    private Label labelGuestEmail;

    @FXML
    private TextField textGuestLastName;

    
    @FXML
    private TableView<Guest> tableAddGuest;

    @FXML
    private AnchorPane secondAnchor;

    @FXML
    private ImageView eventifyLogo1;

    @FXML
    private Button buttonMyEvents;

    @FXML
    private Button buttonHome;

    @FXML
    private ImageView imageHome;
    
    @FXML
    private Label labelError;

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
    private Label labelMyGuests;

    @FXML
    private ImageView imageGuests;

    @FXML
    private ToolBar mainTool;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLogOut;

    @FXML
    private ToolBar toolNavBar;

    @FXML
    private MenuButton menuGuests;

    @FXML
    private MenuItem menuViewGuests;

    @FXML
    private MenuItem menuEditCurrentGuests;

    @FXML
    private Label labelInstructions;
     
    @FXML
    private Button buttonAddGuest;
    
    @FXML
    private TableView<Guest> AddGuestTable;

    @FXML
    private TableColumn columnGuestFname;

    @FXML
    private TableColumn columnGuestLname;

    @FXML
    private TableColumn columnGuestEmail;

    @FXML
    private Button buttonAddGuestToRunsheet;
    
    ArrayList<Guest> guestArray = new ArrayList<>();
    
    Database database = new Database();

    @FXML
    void handleAddGuestButton(ActionEvent event) throws IOException {
         try {
             for(int i = 0; i < guestArray.size(); i++) {
                database.inesrtIntoGuest(guestArray.get(i));        
            } 
         } catch(SQLException e) {
            labelError.setText("Please enter valid Guest Detail information");
         }
        App.setRoot("13AdminMyGuests");
    }


    @FXML
    void handleAddGuestToRunsheet(ActionEvent event) throws IOException {
        Guest current = new Guest();
        current.setfname(textGuestFirstName.getText());
        current.setlname(textGuestLastName.getText());
        current.setemail_address(textGuestEmail.getText());
        current.setadminID(AdminSession.getAdminID());
        current.setaccess_code(accessCodeNameGenerator(textGuestFirstName.getText(), textGuestLastName.getText()) + accessCodeNumberGenerator());
                
        guestArray.add(current);
        
        System.out.println("Name: " + current.getfname() + current.getlname());
                System.out.println("email: " + current.getemail_address());
                        System.out.println("Name: " + current.getfname() + current.getlname());
                                System.out.println("Admin: " + current.getadminID());
                                        System.out.println("code: " + current.getaccess_code());
                                        System.out.println("array" + guestArray);
                                        
                                        
            
        columnGuestFname.setCellValueFactory(new PropertyValueFactory<Guest, String>("fname"));
        columnGuestLname.setCellValueFactory(new PropertyValueFactory<Guest, String>("lname"));
        columnGuestEmail.setCellValueFactory(new PropertyValueFactory<Guest, String>("email_address"));
        
        AddGuestTable.setItems(getGusetColumns());
    }
    
    
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
    void switchToAdminEditGuests(ActionEvent event) throws IOException {
        App.setRoot("14AdminEditGuests");
    }

    @FXML
    void switchToAdminHome(ActionEvent event) throws IOException {
        App.setRoot("3AdminHome");
    }

    @FXML
    void switchToAdminMyEvents(ActionEvent event) throws IOException {
        App.setRoot("4AdminMyEvents");
    }

    @FXML
    void switchToAdminMyGuests(ActionEvent event) throws IOException {
        App.setRoot("13AdminMyGuests");
    }

    @FXML
    void switchToHelp(ActionEvent event) throws IOException {
        App.setRoot("16AdminHelp");
    }
    
  
    public String accessCodeNameGenerator (String fname, String lname) {
        String concatName = fname + lname;
        String accessCodeName = "";
        char hyphin = '-';
        char apostrophe = '\'';
        int i =0;
        while(i < concatName.length()) {
            if(Character.compare(hyphin, concatName.charAt(i))==0) {
                i++;
            } else if (Character.compare(apostrophe, concatName.charAt(i))==0) {
            i++;
            } else {
             accessCodeName += concatName.charAt(i);
             i++;
            }
        }
       return accessCodeName;
    }
    
    public String accessCodeNumberGenerator () {
        String accessCodeNumber = "";
        int i = 0;
        while(i<4) {
            double x = Math.random()*10;
            int y =(int)x;
            accessCodeNumber += Integer.toString(y);
            i++;
        }
        return accessCodeNumber;
    }

    public ObservableList<Guest> getGusetColumns() throws IOException {
        ObservableList<Guest> columns = FXCollections.observableArrayList();
            for(int i = 0; i < guestArray.size(); i++) {
                columns.add(guestArray.get(i));
            }
       return columns;
    } 

     @Override
  public void initialize(URL url, ResourceBundle rb) {
}
}
