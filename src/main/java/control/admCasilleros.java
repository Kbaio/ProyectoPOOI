/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import modelo.Casillero;
import modelo.Entregable;

/**
 *
 * @author david
 */
public class admCasilleros {
    private ArrayList<Casillero> listaCasilleros; 

    public admCasilleros() {
        listaCasilleros = new ArrayList<>();
    }
    
    /**
     *Esta funcion se encarga de crear los casilleros requeridos en un counter,  
     *se recibe el numero de casilleros que se quiere añadir y automaticamente
     *los crea y los añade a la lista de casilleros.
     * 
     * @param numCasilleros
     * @return booleano true o false
     */
    public boolean agregarCasilleros(int numCasilleros){
        int primero = 1000;
        for(int i = 0; i < numCasilleros; i++){
            Casillero nCasillero = new Casillero(primero+i);
            listaCasilleros.add(nCasillero);
        }
        return true;
    }
    
    /**
     * Esta funcion se encarga de agregar un entregable a un casillero en especifico,
     * se recibe el numero de casillero al que se quiere agregar y el entregable que 
     * se agregara al casillero.
     * @param numCasillero
     * @param nuevoEntregable
     * @return true o false
     */
    public boolean agregarEntregableSobre(String descripcion, String remitente, String registro,String tipo, String contenido, float peso,int numCasillero){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero & cActual.getEstado() != false)
            {
                
                return cActual.getListaEntregables().registrarEntregableSobre(descripcion, remitente, registro, tipo, contenido, peso);
            }
        }
        return false;
    }
    
    public boolean agregarEntregablePaquete(String descripcion, String remitente,
            String registro,String entrega, boolean electronico, boolean fragil, float peso, int numCasillero){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero & cActual.getEstado() != false)
            {
                return cActual.getListaEntregables().registrarEntregablesPaquete(descripcion, remitente, registro, entrega, electronico, fragil, peso);
            }
        }
        return false;
    }
    
    public boolean agregarEntregableRevista(boolean estado,String descripcion, String remitente,String registro,String nombre, boolean catalago, String tema, int numCasillero){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero & cActual.getEstado() != false)
            {
               return cActual.getListaEntregables().registrarEntregablesRevista(descripcion, remitente, registro, nombre, catalago, tema, numCasillero);
            }
        }
        return false;
    }
    
    //--------------------------Modificado-----------------------
    public String mostrarEstadoCasillero(int numCasillero){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getEstado()==false){
                    return "Libre";
                }
                else{
                    return "Ocupado";
                }
            } 
        return "No existen casilleros con el numero ingresado.";
    }

    /**
     * 
     * @param numCasillero
     * @return 
     */
    public boolean modificarEstado(int numCasillero){
        for(int i = 0; i < listaCasilleros.size(); i++)
        {
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero)
            {
                cActual.setEstado(!cActual.getEstado());
                cActual.setClienteId(0);
                cActual.vaciarListaEntregables();
                return true;
            } 
        }
        return false;
    }
    //--------------------------Modificado-----------------------   
    public ArrayList<Casillero> getListaCasilleros() {
        return listaCasilleros;
    }

    @Override
    public String toString() {
        return "admCasilleros{" + "listaCasilleros=" + listaCasilleros + '}';
    }
    
    
}
