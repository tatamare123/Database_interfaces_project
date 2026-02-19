package com.example.manager_pro.Repository;

import com.example.manager_pro.clienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientiRepository extends JpaRepository<clienti, Integer> {

}