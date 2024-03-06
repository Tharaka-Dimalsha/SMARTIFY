package com.example.buisnessproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.buisnessproject.Entity.Backtrip;
import com.example.buisnessproject.Entity.Lorry;
import com.example.buisnessproject.Entity.Transportprovider;


public interface LorryRepository extends JpaRepository<Lorry, Long> {
  
}

