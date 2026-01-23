package com.example.bdbt_projekt;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

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
    @GetMapping("/admin/audycje/edit")
    public String editAudycjaForm(@RequestParam("id_audycji") int idAudycji, Model model) {
        model.addAttribute("audycja", dataService.getAudycja(idAudycji));
        return "admin/edit_audycje";
    }

    // Widok dla zarządzania radiostacjami
    @RequestMapping("/admin/radiostacje")
    public String manageRadiostacje() {
        return "admin/manage_radiostacje"; // Ścieżka do szablonu Thymeleaf
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
    @PostMapping("/admin/audycje/add")
    public String addAudycja(
            @RequestParam("tytul_audycji") String tytul,
            @RequestParam("opis") String opis,
            @RequestParam("kategoria") String kategoria,
            @RequestParam("id_studia") int idStudia,
            @RequestParam("data_emisji") String dataEmisjiStr
    ) {
        // input type="date" wysyła yyyy-MM-dd
        LocalDate dataEmisji = LocalDate.parse(dataEmisjiStr);

        Audycje a = new Audycje();
        a.setTytul_audycji(tytul);
        a.setOpis(opis);
        a.setKategoria(kategoria);
        a.setId_studia(idStudia);

        // Audycje ma java.util.Date, więc ustawiamy java.sql.Date (działa z Oracle DATE)
        a.setData_emisji(java.sql.Date.valueOf(dataEmisji));

        dataService.addAudycja(a);
        return "redirect:/admin/audycje";
    }
    @PostMapping("/admin/audycje/delete")
    public String deleteAudycja(@RequestParam("id_audycji") int idAudycji) {
        dataService.deleteAudycja(idAudycji);
        return "redirect:/admin/audycje";
    }
    @PostMapping("/admin/audycje/update")
    public String updateAudycja(
            @RequestParam("id_audycji") int idAudycji,
            @RequestParam("tytul_audycji") String tytul,
            @RequestParam("opis") String opis,
            @RequestParam("kategoria") String kategoria
    ) {
        Audycje a = new Audycje();
        a.setId_audycji(idAudycji);
        a.setTytul_audycji(tytul);
        a.setOpis(opis);
        a.setKategoria(kategoria);

        dataService.updateAudycja(a);
        return "redirect:/admin/audycje";
    }

}
