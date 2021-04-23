/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        public boolean validarNumero(String numero){
       Pattern patron = Pattern.compile("^\\d{4}-?\\d{4}$");
       Matcher matcher = patron.matcher(numero);
       return matcher.matches();
       
    }
    public boolean validarCorreo(String correo){
       Pattern patron = Pattern.compile("^([da-z_.-]+)@([da-z.-]+).([a-z.]{2,6})$");
       Matcher matcher = patron.matcher(correo);
       return matcher.matches();
       
    }  
    //nuevo
    public boolean agregarCliente(int id, String nombre,
            String correo, String telefono, String direccion,
            String sexo, String fechaNacimiento, int numCasillero)
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
    public String modificarClienteNombre(int id, String nombreNuevo){
        Cliente cConsultado = consultaCliente(id);
        if(cConsultado != null){
            cConsultado.setNombre(nombreNuevo);
            return "El nombre fue modificado con exito.";
        }
        return "El nombre del cliente no pudo ser modificado.";
    }
    public String modificarClienteCorreo(int id, String correoNuevo){
        Cliente cConsultado = consultaCliente(id);
        if(cConsultado != null){
            if(validarCorreo(correoNuevo) == true){
                cConsultado.setCorreo(correoNuevo);
                return "El correo fue modificado con exito.";
            }
            else{
                return "El formato del correo no es valido coloque una dirrecion de correo correcta.";
            }
        }
        return "El correo del cliente no pudo ser modificado.";
    }
    public String modificarClienteTelefono(int id, String telefonoNuevo){
        Cliente cConsultado = consultaCliente(id);
        if(cConsultado != null){
            if(validarNumero(telefonoNuevo) == true){
                cConsultado.setTelefono(telefonoNuevo);
                return "El telefono del cliente fue modificado con exito.";
            }
            else{
                return "El formato del telefono no es valido debe ser de 8 digitos.";
            }
        }
        return "El telefono del cliente no pudo ser modificado.";
    }
    public String modificarClienteDireccion(int id, String direccionNueva){
        Cliente cConsultado = consultaCliente(id);
        if(cConsultado != null){
            cConsultado.setDireccion(direccionNueva);
            return "La direccion fue modificada con exito.";
        }
        return "La direccion del cliente no pudo ser modificada.";
    }
    public String modificarClienteSexo(int id, String sexoNuevo){
        Cliente cConsultado = consultaCliente(id);
        if(cConsultado != null){
            cConsultado.setSexo(sexoNuevo);
            return "El sexo fue modificado con exito.";
        }
        return "La sexo del cliente no pudo ser modificada.";
    }
    public String modificarClienteFecha(int id, String fechaNueva){
        Cliente cConsultado = consultaCliente(id);
        if(cConsultado != null){
            cConsultado.setFechaNacimiento(fechaNueva);
            return "La fecha denacimiento fue modificada con exito.";
        }
        return "La fecha de nacimiento del cliente no pudo ser modificada.";
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

    public float determinarDescuento(int nombreId){
        for(int i = 0; i < listaClientes.size(); i++){
            Cliente cActual = listaClientes.get(i);
            if(cActual.getId() == nombreId){
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
