/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Casillero {
    private int numero;
    private boolean estado = false;
    private ArrayList<Entregables> listaEntregables = new ArrayList();

    public Casillero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public ArrayList<Entregables> getListaEntregables() {
        return listaEntregables;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setListaEntregables(ArrayList<Entregables> listaEntregables) {
        this.listaEntregables = listaEntregables;
    }
}
