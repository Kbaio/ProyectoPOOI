/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Calendar;
import modelo.Casillero;
import modelo.Entregable;
import modelo.Paquete;
import modelo.Revista;
import modelo.Sobre;

/**
 *
 * @author david
 */
public class admCasilleros {
    private ArrayList<Casillero> listaCasilleros; 

    public admCasilleros() {
        listaCasilleros = new ArrayList<>();
    }
    
    public boolean agregarCasilleros(int numCasilleros)
        /*
        Esta funcion se encarga de crear los casilleros requeridos en un counter, 
        se recibe el numero de casilleros que se quiere añadir y automaticamente 
        los crea y los añade a la lista de casilleros.
        */
    {
        int primero = 1000;
        for(int i = 0; i < numCasilleros; i++)
        {
            Casillero nCasillero = new Casillero(primero+i);
            listaCasilleros.add(nCasillero);
        }
        return true;
    }
    
    public boolean agregarEntregable(int numCasillero,Entregable nuevoEntregable){
        /*
        Esta funcion se encarga de agregar un entregable a un casillero en especifico, 
        se recibe el numero de casillero al que se quiere agregar y el entregable que 
        se agregara al casillero.
        */
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero & cActual.getEstado() != false)
            {
                cActual.getListaEntregables().add(nuevoEntregable);
                return true;
            }
        }
        return false;
    }
    
    public boolean modificarEstado(int numCasillero){
        for(int i = 0; i < listaCasilleros.size(); i++)
        {
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero)
            {
                cActual.setEstado(!cActual.getEstado());
                return true;
            } 
        }
        return false;
    }
    //nuevo
    public ArrayList<Casillero> getListaCasilleros() {
        return listaCasilleros;
    }

    public void setListaCasilleros(ArrayList<Casillero> listaCasilleros) {
        this.listaCasilleros = listaCasilleros;
    }
    
    
}