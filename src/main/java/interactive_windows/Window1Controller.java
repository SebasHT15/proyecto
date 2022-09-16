package interactive_windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import listClasses.Reader;

import java.io.IOException;


public class Window1Controller {
    private Stage stage1;
    @FXML
    private TextField txtName;
    @FXML
    private TextField usupassword;
    @FXML
    private Label popUp;


    @FXML
    public void cheking() throws IOException {
        listClasses.Reader lector_usuarios = new Reader();


        String name = "Juan";
        String password = "12";
        //Esto es mal, hacer mejor usuaro y meterlo en lista

        if (txtName.getText().equals(name) && usupassword.getText().equals(password)){
            showVentanaUsuario();

        } else{
            popUp.setText("¡Ingrese usuario o contraseña valida!");
            //System.out.println("hola");
        }
    }

    @FXML
    void showVentanaUsuario() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaUsuario.fxml"));
        Parent root = loader.load();
        Window2Controller controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init_ventanaUsuario(txtName.getText(), usupassword.getText(), stage, this);
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

