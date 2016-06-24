/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koushik.ticketservice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author koushik
 */
/*
CREATE TABLE `seat` (
	`id` smallint NOT NULL,
	`number` smallint NOT NULL,
	`seatHoldId` smallint NOT NULL,
	`reserved` tinyint NOT NULL,
	`ttl` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

 */
@Entity
@Table(name = "seat")
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private int id;
    @Basic(optional = false)
    private String number;
    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "seatHoldId", referencedColumnName = "id", insertable = false, updatable = false)
    private SeatHold seatHold;
    @Basic(optional = false)
    private byte reserved;
    @Temporal(TemporalType.DATE)
    private Date ttl;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seat", fetch = FetchType.EAGER)
    private Level level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public SeatHold getSeathold() {
        return seatHold;
    }

    public void setSeathold(SeatHold seatHold) {
        this.seatHold = seatHold;
    }

    public byte getReserved() {
        return reserved;
    }

    public void setReserved(byte reserved) {
        this.reserved = reserved;
    }

    public Date getTtl() {
        return ttl;
    }

    public void setTtl(Date ttl) {
        this.ttl = ttl;
    }

    public SeatHold getSeatHold() {
        return seatHold;
    }

    public void setSeatHold(SeatHold seatHold) {
        this.seatHold = seatHold;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.number);
        hash = 19 * hash + Objects.hashCode(this.seatHold);
        hash = 19 * hash + this.reserved;
        hash = 19 * hash + Objects.hashCode(this.ttl);
        hash = 19 * hash + Objects.hashCode(this.level);
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
        final Seat other = (Seat) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.reserved != other.reserved) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        if (!Objects.equals(this.seatHold, other.seatHold)) {
            return false;
        }
        if (!Objects.equals(this.ttl, other.ttl)) {
            return false;
        }
        if (!Objects.equals(this.level, other.level)) {
            return false;
        }
        return true;
    }

}
