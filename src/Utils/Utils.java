/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Modelo.ListaRedes;
import Vista.Inicio;
import javax.swing.JFrame;

/**
 *
 * @author desarrollo
 */
public class Utils {
    public static int puertoClienteUDP = 56500;
    public static String IpServidor = "";
    public static int PuertoServidor  = 50001;
    public static int PuertoClient = 50002;
    public static boolean AplicacionIniciada = false;
    public static ListaRedes redes = new ListaRedes();
    public static Inicio ventana;
    
    
}
