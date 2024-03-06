package com.example.buisnessproject.Repository;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.buisnessproject.Entity.Backtrip;
import com.example.buisnessproject.Entity.Transportprovider;

@Repository
public interface BacktripRepository extends JpaRepository<Backtrip, Long> {

}
