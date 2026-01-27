package com.example.bdbt_projekt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final DataService dataService;

    public UserController(DataService dataService) {
        this.dataService = dataService;
    }

    // KAFELKI (jak admin)
    @GetMapping("/user_main")
    public String userMain() {
        return "user/user_main";
    }

    // 1) lista radiostacji
    @GetMapping("/user/radiostacje")
    public String radiostacje(Model model) {
        model.addAttribute("listRadiostacje", dataService.getRadiostacje());
        return "user/radiostacje";
    }

    // 2) audycje radiostacji
    @GetMapping("/user/radiostacje/{idStacji}/audycje")
    public String audycjeRadiostacji(@PathVariable int idStacji, Model model) {
        model.addAttribute("radiostacja", dataService.getRadiostacja(idStacji));
        model.addAttribute("listAudycje", dataService.getAudycjeForRadiostacja(idStacji));
        return "user/audycje_radiostacji";
    }

    // 3) szczegóły audycji + utwory
    @GetMapping("/user/audycje/{idAudycji}")
    public String audycja(@PathVariable int idAudycji, Model model) {
        model.addAttribute("audycja", dataService.getAudycja(idAudycji));
        model.addAttribute("utwory", dataService.getUtworyForAudycja(idAudycji));
        return "user/audycje_details";
    }

    // FORMULARZ: zgłoś ulubiony utwór
    @GetMapping("/user/ulubiony_utwor")
    public String ulubionyUtworForm() {
        return "user/ulubiony_utwor";
    }

    // ZAPIS: dodaj do UTWORY
    @PostMapping("/user/ulubiony_utwor/add")
    public String ulubionyUtworAdd(@RequestParam("tytul") String tytul,
                                   @RequestParam("id_albumu") int idAlbumu) {

        Utwory u = new Utwory();
        u.setTytul(tytul);
        u.setId_albumu(idAlbumu);

        dataService.addUtwor(u);
        return "user/user_main";
    }
}