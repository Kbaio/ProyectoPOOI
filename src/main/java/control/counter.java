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
import modelo.Correo;
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
    private admCasilleros admCasilleros = new admCasilleros();
    private admClientes admClientes = new admClientes();
    private int numCasilleros;

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
    
    /**
     * Esta funcion hace la llamada al agregar casilleros del admCasilleros.
     * @param numeroCasilleros
     * @return 
     */
    public boolean agregarCasilleros(int numeroCasilleros){
        admCasilleros.agregarCasilleros(numeroCasilleros);
        System.out.println(admCasilleros.toString());
        return true;
    }
    /**
     * Esta funcion se encarga de recorrer la lista de casilleros y 
     * retorna el primer casillero disponible que encuentre, en caso de no encontrar
     * un casillero disponible retorna un 0.
     * @param id
     * @return 
     */
    public int casilleroDisponible(int id)
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
    /**
     * Esta Funcion verifica que el numero ingrsado tenga 8 caracreres
     * @param numero
     * @return 
     */
    public boolean validarNumero(String numero){
       Pattern patron = Pattern.compile("^\\d{4}-?\\d{4}$");
       Matcher matcher = patron.matcher(numero);
       return matcher.matches();
       
    }
    /**
     * Esta funcion verifica que se meta un correo valido
     * @param correo
     * @return 
     */
    public boolean validarCorreo(String correo){
       Pattern patron = Pattern.compile("^([da-z_.-]+)@([da-z.-]+).([a-z.]{2,6})$");
       Matcher matcher = patron.matcher(correo);
       return matcher.matches();
       
    }
    //-------------------Modificado----------------------------------------
    
    /**
     * Esta funcion verifica que el nuevo cliente no sea uno ya existente.
     * @param id
     * @return 
     */
    public boolean verificarUsuario(int id)
    {
        ArrayList<Casillero> listaCasilleros = admCasilleros.getListaCasilleros();
        for(int k =0; k< listaCasilleros.size();k++){
            Casillero cActual =  listaCasilleros.get(k);
            if(cActual.getClienteId() == id){
                return  false;
            }
        }
        return true;
    }
    
    /**
     * Esta funcion se encarga de agregar un cliente con los datos requeridos 
     * y asigna un casillero automaticamente, tambien cambia el estado del 
     * casillero a ocupado.
     * @param id
     * @param nombre
     * @param correo
     * @param telefono
     * @param direccion
     * @param sexo
     * @param fechaNacimiento
     * @return 
     */
    public String registrarCliente(int id, String nombre, String correo,String telefono, 
            String direccion, String sexo,String fechaNacimiento){
        if(verificarUsuario(id) == true)
        {
            if(validarNumero(telefono) == true)
            {
                if(validarCorreo(correo) == true)
                {
                    int casillero = casilleroDisponible(id);
                    if(casillero != 0)
                    {
                        admClientes.agregarCliente(id, nombre, correo, telefono,direccion, sexo, fechaNacimiento, casillero);
                        return "El usuario pudo ser registrado con exito.\nEl numero de casillero asignado es el: " + casillero;
                    }
                    return "No hay Casilleros Disponibles";
                }
                return "El formato del correo electronico no es valido.";
            }
            return "El formato del numero telefonico no es valido, su longitud debe ser de 8 digitos.";
        }
       return  "La identificacion ya esta asociada a un casillero.";
    }
    //-----------------------Modificado------------------------------------------
    //**********************************************************************
    public Cliente consultarCliente(int id)
    {
        return admClientes.consultaCliente(id);
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
    //**********************************************************************  
    //--------------------------Modificado---------------------------------------------
    public boolean agregarEntregableSobre(String descripcion, String remitente, 
            String registro,String tipo,String contenido, float peso, int numCasillero, int idCliente){
        if(consultarCliente(idCliente)!= null)
            return admCasilleros.agregarEntregableSobre(descripcion, remitente, registro, tipo, contenido, peso, numCasillero);
        return false;
    }
    
    public boolean agregarEntregablePaquete(String descripcion, String remitente, 
            String registro,String entrega, boolean electronico, boolean fragil, float peso, int numCasillero , int idCliente){
        if(consultarCliente(idCliente)!= null)
            return admCasilleros.agregarEntregablePaquete(descripcion, remitente, registro, entrega, electronico, fragil, peso, numCasillero);
        return false;
    }
    
    public boolean agregarEntregableRevista(boolean estado,String descripcion, String remitente,
            String registro,String nombre, boolean catalago, String tema, int numCasillero, int idCliente){
        if(consultarCliente(idCliente)!= null)
            return admCasilleros.agregarEntregableRevista(estado, descripcion, remitente, registro, nombre, catalago, tema, numCasillero);
        return false;
    }
    //----------------------------Modificado-------------------------------------------    
    public void enviarCorreo(int id){
        Cliente clienteActual =  admClientes.consultaCliente(id);
        Casillero casilleroActual = admCasilleros.getListaCasilleros().get(id);
        
        Correo nuevoCorreo = new Correo(clienteActual.getCorreo(),casilleroActual.getListaEntregables().detalleArticulosNoRetirados());
        nuevoCorreo.enviarCorreo();
    }
    
    //-----------------------------modificado----------------------------------------------
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
    
    public String getEstadoCasillero(int numCasillero){
        return admEntregables.mostrarEstadoCasillero(numCasillero, getLCasilleros());
    }
    public String getRecibidosFecha(String fecha){
        return admEntregables.detalleArticulosRecibidos(fecha);
    }
    public String getEntregadosFecha(String fecha){
        return admEntregables.detalleArticulosRecibidos(fecha);
    }
    @Override
    public String toString() {
        return "counter{" + "nombre=" + nombre + ", cedula=" + cedula + ", Direccion=" + Direccion + ", numCasilleros=" + numCasilleros + '}';
    }
    
}
