/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ServicioLocalMateria;
import model.ServicioLocalMatricula;
import servicioWebEstudiante.Estudiante;
import servicioWebMatriculas.Exception_Exception;
import servicioWebMatriculas.Matricula;

/**
 *
 * @author felip
 */
public class JDialogBuscarMatriculaEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form JDialogBuscarMatriculaEstudiante
     */
    private ArrayList<Matricula> matriculas;
    
    private Estudiante estudiante;
    
    private int modo;
            
    //Ver matriculas = 0, Borrar Matricula = 1, Actualizar Matricula = 2
    public JDialogBuscarMatriculaEstudiante(int pModo) throws RemoteException {
        modo = pModo;
        estudiante = null;
        initComponents();
        setLocationRelativeTo(null);
        mostrarOcultarInfo(false);
        
        if(pModo == 0){
            setTitle("Ver Matriculas Estudiante");
            txtTitulo.setText("Ver Matriculas Estudiante");
            txtInfo.setVisible(false);
            txtNota.setVisible(false);
        }else if(pModo == 1){ 
            setTitle("Borrar Matricula Estudiante");
            txtTitulo.setText("Borrar Matriculas Estudiante");
            txtInfo.setVisible(true);
            txtInfo.setText("Para borrar una matricula de doble clic sobre la que quiere eliminar.");
        }
        else if(pModo == 2){ 
            setTitle("Actualizar Matricula Estudiante");
            txtTitulo.setText("Actualizar Matriculas Estudiante");
            txtInfo.setVisible(true);
            txtInfo.setText("Para actualizar una matricula de doble clic sobre la que quiere eliminar.");
        }
        
    }
    
    private void mostrarOcultarInfo(boolean pPam){
        jtDoc.setVisible(pPam);
        jtNombre.setVisible(pPam);
        txtNom.setVisible(pPam);
        btBuscarEstudiante.setVisible(!pPam);
    }
    
    public void actualizarInformacion(Estudiante pEst) throws Exception_Exception, servicioWebMaterias.Exception_Exception{
        estudiante = pEst;
        mostrarOcultarInfo(true);
        jtDoc.setText(estudiante.getDocumentoIdentificacion());
        jtNombre.setText(estudiante.getNombres()+ " " + estudiante.getApellidos());
        cambiarDatosTabla(0);
    }
    
    public void cambiarDatosTabla(int pGrado) throws Exception_Exception, servicioWebMaterias.Exception_Exception{
        
        if(estudiante == null){
            JOptionPane.showMessageDialog(this, "¡Debes de buscar primero un estudiante para ver la información!");
        }else{
            DefaultTableModel modelo = (DefaultTableModel)tablaDatos.getModel();
            modelo.getDataVector().removeAllElements();
            revalidate();
            
            if(pGrado != 0){
                matriculas = (ArrayList<Matricula>)ServicioLocalMatricula.getServicio().darMatriculasEstudianteGrado(estudiante.getDocumentoIdentificacion(), pGrado);
            }else{
                matriculas = (ArrayList<Matricula>) ServicioLocalMatricula.getServicio().darMatriculasEstudiante(estudiante.getDocumentoIdentificacion());
            }
            for (int i = 0; i < matriculas.size(); i++) {
                Vector fila = new Vector();
                fila.add(matriculas.get(i).getCodigo());
                fila.add(ServicioLocalMateria.getServicio().darMateriaPorCodigo(matriculas.get(i).getPkMateria()).getNombre());
                fila.add(matriculas.get(i).getNotaDefinitiva());
                fila.add(matriculas.get(i).getFechaInscripcion());
                fila.add(matriculas.get(i).getFechaInicio());
                fila.add(matriculas.get(i).getFechaFinal());
                String inf = "";
                if(matriculas.get(i).getEstado() == 0){
                    inf = "Matriculada";
                }else if(matriculas.get(i).getEstado() == 1){
                    inf = "Cursando";
                }else if(matriculas.get(i).getEstado() == 2){
                    inf = "Reprobada";
                }else if(matriculas.get(i).getEstado() == 3){
                    inf = "Aprobada";
                }
                fila.add(inf);
                modelo.addRow(fila);
            }
             repaint();
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

        txtTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jcGrado = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        txtInfo = new javax.swing.JLabel();
        txtNota = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNom = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtDoc = new javax.swing.JTextField();
        btBuscarEstudiante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(6, 58, 88));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("MATRICULAS ESTUDIANTE");
        getContentPane().add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 640, 80));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcGrado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", "Noveno", "Decimo", "Once" }));
        jcGrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcGradoItemStateChanged(evt);
            }
        });
        jPanel1.add(jcGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 460, -1));

        jLabel2.setText("Filtrar por grado:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 650, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Matriculas"));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Materia", "Nota", "Fecha Inscripción", "Fecha Inicio", "Fecha Fin", "Estado"
            }
        ));
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        txtInfo.setText("Para borrar una matricula de doble clic sobre la que quiere eliminar.");

        txtNota.setForeground(new java.awt.Color(255, 0, 0));
        txtNota.setText("Nota:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(txtNota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInfo)
                    .addComponent(txtNota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 650, 290));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Estudiante"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNom.setText("Nombre:");
        jPanel3.add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jtNombre.setEditable(false);
        jPanel3.add(jtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 230, -1));

        jLabel4.setText("Documento:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jtDoc.setEditable(false);
        jPanel3.add(jtDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 210, -1));

        btBuscarEstudiante.setText("Buscar Estudiante");
        btBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarEstudianteActionPerformed(evt);
            }
        });
        jPanel3.add(btBuscarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 260, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 650, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcGradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcGradoItemStateChanged
        try {
            try {
                cambiarDatosTabla(jcGrado.getSelectedIndex());
            } catch (servicioWebMaterias.Exception_Exception ex) {
                Logger.getLogger(JDialogBuscarMatriculaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception_Exception ex) {
            Logger.getLogger(GUIPanelMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcGradoItemStateChanged

    private void btBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarEstudianteActionPerformed
        try {
            JDialogBuscarEstudiante busqueda = new JDialogBuscarEstudiante(null, 2);
            busqueda.ponerPadreFrame(this);
            busqueda.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(JDialogBuscarMatriculaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btBuscarEstudianteActionPerformed

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        if(modo == 1){// Borrar
            
            int column = 0;
            int row = tablaDatos.getSelectedRow();
            String value = tablaDatos.getModel().getValueAt(row, column).toString();
            String nom = tablaDatos.getModel().getValueAt(row, 1).toString();
            String info = "¿Seguro que desea eliminar la matricula de " + nom + " - CODIGO: "+ value;
            int select = JOptionPane.showOptionDialog(this, info, "IMPORTANTE", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1);
            if(select == 0){
                try {
                    int codi = Integer.parseInt(value);
                    System.out.println(codi);
                    ServicioLocalMatricula.getServicio().borrarMatriculaCodigo(codi);
                    DefaultTableModel modelo = (DefaultTableModel)tablaDatos.getModel();
                    modelo.removeRow(row);
                    JOptionPane.showMessageDialog(this, "¡Se ha borrado el matricula correctamente!");
                } catch (Exception_Exception ex) {
                    Logger.getLogger(JDialogBuscarMatriculaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } else if(modo == 2){ //Actualizar
            int column = 0;
            int row = tablaDatos.getSelectedRow();
            String value = tablaDatos.getModel().getValueAt(row, column).toString();
            int codi = Integer.parseInt(value);
            try {
                JDialogPanelActMatricula panelActMatricula = new JDialogPanelActMatricula(estudiante, ServicioLocalMatricula.getServicio().darMatriculaCodigo(codi), this);
                panelActMatricula.setVisible(true);
                
            } catch (Exception_Exception ex) {
                Logger.getLogger(JDialogBuscarMatriculaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_tablaDatosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarEstudiante;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcGrado;
    private javax.swing.JTextField jtDoc;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JLabel txtInfo;
    private javax.swing.JLabel txtNom;
    private javax.swing.JLabel txtNota;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
