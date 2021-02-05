// NEW Assignment (correct version in Guthub)
package GroupAssignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
        loadDatabase();
        scene = new Scene(loadFXML("1WelcomePage"), 1366, 768);
        stage.setTitle("EVENTIFY");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    private void loadDatabase() {
        Database.createAdminTable();
        Database.createGuestTable();
        Database.createEventTable();
        Database.createInvitationTable();
        Database.createRSVPTable();
        Database.createRunsheetTable();
    }

}