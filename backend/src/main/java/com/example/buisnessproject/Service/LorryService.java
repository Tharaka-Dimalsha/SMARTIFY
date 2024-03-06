package com.example.buisnessproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Backtrip;
import com.example.buisnessproject.Entity.Lorry;
@Service
public interface LorryService{
     List<Lorry> getAllLorries();

    Lorry getLorryById(Long id);

    Lorry createLorry(Lorry lorry);

    Lorry updateLorry(Long id, Lorry lorry);

    void deleteLorry(Long id);

}
