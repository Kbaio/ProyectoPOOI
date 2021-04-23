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
public class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String sexo;
    private Date fechaNacimiento;
    private int numeroCasillero;
    private int paquetesRecibidos = 0;

    public Cliente() {
    }
    //nuevo
    public Cliente(int id, String nombre, String correo, String telefono, String direccion, String sexo, String fechaNacimiento, int numeroCasillero) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sexo = sexo;
        this.fechaNacimiento = new Date (fechaNacimiento);
        this.numeroCasillero = numeroCasillero;
    }

    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public int getNumeroCasillero() {
        return numeroCasillero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getPaquetesRecibidos() {
        return paquetesRecibidos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }

    public void setFechaNacimiento(String sFecha){ 
        fechaNacimiento = new Date(sFecha);
    }

    public void setPaquetesRecibidos(int paquetesRecibidos) {
        this.paquetesRecibidos = paquetesRecibidos;
    }

    public void setNumeroCasillero(int numeroCasillero) {
        this.numeroCasillero = numeroCasillero;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", numeroCasillero=" + numeroCasillero + ", paquetesRecibidos=" + paquetesRecibidos + '}';
    }
    
}
