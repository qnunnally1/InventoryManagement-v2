package sample;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryListController {

    public void backToMainMenu(Event event){
        try {
            Parent list = FXMLLoader.load(getClass().getResource("InventoryMainMenu.fxml"));
            Scene mainScene = new Scene(list);
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainStage.hide();
            mainStage.setScene(mainScene);
            //adminStage.setTitle("Admin Panel");
            mainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void editEntry(Event event){
        try {
            Parent list = FXMLLoader.load(getClass().getResource("EditEntry.fxml"));
            Scene editScene = new Scene(list);
            Stage editStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            editStage.hide();
            editStage.setScene(editScene);
            //adminStage.setTitle("Admin Panel");
            editStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
