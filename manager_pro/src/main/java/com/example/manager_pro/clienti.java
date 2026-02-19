package com.example.manager_pro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clienti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class clienti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer id_client;

    @Column(name = "nume")
    private String nume;

    @Column(name = "email")
    private String email;

    @Column(name = "telefon")
    private  String telefon;
}
