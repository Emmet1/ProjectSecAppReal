import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Emmet
 */
// The start() method is overridden from the Application class.
@Override
public void start(Stage stage) throws IOException {

    // Load the Login.fxml file using the FXMLLoader class.
    Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));

    // Create a new Scene with the loaded fxml file as the root node and set its dimensions.
    Scene scene = new Scene(root, 600, 400);

    // Set the Scene as the stage's scene and set the stage's title.
    stage.setScene(scene);
    stage.setTitle("UQU");

    // Show the stage.
    stage.show();
}

// This is the main method of the application.
public static void main(String[] args) {
    // Call the launch() method to start the JavaFX application.
    launch(args);
}




