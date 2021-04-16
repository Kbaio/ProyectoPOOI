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
    private ArrayList<Entregable> listaEntregables = new ArrayList();
    //nuevo
    private int clienteId;

    public Casillero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public boolean getEstado() {
        return estado;
    }

    public ArrayList<Entregable> getListaEntregables() {
        return listaEntregables;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setListaEntregables(ArrayList<Entregable> listaEntregables) {
        this.listaEntregables = listaEntregables;
    }
    //nuevo

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    

    
}
