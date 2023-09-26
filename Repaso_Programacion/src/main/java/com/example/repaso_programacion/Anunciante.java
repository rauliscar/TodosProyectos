package com.example.repaso_programacion;

public class Anunciante extends Cliente{
    //Atributos
    int nAnuncios;

    //Constructor sin parámetros
    public Anunciante(){}

    //Constructor con parámetros
    public Anunciante(String id, String password, double descuento, int nAnuncios) {
        super(id, password, descuento);
        this.nAnuncios = nAnuncios;
    }

    //Getter and Setter
    public int getnAnuncios() {
        return nAnuncios;
    }

    public void setnAnuncios(int nAnuncios) {
        this.nAnuncios = nAnuncios;
    }
}
