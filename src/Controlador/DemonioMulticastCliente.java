/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Response;
import Utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAB_A112
 */
public class DemonioMulticastCliente extends Thread {
    private Object convertFromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
    try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
         ObjectInput in = new ObjectInputStream(bis)) {
        return in.readObject();
    } 
}
    
    @Override
    public void run(){
    
        try { 
            InetAddress grupo = InetAddress.getByName("225.4.5.15");
            MulticastSocket socket = new MulticastSocket(Utils.PuertoClient);
            
            socket.joinGroup(grupo);

            byte[] bufer = new byte[1000];

            while (true) {
                DatagramPacket mensajeEntrada = new DatagramPacket(bufer, bufer.length);
                System.out.println("Esperando red nueva...");
                socket.receive(mensajeEntrada);

                Response respuesta = (Response)this.convertFromBytes(mensajeEntrada.getData());
                
                ManejoServidor manejo = new ManejoServidor(respuesta);
                manejo.setIp(mensajeEntrada.getAddress().getHostAddress());
                manejo.setPuerto(respuesta.getRed().getPuerto());
                manejo.start();
                
                System.out.println("Recibida nueva solicitud:" + respuesta.getRed().getNombre());
            }
        }   
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
}
