module com.example.allinall {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.allinall;
    //exports com.example.allinall;
}