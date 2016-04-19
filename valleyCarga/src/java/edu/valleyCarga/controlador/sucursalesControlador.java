/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleyCarga.controlador;

import edu.valleyCarga.entity.Sucursales;
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
@Named(value = "sucursalesControlador")
@SessionScoped
public class sucursalesControlador implements Serializable {

    @EJB
    private edu.valleyCarga.facade.SucursalesFacade sucursalesFacade;
    
    /**
     * Creates a new instance of sucursalesControlador
     */
    public sucursalesControlador() {
    }
    
    public List<Sucursales> todasSucursales(){
        return sucursalesFacade.sucursalesOrdenadas();
    }
    
}
