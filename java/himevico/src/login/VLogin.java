/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import himevico.GestorBBDD;
import himevico.VInicio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import partes.VParteAdministracion;
import trabajadores.Logistica;

/**
 *
 * @author Sheila
 */
public class VLogin extends javax.swing.JFrame {

    private GestorBBDD db;

    /**
     * Creates new form VInicio
     */
    public VLogin() {
        initComponents();
        // Poner icono ventana
        setIconImage(new ImageIcon(getClass().getResource("../imagenes/password.png")).getImage());
        
    }

    /**
     * Crea una ventana de login
     * @param db
     */
    public VLogin(GestorBBDD db) {
        initComponents();
        this.db = db;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jUsuario = new javax.swing.JTextField();
        jContrasena = new javax.swing.JPasswordField();
        jIniciarSesión = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Contraseña: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        getContentPane().add(jUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 247, -1));
        getContentPane().add(jContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 247, -1));

        jIniciarSesión.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jIniciarSesión.setForeground(new java.awt.Color(0, 0, 102));
        jIniciarSesión.setText("Iniciar sesión");
        jIniciarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIniciarSesiónActionPerformed(evt);
            }
        });
        getContentPane().add(jIniciarSesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Usuario: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 222, 375, 1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lock.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 230, 240));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoVentana inicio.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jIniciarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIniciarSesiónActionPerformed
        // Iniciar sesión

        String usuario = jUsuario.getText();
        String contrasena = new String(jContrasena.getPassword());
        String tipoUsuario = null;

        if (GestorBBDD.comprobarUsuario(usuario, contrasena)) {
            try {
                tipoUsuario = GestorBBDD.tipoUsuario(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(VLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (tipoUsuario) {
                case "Logistica-Transporte":
                    VParteAdministracion parte = null;
                    Logistica logistica = null;
                    try {
                        logistica = new Logistica(jUsuario.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(VLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        parte = new VParteAdministracion(logistica);
                    } catch (Exception ex) {
                        Logger.getLogger(VLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    parte.setLocationRelativeTo(null);
                    parte.setVisible(true);
                    break;
                case "Administración":
                    VInicio inicio = new VInicio();
                    inicio.setLocationRelativeTo(null);
                    inicio.setVisible(true);

                    break;
                default:
                    break;
            }
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Error", "", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jIniciarSesiónActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField jContrasena;
    private javax.swing.JButton jIniciarSesión;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jUsuario;
    // End of variables declaration//GEN-END:variables

    private void setIconImage(ImageIcon imageIcon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
