package com.example.manager_pro.Controller;

import com.example.manager_pro.clienti_proiecte;
import com.example.manager_pro.Repository.clienti_proiecteRepository;
import com.example.manager_pro.proiecte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/clients_projects") // This is the URL path
@CrossOrigin("*") // Allows your frontend to connect without security blocks
@RequiredArgsConstructor
public class clienti_proiecteController {

    @Autowired
    private clienti_proiecteRepository clienti_proiecteRepository;

    // Get all clients from the database
    @GetMapping
    public List<clienti_proiecte> getAllAssignments() {
        return clienti_proiecteRepository.findAll();
    }

    // Add a new client to the database
    @PostMapping
    public clienti_proiecte createclienti(@RequestBody clienti_proiecte assignment) {
        return clienti_proiecteRepository.save(assignment);
    }

    //Update a Client Data
//    @PutMapping("/{id}")
//    public clienti_proiecte updateproiect(@PathVariable Integer id, @RequestBody clienti_proiecte assignmentDetails) {
//        clienti_proiecte assignment = clienti_proiecteRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));
//
//        assignment.setId_client(assignmentDetails.getId_client());
//        assignment.setId_proiect(assignmentDetails.getId_proiect());
//        assignment.setRol_client(assignmentDetails.getRol_client());
//
//        return clienti_proiecteRepository.save(assignment);
//    }

    @PutMapping("/{id}")
    public clienti_proiecte updateassignment(@PathVariable Integer id, @RequestBody clienti_proiecte assignmentDetails) {
        clienti_proiecte assignment = clienti_proiecteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Assignment not found"));

        // Update using the full objects provided in the request body
        assignment.setClient(assignmentDetails.getClient());
        assignment.setProiect(assignmentDetails.getProiect());
        assignment.setRol_client(assignmentDetails.getRol_client());

        return clienti_proiecteRepository.save(assignment);
    }

    // Delete a Client
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteclient(@PathVariable Integer id) {
        if (!clienti_proiecteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
        clienti_proiecteRepository.deleteById(id);
    }
}
