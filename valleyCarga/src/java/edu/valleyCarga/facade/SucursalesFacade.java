/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.facade;

import edu.valleyCarga.entity.Sucursales;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marlon
 */
@Stateless
public class SucursalesFacade extends AbstractFacade<Sucursales> {

    @PersistenceContext(unitName = "valleyCargaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalesFacade() {
        super(Sucursales.class);
    }
    
    public List<Sucursales> sucursalesOrdenadas(){
        List<Sucursales> objSucursales = new ArrayList<>();
        
        try {
            Query q = em.createQuery("SELECT c FROM Sucursales c ORDER BY c.ciudadID");
            
            objSucursales = q.getResultList();
        } catch (Exception e) {
        }
        
        return objSucursales;
    }
    
}
