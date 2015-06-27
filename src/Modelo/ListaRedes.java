/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author desarrollo
 */
public class ListaRedes implements Serializable {
    private ArrayList<Red> lista;

    public ListaRedes(ArrayList<Red> lista) {
        this.lista = lista;
    }

    public ArrayList<Red> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Red> lista) {
        this.lista = lista;
    }
    
    public ListaEquipos buscarEquipos(Red red){
        
        Iterator<Red> iterator = lista.iterator();
        
        while(iterator.hasNext()){
            Red redActual = iterator.next();
            if (redActual.getNombre().equals(red.getNombre()))
                return redActual.getListaEquipos();            
        }
        
        return null;
        
    }
}
