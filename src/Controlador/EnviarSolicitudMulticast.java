/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Response;
import Utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author LAB_A112
 */
public class EnviarSolicitudMulticast {
    public EnviarSolicitudMulticast(){
    
    }
    public static byte[] ObjectToByteArray(Response response) throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
          out = new ObjectOutputStream(bos);   
          out.writeObject(response);
          byte[] yourBytes = bos.toByteArray();
          return yourBytes;
        } finally {
          try {
            if (out != null) {
              out.close();
            }
          } catch (IOException ex) {
            // ignore close exception
          }
          try {
            bos.close();
          } catch (IOException ex) {
            // ignore close exception
          }
        }
    }
    
    
    public void Enviar(){
        try{
            InetAddress group = InetAddress.getByName("225.4.5.6");
            MulticastSocket multicastSock = new MulticastSocket();
            Response response = new Response(null,"");
            response.setPuertoCliente(Utils.PuertoServidor);
            byte[] objeto = ObjectToByteArray(response);
            DatagramPacket packet = new DatagramPacket(objeto,objeto.length, group,Utils.puertoClienteUDP);
            multicastSock.send(packet);
            multicastSock.close();
        }
        catch(Exception ex){
        
        }
     }
}
