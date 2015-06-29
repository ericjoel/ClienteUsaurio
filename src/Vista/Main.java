/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DemonioMulticastCliente;
import Utils.Utils;
import java.io.IOException;

/**
 *
 * @author desarrollo
 */
public class Main {
 
    public static void main(String [] args) throws IOException
    {
       DemonioMulticastCliente cliente = new DemonioMulticastCliente();
       cliente.start();
          
       Utils.ventana = new Inicio();
       Utils.ventana.setVisible(true);
    }
    
}
