/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koushik.ticketservice.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author koushik
 */
/*
CREATE TABLE `seathold` (
	`id` smallint NOT NULL,
	`email` varchar(100) NOT NULL,
	`holdStatus` tinyint NOT NULL,
	`holdTime` TIMESTAMP NOT NULL,
	`noOfSeats` smallint NOT NULL,
	`totalPrice` smallint NOT NULL,
	PRIMARY KEY (`id`)
);

 */
@Entity
@Table(name = "seatHold")
public class SeatHold {

    private static final long serialVersionUID = 3932906165189258949L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    private byte holdStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date holdTime;
    @Basic(optional = false)
    private int noOfSeats;
    @Basic(optional = false)
    private int totalPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seatHold", fetch = FetchType.EAGER)
    private Set<Seat> holdedSeats = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seatHold", fetch = FetchType.EAGER)
    private Reservation reservation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getHoldStatus() {
        return holdStatus;
    }

    public void setHoldStatus(byte holdStatus) {
        this.holdStatus = holdStatus;
    }

    public Date getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(Date holdTime) {
        this.holdTime = holdTime;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Seat> getHoldedSeats() {
        return holdedSeats;
    }

    public void setHoldedSeats(Set<Seat> holdedSeats) {
        this.holdedSeats = holdedSeats;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.email);
        hash = 61 * hash + this.holdStatus;
        hash = 61 * hash + Objects.hashCode(this.holdTime);
        hash = 61 * hash + this.noOfSeats;
        hash = 61 * hash + this.totalPrice;
        hash = 61 * hash + Objects.hashCode(this.holdedSeats);
        hash = 61 * hash + Objects.hashCode(this.reservation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SeatHold other = (SeatHold) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.holdStatus != other.holdStatus) {
            return false;
        }
        if (this.noOfSeats != other.noOfSeats) {
            return false;
        }
        if (this.totalPrice != other.totalPrice) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.holdTime, other.holdTime)) {
            return false;
        }
        if (!Objects.equals(this.holdedSeats, other.holdedSeats)) {
            return false;
        }
        if (!Objects.equals(this.reservation, other.reservation)) {
            return false;
        }
        return true;
    }

   

    
}
