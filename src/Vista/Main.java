/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ListaEquipos;
import Modelo.Red;
import Modelo.Reponse.Response;
import Utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 *
 * @author desarrollo
 */
public class Main {
    
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
    
    public static void main(String [] args) throws IOException
    {
        /*
       InetAddress group = InetAddress.getByName("225.4.5.6");
       MulticastSocket multicastSock = new MulticastSocket();
       String msg = "Hello how a asasre";
       Red red = new Red("Red132s", new ListaEquipos());
       Response response = new Response(red,"");
       byte[] objeto = ObjectToByteArray(response);
       DatagramPacket packet = new DatagramPacket(objeto,objeto.length, group,50890);
       multicastSock.send(packet);
       multicastSock.close();
        */    
        Utils.ventana = new Inicio();
        Utils.ventana.setVisible(true);
    }
    
}
