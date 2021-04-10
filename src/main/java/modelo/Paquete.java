/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author david
 */
public class Paquete {
    private String entrega;
    private boolean electronico;
    private boolean fragil;
    private float peso;

    public Paquete(String entrega, boolean electronico, boolean fragil, float peso) {
        this.entrega = entrega;
        this.electronico = electronico;
        this.fragil = fragil;
        this.peso = peso;
    }

    public String getEntrega() {
        return entrega;
    }

    public boolean isElectronico() {
        return electronico;
    }

    public boolean isFragil() {
        return fragil;
    }

    public float getPeso() {
        return peso;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public void setElectronico(boolean electronico) {
        this.electronico = electronico;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Paquete [Entrega:" + entrega + ", electronico:" + electronico + ", fragil:" + fragil + ", peso:" + peso + ']';
    }
    
}
