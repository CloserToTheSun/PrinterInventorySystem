package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class AddPrinterController {

    @FXML TextField tfBarCode, tfDescription, tfCategory, tfLocation, tfSerialNumber,
            tfManufacturer, tfDivision, tfDepartment, tfCampus, tfStatus;

    public void addPrinterButton(ActionEvent event) throws IOException {

        if (tfBarCode.getText().isEmpty() || tfDescription.getText().isEmpty() || tfCategory.getText().isEmpty()
                || tfLocation.getText().isEmpty() || tfSerialNumber.getText().isEmpty() || tfManufacturer.getText().isEmpty()
                || tfDivision.getText().isEmpty() || tfDepartment.getText().isEmpty() || tfCampus.getText().isEmpty()
                || tfStatus.getText().isEmpty()) {
            System.out.println("Error: No text fields may be left empty. Try again");
            return;
        }

        addPrinter(tfBarCode.getText(), tfDescription.getText(), tfCategory.getText(), tfLocation.getText(),
                tfSerialNumber.getText(), tfManufacturer.getText(), tfDivision.getText(), tfDepartment.getText(),
                tfCampus.getText(), tfStatus.getText()
        );

        this.tfBarCode.clear();
        this.tfDescription.clear();
        this.tfCategory.clear();
        this.tfLocation.clear();
        this.tfSerialNumber.clear();
        this.tfManufacturer.clear();
        this.tfDivision.clear();
        this.tfDepartment.clear();
        this.tfCampus.clear();
        this.tfStatus.clear();

    }

    @FXML
    public void addPrinter(String barCode, String description, String category, String location,
                           String serialNumber, String manufacturer, String division, String department,
                           String campus, String status) {
        Printer addPrinter = new Printer(barCode, description, category, location,
                serialNumber, manufacturer, division, department, campus, status);
        PrinterTableController.printerList.add(addPrinter);
    }

    public void backButton(ActionEvent event) throws IOException {
        Parent mainView = FXMLLoader.load(getClass().getResource("PrinterTable.fxml"));
        Scene mainScene = new Scene(mainView);
        mainScene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        //Stage window = new Stage();
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("DTCC Printer Inventory");
        window.setScene(mainScene);
        window.show();
    }
}