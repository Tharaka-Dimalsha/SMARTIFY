package com.example.buisnessproject.Entity;

import java.util.List;
import java.util.Set;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "transportprovider")
public class Transportprovider {
     @Id
     @Column
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false)
     private String name;

     @OneToMany(fetch = FetchType.EAGER)
     @JoinColumn(name = "industry_id") // foreign column
     private Set<Lorry> lorry;

}
