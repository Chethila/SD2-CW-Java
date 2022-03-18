package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controller {

    @FXML
    Label first2;
    @FXML
    Label surname2;
    @FXML
    Label age2;
    @FXML
    Label city2;
    @FXML
    Label nic2;
    @FXML
    Label vaccine2;

    public void displayFirstName(String username) {
        first2.setText(username);
    }
    public void displaySurname(String Surname) {

        surname2.setText(Surname);
    }
    public void displayAge(String Age) {

        age2.setText(Age);
    }
    public void displayCity(String City) {

        city2.setText(City);
    }
    public void displayNIC(String NIC) {

        nic2.setText(NIC);
    }
    public void displayVaccine(String Vaccine) {

        vaccine2.setText(Vaccine);
    }

}