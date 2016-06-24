/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koushik.ticketservice.service;

import com.koushik.ticketservice.entity.SeatHold;
import com.koushik.ticketservice.repository.LevelDetailsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author koushik
 */
@Transactional
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    LevelDetailsRepository levelDetailsRepo;

    @Override
    public int numSeatsAvailable(Optional<Integer> venueLevel) {
        return levelDetailsRepo.getTotalSeats(venueLevel);
    }

    @Override
    public String reserveSeats(int seatHoldId, String customerEmail) {
        return "";
    }

    @Override
    public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel, String customerEmail) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new SeatHold();
    }

}
