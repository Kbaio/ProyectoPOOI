/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author david
 */
public class Sobre {
    private String tipo;
    private String contenido;
    private float peso;

    public Sobre(String tipo, String contenido, float peso) {
        this.tipo = tipo;
        this.contenido = contenido;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public float getPeso() {
        return peso;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Sobre[tipo:" + tipo + "\ncontenido:" + contenido + "\npeso=" + peso+"]";
    }
}
