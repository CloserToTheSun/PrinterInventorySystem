package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    Admin admin = new Admin("admin", "password");

    Technician tech = new Technician("tech", "password");

    @FXML public TextField tfUsername;
    @FXML public PasswordField pfPassword;

    @FXML private void loginButtonAction(ActionEvent event) throws IOException, Exception {

        if (tfUsername.getText().equalsIgnoreCase(admin.getUserName()) && pfPassword.getText().equalsIgnoreCase(admin.getPassword())) {
            Parent mainView = FXMLLoader.load(getClass().getResource("PrinterTable.fxml"));
            Scene mainScene = new Scene(mainView);
            mainScene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("DTCC Printer Inventory");
            window.setScene(mainScene);
            window.show();
        }
        else if (tfUsername.getText().equalsIgnoreCase(tech.getUserName()) && pfPassword.getText().equalsIgnoreCase(tech.getPassword())) {
            Parent mainView = FXMLLoader.load(getClass().getResource("LimitedPrinterTable.fxml"));
            Scene mainScene = new Scene(mainView);
            mainScene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setTitle("DTCC Printer Inventory");
            window.setScene(mainScene);
            window.show();
        }
        else {
            System.out.println("Incorrect username or password");
        }
    }
}