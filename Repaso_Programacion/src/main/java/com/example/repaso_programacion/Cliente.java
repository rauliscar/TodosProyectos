package com.example.repaso_programacion;

public class Cliente {
    //Atributos
    String id; //Identificador: correo electrónico
    String password;
    double descuento;

    //Constructor sin parámetros
    public Cliente(){}

    //Constructor con parámetros
    public Cliente(String id, String password, double descuento) {
        this.id = id;
        this.password = password;
        this.descuento = descuento;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
