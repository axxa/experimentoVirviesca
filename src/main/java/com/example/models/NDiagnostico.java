/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JAVIER
 */
@Entity
@Table(name = "n_diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NDiagnostico.findAll", query = "SELECT n FROM NDiagnostico n"),
    @NamedQuery(name = "NDiagnostico.findByIdDiagnostico", query = "SELECT n FROM NDiagnostico n WHERE n.idDiagnostico = :idDiagnostico"),
    @NamedQuery(name = "NDiagnostico.findByDescripcion", query = "SELECT n FROM NDiagnostico n WHERE n.descripcion = :descripcion")})
public class NDiagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiagnostico")
    private Integer idDiagnostico;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    @ManyToOne(optional = false)
    private NDoctor idDoctor;
    @JoinColumn(name = "idSintoma", referencedColumnName = "idSintoma")
    @ManyToOne(optional = false)
    private NSintoma idSintoma;

    public NDiagnostico() {
    }

    public NDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Integer getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NDoctor getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(NDoctor idDoctor) {
        this.idDoctor = idDoctor;
    }

    public NSintoma getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(NSintoma idSintoma) {
        this.idSintoma = idSintoma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiagnostico != null ? idDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NDiagnostico)) {
            return false;
        }
        NDiagnostico other = (NDiagnostico) object;
        if ((this.idDiagnostico == null && other.idDiagnostico != null) || (this.idDiagnostico != null && !this.idDiagnostico.equals(other.idDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "helloworld.entidades.NDiagnostico[ idDiagnostico=" + idDiagnostico + " ]";
    }
    
}
