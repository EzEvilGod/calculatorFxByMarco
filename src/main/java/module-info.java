module com.example.calculatorfxbymarco {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatorfxbymarco to javafx.fxml;
    exports com.example.calculatorfxbymarco;
}