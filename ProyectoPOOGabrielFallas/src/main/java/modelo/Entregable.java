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
public class Entregable {
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
    public Entregable(int id, boolean estado, String descripcion, String remitente, Calendar registro, Sobre sobre) {
        this.id = id;
        this.estado = estado;
        this.descripcion = descripcion;
        this.remitente = remitente;
        this.registro = registro;
        this.sobre = sobre;
    }

    public Entregable(int id, boolean estado, String descripcion, String remitente, Calendar retiro, Calendar registro, Paquete paquete) {
        this.id = id;
        this.estado = estado;
        this.descripcion = descripcion;
        this.remitente = remitente;
        this.retiro = retiro;
        this.registro = registro;
        this.paquete = paquete;
    }

    public Entregable(int id, boolean estado, String descripcion, String remitente, Calendar retiro, Calendar registro, Revista revista) {
        this.id = id;
        this.estado = estado;
        this.descripcion = descripcion;
        this.remitente = remitente;
        this.retiro = retiro;
        this.registro = registro;
        this.revista = revista;
    }
    

    public int getId() {
        return id;
    }

    public boolean getEstado() {
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

    public String toStringS() {
        return "Entregable{" + "id=" + id + ", estado=" + estado 
                + ", descripcion=" + descripcion + ", remitente=" 
                + remitente + ", retiro=" + retiro + ", registro=" + registro 
                + ", sobre=" + sobre + '}';
    }
    public String toStringP() {
        return "Entregable{" + "id=" + id + ", estado=" + estado 
                + ", descripcion=" + descripcion + ", remitente=" 
                + remitente + ", retiro=" + retiro + ", registro=" + registro 
                + ", paquete=" + paquete + '}';
    }
    public String toStringR() {
        return "Entregable{" + "id=" + id + ", estado=" + estado 
                + ", descripcion=" + descripcion + ", remitente=" 
                + remitente + ", retiro=" + retiro + ", registro=" + registro 
                + ", revista=" + revista + '}';
    }
    

    
}
