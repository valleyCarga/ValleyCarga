/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.entity;

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
 * @author PRACTICAS
 */
@Entity
@Table(name = "perfil_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilUsuarios.findAll", query = "SELECT p FROM PerfilUsuarios p"),
    @NamedQuery(name = "PerfilUsuarios.findByPerfilusuariosID", query = "SELECT p FROM PerfilUsuarios p WHERE p.perfilusuariosID = :perfilusuariosID")})
public class PerfilUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "perfil_usuariosID")
    private Integer perfilusuariosID;
    @JoinColumn(name = "perfilID", referencedColumnName = "perfilID")
    @ManyToOne(optional = false)
    private Perfil perfilID;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuarios cedula;

    public PerfilUsuarios() {
    }

    public PerfilUsuarios(Integer perfilusuariosID) {
        this.perfilusuariosID = perfilusuariosID;
    }

    public Integer getPerfilusuariosID() {
        return perfilusuariosID;
    }

    public void setPerfilusuariosID(Integer perfilusuariosID) {
        this.perfilusuariosID = perfilusuariosID;
    }

    public Perfil getPerfilID() {
        return perfilID;
    }

    public void setPerfilID(Perfil perfilID) {
        this.perfilID = perfilID;
    }

    public Usuarios getCedula() {
        return cedula;
    }

    public void setCedula(Usuarios cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilusuariosID != null ? perfilusuariosID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuarios)) {
            return false;
        }
        PerfilUsuarios other = (PerfilUsuarios) object;
        if ((this.perfilusuariosID == null && other.perfilusuariosID != null) || (this.perfilusuariosID != null && !this.perfilusuariosID.equals(other.perfilusuariosID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleyCarga.controlador.PerfilUsuarios[ perfilusuariosID=" + perfilusuariosID + " ]";
    }
    
}
