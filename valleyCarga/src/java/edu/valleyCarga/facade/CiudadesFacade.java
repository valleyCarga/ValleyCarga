/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.facade;

import edu.valleyCarga.entity.Ciudades;
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
public class CiudadesFacade extends AbstractFacade<Ciudades> {

    @PersistenceContext(unitName = "valleyCargaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadesFacade() {
        super(Ciudades.class);
    }
    public  List<Ciudades> ciudadesOrdenadas(){
        List<Ciudades> objCiudades = new ArrayList<>();
        
        try {
            Query p = em.createQuery("SELECT c FROM Ciudades c order by c.nombre");
            
            objCiudades = p.getResultList();
        } catch (Exception e) {
        }
        
        return objCiudades;
    }
}
