package com.example.manager_pro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "clienti_proiecte")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class clienti_proiecte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer id_rol;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private clienti client;

    @ManyToOne
    @JoinColumn(name = "id_proiect")
    private proiecte proiect;

    @Column(name = "rol_client")
    private String rol_client;


    }