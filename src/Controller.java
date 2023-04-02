
/**
 * FXML Controller class
 *
 * @author Emmet
 */
import java.net.URL;
        import java.util.ArrayList;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.stage.Stage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Controller implements Initializable {
    @FXML private Label Titlelbl;
    @FXML private Label UserNamelbl;
    @FXML private Label Passwordlbl;
    @FXML private Button Registerbtn;
    @FXML private Button Loginbtn;
    @FXML private Label Forgetbtn;
    @FXML private Label Outputlbl;
    @FXML private TextField UserNametxt;
    @FXML private TextField Passwordtxt;
    @FXML private Label Outputlbl1;
    @FXML private Label Outputlbl2;
    @FXML private ImageView Img;
    @FXML private Button Viewbtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image(getClass().getResourceAsStream("/application/icons/uqu.png"));
        Img.setImage(image);
    }

    @FXML
    private void Login(ActionEvent event) {
        boolean valid = true;

        if (UserNametxt.getText().isEmpty()) {
            valid = false;
            Outputlbl1.setText("Please Enter User Name ");
        }

        if (Passwordtxt.getText().isEmpty()) {
            valid = false;
            Outputlbl2.setText("Please Enter Password");
        }

        if (valid) {
            String username = UserNametxt.getText();
            String password = Passwordtxt.getText();

            User user = UserDatabase.getUser(username);
            if (user != null && user.getPassword().equals(password)) {
                // User is authenticated, create a new session and set the user's role
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRoles().iterator().next());

                // Redirect to the appropriate screen based on the user's role
                if (user.getRoles().contains("admin")) {
                    response.sendRedirect("admin-screen.jsp");
                } else if (user.getRoles().contains("user")) {
                    response.sendRedirect("user-screen.jsp");
                }
            } else {
                Outputlbl1.setText(HtmlUtils.htmlEscape("Invalid username or password"));
            }
        }
    }



    @FXML
    private void Registerbtn(ActionEvent event) {
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    private void view(ActionEvent event) {
        Users u = new Users();
        ArrayList<String> uname = new ArrayList<String>();
        ArrayList<String> pass = new ArrayList<String>();
        uname = u.getUserNames();
        pass = u.getPasswords();
        System.out.println("The user Names-" + uname);
    }
}
