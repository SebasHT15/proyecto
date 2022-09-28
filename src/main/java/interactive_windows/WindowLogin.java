package interactive_windows;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import listClasses.Reader;

import java.io.IOException;
import java.util.List;

/**
 *WindowLogin representa el controlador de la ventana Login.
 *@author Sebastían Hernández Bonilla y Adrián Salas Solís
 *@version v0.1 septiembre 2022
 */

public class WindowLogin {
    private Stage stage1;
    @FXML
    private TextField txtName;
    @FXML
    private TextField usupassword;
    @FXML
    private Label popUp;

    /**
     * Permite comprobar que el nombre de usuario y la contraseña coincidan
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    public void cheking() throws IOException {
        Reader lectorUsuario = new Reader();
        lectorUsuario.crear_usuario("C:\\Users\\Adrian\\Desktop\\Proyectos\\Proyecto_prueba\\proyecto\\usuarios.csv");
        //Esto es mal, hacer mejor usuaro y meterlo en lista

        for(int i = 0; i <= lectorUsuario.lista_usuarios.size()-1; i++){
            if (txtName.getText().equals(lectorUsuario.lista_usuarios.get(i).getUser()) && usupassword.getText().equals(lectorUsuario.lista_usuarios.get(i).getPassword())){
                showVentanaUsuario(lectorUsuario.lista_usuarios, i, lectorUsuario.lista_usuarios.get(i).getUrlBibliotecas());
                break;

            } else{
                popUp.setText("¡Ingrese usuario o contraseña valida!");
            }
        }
    }

    /**
     * Crea una venta que contiene al usuario, con acceso a la información, el reproductor y las bibliotecas
     * @param listauser Lista que contiene a los objetos de clase Usuario
     * @param i Es el índice en donde se encuentra el objeto Usuario ingresado en el metodo cheking
     * @param urlBibliotecas Es el string con la ruta al documento .csv en donde esta la información de las bibliotecas de cada usuario.
     * @throws IOException Hará una llamada Exception y lanzará la exepción correspondiente al encontrarlo.
     */
    @FXML
    void showVentanaUsuario(List listauser, Integer i, String urlBibliotecas) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaUsuario.fxml"));
        Parent root = loader.load();
        WindowUsuario controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventanaUsuario(listauser, i, txtName.getText(), usupassword.getText(), urlBibliotecas, stage, this);
        stage.show();
        popUp.setText("");
        this.stage1.close();
    }

    /**
     * Cambia el stage de la ventana Inicio por la de ventana Login
     * @param stage Stage es la ventana Login
     */
    public void setStage(Stage stage) {
        stage1 = stage;
    }

    /**
     * Muestra la ventana Inicio
     */
    public void show(){
        stage1.show();
    }
}

