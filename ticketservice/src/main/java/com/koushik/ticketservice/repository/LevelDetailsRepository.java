/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koushik.ticketservice.repository;

import java.util.Optional;

/**
 *
 * @author koushik
 */
public interface LevelDetailsRepository {

    public int getTotalSeats(Optional<Integer> venueLevel);
}
