/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private int telefono;
    private String direccion;
    private char sexo;
    private Calendar fechaNacimiento;
    private int paquetesRecibidos = 0;

    public Cliente(int id, String nombre, String correo, int telefono, String direccion, char sexo, Calendar fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
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

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public char getSexo() {
        return sexo;
    }

    public Calendar getFechaNacimiento() {
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

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSexo(char Sexo) {
        this.sexo = Sexo;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPaquetesRecibidos(int paquetesRecibidos) {
        this.paquetesRecibidos = paquetesRecibidos;
    }
}
