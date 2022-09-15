module com.example.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens interactive_windows to javafx.fxml;
    exports interactive_windows;
}