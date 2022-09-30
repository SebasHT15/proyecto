module com.example.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.fazecast.jSerialComm;


    opens interactive_windows to javafx.fxml;
    exports interactive_windows;
}