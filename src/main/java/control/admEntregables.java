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
    private int contadorID;
    

    public admEntregables() {
        listaEntregables = new ArrayList<>();
    }
    
    public boolean registrarEntregableSobre(String descripcion,String remitente, String registro,String tipo, String contenido, float peso){
        Sobre nuevoSobre = new Sobre(tipo, contenido, peso); 
        Entregable nuevoEntregable = new Entregable(contadorID,descripcion,remitente,registro,nuevoSobre);
        contadorID+=1;
        listaEntregables.add(nuevoEntregable);
        return true;
    }
    
    public boolean registrarEntregablesPaquete(String descripcion, String remitente,String registro,String entrega,boolean electronico, boolean fragil, float peso){
        Paquete nuevoPaquete = new Paquete(entrega,electronico, fragil, peso);
        Entregable nuevoEntregable = new Entregable(contadorID,descripcion, remitente, registro,nuevoPaquete);
        contadorID+=1;
        listaEntregables.add(nuevoEntregable);
        return true;
    }
    public boolean registrarEntregablesRevista(String descripcion,String remitente, String registro,String nombre,boolean catalogo,String tema, int numCasillero){
        Revista nuevaRevista = new Revista(nombre,catalogo,tema);
        Entregable nuevoEntregable = new Entregable(contadorID,descripcion,remitente,registro,nuevaRevista);
        contadorID+=1;
        return true;
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

    public String detalleArticulosNoRetirados(){
        String mensaje = "";
        for(int i = 0; i < listaEntregables.size(); i++){
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getEstado() == false){
                if(eActual.getPaquete() != null){
                    mensaje += eActual;
                }
                else if(eActual.getRevista() != null){
                    mensaje += eActual;
                }
                else if(eActual.getSobre() != null){
                    mensaje += eActual;
                }
            }
        }
        return mensaje;
    }
    /*
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
