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
@Table(name = "n_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NPaciente.findAll", query = "SELECT n FROM NPaciente n"),
    @NamedQuery(name = "NPaciente.findByIdPaciente", query = "SELECT n FROM NPaciente n WHERE n.idPaciente = :idPaciente"),
    @NamedQuery(name = "NPaciente.findByNombrePaciente", query = "SELECT n FROM NPaciente n WHERE n.nombrePaciente = :nombrePaciente")})
public class NPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaciente")
    private Integer idPaciente;
    @Column(name = "nombrePaciente")
    private String nombrePaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaciente")
    private Collection<NSintoma> nSintomaCollection;

    public NPaciente() {
    }

    public NPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    @XmlTransient
    public Collection<NSintoma> getNSintomaCollection() {
        return nSintomaCollection;
    }

    public void setNSintomaCollection(Collection<NSintoma> nSintomaCollection) {
        this.nSintomaCollection = nSintomaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NPaciente)) {
            return false;
        }
        NPaciente other = (NPaciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "helloworld.entidades.NPaciente[ idPaciente=" + idPaciente + " ]";
    }
    
}
