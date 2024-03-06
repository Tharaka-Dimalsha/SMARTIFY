package com.example.buisnessproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Backtrip;
import com.example.buisnessproject.Entity.Maincustomer;
import com.example.buisnessproject.Repository.BacktripRepository;
import com.example.buisnessproject.Repository.MainCustomerRepository;

@Service
public class MainCustomerServiceImpl implements MainCustomerService {
    private MainCustomerRepository mainCustomerRepository;

    @Autowired
    public MainCustomerServiceImpl(MainCustomerRepository mainCustomerRepository) {
        this.mainCustomerRepository = mainCustomerRepository;
    }

    @Override
    public List<Maincustomer> getAllMaincustomers() {
        return mainCustomerRepository.findAll();
    }

    @Override
    public Maincustomer getMaincustomerById(Long id) {
        return mainCustomerRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("MainCustomer is not found" + id));
    }

    @Override
    public Maincustomer createMaincustomer(Maincustomer maincustomer) {
        return mainCustomerRepository.save(maincustomer);
    }

    @Override
    public Maincustomer updateMaincustomer(Long id, Maincustomer maincustomer) {
        Maincustomer existingMainCustomer = getMaincustomerById(id);

        existingMainCustomer.setName(maincustomer.getName());

        return mainCustomerRepository.save(existingMainCustomer);
    }

    @Override
    public void deleteMaincustomer(Long id) {
        mainCustomerRepository.deleteById(id);
    }
}
