package com.example.buisnessproject.Service;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Backtrip;
import com.example.buisnessproject.Repository.BacktripRepository;

@Service
public class BackTripServiceImpl implements BackTripService {
    private BacktripRepository backtripRepository;

    @Autowired
    public BackTripServiceImpl(BacktripRepository backtripRepository) {
        this.backtripRepository = backtripRepository;
    }

    @Override
    public List<Backtrip> getAllBacktrips() {
        return backtripRepository.findAll();
    }

    @Override
    public Backtrip getBacktripById(Long id) {
        return backtripRepository.findById(id).orElseThrow(() -> new NullPointerException("Trip is not found" + id));
    }

    @Override
    public Backtrip createBacktrip(Backtrip backtrip) {
        return backtripRepository.save(backtrip);
    }

    @Override
    public Backtrip updateBacktrip(Long id, Backtrip backtrip) {
        Backtrip existingBackTrip = getBacktripById(id);

        existingBackTrip.setDestination(backtrip.getDestination());
        existingBackTrip.setOrigin(backtrip.getOrigin());
        existingBackTrip.setOrigindate(backtrip.getOrigindate());
        existingBackTrip.setDestinationdate(backtrip.getDestinationdate());
        existingBackTrip.setContactNo(backtrip.getContactNo());
        existingBackTrip.setSpecialrequirments(backtrip.getSpecialrequirments());
        return backtripRepository.save(existingBackTrip);
    }

    @Override
    public void deleteBacktrip(Long id) {
        backtripRepository.deleteById(id);
    }

    @Override
    public Backtrip getBacktripBytransporterId(Long transporterProviderId) {
        return backtripRepository.findById(transporterProviderId)
                .orElseThrow(() -> new NullPointerException("Trip is not found" + transporterProviderId));
    }

}
