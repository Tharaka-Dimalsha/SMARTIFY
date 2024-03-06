package com.example.buisnessproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Backtrip;
import com.example.buisnessproject.Entity.Lorry;
import com.example.buisnessproject.Repository.BacktripRepository;
import com.example.buisnessproject.Repository.LorryRepository;

@Service
public class LorryServiceImpl implements LorryService {
    private LorryRepository lorryRepository;

    @Autowired
    public LorryServiceImpl(LorryRepository lorryRepository) {
        this.lorryRepository = lorryRepository;
    }

    @Override
    public List<Lorry> getAllLorries() {
        return lorryRepository.findAll();
    }

    @Override
    public Lorry getLorryById(Long id) {
        return lorryRepository.findById(id).orElseThrow(() -> new NullPointerException("Trip is not found" + id));
    }

    @Override
    public Lorry createLorry(Lorry lorry) {
        return lorryRepository.save(lorry);
    }

    @Override
    public Lorry updateLorry(Long id, Lorry lorry) {
        Lorry existingLorry = getLorryById(id);

        existingLorry.setNumberPlate(lorry.getNumberPlate());

        existingLorry.setIndustry(lorry.getIndustry());
        existingLorry.setCargotype(lorry.getCargotype());
        existingLorry.setWeight(lorry.getWeight());
        existingLorry.setVolume(lorry.getVolume());

        return lorryRepository.save(existingLorry);
    }

    @Override
    public void deleteLorry(Long id) {
        lorryRepository.deleteById(id);
    }

}
