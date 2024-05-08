module com.example.randomquestion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.randomquestion to javafx.fxml;
    exports com.example.randomquestion;
    exports com.example.randomquestion.controller;
    opens com.example.randomquestion.controller to javafx.fxml;
}