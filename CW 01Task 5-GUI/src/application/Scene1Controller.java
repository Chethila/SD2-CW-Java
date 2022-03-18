package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {

    @FXML
    TextField first;
    @FXML
    TextField surname;
    @FXML
    TextField age;
    @FXML
    TextField city;
    @FXML
    TextField nic;
    @FXML
    TextField vaccine;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void clear() {
        first.clear();
        surname.clear();
        age.clear();
        city.clear();
        nic.clear();
        vaccine.clear();
    }

    public void generate(ActionEvent event) throws IOException {

        String firstName = first.getText();
        String lastName = surname.getText();
        String userAge = age.getText();
        String userCity = city.getText();
        String userNIC = nic.getText();
        String userVaccine = vaccine.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root = loader.load();

        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.displayFirstName(firstName);
        scene2Controller.displaySurname(lastName);
        scene2Controller.displayAge(userAge);
        scene2Controller.displayCity(userCity);
        scene2Controller.displayNIC(userNIC);
        scene2Controller.displayVaccine(userVaccine);
        //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}