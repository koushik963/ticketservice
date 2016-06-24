/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koushik.ticketservice.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author koushik
 */

/*
CREATE TABLE `reservation` (
	`id` smallint NOT NULL,
	`confirmationCode` varchar(10) NOT NULL UNIQUE,
	`reservedTime` TIMESTAMP NOT NULL,
	`seatHoldId` smallint NOT NULL,
	PRIMARY KEY (`id`)
);
 */
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic(optional = false)
    private String confirmationCode;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date reservedTime;
    @OneToOne
    @PrimaryKeyJoinColumn
    private SeatHold seatHold;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public Date getReservedTime() {
        return reservedTime;
    }

    public void setReservedTime(Date reservedTime) {
        this.reservedTime = reservedTime;
    }

    public SeatHold getSeathold() {
        return seatHold;
    }

    public void setSeathold(SeatHold seathold) {
        this.seatHold = seathold;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.confirmationCode);
        hash = 41 * hash + Objects.hashCode(this.reservedTime);
        hash = 41 * hash + Objects.hashCode(this.seatHold);
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
        final Reservation other = (Reservation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.confirmationCode, other.confirmationCode)) {
            return false;
        }
        if (!Objects.equals(this.reservedTime, other.reservedTime)) {
            return false;
        }
        if (!Objects.equals(this.seatHold, other.seatHold)) {
            return false;
        }
        return true;
    }

    
}
