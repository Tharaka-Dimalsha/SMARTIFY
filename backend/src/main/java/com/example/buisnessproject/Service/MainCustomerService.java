package com.example.buisnessproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.buisnessproject.Entity.Maincustomer;
@Service
public interface MainCustomerService {
    List<Maincustomer> getAllMaincustomers();

   Maincustomer getMaincustomerById(Long id);

   Maincustomer createMaincustomer(Maincustomer maincustomer);

   Maincustomer updateMaincustomer(Long id, Maincustomer maincustomer);

   void deleteMaincustomer(Long id);
}
