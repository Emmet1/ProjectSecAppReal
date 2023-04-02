import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.servlet.http.Cookie;
import javafx.servlet.http.HttpServletRequest;

public class App extends Application  {
    private StackPane root = new StackPane();
    private Stage stage;

    @Override
    public void init() {
        Button button = new Button("OPEN");
        VBox vBox = new VBox();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                new Label("Your Username"),
                new TextField(),
                new Label("Your Password"),
                new PasswordField(),
                new Button("LOGIN"));
        root.getChildren().addAll(vBox);

        button.setOnAction(actionEvent-> {
            if(stage!=null){
                stage.requestFocus();
                return;
            }
            stage = new Stage();
            StackPane stackPane = new StackPane();
            stage.setScene(new Scene(stackPane, 200,200));
            stage.show();
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Get the session ID from the cookie
        HttpServletRequest request = new HttpServletRequestWrapper(request);
        Cookie[] cookies = request.getCookies();
        String sessionId = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("sessionId")) {
                sessionId = cookie.getValue();
                break;
            }
        }

        // Check if the session ID is valid
        if (sessionId != null && isValidSessionId(sessionId)) {
            // User is logged in, display the main screen
            // ...
        } else {
            // User is not logged in, display the login screen
            // ...
        }
    }

    private boolean isValidSessionId(String sessionId) {
        // Check if the session ID is not null or empty
        if (sessionId != null && !sessionId.isEmpty()) {
            // Session ID is valid
            return true;
        } else {
            // Session ID is invalid
            return false;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}