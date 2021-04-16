/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Calendar;
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
    public boolean agregarCliente(int id, String nombre, String correo, int telefono, String direccion, char sexo, Calendar fechaNacimiento, int numCasillero)
    {
        for(int i = 0; i < listaClientes.size(); i++)
        {
            Cliente cActual = listaClientes.get(i);
            if(cActual.getId() == id)
            {
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
}