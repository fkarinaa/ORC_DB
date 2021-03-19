package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;


public class Controller {
    @FXML
    private Button open;

    @FXML
    private Button start;

    @FXML
    private TextField text_filed;

    Stage stage;

    @FXML
    void initialization() {
        assert open != null : "fx:id=\"open\" was not injected: check your FXML file 'sample.fxml'.";
        assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'sample.fxml'.";
        assert text_filed != null : "fx:id=\"text_filed\" was not injected: check your FXML file 'sample.fxml'.";


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                stage = (Stage) open.getScene().getWindow();
            }
        });
    }

    public void openAction(javafx.event.ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        File file = fileChooser.showOpenDialog(this.stage);
        if (file != null) {
            this.text_filed.setText(file.getPath());
        }
    }
}