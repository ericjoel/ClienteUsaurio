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
    
    public ManejoServidor(Response response){
        this.response = response;
    }
    
    private void ManejarRespuesta(){
        if (!response.getError().equals("") ){
            System.out.println("Error " + response.getError());
            return;
        }
        for (Red red : Utils.Utils.redes.getLista()) {
            if(red.getNombre().equals(response.getRed().getNombre())){
                red.setNombre(response.getRed().getNombre());
                red.setListaEquipos(response.getRed().getListaEquipos());
                return;
            }
        }
        Utils.Utils.redes.getLista().add(response.getRed());
        Utils.Utils.ventana.AddItemComboRed(response.getRed());
    }

    @Override
    public void run(){
        this.ManejarRespuesta();
    }
}
