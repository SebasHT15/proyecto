package interactive_windows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import listClasses.PlaylistReader;

import java.io.IOException;

public class WindowEditBiblioteca {
    private WindowBibliotecas controllerVentanaBibliotecas;
    private Stage stage;
    private String urlBibliotecas;
    @FXML
    private TextField NamePlaylist;
    @FXML
    private Label Advertencia;

    @FXML
    void showVentanaBibliotecas() {
        controllerVentanaBibliotecas.show();
        stage.close();
    }
    @FXML
    void addPlaylist(){
        if (NamePlaylist.getText().equals("")){
            Advertencia.setText("Inserte algun nombre");
        }else{
            PlaylistReader playlistReader = new PlaylistReader();
            playlistReader.addPlaylist(this.urlBibliotecas, NamePlaylist.getText(), "2022", String.valueOf(0), "url");
            Advertencia.setText("Añadido con exito");
        }
            }
    @FXML
    void deletePlaylist(){
        if (NamePlaylist.getText().equals("")){
            Advertencia.setText("Inserte algun nombre");
        }else{
            PlaylistReader playlistReader = new PlaylistReader();
            playlistReader.deletePlaylist(this.urlBibliotecas, NamePlaylist.getText());
            Advertencia.setText("Eliminado con exito");
        }
    }

    public void init_ventaEditBibliotecas(String urlBibliotecas, Stage stage, WindowBibliotecas ventanaIniController) throws IOException{
        this.controllerVentanaBibliotecas = ventanaIniController;
        this.stage = stage;
        this.urlBibliotecas = urlBibliotecas;
    }

}
