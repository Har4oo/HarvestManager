package com.harvestmanager.broadacre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlantStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long plantStageId;
    @Column(nullable = false)
    private String plantStageName;

    @Column(nullable = false)
    private int plantStageInPercents;

    @OneToMany(mappedBy = "plantStage")
    @JsonIgnore
    @Column(nullable = false)
    private List<Crop> crops;

    public long getPlantStageId() {
        return plantStageId;
    }

    public void setPlantStageId(long plantStageId) {
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

    public int getPlantStageInPercents() {
        return plantStageInPercents;
    }

    public void setPlantStageInPercents(int plantStageInPercents) {
        this.plantStageInPercents = plantStageInPercents;

    }
}
