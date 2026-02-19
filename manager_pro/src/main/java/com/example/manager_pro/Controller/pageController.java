package com.example.manager_pro.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

import com.example.manager_pro.clienti;
import com.example.manager_pro.proiecte;
import com.example.manager_pro.clienti_proiecte;

import com.example.manager_pro.Repository.clientiRepository;
import com.example.manager_pro.Repository.proiecteRepository;
import com.example.manager_pro.Repository.clienti_proiecteRepository;
@Controller
@RequestMapping("/view")
@RequiredArgsConstructor

public class pageController {
    private final clientiRepository clientiRepo;
    private final proiecteRepository proiecteRepo;
    private final clienti_proiecteRepository clienti_proiecteRepo;

    @GetMapping("/dashboard")
    public String dashboard(){
        return "index";
    }
    //Clienti
    @GetMapping("/clienti")
    public String listClients(Model model) {
        model.addAttribute("lista", clientiRepo.findAll());
        return "clienti-list";
    }

    @GetMapping("/clienti/new")
    public String newClient(Model model) {
        model.addAttribute("obj", new clienti());
        return "clienti-form";
    }
    @GetMapping("/clienti/update/{id}")
    public String editClient(@PathVariable Integer id, Model model) {
        model.addAttribute("obj", clientiRepo.findById(id).orElseThrow());
        return "clienti-form";
    }

    @PostMapping("/clienti/save")
    public String saveClient(@ModelAttribute("obj") clienti c) {
        clientiRepo.save(c);
        return "redirect:/view/clienti";
    }

    @GetMapping("/clienti/delete/{id}")
    public String deleteClient(@PathVariable Integer id) {
        clientiRepo.deleteById(id);
        return "redirect:/view/clienti";
    }

    //Proiecte
    @GetMapping("/proiecte")
    public String listProjects(Model model) {
        model.addAttribute("lista", proiecteRepo.findAll());
        return "proiecte-list";
    }

    @GetMapping("/proiecte/new")
    public String newProject(Model model) {
        model.addAttribute("obj", new proiecte());
        return "proiecte-form";
    }
    @GetMapping("/proiecte/update/{id}")
    public String editProject(@PathVariable Integer id, Model model) {
        model.addAttribute("obj", proiecteRepo.findById(id).orElseThrow());
        return "proiecte-form";
    }

    @PostMapping("/proiecte/save")
    public String saveProject(@ModelAttribute("obj") proiecte p) {
        proiecteRepo.save(p);
        return "redirect:/view/proiecte";
    }

    @GetMapping("/proiecte/delete/{id}")
    public String deleteProject(@PathVariable Integer id) {
        proiecteRepo.deleteById(id);
        return "redirect:/view/proiecte";
    }

    //Clienti_Proiecte
    @GetMapping("/clienti_proiecte")
    public String listAssignments(Model model) {
        model.addAttribute("lista", clienti_proiecteRepo.findAll());
        return "clienti_proiecte-list";
    }

    @GetMapping("/clienti_proiecte/new")
    public String newAssignment(Model model) {
        model.addAttribute("obj", new clienti_proiecte());
        model.addAttribute("allClients", clientiRepo.findAll());
        model.addAttribute("allProjects", proiecteRepo.findAll());
        return "clienti_proiecte-form";
    }
    @GetMapping("/clienti_proiecte/update/{id}")
    public String editAssignment(@PathVariable Integer id, Model model) {
        // Find the assignment using id_rol
        clienti_proiecte assignment = clienti_proiecteRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID:" + id));

        // Add the found object to the model
        model.addAttribute("obj", assignment);

        // IMPORTANT: Repopulate dropdown lists for the form
        model.addAttribute("allClients", clientiRepo.findAll());
        model.addAttribute("allProjects", proiecteRepo.findAll());

        return "clienti_proiecte-form";
    }

    @PostMapping("/clienti_proiecte/save")
    public String saveAssignment(@ModelAttribute("obj") clienti_proiecte cp) {
        clienti_proiecteRepo.save(cp);
        return "redirect:/view/clienti_proiecte";
    }

    @GetMapping("/clienti_proiecte/delete/{id}")
    public String deleteAssignments(@PathVariable Integer id) {
        clienti_proiecteRepo.deleteById(id);
        return "redirect:/view/clienti_proiecte";
    }

}
