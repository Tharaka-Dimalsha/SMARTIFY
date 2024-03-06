package com.example.buisnessproject.Entity;

import java.util.Date;
import java.util.Set;
import java.util.Locale.Category;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "backtrip")
@Data
public class Backtrip {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Destination;

    @Column(nullable = false)
    private String Origin;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private Date Origindate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private Date Destinationdate;

    @Column(nullable = false)
    private Long ContactNo;

    @Column(nullable = true)
    private String Specialrequirments;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "industry_id") // foreign column
    private Set<Industry> industry;

}
