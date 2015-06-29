/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Response;
import Utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author desarrollo
 */
public class DemonioSolicitudServidor extends Thread {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private boolean demon = true;
    
    public DemonioSolicitudServidor(){
    
    }
    
    public void stopThread() throws IOException{
        this.demon = false;
        this.serverSocket.close();
        System.out.println("Se detuvo el servidor");
    }
    
    @Override
    public void run(){
        try{
            
            this.serverSocket = new ServerSocket(Utils.PuertoServidor);
            EnviarSolicitudMulticast enviar = new EnviarSolicitudMulticast();
            enviar.Enviar();
            while (demon){
                
                System.out.println("Esperando peticiones de los servidores por el puerto: " + Utils.PuertoServidor);
                this.socket = this.serverSocket.accept();
                InputStream is = this.socket .getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                Response response = (Response)ois.readObject();
                ManejoServidor manejo = new ManejoServidor(response);
                manejo.start();
                System.out.println( "Peticion recibida de: " +  this.socket.getInetAddress().getHostAddress());
                  
            }
        }catch(Exception e ){
            
        }
    }
    
}
