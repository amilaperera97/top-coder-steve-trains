package com.trains.steve.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Trains {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String distanceBetweenStop;
    private String maxSpeed;
    private boolean sharingTracks;
    private boolean gradeCrossing;
    private String trainFrequency;
    private String amenities;
}