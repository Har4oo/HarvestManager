package com.example.broadacre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;
    @Column(nullable = false)
    private String locationName;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    @Column(nullable = false)
    private List<Crop> crops;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<Crop> getCrops() {
        return crops;
    }

    public void setCrops(List<Crop> crops) {
        this.crops = crops;
    }
}
