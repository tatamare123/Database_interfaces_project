package com.example.manager_pro.Repository;

import com.example.manager_pro.proiecte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface proiecteRepository extends JpaRepository<proiecte, Integer> {
    // Leave this empty for now!
}