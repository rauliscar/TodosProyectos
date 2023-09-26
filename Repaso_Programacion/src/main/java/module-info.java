module com.example.repaso_programacion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.repaso_programacion to javafx.fxml;
    exports com.example.repaso_programacion;
}