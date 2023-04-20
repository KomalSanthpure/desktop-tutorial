module com.example.snakeladdermarchdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakeladdermarchdemo to javafx.fxml;
    exports com.example.snakeladdermarchdemo;
}