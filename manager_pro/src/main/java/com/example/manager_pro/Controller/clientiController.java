package com.example.manager_pro.Controller;

import com.example.manager_pro.clienti;
import com.example.manager_pro.Repository.clientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/clients") // This is the URL path
@CrossOrigin("*") // Allows your frontend to connect without security blocks
@RequiredArgsConstructor
public class clientiController {

    @Autowired
    private clientiRepository clientiRepository;

    @GetMapping("/")
    public String welcome() {
        return "<html><body><h1>CLIENTS MANAGER</h1></body></html>";
    }
    //Get All Clients
    @GetMapping
    public List<clienti> getAllClients() {
        return clientiRepository.findAll();
    }

    // Create a Client
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public clienti createclient(@RequestBody clienti client) {
        return clientiRepository.save(client);
    }

    //Update a Client Data
    @PutMapping("/{id}")
    public clienti updateclient(@PathVariable Integer id, @RequestBody clienti clientiDetails) {
        clienti client = clientiRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));

        client.setNume(clientiDetails.getNume());
        client.setTelefon(clientiDetails.getTelefon());
        client.setEmail(clientiDetails.getEmail());

        return clientiRepository.save(client);
    }

    // Delete a Client
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteclient(@PathVariable Integer id) {
        if (!clientiRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
        }
        clientiRepository.deleteById(id);
    }
}
