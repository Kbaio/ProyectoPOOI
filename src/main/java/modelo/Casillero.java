/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.admEntregables;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Casillero {
    private int numero;
    private boolean estado = false;
    private admEntregables listaEntregables = new admEntregables();
    private int clienteId;

    public Casillero() {
    }

    public Casillero(int numero) {
        this.numero = numero;
        
    }
    public int getNumero() {
        return numero;
    }

    public boolean getEstado() {
        return estado;
    }

    public admEntregables getListaEntregables() {
        return listaEntregables;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setListaEntregables(admEntregables listaEntregables) {
        this.listaEntregables = listaEntregables;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    public void vaciarListaEntregables(){
        listaEntregables = new admEntregables();
    }

    @Override
    public String toString() {
        return "Casillero{" + "numero=" + numero + ", estado=" + estado + ", listaEntregables=" + listaEntregables + ", clienteId=" + clienteId + '}';
    }
    

    
}
