package com.example.manager_pro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "proiecte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class proiecte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proiect")
    private Integer id_proiect;

    @Column(name = "denumire")
    private String denumire;

    @Column(name = "data_start")
    private LocalDate data_start;

    @Column(name = "data_final")
    private  LocalDate data_final;
}