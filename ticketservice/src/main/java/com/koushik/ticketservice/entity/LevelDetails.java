/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koushik.ticketservice.entity;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author koushik
 */
/*

CREATE TABLE `levelDetails` (
	`id` smallint NOT NULL,
	`totalSeats` smallint NOT NULL,
	`price` smallint NOT NULL,
	`currentIndex` smallint NOT NULL,
	`levelId` smallint NOT NULL,
	PRIMARY KEY (`id`)
);


 */
@Entity
@Table(name = "leveldetails")
@NamedQuery(name = "LevelDetails.getTotalSeats", query = "select sum(l.totalSeats)-sum(l.currentIndex) from LevelDetails l where l.level.id = :levelId")
public class LevelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic(optional = false)
    private int totalSeats;
    @Basic(optional = false)
    private int price;
    @Basic(optional = false)
    private int currentIndex;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Level level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
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
        hash = 61 * hash + this.id;
        hash = 61 * hash + this.totalSeats;
        hash = 61 * hash + this.price;
        hash = 61 * hash + this.currentIndex;
        hash = 61 * hash + Objects.hashCode(this.level);
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
        final LevelDetails other = (LevelDetails) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.totalSeats != other.totalSeats) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (this.currentIndex != other.currentIndex) {
            return false;
        }
        if (!Objects.equals(this.level, other.level)) {
            return false;
        }
        return true;
    }

}
