package com.example.repaso_programacion;

public class Usuario extends Cliente{
    //Atributos
    boolean premium;

    //Constructor sin parámetros
    public Usuario(){}

    //Constructor con parámetros
    public Usuario(String id, String password, double descuento, boolean premium) {
        super(id, password, descuento);
        this.premium = premium;
    }

    //Getter and Setter
    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
