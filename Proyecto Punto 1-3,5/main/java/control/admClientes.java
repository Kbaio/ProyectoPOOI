/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import modelo.Cliente;


/**
 *
 * @author david
 */
public class admClientes {
    private ArrayList<Cliente> listaClientes; 

    public admClientes() {
        listaClientes = new ArrayList<>();
    }
    //nuevo
    public boolean agregarCliente(int id, String nombre, String correo, String telefono, String direccion, String sexo, String fechaNacimiento, int numCasillero)
    {
        for(int i = 0; i < listaClientes.size(); i++)
        {
            Cliente cActual = listaClientes.get(i);
            if(cActual.getId() == id){
                return false;
            }
        }
        Cliente nuevoCliente = new Cliente(id,nombre,correo,telefono,direccion,sexo,fechaNacimiento, numCasillero); 
        listaClientes.add(nuevoCliente);
        return true;
    }
    
    public Cliente consultaCliente(int id)
    {
        for(int i = 0 ; i < listaClientes.size(); i++)
        {
            Cliente cActual = listaClientes.get(i);
            if(cActual.getId() == id)
            {
                return cActual;
            }
        }
        return null;
    }
    
    public boolean eliminarCliente(int id)
    {
        for(int i = 0; i < listaClientes.size();i++)
        {
            Cliente cActual = listaClientes.get(i);
            if(cActual.getId() == id)
            {
                listaClientes.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean asignarCasillero(int id,int numcasillero){
                for(int i = 0; i < listaClientes.size();i++){
                Cliente cActual = listaClientes.get(i);
                if(cActual.getId() == id)
                {
                    cActual.setNumeroCasillero(numcasillero);
                    return true;
                }
        }
        return false;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public float determinarDescuento(String nombreCliente){
        for(int i = 0; i < listaClientes.size(); i++){
            Cliente cActual = listaClientes.get(i);
            if(cActual.getNombre().equalsIgnoreCase(nombreCliente)){
                int numPaquetes = cActual.getPaquetesRecibidos();
                if(numPaquetes >= 10){
                    return (float) 0.05;
                }
                else if(numPaquetes >= 20){
                    return (float) 0.1;
                }
                else{
                    return 0;
                }
            }
        }
        return 0;
    }
    @Override
    public String toString() {
        return "admClientes{" + "listaClientes=" + listaClientes + '}';
    }
    
}
