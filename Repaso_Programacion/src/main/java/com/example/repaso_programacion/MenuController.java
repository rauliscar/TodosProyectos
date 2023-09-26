package com.example.repaso_programacion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class MenuController {

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnIngresos;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TextField txtAnuncios;

    @FXML
    private TextField txtDescuento;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPassword;


    //Declaración de la lista
    ArrayList<Cliente> clientes = new ArrayList<>();

    //Acción botón guardar
    @FXML
    void botonGuardar(ActionEvent event){
        if ((txtAnuncios.getText()).isEmpty()){
            Cliente cliente = new Anunciante(txtId.getText(), txtPassword.getText(), Double.parseDouble(txtDescuento.getText()), Integer.parseInt(txtAnuncios.getText()));
            clientes.add(cliente);
        } else {
            Cliente cliente = new Usuario(txtId.getText(), txtPassword.getText(), Double.parseDouble(txtDescuento.getText()), true);
            clientes.add(cliente);
        }
    }

}
