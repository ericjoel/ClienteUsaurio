/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Red;
import Modelo.Response;
import java.util.Iterator;

/**
 *
 * @author desarrollo
 */
public class ManejoServidor extends Thread {
    private Response response;
    private String ip;
    private int puerto;
    
    public ManejoServidor(Response response){
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    
    private void ManejarRespuesta(){
        if (!response.getError().equals("") ){
            System.out.println("Error " + response.getError());
            return;
        }
        
        for (Red red : Utils.Utils.redes.getLista()) {
            if(red.getNombre().equals(response.getRed().getNombre())){
                red.setIp(ip);
                red.setPuerto(puerto);
                red.setNombre(response.getRed().getNombre());
                red.setListaEquipos(response.getRed().getListaEquipos());                
                return;
            }
        }
        response.getRed().setIp(ip);
        response.getRed().setPuerto(puerto);
        Utils.Utils.redes.getLista().add(response.getRed());
        Utils.Utils.ventana.AddItemComboRed(response.getRed());
    }

    @Override
    public void run(){
        this.ManejarRespuesta();
    }
}
