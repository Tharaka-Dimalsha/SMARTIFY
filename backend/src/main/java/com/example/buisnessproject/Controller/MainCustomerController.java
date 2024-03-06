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
import com.example.buisnessproject.Entity.Maincustomer;
import com.example.buisnessproject.Service.BackTripService;
import com.example.buisnessproject.Service.MainCustomerService;

@CrossOrigin(origins = "*")
@RestController
public class MainCustomerController {
    private MainCustomerService mainCustomerService;

    @Autowired
    public MainCustomerController(MainCustomerService mainCustomerService) {
        this.mainCustomerService = mainCustomerService;
    }

    @GetMapping("/maincustomers")
    public ResponseEntity<List<Maincustomer>> getAllMainCustomer() {
        List<Maincustomer> maincustomers = mainCustomerService.getAllMaincustomers();
        return ResponseEntity.status(HttpStatus.OK).body(maincustomers);

    }

    @GetMapping("/maincustomers/{id}")
    public ResponseEntity<Maincustomer> getMainCustomerById(@PathVariable Long id) {
        try {
            Maincustomer maincustomer = mainCustomerService.getMaincustomerById(id);
            return ResponseEntity.status(HttpStatus.OK).body(maincustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/maincustomers")
    public ResponseEntity<Maincustomer> createMainCustomer(@RequestBody Maincustomer maincustomer) {
        try {
            Maincustomer createdMaincustomer = mainCustomerService.createMaincustomer(maincustomer);
            return ResponseEntity.status(HttpStatus.OK).body(createdMaincustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @PutMapping("/maincustomers/{id}")
    public ResponseEntity<Maincustomer> updateMainCustomer(@PathVariable Long id,
            @RequestBody Maincustomer maincustomer) {
        try {
            Maincustomer updatedMaincustomer = mainCustomerService.updateMaincustomer(id, maincustomer);
            return ResponseEntity.status(HttpStatus.OK).body(updatedMaincustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/maincustomers/{id}")
    public ResponseEntity<Void> deleteMainCustomer(@PathVariable Long id) {
        try {
            mainCustomerService.deleteMaincustomer(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
