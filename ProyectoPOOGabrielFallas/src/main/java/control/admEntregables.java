/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import modelo.Entregable;
import control.admCasilleros;
import java.util.Calendar;
import java.util.Date;
import modelo.Casillero;
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
    public boolean mostrarEstadoCasillero(int numCasillero){
        for(int i = 0; i < admCasilleros.getListaCasilleros().size(); i++){
            Casillero cActual = admCasilleros.getListaCasilleros().get(i);
            if(cActual.getNumero() == numCasillero || cActual.getClienteId() == numCasillero){
                boolean estado = cActual.getEstado();
                return true;
            }
            
        }
        return false;
    }
    public String detalleArticulosRecibidos(Calendar fecha){
        for(int i = 0; i < listaEntregables.size(); i++){
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getRegistro() == fecha){
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
        return "El casillero ingresado no fue encontrado";
    }
    public String detalleArticulosRetirados(Calendar fecha){
        for(int i = 0; i < listaEntregables.size(); i++){
            Entregable eActual = listaEntregables.get(i);
            if(eActual.getRetiro() == fecha){
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
        return "El casillero ingresado no fue encontrado";
    }
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
