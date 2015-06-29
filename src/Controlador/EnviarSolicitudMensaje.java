/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Red;
import Modelo.RespuestaInterfaz;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author LAB_A112
 */
public class EnviarSolicitudMensaje {
    
    public EnviarSolicitudMensaje(){
    
    }
            
    public String SendMessage(RespuestaInterfaz resp){
        
        Socket so;
        try {
            so = new Socket(resp.getIp(), resp.getPuerto());
            DataOutputStream output = new DataOutputStream(so.getOutputStream());
            DataInputStream input = new DataInputStream(so.getInputStream());
            // Escribe el mensaje de salida
            output.writeUTF(resp.getAccion() + " " + resp.getArchivo() + "." + resp.getRed() + "." +  resp.getEquipo() + " " + resp.getMensaje());
            output.flush();
            String message = input.readUTF();
            System.out.println(message);
            return message;
            
        } catch (IOException ex) {
            
        }
       return "Error";
    }
}
