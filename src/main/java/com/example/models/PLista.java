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
@Table(name = "p_lista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PLista.findAll", query = "SELECT p FROM PLista p"),
    @NamedQuery(name = "PLista.findByIdLista", query = "SELECT p FROM PLista p WHERE p.idLista = :idLista"),
    @NamedQuery(name = "PLista.findByNombre", query = "SELECT p FROM PLista p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PLista.findByDsc", query = "SELECT p FROM PLista p WHERE p.dsc = :dsc")})
public class PLista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLista")
    private Integer idLista;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dsc")
    private String dsc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLista")
    private Collection<PListavalores> pListavaloresCollection;

    public PLista() {
    }

    public PLista(Integer idLista) {
        this.idLista = idLista;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    @XmlTransient
    public Collection<PListavalores> getPListavaloresCollection() {
        return pListavaloresCollection;
    }

    public void setPListavaloresCollection(Collection<PListavalores> pListavaloresCollection) {
        this.pListavaloresCollection = pListavaloresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PLista)) {
            return false;
        }
        PLista other = (PLista) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "helloworld.entidades.PLista[ idLista=" + idLista + " ]";
    }
    
}
