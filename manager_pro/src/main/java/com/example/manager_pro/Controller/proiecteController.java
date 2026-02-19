package com.example.manager_pro.Controller;

import com.example.manager_pro.clienti;
import com.example.manager_pro.proiecte;
import com.example.manager_pro.Repository.proiecteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;


import java.util.List;

@RestController
@RequestMapping("/api/projects") // This is the URL path
@CrossOrigin("*") // Allows your frontend to connect without security blocks
@RequiredArgsConstructor

public class proiecteController {

    @Autowired
    private proiecteRepository proiecteRepository;

    // Get all clients from the database
    @GetMapping
    public List<proiecte> getAllProjects() {
        return proiecteRepository.findAll();
    }

    // Add a new client to the database
    @PostMapping
    public proiecte createclienti(@RequestBody proiecte proiect) {
        return proiecteRepository.save(proiect);
    }


    //Update a Client Data
    @PutMapping("/{id}")
    public proiecte updateproiect(@PathVariable Integer id, @RequestBody proiecte proiecteDetails) {
        proiecte proiect = proiecteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));

        proiect.setDenumire(proiecteDetails.getDenumire());
        proiect.setData_start(proiecteDetails.getData_start());
        proiect.setData_final(proiecteDetails.getData_final());

        return proiecteRepository.save(proiect);
    }

    // Delete a Client
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteclient(@PathVariable Integer id) {
        if (!proiecteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
        proiecteRepository.deleteById(id);
    }
}
