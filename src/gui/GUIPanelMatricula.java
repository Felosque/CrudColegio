/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.toedter.calendar.JDateChooser;
import constantes.UtilitiesFunctions;
import static constantes.UtilitiesFunctions.dateToGregorian;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ServicioLocalMateria;
import model.ServicioLocalMatricula;
import servicioWebEstudiante.Estudiante;
import servicioWebMaterias.Exception_Exception;
import servicioWebMaterias.Materia;
import servicioWebMatriculas.Matricula;

/**
 *
 * @author felip
 */
public class GUIPanelMatricula extends javax.swing.JPanel {

    /**
     * Creates new form GUIPanelMatricula
     */
    private JDateChooser jdFechaInicio;
    
    private JDateChooser jdFechaFin;
    
    private ArrayList<Materia> materias;
    
    private Estudiante estudiante;
    
    public GUIPanelMatricula() {
        initComponents();
        
        estudiante = null;
        
        img.setIcon(new ImageIcon(this.getClass().getResource("/img/registro3.png")));
        
        jdFechaInicio = new JDateChooser(new Date());
        panelFechaInicio.add(jdFechaInicio);
        jdFechaInicio.setBounds(0,0, 300, 20);
        jdFechaInicio.setForeground(new Color(0, 0, 0));
        
        jdFechaFin = new JDateChooser(new Date());
        panelFechaFin.add(jdFechaFin);
        jdFechaFin.setBounds(0,0, 300, 20);
        jdFechaFin.setForeground(new Color(0, 0, 0));
        
        mostrarOcultarEstudiante(false);
    }

    private void mostrarOcultarEstudiante(boolean pPam){
        lbDocumento.setVisible(pPam);
        lbGenero.setVisible(pPam);
        lbNombre.setVisible(pPam);
        jtNombre.setVisible(pPam);
        jtDoc.setVisible(pPam);
        jtGenero.setVisible(pPam);
        
        btBuscarEstudiante.setVisible(!pPam);
    }
    
    public void actualizarInformacion(Estudiante pEst){
        estudiante = pEst;
        jtNombre.setText(estudiante.getNombres()+ " " + estudiante.getApellidos() );
        jtDoc.setText(estudiante.getDocumentoIdentificacion());
        jtGenero.setText((estudiante.getGenero() == 1) ? "Femenino":"Masculino");
        mostrarOcultarEstudiante(true);
    }
    
    private void cambiarDatosTabla(int pGrado) throws Exception_Exception{
        
        if(estudiante == null) { 
            JOptionPane.showMessageDialog(this, "¡Debe seleccionar primero un estudiante para matricularlo!");
            jcGrados.setSelectedIndex(0);
        } 
        else {
            DefaultTableModel modelo = (DefaultTableModel)tablaDatos.getModel();
            modelo.getDataVector().removeAllElements();
            revalidate();

            materias = (ArrayList<Materia>) ServicioLocalMateria.getServicio().darMateriasPorGrado(pGrado);

            for (int i = 0; i < materias.size(); i++) {
                Vector fila = new Vector();
                fila.add(materias.get(i).getCodigo());
                fila.add(materias.get(i).getNombre());
                fila.add(materias.get(i).getIntensidadHoraria());
                modelo.addRow(fila);
            }
        }
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
        lbNombre = new javax.swing.JLabel();
        lbDocumento = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtDoc = new javax.swing.JTextField();
        jtGenero = new javax.swing.JTextField();
        btBuscarEstudiante = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jcGrados = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        panelFechaInicio = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelFechaFin = new javax.swing.JPanel();
        img = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Estudiante"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNombre.setText("Nombre:");
        jPanel1.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        lbDocumento.setText("Documento:");
        jPanel1.add(lbDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 20));

        lbGenero.setText("Genero:");
        jPanel1.add(lbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jtNombre.setEditable(false);
        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(jtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 301, -1));

        jtDoc.setEditable(false);
        jPanel1.add(jtDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 301, -1));

        jtGenero.setEditable(false);
        jPanel1.add(jtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 301, -1));

        btBuscarEstudiante.setText("Buscar Estudiante");
        btBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 270, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 460, 110));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Materias"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Intensidad"
            }
        ));
        jScrollPane1.setViewportView(tablaDatos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 108, 428, 100));

        jLabel4.setText("Fecha Inicio:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jcGrados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "_____", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", "Noveno", "Decimo", "Once" }));
        jcGrados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcGradosItemStateChanged(evt);
            }
        });
        jPanel2.add(jcGrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 144, 20));

        jButton1.setText("Matricular Estudiante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 189, 39));

        panelFechaInicio.setLayout(new java.awt.BorderLayout());
        jPanel2.add(panelFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, 20));

        jLabel5.setText("Curso a matricular:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel6.setText("Fecha Finalización:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        panelFechaFin.setLayout(new java.awt.BorderLayout());
        jPanel2.add(panelFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 190, 20));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 460, 270));
        add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 230, 283));
    }// </editor-fold>//GEN-END:initComponents

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jcGradosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcGradosItemStateChanged
        try {
            if(jcGrados.getSelectedIndex() != 0){
                System.out.println(jcGrados.getSelectedIndex());
                cambiarDatosTabla(jcGrados.getSelectedIndex());
            }
        } catch (Exception_Exception ex) {
            Logger.getLogger(GUIPanelMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcGradosItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jdFechaInicio.getDate().before(new Date())){
            JOptionPane.showMessageDialog(this, "¡No puedes poner una fecha de inicio antes que hoy!");
        }else if(jdFechaFin.getDate().before(jdFechaInicio.getDate())){
            JOptionPane.showMessageDialog(this, "¡No puedes poner una fecha final antes que la fecha de inicio!");
        }else if(jcGrados.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Debes seleccionar el grado de matricula primero.");
        }else {
            for (int i = 0; i < materias.size(); i++) {
                Matricula matricula = new Matricula();
                matricula.setCodigo(0);
                matricula.setPkEstudiante(estudiante.getDocumentoIdentificacion());
                matricula.setPkMateria(materias.get(i).getCodigo());
                matricula.setFechaInscripcion(dateToGregorian(new Date()));
                matricula.setFechaInicio(dateToGregorian(jdFechaInicio.getDate()));
                matricula.setFechaFinal(dateToGregorian(jdFechaFin.getDate()));
                matricula.setEstado(1);
                matricula.setNotaDefinitiva(0.0);
                
                try {
                    ServicioLocalMatricula.getServicio().matricularEstudiante(matricula);
                } catch (servicioWebMatriculas.Exception_Exception ex) {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar matricular la materia: " + materias.get(i).getNombre());
                }
            }
            JOptionPane.showMessageDialog(this, "Se ha matriculado el estudiante: "+ estudiante.getNombres() + " " + estudiante.getApellidos() + " en el grado: "+ jcGrados.getSelectedIndex());
            mostrarOcultarEstudiante(false);
            estudiante = null;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarEstudianteActionPerformed
        JDialogBuscarEstudiante busqueda;
        try {
            busqueda = new JDialogBuscarEstudiante(this, 1);
            busqueda.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(GUIPanelMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btBuscarEstudianteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarEstudiante;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcGrados;
    private javax.swing.JTextField jtDoc;
    private javax.swing.JTextField jtGenero;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JLabel lbDocumento;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JPanel panelFechaFin;
    private javax.swing.JPanel panelFechaInicio;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
