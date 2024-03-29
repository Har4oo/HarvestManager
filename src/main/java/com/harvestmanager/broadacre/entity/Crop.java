package com.harvestmanager.broadacre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cropId;
    @Column(nullable = false)
    private String cropName;
    @Column(nullable = false)
    private int seedlingsNumber;
    @Column(nullable = false)
    private boolean active;

    @Column(length = 1500)
    private String photoUrl;
    @ManyToOne
    @JoinColumn(nullable = false,name = "soil_id")
    private Soil soil;

    @ManyToOne
    @JoinColumn(nullable = false, name = "plantStage_id")
    private PlantStage plantStage;

    @ManyToOne
    @JoinColumn(nullable = false, name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(nullable = false, name = "cropType_id")
    private CropType cropType;

    @ManyToOne
    @JoinColumn(nullable = false, name = "sort_id")
    private Sort sort;

    @OneToMany(mappedBy = "crop",cascade={CascadeType.REMOVE})
    @JsonIgnore
    @Column(nullable = false)
    private List<PersonalObservation> personalObservations;

    @OneToMany(mappedBy = "crop",cascade={CascadeType.REMOVE})
    @JsonIgnore
    @Column(nullable = false)
    private List<Harvest> harvests;

    public Crop(CropDTO crop, Sort sort) {
        this.sort = sort;
        this.cropName = crop.getCropName();
        this.seedlingsNumber = crop.getSeedlingsNumber();
        this.location = crop.getLocation();
        this.soil = crop.getSoil();
        this.plantStage = crop.getPlantStage();
        this.active = crop.isActive();
        this.photoUrl = crop.getPhotoUrl();
        this.cropType = crop.getCropType();
    }

    public Crop() {
    }

    public long getCropId() {
        return cropId;
    }

    public void setCropId(long cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public int getSeedlingsNumber() {
        return seedlingsNumber;
    }

    public void setSeedlingsNumber(int seedlingsNumber) {
        this.seedlingsNumber = seedlingsNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public PlantStage getPlantStage() {
        return plantStage;
    }

    public void setPlantStage(PlantStage plantStage) {
        this.plantStage = plantStage;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CropType getCropType() {
        return cropType;
    }

    public void setCropType(CropType cropType) {
        this.cropType = cropType;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<PersonalObservation> getPersonalObservations() {
        return personalObservations;
    }

    public void setPersonalObservations(List<PersonalObservation> personalObservations) {
        this.personalObservations = personalObservations;
    }

    public List<Harvest> getHarvests() {
        return harvests;
    }

    public void setHarvests(List<Harvest> harvests) {
        this.harvests = harvests;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "cropId=" + cropId +
                ", cropName='" + cropName + '\'' +
                ", seedlingsNumber=" + seedlingsNumber +
                ", active=" + active +
                ", photoUrl='" + photoUrl + '\'' +
                ", soil=" + soil +
                ", plantStage=" + plantStage +
                ", location=" + location +
                ", cropType=" + cropType +
                ", sort=" + sort +
                ", personalObservations=" + personalObservations +
                ", harvests=" + harvests +
                '}';
    }
}
