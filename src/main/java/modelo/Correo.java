/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
/**
 *
 * @author david
 */
public class Correo {
    private String to;
    private String mensaje;
    private String from = "maildummy400@gmail.com";
    private String password = "Contrasena480";
    private Properties properties = System.getProperties();
    private Session session;

    public Correo(String to,String mensaje) {
        this.to = to;
        this.mensaje = mensaje;
    }
    
    /**
     * Esta funcion se encarga de crear las propiedades para 
     * el servidor.
     */
    private void setupServerProperties(){
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }
    
    /**
     * Esta funcion se utiliza para crear la session.
     */
    private void setupSession(){
        this.session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication("maildummy400@gmail.com", "Contrasena480");
            }
        });
    }
    
    /**
     * Esta funcion se encarga de juntar todos los otros elementos 
     * y se encarga de enviar el correo.
     * 
     * @return un booleano
     */
    public boolean enviarCorreo(){
        setupServerProperties();
        setupSession();
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Casillero con paquets");
            message.setText("Estimado Cliente, se le informa que tiene paquetes pendientes en su casillero:\n"+mensaje);
            Transport.send(message);
            return true;
        }catch(MessagingException mex){
            mex.printStackTrace();
            return false;
        }
    }
}
