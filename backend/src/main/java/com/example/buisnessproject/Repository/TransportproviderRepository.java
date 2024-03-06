package com.example.buisnessproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buisnessproject.Entity.Transportprovider;
@Repository
public interface TransportproviderRepository extends JpaRepository<Transportprovider, Long> {

}
