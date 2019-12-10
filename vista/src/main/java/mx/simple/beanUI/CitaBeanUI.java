package mx.simple.beanUI;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import static mx.simple.beanUI.PacienteBeanUI.pac2;
import mx.simple.entidad.Cita;
import mx.simple.entidad.Instrumentodental;
import mx.simple.entidad.Paciente;
import mx.simple.helper.CitaHelper;
import mx.simple.helper.PacienteHelper;


/**
 *
 * @author luisc
 */
@ManagedBean(name = "citaUI")
@SessionScoped
public class CitaBeanUI implements Serializable {
    
        private CitaHelper citaHelper;
        private PacienteHelper pacienteHelper;
        private Cita cita;
        private List<Cita> cit;
        private String fecha;
        private String hr;
        private List<Paciente> Pac;
        private Paciente pacienteSelect;
        private String nombre="";
        
        
       
       
   
    public CitaBeanUI() throws IOException {
        citaHelper = new CitaHelper();
        cita = new Cita();
       cit = citaHelper.Consulta();
    
   
    }

    /**
     * Metodo postconstructor todo lo que este dentro de este metodo sera la
     * primero que haga cuando cargue la pagina
     */
    @PostConstruct
    public void init() {
        cita = new Cita();
    }

    
    public void actu() throws IOException {
        cit = consulta();
        
    }
    
    public void registro() throws ParseException{
        cita.setFechaDeCita(Date.valueOf(fecha));
        cita.setIDCita(1);
       int IDdCita = pacienteSelect.getIDPaciente();
       
        cita.setiDP(IDdCita);
         cita.setPaciente(pacienteSelect.getNombre()+" "+pacienteSelect.getApellidoP()+" "+pacienteSelect.getApellidoM());
       citaHelper.Registro(cita);
    }
    
    public String Busqueda(Cita c){
        String nombre="";
            for (Paciente Pac1 : Pac) {
                if(Pac1.getIDPaciente() == c.getiDP())
                    nombre= Pac1.getNombre() + Pac1.getApellidoP()+Pac1.getApellidoM();
            }
            return nombre;
    }
    
    public List<Cita> consulta(){
       List<Cita> ci= citaHelper.Consulta();
        return ci;
    }
    
    public void modificar(Cita cita) throws IOException{
         
        cita.setFechaDeCita(Date.valueOf(fecha));
        citaHelper.Modificar(cita);
        
             FacesMessage msg = new FacesMessage("Cita Editada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
     }

    public List<Cita> getCit() {
        return cit;
    }

    public void setCit(List<Cita> cit) {
        this.cit = cit;
    }

   
    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public Paciente getPacienteSelect() {
        return pacienteSelect;
    }

    public void setPacienteSelect(Paciente pacienteSelect) {
        this.pacienteSelect = pacienteSelect;
    }
    
    
    
    
    
}
