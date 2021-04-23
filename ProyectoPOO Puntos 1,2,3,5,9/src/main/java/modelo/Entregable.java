/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author david
 */
public class Entregable {
    private int id;
    private boolean estado;
    private String descripcion;
    private String remitente;
    private String destinatario;
    private Date retiro;
    private Date registro;
    // IMPLEMENTAR INRERFAZ
   //------------------------------- 
    private Sobre sobre;
    private Paquete paquete;
    private Revista revista;
    //----------------------------

    public Entregable(int id, boolean estado, String descripcion,
            String remitente, String registro, Sobre sobre, String destinatario) {
        this.id = id;
        this.estado = estado;
        this.descripcion = descripcion;
        this.remitente = remitente;
        this.registro = new Date(registro);
        this.sobre = sobre;
        this.destinatario = destinatario;
    }
    

    public Entregable(int id, boolean estado, String descripcion,
            String remitente, String registro, Paquete paquete, String destinatario) {
        this.id = id;
        this.estado = estado;
        this.descripcion = descripcion;
        this.remitente = remitente;
        this.registro = new Date(registro);
        this.paquete = paquete;
        this.destinatario = destinatario;
    }

    public Entregable(int id, boolean estado, String descripcion,
            String remitente, String registro, Revista revista, String destinatario) {
        this.id = id;
        this.estado = estado;
        this.descripcion = descripcion;
        this.remitente = remitente;
        this.registro = new Date(registro);
        this.revista = revista;
        this.destinatario = destinatario;
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

    public Date getRetiro() {
        return retiro;
    }

    public Date getRegistro() {
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

    public void setRetiro(Date retiro) {
        this.retiro = retiro;
    }

    public void setRegistro(Date registro) {
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

    @Override
    public String toString() {
        return "Entregable{" + "id=" + id + ", estado=" + estado 
                + ", descripcion=" + descripcion + ", remitente=" + remitente 
                + ", retiro=" + retiro + ", registro=" + registro + ", sobre=" 
                + sobre + ", paquete=" + paquete + ", revista=" + revista +
                ",destinatario=" + destinatario + '}';
    }
    
    

    
}
