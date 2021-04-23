/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Casillero;
import modelo.Cliente;
import modelo.Entregable;
import modelo.Paquete;
import modelo.Revista;
import modelo.Sobre;

/**
 *
 * @author david
 */
public class counter {
    private String nombre;
    private String cedula;
    private String Direccion;
    private int numCasilleros;
    private admCasilleros admCasilleros = new admCasilleros();
    private admClientes admClientes = new admClientes();
    private admEntregables admEntregables = new admEntregables();

    public counter() {
    }

    public counter(String nombre, String cedula, String Direccion, int numCasilleros) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.Direccion = Direccion;
        this.numCasilleros = numCasilleros;
    }


    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public String getDireccion() {
        return Direccion;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getNumCasilleros() {
        return numCasilleros;
    }

    public void setNumCasilleros(int numCasilleros) {
        this.numCasilleros = numCasilleros;
    }
    public ArrayList<Casillero> getLCasilleros(){
        return admCasilleros.getListaCasilleros();
    }
    public ArrayList<Cliente> getLClientes(){
        return admClientes.getListaClientes();
    }
    public ArrayList<Entregable> getLEntregables(){
        return admEntregables.getListaEntregables();
    }
    /*
    Esta funcion hace la llamada al agregar casilleros del admCasilleros.
    */
    public boolean agregarCasilleros(int numeroCasilleros){
        admCasilleros.agregarCasilleros(numeroCasilleros);
        System.out.println(admCasilleros.toString());
        return true;
    }
    
    public int casilleroDisponible(int id)
        /*
        Esta funcion se encarga de recorrer la lista de casilleros y 
        retorna el primer casillero disponible que encuentre, en caso de no encontrar
        un casillero disponible retorna un 0.
        */
    {
        ArrayList<Casillero> listaCasilleros = admCasilleros.getListaCasilleros();
        for(int i = 0; i < listaCasilleros.size();i++){
           Casillero cActual =  listaCasilleros.get(i);
           if(cActual.getEstado() == false){
               cActual.setClienteId(id);
               cActual.setEstado(true);
               return cActual.getNumero();
           }
        }
        return 0;
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
    public String registrarCliente(int id, String nombre, String correo,  
            String telefono, String direccion, String sexo, 
            String fechaNacimiento){
        /*
        Esta funcion se encarga de agregar un cliente con los datos requeridos 
        y asigna un casillero automaticamente, tambien cambia el estado del 
        casillero a ocupado.
        */
        ArrayList<Casillero> listaCasilleros = admCasilleros.getListaCasilleros();
        for(int k =0; k< listaCasilleros.size();k++){
            Casillero cActual =  listaCasilleros.get(k);
            if(cActual.getClienteId() == id){
                return  "La identificacion ya esta asociada a un casillero.";
            }
        }
        int casillero = casilleroDisponible(id);
        if(casillero != 0){
            if(validarNumero(telefono) == true){
                if(validarCorreo(correo) == true){
                    admClientes.agregarCliente(id, nombre, correo, telefono, 
                        direccion, sexo, fechaNacimiento, casillero);
                    return "El usuario pudo ser registrado con exito.\n"
                            + "El numero de casillero asignado es el: " + casillero;
                }
                else{
                    return "El formato del correo electronico no es valido.";
                }
            }
            else{
                return "El formato del numero telefonico no es valido, su longitud "
                        + "debe ser de 8 digitos.";
            }
        }
        return "No existen casilleros disponibles.";
    }
    public Cliente consultarCliente(int id){
        return admClientes.consultaCliente(id);
    }
    
    public String modificarCCedula(int id, String nuevaCedula){
        return admClientes.modificarClienteCorreo(id, nuevaCedula);
    }
    public String modificarCDireccion(int id, String nuevaDireccion){
        return admClientes.modificarClienteDireccion(id, nuevaDireccion);
    }
    public String modificarCNombre(int id, String nuevoNombre){
        return admClientes.modificarClienteNombre(id, nuevoNombre);
    }
    public String modificarCSexo(int id, String nuevoSexo){
        return admClientes.modificarClienteSexo(id, nuevoSexo);
    }
    public String modificarCTelefono(int id, String nuevoTelefono){
        return admClientes.modificarClienteTelefono(id, nuevoTelefono);
    }
    public String modificarCFecha(int id, String nuevaFecha){
        return admClientes.modificarClienteFecha(id, nuevaFecha);
    }
    
    public boolean eliminarCliente(int id){
        Cliente cEliminar = admClientes.consultaCliente(id);
        if(cEliminar != null){
            admCasilleros.modificarEstado(cEliminar.getNumeroCasillero());
            admClientes.eliminarCliente(id);
            return true;
        }
        return false;
    }
    
    /*
    public boolean modificarCliente(int valorEditar,int id){
        Cliente cModificar = admClientes.consultaCliente(id);
        if(cModificar != null){
            
        }
    }
    */
    public String agregarEntregableSobre(int id, boolean estado,
            String descripcion, String remitente, String registro, 
            String tipo, String contenido, float peso, int numCasillero,
            int idCliente, String destinatario){
        Sobre nSobre = new Sobre(tipo, contenido, peso); 
        return admEntregables.registrarEntregables(id, estado, descripcion, remitente,
                registro, nSobre, numCasillero, getLCasilleros(), idCliente, 
                getLClientes(), destinatario);
    }
    public String agregarEntregablePaquete(int id, boolean estado,
            String descripcion, String remitente, String registro, 
            String entrega, boolean electronico, boolean fragil, float peso,
            int numCasillero , int idCliente, String destinatario){
        Paquete nPaquete = new Paquete(entrega, electronico, fragil, peso); 
        return admEntregables.registrarEntregables(id, estado, descripcion, remitente,
                registro, nPaquete, numCasillero, getLCasilleros(), 
                idCliente, getLClientes(), destinatario);
    }
    public String agregarEntregableRevista(int id, boolean estado,
            String descripcion, String remitente, String registro, 
            String nombre, boolean catalago, String tema, int numCasillero,
            int idCliente, String destinatario){
        Revista nRevista = new Revista(nombre, catalago, tema); 
        return admEntregables.registrarEntregables(id, estado, descripcion, remitente,
                registro, nRevista, numCasillero, getLCasilleros(), 
                idCliente, getLClientes(), destinatario);
    }
    /**
     * Decip
     * @param id es
     * @return 
     */
    public String retiroArticulos(int id){
        ArrayList<Entregable> paquetesSinEntregar = new ArrayList<>();
        for(int i = 0; i < getLEntregables().size();i++){
           Entregable cEntregables =  getLEntregables().get(i);
           if(cEntregables.getEstado() == false && cEntregables.getId() == id){
               paquetesSinEntregar.add(cEntregables);
           }
        }
        return paquetesSinEntregar.toString();
    }
    public String getEntregablesPendientes(){
        return admEntregables.detalleArticulosNoRetirados();
    }
    public String getEstadoCasillero(int numCasillero){
        return admEntregables.mostrarEstadoCasillero(numCasillero, getLCasilleros());
    }
    public String getRecibidosFecha(String fecha){
        return admEntregables.detalleArticulosRecibidos(fecha);
    }
    public String getEntregadosFecha(String fecha){
        return admEntregables.detalleArticulosRetirados(fecha);
    }
    public String getCobroPaquetes(int id){
        float descuento = admClientes.determinarDescuento(id);
        return admEntregables.cobroArticulosRetirados(id, descuento);
    }
    @Override
    public String toString() {
        return "counter{" + "nombre=" + nombre + ", cedula=" + cedula + ", Direccion=" + Direccion + ", numCasilleros=" + numCasilleros + '}';
    }
    
}
