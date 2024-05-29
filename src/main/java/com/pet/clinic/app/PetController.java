package com.pet.clinic.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PetController {

    @Autowired
    private PetRepo repo;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("pet", new Pet());
        return "register";
    }
    
    @GetMapping("/search")
    public String getSearchPage(Model model) {
        model.addAttribute("petSearch", new Pet());
        return "search"; 
    }
    
    @GetMapping("/dashboard")
    public String getDashboardPage(Model model) {
        model.addAttribute("pets", repo.findAll());
        return "dashboard";
    }

    @PostMapping("/register")
    public String savePet(@ModelAttribute("pet") Pet pet, RedirectAttributes redirectAttributes) {
    	repo.save(pet);
        redirectAttributes.addFlashAttribute("message", "Your Appointment successful Booked!");
        return "redirect:/register";
    }

    @PostMapping("/search")
    public String postSearchPage(@ModelAttribute("petSearch") Pet pet, Model model) {
        String slotId = pet.getSlotid();
        List<Pet> petList = repo.findBySlotid(slotId);
        
        model.addAttribute("petList", petList);
        return "search";
    }
    
}
