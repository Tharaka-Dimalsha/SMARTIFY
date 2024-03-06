package com.example.buisnessproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buisnessproject.Entity.Maincustomer;
@Repository
public interface MainCustomerRepository extends JpaRepository<Maincustomer,Long>{
    
}
