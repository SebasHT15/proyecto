package interactive_windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WindowBibliotecas {
    private WindowUsuario controllerVentanaUsuario;

    private Integer number_playlist=3;
    private Stage stage;
    private Label[] label;
    private Button[] button;

    @FXML
    private VBox label_pane;
    @FXML
    private VBox button_pane;
    @FXML
    private SplitPane pane;

    @FXML
    void showVentanaUsuario2() {
        controllerVentanaUsuario.show();
        stage.close();
    }

    public void init_ventanaBibliotecas(Stage stage, WindowUsuario ventanaIniController) {
        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
        //this.number_playlist = 3;

        label_pane.setSpacing(5);
        Label[] label = new Label[number_playlist];
        Button[] button = new Button[number_playlist];


        for (int i = 0; i < label.length; i++) {
            label[i] = new Label(); // This is missing in the original code
            label[i].setFont(new Font("Arial",18));

            label_pane.getChildren().add((label[i]));

            label[i].setText("Label "+i);

            button[i]=new Button();

            button_pane.getChildren().add(button[i]);

            button[i].setText("Boton "+i);

            int i_print_console = i;
            button[i].setOnAction(event_print_console -> handle_print_console(event_print_console, i_print_console));
        }
    }
    @FXML
    private void handle_print_console(ActionEvent event, Integer value){
        System.out.println(value);}
}
