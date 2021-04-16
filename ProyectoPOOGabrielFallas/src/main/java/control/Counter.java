/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Calendar;
import modelo.Casillero;
import modelo.Cliente;

/**
 *
 * @author david
 */
public class Counter {
    private String nombre;
    private int cedula;
    private String Direccion;
    private admCasilleros admCasilleros = new admCasilleros();
    private admClientes admClientes = new admClientes();

    public Counter() {
    }
    
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
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /*
    Esta funcion hace la llamada al agregar casilleros del admCasilleros.
    */
    public boolean agregarCasilleros(int numeroCasilleros){
        admCasilleros.agregarCasilleros(numeroCasilleros);
        return true;
    }
    
    public int casilleroDisponible()
        /*
        Esta funcion se encarga de recorrer la lista de casilleros y 
        retorna el primer casillero disponible que encuentre, en caso de no encontrar
        un casillero disponible retorna un 0.
        */
    {
        ArrayList<Casillero> listaCasilleros = admCasilleros.getListaCasilleros();
        for(int i = 0; i < listaCasilleros.size();i++)
        {
           Casillero cActual =  listaCasilleros.get(i);
           if(cActual.getEstado() == false)
           {
               return cActual.getNumero();
           }
        }
        return 0;
    }
    
    public boolean registrarCliente(int id, String nombre, String correo, int telefono, String direccion, char sexo, Calendar fechaNacimiento)
        /*
        Esta funcion se encarga de agregar un cliente con los datos requeridos 
        y asigna un casillero automaticamente, tambien cambia el estado del 
        casillero a ocupado.
        */
    {
        int casillero = casilleroDisponible();
        if(casillero != 0)
        {
            admCasilleros.modificarEstado(casillero);
            admClientes.agregarCliente(id, nombre, correo, telefono, direccion, sexo, fechaNacimiento, casillero);
            return true;
        }
        return false;
    }
    
    public Cliente consultarCliente(int id)
    {
        return admClientes.consultaCliente(id);
    }
    
    public boolean eliminarCliente(int id)
    {
        
        Cliente cEliminar = admClientes.consultaCliente(id);
        if(cEliminar != null){
            admCasilleros.modificarEstado(cEliminar.getNumeroCasillero());
            admClientes.eliminarCliente(id);
            return true;
        }
        return false;
    }
    
   /* public boolean modificarCliente(int valorEditar,int id)
    {
        Cliente cModificar = admClientes.consultaCliente(id);
        if(cModificar != null)
        {
            
        }
    }*/
    
}
