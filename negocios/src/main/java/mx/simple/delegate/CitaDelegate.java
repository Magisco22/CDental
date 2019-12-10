/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.simple.delegate;

import java.util.List;
import mx.simple.entidad.Cita;
import mx.simple.integracion.ServiceFacadeLocator;
import mx.simple.integracion.ServiceLocator;

/**
 *
 * @author Raquel
 */
public class CitaDelegate {
    public void saveCita(Cita cita){
        ServiceLocator.getInstanceCitaDAO().save(cita);
    }
  public List<Cita> Consultar(){
       List<Cita> pa= ServiceLocator.getInstanceCitaDAO().findAll();
      
   return pa;
       
    }
  public void modificarCita(Cita cita){
       
        ServiceLocator.getInstanceCitaDAO().update(cita);
    }
}
