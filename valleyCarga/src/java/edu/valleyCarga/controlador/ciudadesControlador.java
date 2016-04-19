/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.controlador;

import edu.valleyCarga.entity.Ciudades;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author PRACTICAS
 */
@Named(value = "ciudadesControlador")
@SessionScoped
public class ciudadesControlador implements Serializable {
    
    @EJB
    edu.valleyCarga.facade.CiudadesFacade ciudadesFacade;
    /**
     * Creates a new instance of ciudadesControlador
     */
    public ciudadesControlador() {
    }
    
    public List<Ciudades> ciudadesOrdenadas(){
        return ciudadesFacade.ciudadesOrdenadas();
    }
    
}
