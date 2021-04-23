/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Date;
import modelo.Entregable;
import modelo.Casillero;
import modelo.Cliente;
import modelo.Paquete;
import modelo.Revista;
import modelo.Sobre;
/**
 *
 * @author PC
 */
public class admEntregables {
    private ArrayList<Entregable> listaEntregables; 
    

    public admEntregables() {
        listaEntregables = new ArrayList<>();
    }
    static admCasilleros admCasilleros = new admCasilleros(); // representa la asociación  dirigida
    public String registrarEntregables(int id, boolean estado, String descripcion, 
            String remitente, String registro, Sobre sobre, int numCasillero
            , ArrayList<Casillero> listaCasilleros, int idCliente,
            ArrayList<Cliente> listaClientes, String destinatario){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero){
                Entregable nEntregable = new Entregable(id, estado,
                        descripcion, remitente, registro, sobre, destinatario);
                ArrayList <Entregable> nuevaLista = cActual.getListaEntregables();
                nuevaLista.add(nEntregable);
                cActual.setListaEntregables(nuevaLista);
                cActual.setEstado(false);
                cActual.setClienteId(idCliente);
                listaEntregables.add(nEntregable);
                for(int k = 0; k < listaClientes.size(); k++){
                    Cliente clienteA = listaClientes.get(k);
                    if(clienteA.getId() == idCliente){
                        int numCasilleros = clienteA.getPaquetesRecibidos()+1;
                        clienteA.setPaquetesRecibidos(numCasilleros);
                    }
                }
                return "El entregable ha sido registrado con exito.";
            }   
        }
        return "El numero del casillero ingresado no existe";
    }
    public String registrarEntregables(int id, boolean estado, String descripcion, 
            String remitente, String registro, Paquete paquete, int numCasillero
            , ArrayList<Casillero> listaCasilleros, int idCliente,
            ArrayList<Cliente> listaClientes, String destinatario){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero){
                Entregable nEntregable = new Entregable(id, estado, descripcion,
                        remitente, registro, paquete, destinatario);
                ArrayList <Entregable> nuevaLista = cActual.getListaEntregables();
                nuevaLista.add(nEntregable);
                cActual.setListaEntregables(nuevaLista);
                cActual.setEstado(false);
                cActual.setClienteId(idCliente);
                listaEntregables.add(nEntregable);
                for(int k = 0; k < listaClientes.size(); k++){
                    Cliente clienteA = listaClientes.get(k);
                    if(clienteA.getId() == idCliente){
                        int numCasilleros = clienteA.getPaquetesRecibidos()+1;
                        clienteA.setPaquetesRecibidos(numCasilleros);
                    }
                }
                return "El entregable ha sido registrado con exito.";
            }   
        }

        return "El numero del casillero ingresado no existe";
    }
    public String registrarEntregables(int id, boolean estado, String descripcion, 
            String remitente, String registro, Revista revista, int numCasillero
            , ArrayList<Casillero> listaCasilleros, int idCliente, 
            ArrayList<Cliente> listaClientes, String destinatario){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero){
                Entregable nEntregable = new Entregable(id, estado,
                        descripcion, remitente, registro, revista, destinatario);
                ArrayList <Entregable> nuevaLista = cActual.getListaEntregables();
                nuevaLista.add(nEntregable);
                cActual.setListaEntregables(nuevaLista);
                cActual.setClienteId(idCliente);
                cActual.setEstado(false);
                listaEntregables.add(nEntregable);
                for(int k = 0; k < listaClientes.size(); k++){
                    Cliente clienteA = listaClientes.get(k);
                    if(clienteA.getId() == idCliente){
                        int numCasilleros = clienteA.getPaquetesRecibidos()+1;
                        clienteA.setPaquetesRecibidos(numCasilleros);
                    }
                }
                return "El entregable ha sido registrado con exito.";
            }   
        }
        return "El numero del casillero ingresado no existe";
    }
    public String mostrarEstadoCasillero(int numCasillero,
            ArrayList<Casillero> listaCasilleros){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero || cActual.getClienteId() == numCasillero){
                if(cActual.getListaEntregables().size() == 0){
                    return "Libre";
                }
                else{
                    return "Ocupado";
                }
            } 
        }
        return "No existen casilleros con el numero ingresado.";
    }
    public String detalleArticulosRecibidos(String fecha){
        ArrayList<Entregable> paquetesSinEntregar = new ArrayList<>();
        Date fechaD = new Date(fecha);
        for(int i = 0; i < listaEntregables.size(); i++){
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getRegistro().equals(fechaD) && eActual.getEstado() == false){
                paquetesSinEntregar.add(eActual);
            }
        }
        if(paquetesSinEntregar.size() == 0){
            return "No se encontraron paquetes recibidos en la fecha ingresada.";
        }
        return paquetesSinEntregar.toString();
    }
    public String detalleArticulosRetirados(String fecha){
        ArrayList<Entregable> paquetesEntregados = new ArrayList<>();
        Date fechaD = new Date(fecha);
        for(int i = 0; i < listaEntregables.size(); i++){
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getRegistro().equals(fechaD)&& eActual.getEstado() == true){
                paquetesEntregados.add(eActual);
            }
        }
        if(paquetesEntregados.size() == 0){
            return "No se encontraron paquetes recibidos en la fecha ingresada.";
        }
        return paquetesEntregados.toString();
    }
    public String detalleArticulosNoRetirados(){
        ArrayList<Entregable> paquetesSinEntregar = new ArrayList<>();
        for(int i = 0; i < listaEntregables.size(); i++){
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getEstado() == false){ //false sin retirar y true retirados
                paquetesSinEntregar.add(eActual);
            }
        }
        if(paquetesSinEntregar.size() == 0){
            return "No se encontraron paquetes recibidos en la fecha ingresada.";
        }
        return paquetesSinEntregar.toString();
    }
    public String cobroArticulosRetirados(int idCliente, float descuento){
        float monto = 0;
        float montoTotal = 0;
        float montoPeso = 0;
        float montoElectronico = 0;
        float montoFragil = 0;
        float montoCatalago = 0;
        float montoDocumento = 0;
        float montoArticuloPequenos = 0;
        for(int i = 0; i < listaEntregables.size(); i++){
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getEstado() == true && eActual.getId() == idCliente){
                if(eActual.getPaquete() != null){
                    montoPeso += eActual.getPaquete().getPeso() * 0.02;
                    monto += montoPeso;
                    if(eActual.getPaquete().getElectronico() == true){
                        montoElectronico+=2.0;
                        monto+=montoElectronico;
                    }
                    if(eActual.getPaquete().getFragil() == true){
                        montoFragil += 2.0;
                        monto+=montoFragil;
                    }                             
                }
                else if(eActual.getRevista() != null){                
                    if(eActual.getRevista().getCatalogo() == false){
                        montoCatalago+=1;
                        monto+=montoCatalago;
                    }
                }
                else if(eActual.getSobre() != null){
                    if(eActual.getSobre().getContenido().equalsIgnoreCase("documento")){
                        if(eActual.getSobre().getTipo().equalsIgnoreCase("manila")){
                            montoDocumento+=1;
                            monto+=montoDocumento;
                        }
                    }
                    else if(eActual.getSobre().getContenido().equalsIgnoreCase("articulo pequeño")){
                        if(eActual.getSobre().getTipo().equalsIgnoreCase("aereo")){
                            montoArticuloPequenos+=1;
                        }
                        else if(eActual.getSobre().getTipo().equalsIgnoreCase("manila")){
                            montoArticuloPequenos+=2;
                        }
                        monto+=montoArticuloPequenos;
                    }
                }    
            }
        }
        montoTotal+=monto;
        montoTotal-=monto*descuento;
        return "******Detalle de factura******\n" +
         "     Montos sobres    \n" 
        +"- Monto por documento: "+ montoDocumento + "\n" + 
        "- Monto por articulo pequeño: " + montoArticuloPequenos + "\n" + 
        "\n    Montos paquetes   \n"
         + "- Monto por peso: "+ montoPeso + "\n"
        + "- Monto por ser electronico: " + montoElectronico + 
        "\n" + "- Monto por ser fragil: " + montoFragil + "\n" + 
        "\n   Montos revistas    \n"+
        "- Monto por ser catalago : " + montoCatalago + "\n" +
         "\n" + "    Subtotal:    " + monto +
        "\n" + "    Descuento:    " + descuento +
        "\n" + "    Monto total:  " + montoTotal; 

    }
    public String reporteContable(String fecha, float descuento){
        float montoImpuestos = 0;
        float montoDescuentos = 0;
        float montoTotal = 0;
        for(int i = 0; i < listaEntregables.size(); i++){
            float montoCliente = 0;
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getRetiro().equals(fecha)){
                if(eActual.getPaquete() != null){
                    montoCliente += eActual.getPaquete().getPeso() * 0.02;
                    if(eActual.getPaquete().getElectronico() == true){
                        montoCliente+=2.0;
                    }
                    if(eActual.getPaquete().getFragil() == true){
                        montoCliente += 2.0;
                    }                             
                }
                else if(eActual.getRevista() != null){                
                    if(eActual.getRevista().getCatalogo() == false){
                        montoCliente+=1;
                    }
                }
                else if(eActual.getSobre() != null){
                    if(eActual.getSobre().getContenido().equalsIgnoreCase("documento")){
                        if(eActual.getSobre().getTipo().equalsIgnoreCase("manila")){
                            montoCliente+=1;
                        }
                    }
                    else if(eActual.getSobre().getContenido().equalsIgnoreCase("articulo pequeño")){
                        if(eActual.getSobre().getTipo().equalsIgnoreCase("aereo")){
                            montoCliente+=1;
                        }
                        else if(eActual.getSobre().getTipo().equalsIgnoreCase("manila")){
                            montoCliente+=2;
                        }
                    }
                }
                montoImpuestos+=montoCliente;
                montoDescuentos+=montoCliente - (montoCliente*descuento);
            }
        }
        montoTotal+=(montoImpuestos-montoDescuentos);
        return "******Resumen Contable******\n" +
                "- Monto impuestos: " + montoImpuestos +
                "- Monto Descuentos: " + montoDescuentos +
                "- Monto total: " + montoTotal;

    }
    
    public ArrayList<Entregable> getListaEntregables() {
        return listaEntregables;
    }

    public void setListaEntregables(ArrayList<Entregable> listaEntregables) {
        this.listaEntregables = listaEntregables;
    }
    /*
    public String clientesPaquetesPendientes(){
      for(int i = 0; i < listaEntregables.size(); i++){
        Entregable eActual = listaEntregables.get(i);
        if(eActual.getEstado() == false){ //false sin retirar y true retirados
            eActual.get;
        }
      }  
    }
    */
    @Override
    public String toString() {
        return "admEntregables{" + "listaEntregables=" + listaEntregables + '}';
    }
    
}
