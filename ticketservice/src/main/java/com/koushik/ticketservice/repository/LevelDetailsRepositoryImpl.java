/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koushik.ticketservice.repository;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author koushik
 */
@Repository
public class LevelDetailsRepositoryImpl implements LevelDetailsRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int getTotalSeats(Optional<Integer> venueLevel) {
        return em.createNamedQuery("LevelDetails.getTotalSeats", Long.class).setParameter("levelId", venueLevel.get()).getSingleResult().intValue();
    }

}
