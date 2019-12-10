package mx.simple.beanUI;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.simple.entidad.Instrumentodental;

import mx.simple.helper.InstrumentosDentalesHelper;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Gabriel Rodriguez
 */
@ManagedBean(name = "instrumentosDUI")
@SessionScoped
public class InstrumentosDentalesBeanUI implements Serializable {
    private InstrumentosDentalesHelper instrumentosDentalesHelper;
    private Instrumentodental instrumentoDental;
    private Instrumentodental instrumentoSelect;
    private List<String> cities;
    private List<String> cities2;
    static List<Instrumentodental> ins;
    
    public InstrumentosDentalesBeanUI() throws IOException{
        instrumentosDentalesHelper = new InstrumentosDentalesHelper();
        instrumentoDental = new Instrumentodental();
       ins = instrumentosDentalesHelper.Consulta();
       cities2 = Consulta2();
    }
    
    
      @PostConstruct
    public void init(){
        instrumentoDental = new Instrumentodental();
    }
    
    public void actu() throws IOException {
       ins = Consulta();
    }
    
    public void registro(){
        
        int ban=0;
      instrumentoDental.setIDInstrumento(1);
      if(instrumentoDental.getDescripcion().isEmpty()){
          instrumentoDental.setDescripcion("NA");
      }
        for (Instrumentodental in : ins) {
            if(instrumentoDental.getProducto().equalsIgnoreCase(in.getProducto())){
                ban =1;
            }
        }
           if(ban==0){
            instrumentosDentalesHelper.Registro(instrumentoDental);
            saveMessage();
           }else{
               repetidoMessage();
           }
    }
    
    
    
     public void modificar(Instrumentodental instrumentoDental) throws IOException{
         instrumentosDentalesHelper.Modificar(instrumentoDental);
             FacesMessage msg = new FacesMessage("Instrumento Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
     }
   
    
    public void eliminar(){
        instrumentosDentalesHelper.Eliminar(instrumentoSelect);
    }
    
    
      // Metodo para mostrar mensaje de modificacion de paciente exitosa
      public void onRowEdit(RowEditEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("Instrumento Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
       
    }
     
      // Metodo para mostrar mensaje de cancelacion de modificacion de paciente
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public List<Instrumentodental> Consulta(){
        List < Instrumentodental> Ins = instrumentosDentalesHelper.Consulta();
        return Ins;
    }
    
    public List<String> Consulta2(){
        List < Instrumentodental> Ins = instrumentosDentalesHelper.Consulta();
       
        cities = new ArrayList<>();
        for (Instrumentodental In : Ins) {
             cities.add(In.getProducto());
        }
        return cities;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<String> getCities2() {
        return cities2;
    }

    public void setCities2(List<String> cities2) {
        this.cities2 = cities2;
    }
    
    
    public InstrumentosDentalesHelper getInstrumentosDentalesHelper() {
        return instrumentosDentalesHelper;
    }

    public void setInstrumentosDentalesHelper(InstrumentosDentalesHelper instrumentosDentalesHelper) {
        this.instrumentosDentalesHelper = instrumentosDentalesHelper;
    }

    public Instrumentodental getInstrumentoDental() {
        return instrumentoDental;
    }
  
    public void setInstrumentoDental(Instrumentodental instrumentoDental) {
        this.instrumentoDental = instrumentoDental;
    }

    public Instrumentodental getInstrumentoSelect() {
        return instrumentoSelect;
    }

    public void setInstrumentoSelect(Instrumentodental instrumentoSelect) {
        this.instrumentoSelect = instrumentoSelect;
    }

    public List<Instrumentodental> getIns() {
        return ins;
    }

    public void setIns(List<Instrumentodental> ins) {
        this.ins = ins;
    }

     public void repetidoMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Producto ya registrado") );
    }
    
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro exitoso") );
    }
}

