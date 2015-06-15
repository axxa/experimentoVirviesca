/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JAVIER
 */
@Entity
@Table(name = "n_doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NDoctor.findAll", query = "SELECT n FROM NDoctor n"),
    @NamedQuery(name = "NDoctor.findByIdDoctor", query = "SELECT n FROM NDoctor n WHERE n.idDoctor = :idDoctor"),
    @NamedQuery(name = "NDoctor.findByNombre", query = "SELECT n FROM NDoctor n WHERE n.nombre = :nombre")})
public class NDoctor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDoctor")
    private Integer idDoctor;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoctor")
    private Collection<NDiagnostico> nDiagnosticoCollection;

    public NDoctor() {
    }

    public NDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<NDiagnostico> getNDiagnosticoCollection() {
        return nDiagnosticoCollection;
    }

    public void setNDiagnosticoCollection(Collection<NDiagnostico> nDiagnosticoCollection) {
        this.nDiagnosticoCollection = nDiagnosticoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoctor != null ? idDoctor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NDoctor)) {
            return false;
        }
        NDoctor other = (NDoctor) object;
        if ((this.idDoctor == null && other.idDoctor != null) || (this.idDoctor != null && !this.idDoctor.equals(other.idDoctor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "helloworld.entidades.NDoctor[ idDoctor=" + idDoctor + " ]";
    }
    
}
