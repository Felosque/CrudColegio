/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.toedter.calendar.JDateChooser;
import constantes.UtilitiesFunctions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import estructural.Estudiante;
import gui.GUIConstantes.TIPO_ACCION;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author felip
 */
public class GUIPanelInfo extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form GUIPanelInfo
     */
    
    private GUIPrincipal guiPrincipal;
    
    private JDialogPanelInfo dialogoPadre;
    
    private TIPO_ACCION modo;
    
    private Estudiante estudiante;
    
    private JDateChooser jdFechaNacimiento;
    
    //Modo 1: Registrar - Modo 2: Actualizar - Modo 3: Visualizar Modo 4: borrar
    public GUIPanelInfo(GUIPrincipal pGui, JDialogPanelInfo padre, TIPO_ACCION pModo) {
        guiPrincipal = pGui;
        modo = pModo;
        dialogoPadre = padre;
        
        initComponents();
        ponerImagen();
        
        jdFechaNacimiento = new JDateChooser(UtilitiesFunctions.sumarRestarAnosDate(new Date(), -5));
        panelCalendario.add(jdFechaNacimiento);
        jdFechaNacimiento.setBounds(0,0, 390, 20);
        jdFechaNacimiento.setForeground(new Color(0, 0, 0));
         
        if(null != pModo) switch (pModo) {
            case CREAR:
                habilitarEdicion(true);
                habilitarBoton(true);
                break;
            case ACTUALIZAR:
                habilitarEdicion(true);
                jtDNI.setEditable(false);
                habilitarBoton(true);
                break;
            case LEER:
                habilitarEdicion(false);
                habilitarBoton(false);
                break;
            case ELIMINAR:
                habilitarEdicion(false);
                habilitarBoton(true);
                break;
            default:
                break;
        }
       
        //txtTitulo.setHorizontalAlignment(JLabel.Center);
        btAccion.addActionListener(this);
        btAccion.setActionCommand("ACCION");
        
        jcGenero.setEditable(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtDNI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtEps = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtTelf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtCorreo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtDireccion = new javax.swing.JTextField();
        imagenPersona = new javax.swing.JLabel();
        btAccion = new javax.swing.JButton();
        panelCalendario = new javax.swing.JPanel();
        jcGenero = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Fecha Nacimiento: (Día/Mes/Año)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 220, 20));

        jLabel2.setText("Nombres:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 60, 20));

        jLabel3.setText("Apellidos:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 60, 20));

        jtApellido.setEditable(false);
        jPanel1.add(jtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 180, -1));

        jtNombre.setEditable(false);
        jPanel1.add(jtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 180, -1));

        jLabel5.setText("EPS:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 150, 20));

        jtDNI.setEditable(false);
        jPanel1.add(jtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 390, -1));

        jLabel6.setText("Género:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 150, 20));

        jLabel7.setText("Documento de identificación:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 200, 20));

        jtEps.setEditable(false);
        jPanel1.add(jtEps, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 180, -1));

        jLabel8.setText("Teléfono:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 150, 20));

        jtTelf.setEditable(false);
        jtTelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTelfActionPerformed(evt);
            }
        });
        jPanel1.add(jtTelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 180, -1));

        jLabel9.setText("Correo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 150, 20));

        jtCorreo.setEditable(false);
        jtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(jtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 180, -1));

        jLabel10.setText("Dirección de la casa:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 150, 20));

        jtDireccion.setEditable(false);
        jtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(jtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 390, -1));
        jPanel1.add(imagenPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 290, 290));

        btAccion.setText("REGISTRAR ESTUDIANTE");
        jPanel1.add(btAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 180, -1));

        panelCalendario.setLayout(null);
        jPanel1.add(panelCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 390, 20));

        jcGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jPanel1.add(jcGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 180, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtTelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTelfActionPerformed

    private void jtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCorreoActionPerformed

    private void jtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDireccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAccion;
    private javax.swing.JLabel imagenPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcGenero;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtCorreo;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtDireccion;
    private javax.swing.JTextField jtEps;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtTelf;
    private javax.swing.JPanel panelCalendario;
    // End of variables declaration//GEN-END:variables

    public void ponerImagen()
    {
        imagenPersona.setIcon(new ImageIcon(this.getClass().getResource("/img/user.png")));
    }
    
    public void habilitarBoton(boolean pEdit)
    {
        btAccion.setVisible(pEdit);
        if(modo == TIPO_ACCION.CREAR){
            btAccion.setText("Registrar Estudiante");
            dialogoPadre.cambiarTitulo("Registrar Estudiante");
            dialogoPadre.setTitle("Gestión Estudiantil - Registrar Estudiante");
        }else if(modo == TIPO_ACCION.ACTUALIZAR){
            dialogoPadre.cambiarTitulo("Actualizar Estudiante");
            btAccion.setText("Actualizar Estudiante");
            dialogoPadre.setTitle("Gestión Estudiantil - Actualizar Estudiante");
        }else if(modo == TIPO_ACCION.LEER){
            dialogoPadre.cambiarTitulo("Visualizar Estudiante");
            dialogoPadre.setTitle("Gestión Estudiantil - Visualizar Estudiante");
        }
        else if(modo == TIPO_ACCION.ELIMINAR){
            dialogoPadre.cambiarTitulo("Borrar Estudiante");
            btAccion.setText("Borrar Estudiante");
            dialogoPadre.setTitle("Gestión Estudiantil - Borrar Estudiante");
        }
    }
    
    public void habilitarEdicion(boolean pEdit)
    {
        //fECHA
        jdFechaNacimiento.setEnabled(pEdit);
        jtNombre.setEditable(pEdit);
        jtApellido.setEditable(pEdit);
        jtDNI.setEditable(pEdit);
        jcGenero.setEnabled(pEdit);
        jtEps.setEditable(pEdit);
        jtCorreo.setEditable(pEdit);
        jtDireccion.setEditable(pEdit);
        jtTelf.setEditable(pEdit);
    }
    
    public void refrescarInfo(Estudiante pEstudiante)
    {
        //Fecha
        estudiante = pEstudiante;
        jdFechaNacimiento.setDate(estudiante.getFechaNacimiento());
        jtNombre.setText(pEstudiante.getNombres());
        jtApellido.setText(pEstudiante.getApellidos());
        jtDNI.setText(pEstudiante.getDocumento());
        jcGenero.setSelectedIndex(pEstudiante.getGenero());
        jtEps.setText(pEstudiante.getEps());
        jtCorreo.setText(pEstudiante.getCorreo());
        jtDireccion.setText(pEstudiante.getDireccion());
        jtTelf.setText(pEstudiante.getTelefono());
    }

    public Estudiante crearEstudiante() throws Exception
    {
        Estudiante estudianteCreado = new Estudiante();
        try{
            estudianteCreado.setNombres(jtNombre.getText().trim());
            estudianteCreado.setApellidos(jtApellido.getText().trim());
            estudianteCreado.setFechaNacimiento(jdFechaNacimiento.getDate());
            estudianteCreado.setDocIdentificacion(jtDNI.getText().trim());
            estudianteCreado.setEps(jtEps.getText().trim());
            estudianteCreado.setGenero(jcGenero.getSelectedIndex());
            estudianteCreado.setTelefono(jtTelf.getText().trim());
            estudianteCreado.setCorreo(jtCorreo.getText().trim());
            estudianteCreado.setDireccion(jtDireccion.getText().trim());
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return estudianteCreado;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try{
            Estudiante estActual = crearEstudiante();
            if(modo == TIPO_ACCION.CREAR){
                guiPrincipal.registrarEstudiante(estActual);
                JOptionPane.showMessageDialog(this, "¡Se ha registrado el estudiante correctamente!");
                dialogoPadre.dispose();
            }
            else if(modo == TIPO_ACCION.ACTUALIZAR){//Actualizarlo
                guiPrincipal.actualizarEstudiante(estudiante.getDocumento(), estActual);
                JOptionPane.showMessageDialog(this, "¡Se ha actualizado el estudiante correctamente!");
                guiPrincipal.uiVerLista();
                dialogoPadre.dispose();
            }
            else if(modo == TIPO_ACCION.ELIMINAR){//Actualizarlo
                int select = JOptionPane.showOptionDialog(this, "¿Está seguro de querer eliminar el estudiante?", "IMPORTANTE", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1);
                if(select == 0){
                    guiPrincipal.borrarEstudiante(estudiante.getDocumento());
                    JOptionPane.showMessageDialog(this, "¡Se ha borrado el estudiante correctamente!");
                    guiPrincipal.uiVerLista();
                    dialogoPadre.dispose();
                }
            }
            
        } catch(RemoteException er){
            JOptionPane.showMessageDialog(this, er.getLocalizedMessage(), "ATENCIÓN", JOptionPane.ERROR_MESSAGE);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ATENCIÓN", JOptionPane.ERROR_MESSAGE);
        } 

    }
    
}
