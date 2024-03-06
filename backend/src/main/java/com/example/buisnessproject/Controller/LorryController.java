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
import com.example.buisnessproject.Entity.Lorry;
import com.example.buisnessproject.Service.BackTripService;
import com.example.buisnessproject.Service.LorryService;
@RestController
@CrossOrigin(origins="*")
public class LorryController {
     private LorryService lorryService;

    @Autowired
    public LorryController(LorryService lorryService) {
        this.lorryService = lorryService;
    }

    @GetMapping("/lorriess")
    public ResponseEntity<List<Lorry>> getAllLorries() {
        List<Lorry> lorries = lorryService.getAllLorries();
        return ResponseEntity.status(HttpStatus.OK).body(lorries);

    }

    @GetMapping("/lorries/{id}")
    public ResponseEntity<Lorry> getLorryById(@PathVariable Long id) {
        try {
            Lorry lorry = lorryService.getLorryById(id);
            return ResponseEntity.status(HttpStatus.OK).body(lorry);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/lorries")
    public ResponseEntity<Lorry> createLorry(@RequestBody Lorry lorry) {
        try {
            Lorry createdLorry = lorryService.createLorry(lorry);
            return ResponseEntity.status(HttpStatus.OK).body(createdLorry);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @PutMapping("/lorries/{id}")
    public ResponseEntity<Lorry> updateLorry(@PathVariable Long id, @RequestBody Lorry lorry) {
        try {
            Lorry updatedLorry = lorryService.updateLorry(id, lorry);
            return ResponseEntity.status(HttpStatus.OK).body(updatedLorry);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/lorriess/{id}")
    public ResponseEntity<Void> deleteLorry(@PathVariable Long id) {
        try {
            lorryService.deleteLorry(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    

}
