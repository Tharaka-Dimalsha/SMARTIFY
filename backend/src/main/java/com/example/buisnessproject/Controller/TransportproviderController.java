package com.example.buisnessproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.buisnessproject.Entity.Maincustomer;
import com.example.buisnessproject.Entity.Transportprovider;
import com.example.buisnessproject.Service.MainCustomerService;
import com.example.buisnessproject.Service.TransportProviderService;

@CrossOrigin(origins = "*")
@RestController
public class TransportproviderController {
    private TransportProviderService transportProviderService;

    @Autowired
    public TransportproviderController(TransportProviderService transportProviderService) {
        this.transportProviderService = transportProviderService;
    }

    @GetMapping("/transportproviders")
    public ResponseEntity<List<Transportprovider>> getTransportProviders() {
        List<Transportprovider> transportproviders = transportProviderService.getAllTransportproviders();
        return ResponseEntity.status(HttpStatus.OK).body(transportproviders);

    }

    @GetMapping("/transportproviders/{id}")
    public ResponseEntity<Transportprovider> getTransportProviderById(@PathVariable Long id) {
        try {
            Transportprovider transportProvider = transportProviderService.getTransportproviderById(id);
            return ResponseEntity.status(HttpStatus.OK).body(transportProvider);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/transportproviders")
    public ResponseEntity<Transportprovider> createTransportProvider(@RequestBody Transportprovider transportProvider) {
        try {
            Transportprovider createdTransportprovider = transportProviderService
                    .createTransportprovider(transportProvider);
            return ResponseEntity.status(HttpStatus.OK).body(createdTransportprovider);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @PutMapping("/transportproviders/{id}")
    public ResponseEntity<Transportprovider> updateTransportProvider(@PathVariable Long id,
            @RequestBody Transportprovider transportProvider) {
        try {
            Transportprovider updatedTransportProvider = transportProviderService.updateTransportprovider(id,
                    transportProvider);
            return ResponseEntity.status(HttpStatus.OK).body(updatedTransportProvider);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/transportproviders/{id}")
    public ResponseEntity<Void> deleteTransportProvider(@PathVariable Long id) {
        try {
            transportProviderService.deleteTransportprovider(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
