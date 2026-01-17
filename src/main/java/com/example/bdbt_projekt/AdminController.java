package com.example.bdbt_projekt;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    private final DataService dataService;

    public AdminController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/admin/audycje")
    public String manageAudycje(Model model) {
        model.addAttribute("listAudycje", dataService.getAudycje());
        model.addAttribute("listRadiostacje", dataService.getRadiostacje());
        return "admin/manage_audycje";
    }

    // Widok dla zarządzania radiostacjami
    @RequestMapping("/admin/radiostacje")
    public String manageRadiostacje() {
        return "admin/manage_radiostacje"; // Ścieżka do szablonu Thymeleaf
    }

    // Widok dla zarządzania audycjami
    @RequestMapping("/admin/audycje")
    public String manageAudycje() {
        return "admin/manage_audycje"; // Ścieżka do szablonu Thymeleaf
    }

    // Widok dla zarządzania utworami
    @RequestMapping("/admin/utwory")
    public String manageUtwory() {
        return "admin/manage_utwory"; // Ścieżka do szablonu Thymeleaf
    }

    // Widok dla zarządzania prowadzącymi
    @RequestMapping("/admin/prowadzacy")
    public String manageProwadzacy() {
        return "admin/manage_prowadzacy"; // Ścieżka do szablonu Thymelea
    }
}

    // Możliwe inne en