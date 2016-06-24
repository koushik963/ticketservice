/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koushik.ticketservice.controller;

import com.koushik.ticketservice.service.TicketService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author koushik
 */
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloWorld() {
        return "Hello World!!!";
    }
    @RequestMapping(value = "/numSeats/{venueLevel}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long getNumSeats(@PathVariable("venueLevel") int venueLevel) {
        return ticketService.numSeatsAvailable(Optional.of(venueLevel));
    }   
}
