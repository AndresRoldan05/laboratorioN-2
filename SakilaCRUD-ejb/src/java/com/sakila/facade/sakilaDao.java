/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakila.facade;

import com.sakila.entities.Actor;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
@Stateless
@LocalBean
public class sakilaDao {

    @PersistenceContext(unitName = "SakilaCRUD-ejbPU")
    private EntityManager em;

    public List<Actor> getAllActores() {
        Query query = em.createNamedQuery("Actor.findAll");
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Actor updateActor(Actor actor) {
        return em.merge(actor);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
