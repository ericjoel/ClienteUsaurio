/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DemonioSolicitudServidor;
import Controlador.EnviarSolicitudMensaje;
import Modelo.Archivo;
import Modelo.Equipo;
import Modelo.ListaEquipos;
import Modelo.Red;
import Modelo.RespuestaInterfaz;
import Utils.Utils;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author desarrollo
 */
public class Inicio extends javax.swing.JFrame {
    private DemonioSolicitudServidor servidor;
    private String accionAnterior = "";
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        this.accionAnterior = "Crear";
        initComponents();
        PromptSupport.setPrompt("Nombre archivo", this.jTextFieldNombreArchivo);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, this.jTextFieldNombreArchivo);
        
        PromptSupport.setPrompt("Mensaje archivo", this.jTextAreaMensaje);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, this.jTextAreaMensaje);
        InicializarComboConsultar();
    }   

    public void AddItemComboRed(Red red){
        if (red.getNombre() != null)
            this.jComboBoxRed.addItem(red.getNombre());
        JOptionPane.showMessageDialog(this, "Se ha agregado una nueva red");
    }
    
    private void InicializarComboConsultar(){
        this.jComboBoxConsultar = new javax.swing.JComboBox();
        jComboBoxConsultar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un archivo" }));
        jComboBoxConsultar.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxConsultarItemStateChanged(evt);
            }
        });
        this.jComboBoxConsultar.setVisible(false);    
    }
    
    private void Layout(){
        this.jComboBoxConsultar.setVisible(true);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonIniciarAplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDetenerAplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jButtonEnviarMensaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxEquipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxConsultar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxRed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxAccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEnviarMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonIniciarAplicacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDetenerAplicacion)
                .addGap(12, 12, 12))
        );
        pack();
        setLocationRelativeTo(null);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonIniciarAplicacion = new javax.swing.JButton();
        jButtonDetenerAplicacion = new javax.swing.JButton();
        jButtonEnviarMensaje = new javax.swing.JButton();
        jTextFieldNombreArchivo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMensaje = new javax.swing.JTextArea();
        jComboBoxAccion = new javax.swing.JComboBox();
        jComboBoxRed = new javax.swing.JComboBox();
        jComboBoxEquipo = new javax.swing.JComboBox();
        jMenuInicio = new javax.swing.JMenuBar();
        jMenuPrincipal = new javax.swing.JMenu();
        jItemConfiguracion = new javax.swing.JMenuItem();
        jItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setResizable(false);

        jButtonIniciarAplicacion.setText("Iniciar Aplicación");
        jButtonIniciarAplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarAplicacionActionPerformed(evt);
            }
        });

        jButtonDetenerAplicacion.setText("Detener Aplicación");
        jButtonDetenerAplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetenerAplicacionActionPerformed(evt);
            }
        });

        jButtonEnviarMensaje.setText("Enviar mensaje");
        jButtonEnviarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarMensajeActionPerformed(evt);
            }
        });

        jTextFieldNombreArchivo.setToolTipText("Nombre del archivo");
        jTextFieldNombreArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreArchivoActionPerformed(evt);
            }
        });

        jTextAreaMensaje.setColumns(20);
        jTextAreaMensaje.setLineWrap(true);
        jTextAreaMensaje.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMensaje);

        jComboBoxAccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crear", "Consultar", "Modificar", "Eliminar" }));
        jComboBoxAccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAccionItemStateChanged(evt);
            }
        });
        jComboBoxAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAccionActionPerformed(evt);
            }
        });

        jComboBoxRed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una red" }));
        jComboBoxRed.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRedItemStateChanged(evt);
            }
        });

        jComboBoxEquipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un equipo" }));

        jMenuPrincipal.setText("Archivo");
        jMenuPrincipal.setToolTipText("");

        jItemConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/configure_shortcuts.png"))); // NOI18N
        jItemConfiguracion.setText("Configuracion");
        jItemConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemConfiguracionActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jItemConfiguracion);

        jItemSalir.setText("Salir");
        jItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemSalirActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jItemSalir);

        jMenuInicio.add(jMenuPrincipal);

        setJMenuBar(jMenuInicio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonIniciarAplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEnviarMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxEquipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNombreArchivo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxRed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxAccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jButtonDetenerAplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jButtonEnviarMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonIniciarAplicacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDetenerAplicacion)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jItemConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jItemConfiguracionActionPerformed
        Configuracion configuracion = new Configuracion(this);
    }//GEN-LAST:event_jItemConfiguracionActionPerformed

    private void jItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jItemSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jItemSalirActionPerformed

    private void jButtonIniciarAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarAplicacionActionPerformed
        if (Utils.AplicacionIniciada){
            JOptionPane.showMessageDialog(this, "La aplicación ya se inicio");
            return;
        }
        Utils.AplicacionIniciada = true;
        if (Utils.PuertoServidor <  50000){
            JOptionPane.showMessageDialog(this, "El puerto debe ser mayor a 50000");
            return;
        }            
        
        servidor = new DemonioSolicitudServidor();
        servidor.start();
        
        JOptionPane.showMessageDialog(this, "Se inicio la aplicación");
    }//GEN-LAST:event_jButtonIniciarAplicacionActionPerformed

    private void jButtonEnviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarMensajeActionPerformed
        if (!Utils.AplicacionIniciada){
            JOptionPane.showMessageDialog(this, "Debe iniciar la aplicación.");
            return;
        }
        EnviarSolicitudMensaje mensaje = new EnviarSolicitudMensaje();
        
      //  RespuestaInterfaz respuesta = new RespuestaInterfaz()
        mensaje.SendMessage(null);
                
    }//GEN-LAST:event_jButtonEnviarMensajeActionPerformed

    private void jTextFieldNombreArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreArchivoActionPerformed

    private void jComboBoxAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAccionActionPerformed

    private void jComboBoxAccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAccionItemStateChanged
        
        String accion = (String)this.jComboBoxAccion.getSelectedItem();
        
        this.jTextAreaMensaje.setEnabled(true);
        this.jTextFieldNombreArchivo.setVisible(true);
        this.jComboBoxConsultar.setVisible(false);
        if (accion.equals("Crear")){
            this.jTextFieldNombreArchivo.setText("");
            this.jTextAreaMensaje.setText("");
            this.jComboBoxEquipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione un equipo" }));
            this.jComboBoxEquipo.setEnabled(true);
            this.jComboBoxRed.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una red" }));               
            this.jComboBoxRed.setEnabled(true);
            Iterator iteratorRed = Utils.redes.getLista().iterator();
            while (iteratorRed.hasNext()){
                Red redTem = (Red) iteratorRed.next();
                this.jComboBoxRed.addItem(redTem.getNombre());                
            }
            
        }
        if (!accion.equals("Crear")){
            this.jComboBoxConsultar.setVisible(true);
            this.jTextFieldNombreArchivo.setVisible(false);
            
            Layout();
        }        
        if (accion.equals("Eliminar") || accion.equals("Consultar")){
            this.jTextAreaMensaje.setEnabled(false);            
        }
        if (accion.equals("Eliminar") || accion.equals("Consultar") || accion.equals("Modificar")){
            
            if (this.accionAnterior.equals("Crear")){
                this.jComboBoxEquipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione un equipo" }));
                this.jComboBoxEquipo.setEnabled(false);
                this.jComboBoxRed.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una red" }));
                this.jComboBoxRed.setEnabled(false);
                this.jComboBoxConsultar.setModel(new DefaultComboBoxModel(new String[] { "Seleccione un archivo" }));
                for (Archivo archivo : Utils.redes.obtenerArchivos().getLista()){
                    this.jComboBoxConsultar.addItem(archivo.getNombre() + "." + archivo.getExtension());
                }            
                this.jTextAreaMensaje.setText("");
            }
            this.jTextAreaMensaje.setEnabled(false);
            if(accion.equals("Modificar")){
                this.jTextAreaMensaje.setEnabled(true);
            }            
            
        }
        this.accionAnterior = accion;
        


    }//GEN-LAST:event_jComboBoxAccionItemStateChanged

    private void jButtonDetenerAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetenerAplicacionActionPerformed
        if (this.servidor != null){
            try {
                Utils.AplicacionIniciada = false;
                this.servidor.stopThread();
                JOptionPane.showMessageDialog(this, "Se detuvo la aplicación");
            } catch (IOException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }             
    }//GEN-LAST:event_jButtonDetenerAplicacionActionPerformed

    private void jComboBoxRedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRedItemStateChanged
        
        String red = (String)this.jComboBoxRed.getSelectedItem();
        
        if (red.equals("Seleccione una red")){
            this.jComboBoxEquipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione un equipo" }));
            return;
        }        
        Red redTemp = new Red(red,null);  
        ListaEquipos equipos = Utils.redes.buscarEquipos(redTemp);
        this.jComboBoxEquipo.removeAllItems();
        this.jComboBoxEquipo.addItem("Seleccione un equipo");
        Iterator iterator = equipos.getLista().iterator();
        while(iterator.hasNext()){
            Equipo temp = (Equipo) iterator.next();
            this.jComboBoxEquipo.addItem(temp.getNumero());
        }
    }//GEN-LAST:event_jComboBoxRedItemStateChanged
    
    private void jComboBoxConsultarItemStateChanged(java.awt.event.ItemEvent evt) {       
       String archivo = (String)this.jComboBoxConsultar.getSelectedItem();
       if(archivo.equals("Seleccione un archivo")){
           this.jComboBoxRed.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una red" }));
           this.jComboBoxEquipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione un equipo" }));
           this.jTextAreaMensaje.setText("");
           return;
       }
       
       Archivo temp = new Archivo(archivo,"","");
       RespuestaInterfaz resp = Utils.redes.buscarArchivo(temp);
       
       Iterator iterator = Utils.redes.getLista().iterator();      
       this.jComboBoxRed.setModel(new DefaultComboBoxModel(new String[] { "Seleccione una red" }));
       while (iterator.hasNext()){
           Red red = (Red)iterator.next();
           this.jComboBoxRed.addItem(red.getNombre());
       }
       for(int i = 0; i < this.jComboBoxRed.getItemCount(); i++){
           String red = (String)this.jComboBoxRed.getItemAt(i);
           if (red.equals(resp.getRed())){
                this.jComboBoxRed.setSelectedIndex(i);
                break;
           }           
        }
        Red redTemp = new Red(resp.getRed(),null); 
        ListaEquipos equipos = Utils.redes.buscarEquipos(redTemp);
        this.jComboBoxEquipo.removeAllItems();
        this.jComboBoxEquipo.addItem("Seleccione un equipo");
        int indexEquipo = 0;
        Iterator iteratorEquipo = equipos.getLista().iterator();
        while(iteratorEquipo.hasNext()){
            Equipo tempEquipo = (Equipo) iteratorEquipo.next();
            this.jComboBoxEquipo.addItem(tempEquipo.getNumero());           
            indexEquipo++;   
            
            if (String.valueOf(tempEquipo.getNumero()).equals(resp.getEquipo())){
                this.jComboBoxEquipo.setSelectedIndex(indexEquipo);                        
            }
            
        }
        
        this.jTextAreaMensaje.setText(resp.getMensaje());
       
    } 
    private javax.swing.JComboBox jComboBoxConsultar;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetenerAplicacion;
    private javax.swing.JButton jButtonEnviarMensaje;
    private javax.swing.JButton jButtonIniciarAplicacion;
    private javax.swing.JComboBox jComboBoxAccion;
    private javax.swing.JComboBox jComboBoxEquipo;
    private javax.swing.JComboBox jComboBoxRed;
    private javax.swing.JMenuItem jItemConfiguracion;
    private javax.swing.JMenuItem jItemSalir;
    private javax.swing.JMenuBar jMenuInicio;
    private javax.swing.JMenu jMenuPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMensaje;
    private javax.swing.JTextField jTextFieldNombreArchivo;
    // End of variables declaration//GEN-END:variables


}
