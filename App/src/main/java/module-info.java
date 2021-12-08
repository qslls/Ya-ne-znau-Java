module example.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.app to javafx.fxml;
    exports example.app;
}