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
            , ArrayList<Casillero> listaCasilleros, int idCliente){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            System.out.println(cActual.getNumero());
            if(cActual.getNumero() == numCasillero){
                Entregable nEntregable = new Entregable(id, estado, descripcion, remitente, registro, sobre);
                ArrayList <Entregable> nuevaLista = cActual.getListaEntregables();
                nuevaLista.add(nEntregable);
                cActual.setListaEntregables(nuevaLista);
                cActual.setEstado(false);
                cActual.setClienteId(idCliente);
                listaEntregables.add(nEntregable);
                return "El entregable ha sido registrado con exito.";
            }   
        }
        return "El numero del casillero ingresado no existe";
    }
    public String registrarEntregables(int id, boolean estado, String descripcion, 
            String remitente, String registro, Paquete paquete, int numCasillero
            , ArrayList<Casillero> listaCasilleros, int idCliente){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero){
                Entregable nEntregable = new Entregable(id, estado, descripcion, remitente, registro, paquete);
                ArrayList <Entregable> nuevaLista = cActual.getListaEntregables();
                nuevaLista.add(nEntregable);
                cActual.setListaEntregables(nuevaLista);
                cActual.setEstado(false);
                cActual.setClienteId(idCliente);
                listaEntregables.add(nEntregable);
                return "El entregable ha sido registrado con exito.";
            }   
        }

        return "El numero del casillero ingresado no existe";
    }
    public String registrarEntregables(int id, boolean estado, String descripcion, 
            String remitente, String registro, Revista revista, int numCasillero
            , ArrayList<Casillero> listaCasilleros, int idCliente){
        for(int i = 0; i < listaCasilleros.size(); i++){
            Casillero cActual = listaCasilleros.get(i);
            if(cActual.getNumero() == numCasillero){
                Entregable nEntregable = new Entregable(id, estado, descripcion, remitente, registro, revista);
                ArrayList <Entregable> nuevaLista = cActual.getListaEntregables();
                nuevaLista.add(nEntregable);
                cActual.setListaEntregables(nuevaLista);
                cActual.setClienteId(idCliente);
                cActual.setEstado(false);
                listaEntregables.add(nEntregable);
                return "El entregable ha sido registrado con exito.";
            }   
        }
        return "El numero del casillero ingresado no existe";
    }
    public String mostrarEstadoCasillero(int numCasillero , ArrayList<Casillero> listaCasilleros){
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
            if(eActual.getRegistro().equals(fechaD )&& eActual.getEstado() == true){
                paquetesEntregados.add(eActual);
            }
        }
        return "El casillero ingresado no fue encontrado";
    }
    /*
    public String detalleArticulosNoRetirados(){
        for(int i = 0; i < listaEntregables.size(); i++){
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getEstado() == false){ //false sin retirar y true retirados
                if(eActual.getPaquete() != null){
                    return eActual.toStringP();
                }
                else if(eActual.getRevista() != null){
                    return eActual.toStringR();
                }
                else if(eActual.getSobre() != null){
                    return eActual.toStringS();
                }
            }
        }
        return "No existen articulos sin retirar";
    }
    public String cobroArticulosRetirados(int id){
        float monto = 0;
        for(int i = 0; i < listaEntregables.size(); i++){
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getEstado() == true && eActual.getId() == id){
                if(eActual.getPaquete() != null){
                    float montoPeso = 0;
                    float montoElectronico = 0;
                    float montoFragil = 0;
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
                    return  "***Detalle***" + "- Monto por peso: " 
                            + montoPeso + "\n" + 
                            "- Monto por ser electronico: " + montoElectronico + 
                            "\n" + "- Monto por ser fragil: " + montoFragil + "\n" + 
                            "Monto total: " + monto; 
                }
                else if(eActual.getRevista() != null){
                    float montoCatalago = 0;
                    if(eActual.getRevista().getCatalogo() == true){
                        montoCatalago+=1;
                        monto+=montoCatalago;
                    }
                    return "***Detalle***" + "- Monto por ser catalago : " 
                            + montoCatalago + "\n" + "Monto total: " + monto;
                }
                else if(eActual.getSobre() != null){
                    float montoDocumento = 0;
                    float montoArticuloPequenos = 0;
                    if(eActual.getSobre().getTipo().equalsIgnoreCase("aereo")){
                        montoArticuloPequenos+=1;
                    }
                    else if(eActual.getSobre().getTipo().equalsIgnoreCase("manila")){
                        montoDocumento+=1;
                        montoArticuloPequenos+=2;
                    }
                    return  "***Detalle***" + "- Monto por documento: " 
                            + montoDocumento + "\n" + 
                            "- Monto por articulo completo: " + montoArticuloPequenos + 
                            "\n" + "Monto total: " + monto; 
                }
            }
        }
        return "No existe el articulo ingresado";
    }
*/
    public ArrayList<Entregable> getListaEntregables() {
        return listaEntregables;
    }

    public void setListaEntregables(ArrayList<Entregable> listaEntregables) {
        this.listaEntregables = listaEntregables;
    }
    
    @Override
    public String toString() {
        return "admEntregables{" + "listaEntregables=" + listaEntregables + '}';
    }
    
}
