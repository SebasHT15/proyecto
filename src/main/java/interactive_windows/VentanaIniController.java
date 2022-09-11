package interactive_windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaIniController {
    private Stage stage1;
    @FXML
    private TextField txtName;

    @FXML
    void showVentanaUsuario(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VentanaUsuario.fxml"));
        Parent root = loader.load();
        VentanaUsuController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(txtName.getText(), stage, this);
        stage.show();
        this.stage1.close();
    }

    public void setStage(Stage stage) {
        stage1 = stage;
    }
}