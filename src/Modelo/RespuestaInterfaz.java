/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author desarrollo
 */
public class RespuestaInterfaz implements Serializable{
    
    private String Red;
    private String Equipo;
    private String Archivo;
    private String Mensaje;
    private String ip;
    private int puerto;
    private String accion;

    public RespuestaInterfaz(String Red, String Equipo, String Mensaje) {
        this.Red = Red;
        this.Equipo = Equipo;
        this.Mensaje = Mensaje;
    }

    public String getArchivo() {
        return Archivo;
    }

    public void setArchivo(String Archivo) {
        this.Archivo = Archivo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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

    public String getRed() {
        return Red;
    }

    public void setRed(String Red) {
        this.Red = Red;
    }

    public String getEquipo() {
        return Equipo;
    }

    public void setEquipo(String Equipo) {
        this.Equipo = Equipo;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
}
