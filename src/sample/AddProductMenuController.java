package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class AddProductMenuController {

    @FXML
    private RadioButton shirt;

    @FXML
    private RadioButton pants;

    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField productQuantity;

    @FXML
    private Button addButton;

    public void addProduct(Event event){
        if(productName != null && productPrice != null && productQuantity != null) {
            Clothing c;

            if(shirt.isSelected()){
                c = new Clothing(ClothingType.SHIRT, productName.getText(), Double.parseDouble(productPrice.getText()), Integer.parseInt(productQuantity.getText()));
            }else{
                c = new Clothing(ClothingType.PANTS, productName.getText(), Double.parseDouble(productPrice.getText()), Integer.parseInt(productQuantity.getText()));
            }

            try {
                InventoryMainMenuController.insertClothing(c);
                ConfirmationPopUpController.inputName(c.getName());
                Parent list = FXMLLoader.load(getClass().getResource("ConfirmationPopUp.fxml"));
                Scene addProductScene = new Scene(list);
                Stage addProductStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                addProductStage.hide();
                addProductStage.setScene(addProductScene);
                //adminStage.setTitle("Admin Panel");
                addProductStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            productName.setText("No input");
            productName.setStyle("-fx-text-inner-color: red;");
            productPrice.setText("0");
            productQuantity.setText("0");
        }
    }
    public void cancelEntry(Event event){
        try {
            Parent list = FXMLLoader.load(getClass().getResource("InventoryMainMenu.fxml"));
            Scene cancelScene = new Scene(list);
            Stage cancelStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            cancelStage.hide();
            cancelStage.setScene(cancelScene);
            //adminStage.setTitle("Admin Panel");
            cancelStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
