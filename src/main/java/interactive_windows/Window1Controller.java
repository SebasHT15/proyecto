package interactive_windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Window1Controller {
    private Stage stage1;
    @FXML
    private TextField txtName;
    @FXML
    private TextField usupassword;

    @FXML
    void showVentanaUsuario() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaUsuario.fxml"));
        Parent root = loader.load();
        Window2Controller controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(txtName.getText(), usupassword.getText(), stage, this);
        stage.show();
        this.stage1.close();
    }

    public void setStage(Stage stage) {
        stage1 = stage;
    }

    public void show(){
        stage1.show();
    }
}
