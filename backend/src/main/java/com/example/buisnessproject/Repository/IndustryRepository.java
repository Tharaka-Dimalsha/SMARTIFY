package com.example.buisnessproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buisnessproject.Entity.Industry;
@Repository
public interface IndustryRepository extends JpaRepository <Industry,Long> {
    
}
