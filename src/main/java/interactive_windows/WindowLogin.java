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


public class WindowLogin {
    private Stage stage1;
    @FXML
    private TextField txtName;
    @FXML
    private TextField usupassword;
    @FXML
    private Label popUp;
    @FXML
    public void cheking() throws IOException {
        Reader lectorUsuario = new Reader();
        lectorUsuario.crear_usuario("C:\\Users\\sebas\\OneDrive\\Escritorio\\TEC\\Semestre 2\\Datos 1\\copia 17_9_22\\usuarios.csv");
        //Esto es mal, hacer mejor usuaro y meterlo en lista

        for(int i = 0; i <= lectorUsuario.lista_usuarios.size()-1; i++){
            if (txtName.getText().equals(lectorUsuario.lista_usuarios.get(i).getUser()) && usupassword.getText().equals(lectorUsuario.lista_usuarios.get(i).getPassword())){
                showVentanaUsuario(lectorUsuario.lista_usuarios, i);
                break;

            } else{
                popUp.setText("¡Ingrese usuario o contraseña valida!");
            }
        }
    }

    @FXML
    void showVentanaUsuario(List listauser, Integer i) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaUsuario.fxml"));
        Parent root = loader.load();
        WindowUsuario controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventanaUsuario(listauser, i, txtName.getText(), usupassword.getText(), stage, this);
        stage.show();
        popUp.setText("");
        this.stage1.close();
    }

    public void setStage(Stage stage) {
        stage1 = stage;
    }

    public void show(){
        stage1.show();
    }
}

