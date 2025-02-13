/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Conexion_Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Panel_Departamentos extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Departamentos
     */
    public Panel_Departamentos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegistrarD = new javax.swing.JButton();
        btnEliminarD = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDepartamentos = new javax.swing.JTextField();
        txtNombresD = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnRegistrarD.setText("Registrar");
        btnRegistrarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDActionPerformed(evt);
            }
        });

        btnEliminarD.setText("Eliminar");
        btnEliminarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDActionPerformed(evt);
            }
        });

        jLabel2.setText("NombreDepartamento");

        jLabel1.setText("idDepartamentos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombresD, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminarD)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnRegistrarD)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombresD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarD)
                    .addComponent(btnRegistrarD))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDActionPerformed
        // TODO add your handling code here:

        Conexion_P conexion = new Conexion_P();  // Crear una instancia de la clase ConexionBD
        Connection con = conexion.establecerconexion();  // Establecer la conexión

        if (con != null) {  // Verificar si la conexión fue exitosa
            try {
                // Preparar la consulta SQL
                PreparedStatement pps = con.prepareStatement("INSERT INTO departamentos (idDepartamentos,NombreDepartamento) VALUES (?, ?)");

                // Establecer los valores de los parámetros
                pps.setString(1, txtDepartamentos.getText());
                pps.setString(2, txtNombresD.getText());
 

                // Ejecutar la consulta
                pps.executeUpdate();

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Datos guardados");

                // Cerrar la conexión
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(Panel_Personal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conexión a la base de datos fallida.");
        }
    }//GEN-LAST:event_btnRegistrarDActionPerformed

    private void btnEliminarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDActionPerformed
        // TODO add your handling code here:
         Conexion_P conexion = new Conexion_P();  
    Connection con = conexion.establecerconexion();  // Establecer la conexión

    if (con != null) {  // Verificar si la conexión fue exitosa
        try {
            // Preparar la consulta SQL para eliminar
            PreparedStatement pps = con.prepareStatement("DELETE FROM usuarios WHERE Codigo = ?");
            
            // Establecer el valor del parámetro (Código del usuario)
            pps.setString(1, txtDepartamentos.getText());
            
            // Ejecutar la consulta
            int resultado = pps.executeUpdate();
            
            if (resultado > 0) {
                // Mostrar mensaje de éxito si se eliminó el registro
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente.");
            } else {
                // Mostrar mensaje si no se encontró un registro con ese Código
                JOptionPane.showMessageDialog(null, "No se encontró un registro con ese código.");
            }
            
            // Cerrar la conexión
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Personal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Conexión a la base de datos fallida.");
    }
        
        
        
    }//GEN-LAST:event_btnEliminarDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarD;
    private javax.swing.JButton btnRegistrarD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDepartamentos;
    private javax.swing.JTextField txtNombresD;
    // End of variables declaration//GEN-END:variables
}
