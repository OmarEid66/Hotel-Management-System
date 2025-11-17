module com.example.hotel_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.hotel_system to javafx.fxml;
    exports com.example.hotel_system;
}