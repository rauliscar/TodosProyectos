package com.example.repaso_programacion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private ToggleGroup premium;

    @FXML
    private RadioButton toggleNoPremium;

    @FXML
    private RadioButton togglePremium;

    @FXML
    private TextField txtAnuncios;

    @FXML
    private TextField txtDescuento;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPassword;


    //Declaración de la(s) lista(s)
            //ArrayList<Cliente> clientes = new ArrayList<>();   **He comentado la lista porque voy a hacer una lista para anunciantes y otra para usuarios
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Anunciante> anunciantes = new ArrayList<>();

    //Acción botón guardar
    @FXML
    void botonGuardar(ActionEvent event){
        //Si el campo anuncios contratados está vacío, se crea un objeto cliente de tipo usuario, si está relleno se crea de tipo anunciante
        if ((txtAnuncios.getText()).isEmpty()){
            //Evaluamos si el usuario que se ha introducido es premium o no es premium para después añadirle a la lista
            boolean isPremium = true;
            if (toggleNoPremium.isSelected()){
                isPremium = false;
            }
            //Se añade a la lista como usuario
            Usuario usuario = new Usuario(txtId.getText(), txtPassword.getText(), Double.parseDouble(txtDescuento.getText()), isPremium);
            usuarios.add(usuario);
        } else {
            //Se añade a la lista como anunciante
            Anunciante anunciante = new Anunciante(txtId.getText(), txtPassword.getText(), Double.parseDouble(txtDescuento.getText()), Integer.parseInt(txtAnuncios.getText()));
            anunciantes.add(anunciante);
        }

        for (Cliente c: usuarios) {
            System.out.println(c.getId());
            System.out.println(c.getPassword());
            System.out.println("-----------------");
        }

    }

    //Acción botón limpiar
    @FXML
    void botonLimpiar(ActionEvent event){
        txtId.setText(null);
        txtPassword.setText(null);
        txtDescuento.setText(null);
        txtAnuncios.setText(null);
        togglePremium.setSelected(false);
        toggleNoPremium.setSelected(false);
    }

    //Acción botón Buscar
    @FXML
    void botonBuscar(ActionEvent event){
        //Primero se borran los campos diferentes al identificador para después ser sobreescritos
        txtPassword.setText(null);
        txtDescuento.setText(null);
        txtAnuncios.setText(null);
        togglePremium.setSelected(false);
        toggleNoPremium.setSelected(false);

        //Si el ArrayList usuarios se encuentra vacío se lanza un error informando
        if (!usuarios.isEmpty()){
            //Se recoge el identificador en una variable
            String id = txtId.getText();

            //Se genera una variable boolean para en caso de no existir el "id", lanzar un error.
            boolean idExists = false;

            //Se genera el contador 'i' para saber la posición en el array de la coincidencia
            int i = 0;

            //Se recorre el ArrayList y se buscan coincidencias
            for (Cliente c: usuarios) {
                if (id.equalsIgnoreCase(c.getId())){
                    //Se cambia la variable a true porque ha encontrado una coincidencia
                    idExists = true;
                    //Le quito uno a i porque se va a incrementar después
                    i-=1;
                }
                i++;
            }

            //Si el 'id' existe, se muestra la información, si no, se muestra un error
            if (idExists){
                //Se coge el número 'i' anterior y se busca en la posición del array
                txtPassword.setText(usuarios.get(i).getPassword());
                txtDescuento.setText(String.valueOf(usuarios.get(i).getDescuento()));
                txtAnuncios.setText("Al ser usuario no puede contratar anuncios.");
                if (usuarios.get(i).isPremium()){
                    togglePremium.setSelected(true);
                } else {
                    toggleNoPremium.setSelected(true);
                }
            } else {
                //Se informa de que no se ha encontrado ninguna coincidencia
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("No se ha encontrado ninguna coincidencia, pruebe a buscar de nuevo");
                alert.showAndWait();
            }
        } else {
            //Se informa de que está vacío
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("La lista de usuarios está vacía");
            alert.showAndWait();
        }

    }

}























