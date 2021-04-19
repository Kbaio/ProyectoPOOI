/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.counter;
import control.admClientes;

/**
 *
 * @author PC
 */
public class FramePrincipal {
    /**
     * Deci...
     */
    public FramePrincipal() {
    }
    static counter Counter = new counter("Counter Prinicipal", "1-8785-7249", "San Jose", 10); 
    static admClientes AdmClientes = new admClientes();
    
    public static void main(String[] args) {
        // TODO code application logic here
        //Prueba parte 1
        System.out.println("******Agregar casilleros******");
        System.out.println(Counter.agregarCasilleros(10));
        System.out.println(Counter.toString());
        System.out.println("\n");
        
        //Prueba parte 2
            //Agregar
        System.out.println("******Agregar clientes******");
        System.out.println(Counter.registrarCliente(10, "Gabriel Fallas Lopez", "gabrielfallas@gmail.com", "8400-5213", "San Jose", "M", "2002/03/08"));
        
        System.out.println(Counter.registrarCliente(100, "Esteban Quesada", "equesada@gmail.com", "87549856", "San Jose", "M", "2002/03/08"));
        System.out.println("Casilleros: " + Counter.getLCasilleros());
        System.out.println(Counter.getLClientes());
            //modificacion faltante
            //Consultar
        System.out.println("******Consultar clientes******");
        System.out.println(Counter.consultarCliente(100));
        System.out.println("\n");
            //Eliminar
        System.out.println("******Eliminar clientes******");    
        System.out.println(Counter.eliminarCliente(10));
        System.out.println(Counter.getLClientes());
        System.out.println(Counter.getLCasilleros());
        System.out.println("\n");
       
        //Prueba parte 3
        System.out.println("******Agregar entregables******");
        //Sobre
        System.out.println(Counter.agregarEntregable(22, false, "Muy pesado",
                "Alonso Quesada", "2021/04/18", "aereo", "documentacion",
                (float) 7.50, 1000, 100));
        //Paquete
        System.out.println(Counter.agregarEntregable(24, false, "Liviano",
                "Sebastian Lopez", "2020/10/10", "En caja", true, true,
                (float) 5.4, 1001, 100));
        //Revista
        System.out.println(Counter.agregarEntregable(15, false, "Nueva",
                "Lautaro Martinez", "2000/12/12", "Sport", true, "Deportes",
                1000, 100));
        //Probar repetido
        System.out.println(Counter.agregarEntregable(15, false, "Vieja",
                "Allen Guevara", "1999/10/07", "Hola", true, "Moda", 1000, 100));
        System.out.println("\n");
        System.out.println(Counter.getLEntregables());
        System.out.println("\n");
        
        
        //Prueba parte 4
        System.out.println("******Retiro de articulos******");
        System.out.println(Counter.retiroArticulos(15));
        
        
        //Prueba parte 5
        System.out.println("******Administracion de entregables******");
            //Estado
        System.out.println("Estado del casillero: " + Counter.getEstadoCasillero(100));
        System.out.println(Counter.getLEntregables());
            //Recibidos segun fecha particular
        System.out.println(Counter.getRecibidosFecha("1999/10/07"));
    }
    
}
