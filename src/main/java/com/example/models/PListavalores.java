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
@Table(name = "p_listavalores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PListavalores.findAll", query = "SELECT p FROM PListavalores p"),
    @NamedQuery(name = "PListavalores.findByIdListaValor", query = "SELECT p FROM PListavalores p WHERE p.idListaValor = :idListaValor"),
    @NamedQuery(name = "PListavalores.findByValor", query = "SELECT p FROM PListavalores p WHERE p.valor = :valor"),
    @NamedQuery(name = "PListavalores.findByDsc", query = "SELECT p FROM PListavalores p WHERE p.dsc = :dsc")})
public class PListavalores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idListaValor")
    private Integer idListaValor;
    @Column(name = "valor")
    private String valor;
    @Column(name = "dsc")
    private String dsc;
    @JoinColumn(name = "idLista", referencedColumnName = "idLista")
    @ManyToOne(optional = false)
    private PLista idLista;

    public PListavalores() {
    }

    public PListavalores(Integer idListaValor) {
        this.idListaValor = idListaValor;
    }

    public Integer getIdListaValor() {
        return idListaValor;
    }

    public void setIdListaValor(Integer idListaValor) {
        this.idListaValor = idListaValor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public PLista getIdLista() {
        return idLista;
    }

    public void setIdLista(PLista idLista) {
        this.idLista = idLista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListaValor != null ? idListaValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PListavalores)) {
            return false;
        }
        PListavalores other = (PListavalores) object;
        if ((this.idListaValor == null && other.idListaValor != null) || (this.idListaValor != null && !this.idListaValor.equals(other.idListaValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "helloworld.entidades.PListavalores[ idListaValor=" + idListaValor + " ]";
    }
    
}
