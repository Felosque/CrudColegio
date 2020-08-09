/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import estructural.Estudiante;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author felip
 */
public class ServicioEstudiante {
    
    private ArrayList<Estudiante> estudiantes;

    public ServicioEstudiante() {
        estudiantes = new ArrayList<>();
        LocalDateTime date = LocalDateTime.now();
        estudiantes.add(new Estudiante("Alejandro", "Luna", date, "987654321", "A+", "SALUDCOP", "30012324234", "Avenida 49", "alejandro.luna@gmail.com"));
        estudiantes.add(new Estudiante("Luis Felipe", "Londoño Medina", date, "123456789", "O+", "SALUD TOTAL", "2772478", "CALLE 60 A", "felipelondono@gmail.com")); 
    }
    
    public void insertarEstudiante(Estudiante pEstudiante){
        estudiantes.add(pEstudiante);
    }
    
    public boolean eliminarEstudiante(String pDocumento){
        for(int i = 0; i < estudiantes.size(); i++){
            if(estudiantes.get(i).getDocumento().equals(pDocumento)){
                estudiantes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizarEstudiante(String pDocumento, Estudiante pEstudiante)
    {
        for(int i = 0; i < estudiantes.size(); i++){
            if(estudiantes.get(i).getDocumento().equals(pEstudiante.getDocumento())){
                estudiantes.get(i).actualizarTodaInformacion(pEstudiante);
                return true;
            }
        }
        return false;
    }
    
    public Estudiante buscarEstudiante(String pDocumento)
    {
        for(int i = 0; i < estudiantes.size(); i++){
            if(estudiantes.get(i).getDocumento().equals(pDocumento)){
                return estudiantes.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<Estudiante> darEstudiantes() {
        return estudiantes;
    }

    public void cambiarEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
}