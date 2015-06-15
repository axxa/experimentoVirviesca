/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JAVIER
 */
@Entity
@Table(name = "n_sintoma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NSintoma.findAll", query = "SELECT n FROM NSintoma n"),
    @NamedQuery(name = "NSintoma.findByIdSintoma", query = "SELECT n FROM NSintoma n WHERE n.idSintoma = :idSintoma"),
    @NamedQuery(name = "NSintoma.findByFecha", query = "SELECT n FROM NSintoma n WHERE n.fecha = :fecha"),
    @NamedQuery(name = "NSintoma.findByLocallizacionDolor", query = "SELECT n FROM NSintoma n WHERE n.locallizacionDolor = :locallizacionDolor"),
    @NamedQuery(name = "NSintoma.findByIntensidad", query = "SELECT n FROM NSintoma n WHERE n.intensidad = :intensidad"),
    @NamedQuery(name = "NSintoma.findByPatronesSueno", query = "SELECT n FROM NSintoma n WHERE n.patronesSueno = :patronesSueno"),
    @NamedQuery(name = "NSintoma.findByActividadFisica", query = "SELECT n FROM NSintoma n WHERE n.actividadFisica = :actividadFisica")})
public class NSintoma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSintoma")
    private Integer idSintoma;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "locallizacionDolor")
    private Integer locallizacionDolor;
    @Column(name = "intensidad")
    private Integer intensidad;
    @Column(name = "patronesSueno")
    private String patronesSueno;
    @Column(name = "actividadFisica")
    private Integer actividadFisica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSintoma")
    private Collection<NDiagnostico> nDiagnosticoCollection;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
    private NPaciente idPaciente;

    public NSintoma() {
    }

    public NSintoma(Integer idSintoma) {
        this.idSintoma = idSintoma;
    }

    public NSintoma(Integer idSintoma, Date fecha) {
        this.idSintoma = idSintoma;
        this.fecha = fecha;
    }

    public Integer getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(Integer idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getLocallizacionDolor() {
        return locallizacionDolor;
    }

    public void setLocallizacionDolor(Integer locallizacionDolor) {
        this.locallizacionDolor = locallizacionDolor;
    }

    public Integer getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(Integer intensidad) {
        this.intensidad = intensidad;
    }

    public String getPatronesSueno() {
        return patronesSueno;
    }

    public void setPatronesSueno(String patronesSueno) {
        this.patronesSueno = patronesSueno;
    }

    public Integer getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(Integer actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    @XmlTransient
    public Collection<NDiagnostico> getNDiagnosticoCollection() {
        return nDiagnosticoCollection;
    }

    public void setNDiagnosticoCollection(Collection<NDiagnostico> nDiagnosticoCollection) {
        this.nDiagnosticoCollection = nDiagnosticoCollection;
    }

    public NPaciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(NPaciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSintoma != null ? idSintoma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NSintoma)) {
            return false;
        }
        NSintoma other = (NSintoma) object;
        if ((this.idSintoma == null && other.idSintoma != null) || (this.idSintoma != null && !this.idSintoma.equals(other.idSintoma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "helloworld.entidades.NSintoma[ idSintoma=" + idSintoma + " ]";
    }
    
}
