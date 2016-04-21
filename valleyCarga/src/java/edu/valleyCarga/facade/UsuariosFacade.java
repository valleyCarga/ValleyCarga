/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.facade;

import edu.valleyCarga.entity.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PRACTICAS
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "valleyCargaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public List<Usuarios> validarUsuario(long cedula,String clave){
        List<Usuarios> logueado = new ArrayList<>();
        
        try {
            Query p= em.createQuery("SELECT c from Usuarios c where c.cedula = :cedula and c.clave=:clave");
            p.setParameter("cedula",cedula );
            p.setParameter("clave",clave );
            logueado = p.getResultList();
        } catch (Exception e) {
        }
        return logueado;
    }
}