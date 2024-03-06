package com.example.buisnessproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Industry;
import com.example.buisnessproject.Entity.Lorry;
import com.example.buisnessproject.Repository.IndustryRepository;
import com.example.buisnessproject.Repository.LorryRepository;

@Service
public class IndustryServiceImpl implements IndustryService {
    private IndustryRepository industryRepository;

    @Autowired
    public IndustryServiceImpl(IndustryRepository industryRepository) {
        this.industryRepository = industryRepository;
    }

    @Override
    public List<Industry> getAllIndustries() {
        return industryRepository.findAll();
    }

    @Override
    public Industry getIndustryById(Long id) {
        return industryRepository.findById(id).orElseThrow(() -> new NullPointerException("Trip is not found" + id));
    }

    @Override
    public Industry createIndustry(Industry industry) {
        return industryRepository.save(industry);
    }

    @Override
    public Industry updateIndustry(Long id, Industry industry) {
        Industry existingIndustry = getIndustryById(id);

        existingIndustry.setName(industry.getName());

        return industryRepository.save(existingIndustry);
    }

    @Override
    public void deleteIndustry(Long id) {
        industryRepository.deleteById(id);
    }
}
