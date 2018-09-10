/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakila.beans;

import com.sakila.entities.Actor;
import com.sakila.facade.sakilaDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Andres
 */
@Named(value = "sakilaBean")
@SessionScoped
public class SakilaBean implements Serializable {

    @EJB
    private sakilaDao sakilaDao;
    private Actor actor;
    private List<Actor> actores;

    /**
     * Creates a new instance of SakilaBean
     */
    public SakilaBean() {
    }
    
    public Actor getActor() {
        return actor;
    }

    public List<Actor> getAllActores() {
        if(actores == null || actores.isEmpty()){
            this.refresh();
        }
        return actores;
    }
    
    private void refresh(){
        actores = sakilaDao.getAllActores();
    }
    
    public String update(){
        System.out.println("com.sakila.beans.SakilaDao.update() " + "###UPDATE###");
        actor = sakilaDao.updateActor(actor);
        return "Actor Update";
    }
    
}
