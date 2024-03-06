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

import com.example.buisnessproject.Entity.Backtrip;
import com.example.buisnessproject.Service.BackTripService;

@CrossOrigin(origins = "*")
@RestController
public class BackTripController {

    private BackTripService backTripService;

    @Autowired
    public BackTripController(BackTripService backTripService) {
        this.backTripService = backTripService;
    }

    @GetMapping("/backtrips")
    public ResponseEntity<List<Backtrip>> getAllBackTrip() {
        List<Backtrip> backtrips = backTripService.getAllBacktrips();
        return ResponseEntity.status(HttpStatus.OK).body(backtrips);

    }

    @GetMapping("/backtrips/{id}")
    public ResponseEntity<Backtrip> getBackTripById(@PathVariable Long id) {
        try {
            Backtrip backtrip = backTripService.getBacktripById(id);
            return ResponseEntity.status(HttpStatus.OK).body(backtrip);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/backtrips")
    public ResponseEntity<Backtrip> createBacktrip(@RequestBody Backtrip backtrip) {
        try {
            Backtrip createdBacktrip = backTripService.createBacktrip(backtrip);
            return ResponseEntity.status(HttpStatus.OK).body(createdBacktrip);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @PutMapping("/backtrips/{id}")
    public ResponseEntity<Backtrip> updateBacktrip(@PathVariable Long id, @RequestBody Backtrip backtrip) {
        try {
            Backtrip updatedBacktrip = backTripService.updateBacktrip(id, backtrip);
            return ResponseEntity.status(HttpStatus.OK).body(updatedBacktrip);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/backtrips/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        try {
            backTripService.deleteBacktrip(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @GetMapping("transportproviders/{id}backtrips")
    public ResponseEntity<Backtrip> getBackTripBytransporterproviderId(@PathVariable Long transportproviderId) {
        try {
            Backtrip backtrip = backTripService.getBacktripBytransporterId(transportproviderId);
            return ResponseEntity.status(HttpStatus.OK).body(backtrip);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
