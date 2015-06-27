/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JFrame;

/**
 *
 * @author desarrollo
 */
public class PaginaPadre extends JFrame {
    
    private JFrame Padre;

    public PaginaPadre(JFrame Padre) {
        this.Padre = Padre;     
        this.setVisible(true);
        this.Padre.setVisible(false);
    }
    
    public void Dispose(){
        this.Padre.setVisible(true);
        this.dispose();
    }

    public JFrame getPadre() {
        return Padre;
    }

    public void setPadre(JFrame Padre) {
        this.Padre = Padre;
    }    
    
}
