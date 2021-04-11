/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;

/**
 *
 * @author david
 */
public class Entregables {
    private int id;
    private boolean estado;
    private String descripcion;
    private String remitente;
    private Calendar retiro;
    private Calendar registro;
    // IMPLEMENTAR INRERFAZ
   //------------------------------- 
    private Sobre sobre;
    private Paquete paquete;
    private Revista revista;
    //----------------------------
    public Entregables(int id, boolean estado, String descripcion, String remitente, Calendar registro, Sobre sobre, Paquete paquete, Revista revista) {
        this.id = id;
        this.estado = estado;
        this.descripcion = descripcion;
        this.remitente = remitente;
        this.registro = registro;
        this.sobre = sobre;
        this.paquete = paquete;
        this.revista = revista;
    }

    public int getId() {
        return id;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRemitente() {
        return remitente;
    }

    public Calendar getRetiro() {
        return retiro;
    }

    public Calendar getRegistro() {
        return registro;
    }

    public Sobre getSobre() {
        return sobre;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public void setRetiro(Calendar retiro) {
        this.retiro = retiro;
    }

    public void setRegistro(Calendar registro) {
        this.registro = registro;
    }

    public void setSobre(Sobre sobre) {
        this.sobre = sobre;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }    
    
}
