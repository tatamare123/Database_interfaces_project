package com.example.manager_pro.Repository;

import com.example.manager_pro.clienti_proiecte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienti_proiecteRepository extends JpaRepository<clienti_proiecte, Integer> {
    // Leave this empty for now!
}