package com.example.buisnessproject.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "lorry")
@Entity
public class Lorry {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numberPlate;

    @Column(nullable = false)
    private String industry;

    @Column(nullable = false)
    private String Cargotype;

    @Column(nullable = true)
    private Long weight;

    @Column(nullable = true)
    private Long volume;

}
