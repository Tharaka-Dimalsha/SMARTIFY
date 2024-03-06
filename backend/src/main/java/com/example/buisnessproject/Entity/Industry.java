package com.example.buisnessproject.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Locale.Category;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.mapping.ManyToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "industry")
public class Industry {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(name = "Lorry_Industry", joinColumns = @JoinColumn(name = "lorry_id"), inverseJoinColumns = @JoinColumn(name = "industry_id"))
    private Set<Lorry> lorries;

}
