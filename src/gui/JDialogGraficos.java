/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author felip
 */
public class JDialogGraficos extends JDialog {

    public JDialogGraficos(List<Integer> generoEstudiantes) {
        
        
        setResizable(false);
        setLocationRelativeTo(null);
        
        GUIPanelGrafica panelGrafica = new GUIPanelGrafica(generoEstudiantes, 1);
        add(panelGrafica, BorderLayout.CENTER);
        
        this.setSize(new Dimension(616, 439));
    }
    
    
    
}
