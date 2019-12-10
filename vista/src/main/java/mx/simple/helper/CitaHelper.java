/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.simple.helper;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import mx.simple.delegate.CitaDelegate;
import mx.simple.entidad.Cita;
import mx.simple.integracion.ServiceFacadeLocator;
/**
 *
 * @author luisc
 */
public class CitaHelper implements Serializable{
    Cita cita;
    
    public Cita Registro(Cita cita){
       ServiceFacadeLocator.getInstanceFacadeCita().guardarCita(cita);
       return null;
        
    }
    
    public List<Cita> Consulta(){
        List<Cita> ci = ServiceFacadeLocator.getInstanceFacadeCita().Consultar();
        return ci;
    } 
    
    public Cita Modificar(Cita cita){
        ServiceFacadeLocator.getInstanceFacadeCita().modificarCita(cita);
        return null;
    }
    
}
