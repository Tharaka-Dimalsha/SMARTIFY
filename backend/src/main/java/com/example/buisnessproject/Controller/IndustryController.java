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

import com.example.buisnessproject.Entity.Industry;
import com.example.buisnessproject.Service.IndustryService;

@RestController
@CrossOrigin(origins = "*")
public class IndustryController {
    private IndustryService industryService;

    @Autowired
    public IndustryController(IndustryService industryService) {
        this.industryService = industryService;
    }

    @GetMapping("/industries")
    public ResponseEntity<List<Industry>> getAllIndustries() {
        List<Industry> industries = industryService.getAllIndustries();
        return ResponseEntity.status(HttpStatus.OK).body(industries);

    }

    @GetMapping("/industries/{id}")
    public ResponseEntity<Industry> getIndustryById(@PathVariable Long id) {
        try {
            Industry industry = industryService.getIndustryById(id);
            return ResponseEntity.status(HttpStatus.OK).body(industry);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/industries")
    public ResponseEntity<Industry> createIdustry(@RequestBody Industry industry) {
        try {
            Industry createdIndustry = industryService.createIndustry(industry);
            return ResponseEntity.status(HttpStatus.OK).body(createdIndustry);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @PutMapping("/industries/{id}")
    public ResponseEntity<Industry> updateIndustry(@PathVariable Long id, @RequestBody Industry industry) {
        try {
            Industry updatedIndustry = industryService.updateIndustry(id, industry);
            return ResponseEntity.status(HttpStatus.OK).body(updatedIndustry);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/industries/{id}")
    public ResponseEntity<Void> deleteIndustry(@PathVariable Long id) {
        try {
            industryService.deleteIndustry(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
