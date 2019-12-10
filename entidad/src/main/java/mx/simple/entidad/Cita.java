/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.simple.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisc
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByIDCita", query = "SELECT c FROM Cita c WHERE c.iDCita = :iDCita"),
    @NamedQuery(name = "Cita.findByIDP", query = "SELECT c FROM Cita c WHERE c.iDP = :iDP"),
    @NamedQuery(name = "Cita.findByPaciente", query = "SELECT c FROM Cita c WHERE c.paciente = :paciente"),
    @NamedQuery(name = "Cita.findByFechaDeCita", query = "SELECT c FROM Cita c WHERE c.fechaDeCita = :fechaDeCita"),
    @NamedQuery(name = "Cita.findByPrecio", query = "SELECT c FROM Cita c WHERE c.precio = :precio"),
    @NamedQuery(name = "Cita.findByHora", query = "SELECT c FROM Cita c WHERE c.hora = :hora"),
    @NamedQuery(name = "Cita.findByTipoDeProcedimiento", query = "SELECT c FROM Cita c WHERE c.tipoDeProcedimiento = :tipoDeProcedimiento")})
    
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCita")
    private Integer iDCita;
      @Basic(optional = false)
    @Column(name = "IDP")
    private Integer iDP;
       @Basic(optional = false)
    @Column(name = "Paciente")
    private String paciente;
    @Column(name = "FechaDeCita")
    @Temporal(TemporalType.DATE)
    private Date fechaDeCita;
    @Basic(optional = false)
    @Column(name = "Precio")
    private float precio;
    @Basic(optional = false)
    @Column(name = "Hora")
    private String hora;
    @Basic(optional = false)
    @Column(name = "TipoDeProcedimiento")
    private String tipoDeProcedimiento;
       
  

    public Cita() {
    }

    public Cita(Integer iDCita) {
        this.iDCita = iDCita;
    }

    public Cita(Integer iDCita,Integer iDP,String paciente ,float precio, String hora, String tipoDeProcedimiento) {
        this.iDCita = iDCita;
        this.iDP = iDP;
        this.precio = precio;
        this.hora = hora;
        this.tipoDeProcedimiento = tipoDeProcedimiento;
        this.paciente = paciente;
    }

    public Integer getIDCita() {
        return iDCita;
    }

    public void setIDCita(Integer iDPaciente) {
        this.iDCita = iDPaciente;
    }

    public Integer getiDP() {
        return iDP;
    }

    public void setiDP(Integer iDP) {
        this.iDP = iDP;
    }

    
    public Date getFechaDeCita() {
        return fechaDeCita;
    }

    public void setFechaDeCita(Date fechaDeCita) {
        this.fechaDeCita = fechaDeCita;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoDeProcedimiento() {
        return tipoDeProcedimiento;
    }

    public void setTipoDeProcedimiento(String tipoDeProcedimiento) {
        this.tipoDeProcedimiento = tipoDeProcedimiento;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCita != null ? iDCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.iDCita == null && other.iDCita != null) || (this.iDCita != null && !this.iDCita.equals(other.iDCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.simple.entidad.Cita[ iDPaciente=" + iDCita + " ]";
    }
    
}
