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
public class Counter {
    private String nombre;
    private int cedula;
    private String Direccion;
    private ArrayList<Casillero> listaCasilleros = new ArrayList();
    private ArrayList<Cliente> listaClientes = new ArrayList();

    public Counter(String nombre, int cedula, String Direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.Direccion = Direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return Direccion;
    }

    public ArrayList<Casillero> getListaCasilleros() {
        return listaCasilleros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setListaCasilleros(ArrayList<Casillero> listaCasilleros) {
        this.listaCasilleros = listaCasilleros;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
