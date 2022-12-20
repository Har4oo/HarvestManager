package com.example.broadacre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlantStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int plantStageId;
    @Column(nullable = false)
    private String plantStageName;

    @OneToMany(mappedBy = "plantStage")
    @JsonIgnore
    @Column(nullable = false)
    private List<Crop> crops;

    public int getPlantStageId() {
        return plantStageId;
    }

    public void setPlantStageId(int plantStageId) {
        this.plantStageId = plantStageId;
    }

    public String getPlantStageName() {
        return plantStageName;
    }

    public void setPlantStageName(String plantStageName) {
        this.plantStageName = plantStageName;
    }

    public List<Crop> getCrops() {
        return crops;
    }

    public void setCrops(List<Crop> crops) {
        this.crops = crops;
    }
}
