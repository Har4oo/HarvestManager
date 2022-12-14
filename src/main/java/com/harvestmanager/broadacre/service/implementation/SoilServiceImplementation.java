package com.harvestmanager.broadacre.service.implementation;

import com.harvestmanager.broadacre.entity.Soil;
import com.harvestmanager.broadacre.repository.SoilRepository;
import com.harvestmanager.broadacre.service.SoilService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SoilServiceImplementation implements SoilService {
    private SoilRepository soilRepository;

    @Override
    public List<Soil> getSoils() {
        return soilRepository.findAll();
    }

    @Override
    public Soil getSoil(long id) {
        return soilRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));
    }

    @Override
    public Soil createSoil(Soil soil) {
        return soilRepository.save(soil);
    }

    @Override
    public Soil updateSoil(Soil soil, long id) {
        soil.setSoilId(id);
        return soilRepository.save(soil);
    }

    @Override
    public void deleteSoil(long id) {
        soilRepository.deleteById(id);
    }
}
