package com.harvestmanager.broadacre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Soil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long soilId;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "soil")
    @JsonIgnore
    @Column(nullable = false)
    private List<Crop> crops;

    public long getSoilId() {
        return soilId;
    }

    public void setSoilId(long soilId) {
        this.soilId = soilId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Crop> getCrops() {
        return crops;
    }

    public void setCrops(List<Crop> crops) {
        this.crops = crops;
    }
}

