package app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;

public class Printer {

    private final StringProperty barCode;
    private final StringProperty description;
    private final StringProperty categoryName;
    private final StringProperty locationName;
    private final StringProperty serialNumber;
    private final StringProperty manufacturerName;
    private final StringProperty division;
    private final StringProperty department;
    private final StringProperty campus;
    private final StringProperty status;

    /*
    public Printer() {
        this.barCode = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
        this.categoryName = new SimpleStringProperty("");
        this.locationName = new SimpleStringProperty("");
        this.serialNumber = new SimpleStringProperty("");
        this.manufacturerName = new SimpleStringProperty("");
        this.division = new SimpleStringProperty("");
        this.department = new SimpleStringProperty("");
        this.campus = new SimpleStringProperty("");
        this.status = new SimpleStringProperty("");
    }
    */

    public Printer(String barCode, String description, String categoryName, String locationName, String serialNumber,
                   String manufacturerName, String division, String department, String campus, String status) {
        this.barCode = new SimpleStringProperty(barCode);
        this.description = new SimpleStringProperty(description);
        this.categoryName = new SimpleStringProperty(categoryName);
        this.locationName = new SimpleStringProperty(locationName);
        this.serialNumber = new SimpleStringProperty(serialNumber);
        this.manufacturerName = new SimpleStringProperty(manufacturerName);
        this.division = new SimpleStringProperty(division);
        this.department = new SimpleStringProperty(department);
        this.campus = new SimpleStringProperty(campus);
        this.status = new SimpleStringProperty(status);
    }

    public String getBarCode() { return barCode.get(); }
    public StringProperty barCodeProperty() { return barCode; }
    public void setBarCode(String barCode) { this.barCode.set(barCode); }
    public String getDescription() { return description.get(); }
    public StringProperty descriptionProperty() { return description; }
    public void setDescription(String description) { this.description.set(description); }
    public String getCategoryName() { return categoryName.get(); }
    public StringProperty categoryNameProperty() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName.set(categoryName); }
    public String getLocationName() { return locationName.get(); }
    public StringProperty locationNameProperty() { return locationName; }
    public void setLocationName(String locationName) { this.locationName.set(locationName); }
    public String getSerialNumber() { return serialNumber.get(); }
    public StringProperty serialNumberProperty() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber.set(serialNumber); }
    public String getManufacturerName() { return manufacturerName.get(); }
    public StringProperty manufacturerNameProperty() { return manufacturerName; }
    public void setManufacturerName(String manufacturerName) { this.manufacturerName.set(manufacturerName); }
    public String getDivision() { return division.get(); }
    public StringProperty divisionProperty() { return division; }
    public void setDivision(String division) { this.division.set(division); }
    public String getDepartment() { return department.get(); }
    public StringProperty departmentProperty() { return department; }
    public void setDepartment(String department) { this.department.set(department); }
    public String getCampus() { return campus.get(); }
    public StringProperty campusProperty() { return campus; }
    public void setCampus(String campus) { this.campus.set(campus); }
    public String getStatus() { return status.get(); }
    public StringProperty statusProperty() { return status; }
    public void setStatus(String status) { this.status.set(status); }

    public String getPrinter() {
        return this.barCode.toString() + this.description + this.categoryName + this.locationName + this.serialNumber
                + this.manufacturerName + this.division + this.department + this.campus + this.status;
    }


    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("");
        temp.append("PrinterInfo [barCode=" + getBarCode() + ", description=" + getDescription() + ", categoryName=" + getCategoryName()
                + ", locationName=" + getLocationName() + ", serialNumber=" + getSerialNumber() + ", manufacturerName="
                + getManufacturerName() + ", division=" + getDivision() + ", department=" + getDepartment() + ", campus=" + getCampus()
                + ", status=" + getStatus() + "]");
        return temp.toString().trim();
    }
}