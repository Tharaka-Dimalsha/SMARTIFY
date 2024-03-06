package com.example.buisnessproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Backtrip;

@Service
public interface BackTripService {
    List<Backtrip> getAllBacktrips();

    Backtrip getBacktripById(Long id);

    Backtrip createBacktrip(Backtrip backtrip);

    Backtrip updateBacktrip(Long id, Backtrip backtrip);

    void deleteBacktrip(Long id);

    Backtrip getBacktripBytransporterId(Long transportproviderId);
}
