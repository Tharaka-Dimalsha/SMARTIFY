package com.example.buisnessproject.Service;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Maincustomer;
import com.example.buisnessproject.Entity.Transportprovider;
import com.example.buisnessproject.Repository.MainCustomerRepository;
import com.example.buisnessproject.Repository.TransportproviderRepository;

@Service
public class TransportProviderServiceImpl implements TransportProviderService {
    private TransportproviderRepository transportproviderRepository;

    @Autowired
    public TransportProviderServiceImpl(TransportproviderRepository transportproviderRepository) {
        this.transportproviderRepository = transportproviderRepository;
    }

    @Override
    public List<Transportprovider> getAllTransportproviders() {
        return transportproviderRepository.findAll();
    }

    @Override
    public Transportprovider getTransportproviderById(Long id) {
        return transportproviderRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("MainCustomer is not found" + id));
    }

    @Override
    public Transportprovider createTransportprovider(Transportprovider transportprovider) {
        return transportproviderRepository.save(transportprovider);
    }

    @Override
    public Transportprovider updateTransportprovider(Long id, Transportprovider transportprovider) {
        Transportprovider existingTransportprovider = getTransportproviderById(id);

        existingTransportprovider.setName(transportprovider.getName());
        return transportproviderRepository.save(existingTransportprovider);
    }

    @Override
    public void deleteTransportprovider(Long id) {
        transportproviderRepository.deleteById(id);
    }
}
