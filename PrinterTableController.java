package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrinterTableController {

    @FXML public TableView<Printer> printerTable;

    @FXML private TableColumn<Printer, String> barCode;
    @FXML private TableColumn<Printer, String> description;
    @FXML private TableColumn<Printer, String> categoryName;
    @FXML private TableColumn<Printer, String> locationName;
    @FXML private TableColumn<Printer, String> serialNumber;
    @FXML private TableColumn<Printer, String> manufacturerName;
    @FXML private TableColumn<Printer, String> division;
    @FXML private TableColumn<Printer, String> department;
    @FXML private TableColumn<Printer, String> campus;
    @FXML private TableColumn<Printer, String> status;

    @FXML private TextField filterField;

    public static ObservableList<Printer> printerList = FXCollections.observableArrayList();
    public static FilteredList<Printer> filteredData = new FilteredList<>(printerList, p -> true);
    public static SortedList<Printer> sortedData = new SortedList<>(filteredData);

    /** Assign CSV path file to string below  */
    public static final String CSV_FILE = "/Users/patrickobrien/IdeaProjects/PrinterInventorySystem/src/app/printers.csv";

    public PrinterTableController() {
        importCSV();
    }

    @FXML
    public void initialize() {

        printerTable.refresh();
        // Initialize columns
        barCode.setCellValueFactory(cellData -> cellData.getValue().barCodeProperty());
        description.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        categoryName.setCellValueFactory(cellData -> cellData.getValue().categoryNameProperty());
        locationName.setCellValueFactory(cellData -> cellData.getValue().locationNameProperty());
        serialNumber.setCellValueFactory(cellData -> cellData.getValue().serialNumberProperty());
        manufacturerName.setCellValueFactory(cellData -> cellData.getValue().manufacturerNameProperty());
        division.setCellValueFactory(cellData -> cellData.getValue().divisionProperty());
        department.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
        campus.setCellValueFactory(cellData -> cellData.getValue().campusProperty());
        status.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Printer> filteredData = new FilteredList<>(printerList, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(printer -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare printer properties of every printer with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (printer.getBarCode().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches bar code
                }
                else if (printer.getDescription().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches description
                }
                else if (printer.getCategoryName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches category
                }
                else if (printer.getLocationName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches location
                }
                else if (printer.getSerialNumber().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches serial number
                }
                else if (printer.getManufacturerName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches manufacturer
                }
                else if (printer.getDivision().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches division
                }
                else if (printer.getDepartment().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches department
                }
                else if (printer.getCampus().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches campus
                }
                else if (printer.getStatus().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches status
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Printer> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(printerTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        printerTable.setItems(sortedData);
        printerTable.setEditable(true);
    }

    @FXML
    private void deleteButton(ActionEvent event) {
        printerTable.setEditable(true);

        //int tableIndex = printerTable.getSelectionModel().getSelectedIndex();
        //int listIndex = sortedData.getSourceIndexFor(printerList, tableIndex);
        //printerList.remove(listIndex);

        Printer printer = printerTable.getSelectionModel().getSelectedItem();
        printerList.removeAll(printer);
    }

    @FXML
    private void addPrinterScene(ActionEvent event) throws IOException {
        Parent addPrinterView = FXMLLoader.load(getClass().getResource("AddPrinter.fxml"));
        Scene scene = new Scene(addPrinterView);
        scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void printReport() {

        //for (int i = 0; i < sortedData.size(); i++) {
        //    System.out.println(sortedData.get(i).toString());
        //}

        for (int i = 0; i < printerList.size(); i++) {
            System.out.println(printerList.get(i).toString());
        }
    }

    @FXML private void logOutButtonAction(ActionEvent event) throws IOException {
        Parent mainView = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene mainScene = new Scene(mainView);
        mainScene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setTitle("DTCC Printer Inventory");
        window.setScene(mainScene);
        window.show();
    }

    public void importCSV() {
        BufferedReader br = null;
        try
        {
            //Reading the csv file
            /**
             * INSERT CSV FILEPATH IN BUFFERED READER BELOW
             */
            br = new BufferedReader(new FileReader(CSV_FILE));

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null)
            {
                String[] printerDetails = line.split(",");

                if(printerDetails.length > 0 )
                {
                    //Create a temporary printer
                    Printer printer = new Printer(printerDetails[0], printerDetails[1], printerDetails[2],
                            printerDetails[3], printerDetails[4], printerDetails[5], printerDetails[6],
                            printerDetails[7], printerDetails[8], printerDetails[9]);

                    // Add the temporary printer to the ArrayList
                    printerList.add(printer);
                }
            } // end of the while loop
        }
        catch(Exception ee) {
            ee.printStackTrace();
        }
        finally {
            try {
                br.close();
            }
            catch(IOException ie) {
                System.out.println("Error occurred while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
    }
}