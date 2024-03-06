package com.example.buisnessproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Transportprovider;

@Service
public interface TransportProviderService {
    List<Transportprovider> getAllTransportproviders();

    Transportprovider getTransportproviderById(Long id);

    Transportprovider createTransportprovider(Transportprovider transportprovider);

    Transportprovider updateTransportprovider(Long id, Transportprovider transportprovider);

    void deleteTransportprovider(Long id);
}
