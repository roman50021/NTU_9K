module com.example.ntu_9k {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ntu_9k to javafx.fxml;
    exports com.example.ntu_9k;
}