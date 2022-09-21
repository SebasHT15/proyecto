package interactive_windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import listClasses.Reader;

import java.io.IOException;


//Añadir boton para crear bibliotecas
public class WindowBibliotecas {
    private WindowUsuario controllerVentanaUsuario;

    private Integer number_playlist=3;
    private Stage stage;
    private Label[] superlabel;
    private Label[] sublabel;
    private Button[] button;

    private String urlBibliotecas;

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

    public void init_ventanaBibliotecas(String urlBibliotecas, Stage stage, WindowUsuario ventanaIniController) throws IOException {
        this.controllerVentanaUsuario = ventanaIniController;
        this.stage = stage;
        this.urlBibliotecas=urlBibliotecas;

        Reader lector_playlist = new Reader();
        lector_playlist.crear_bibliotecas(urlBibliotecas);
        //this.number_playlist = 3;

        button_pane.setSpacing(15);
        Label[] superlabel = new Label[lector_playlist.getNumber_playlist()];
        Label[] sublabel = new Label[lector_playlist.getNumber_playlist()];
        Button[] button = new Button[lector_playlist.getNumber_playlist()];


        for (int i = 0; i < superlabel.length; i++) {
            superlabel[i] = new Label();
            superlabel[i].setFont(new Font("Arial",18));
            label_pane.getChildren().add(superlabel[i]);
            superlabel[i].setText(lector_playlist.lista_playlist.get(i).name_playlist());

            sublabel[i] = new Label();
            sublabel[i].setFont(new Font("Arial",11));
            label_pane.getChildren().add(sublabel[i]);
            sublabel[i].setText("Canciones: "+lector_playlist.lista_playlist.get(i).number_songs()+"   "+"Fecha: "+lector_playlist.lista_playlist.get(i).creation_date());

            button[i]=new Button();

            button_pane.getChildren().add(button[i]);

            button[i].setText("Editar");

            int i_print_console = i;
            button[i].setOnAction(event_print_console -> handle_print_console(event_print_console, i_print_console));
        }
    }
    @FXML
    private void handle_print_console(ActionEvent event, Integer value){
        System.out.println(value);}

    @FXML
    void showVentanaEditBibliotecas() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaEditBiblioteca.fxml"));
        Parent root = loader.load();
        WindowEditBiblioteca controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventaEditBibliotecas(this.urlBibliotecas, stage, this);
        stage.show();
        this.stage.close();
    }
    public void show(){
        stage.show();
    }
}
