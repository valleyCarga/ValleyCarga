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
 * @author PRACTICAS
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
    
    public  List<Sucursales> sucursalesOrdenadas(){
        List<Sucursales> objSucursales = new ArrayList<>();
        
        try {
            Query p = em.createQuery("SELECT c FROM Sucursales c order by c.ciudadID");
            
            objSucursales = p.getResultList();
        } catch (Exception e) {
        }
        
        return objSucursales;
    }
    
}
