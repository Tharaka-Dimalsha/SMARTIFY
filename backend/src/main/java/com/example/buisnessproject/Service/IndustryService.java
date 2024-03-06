package com.example.buisnessproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Industry;
import com.example.buisnessproject.Entity.Lorry;
@Service
public interface IndustryService {
     List<Industry> getAllIndustries();

    Industry getIndustryById(Long id);

    Industry createIndustry(Industry industry);

    Industry updateIndustry(Long id, Industry industry);

    void deleteIndustry(Long id);
}
