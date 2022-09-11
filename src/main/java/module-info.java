module com.example.proyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens interactive_windows to javafx.fxml;
    exports interactive_windows;
}