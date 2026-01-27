package com.example.bdbt_projekt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class AdminController {

    private final DataService dataService;

    public AdminController(DataService dataService) {
        this.dataService = dataService;
    }

    // =========================
    // AUDYCJE
    // =========================
    @GetMapping("/admin/audycje")
    public String manageAudycje(Model model) {
        model.addAttribute("listAudycje", dataService.getAudycjeView()); // teraz view z radiostacją
        model.addAttribute("listStudia", dataService.getStudia());       // dropdown do dodawania
        return "admin/manage_audycje";
    }

    @PostMapping("/admin/audycje/add")
    public String addAudycja(
            @RequestParam("tytul_audycji") String tytul,
            @RequestParam("opis") String opis,
            @RequestParam("kategoria") String kategoria,
            @RequestParam("id_studia") int idStudia,
            @RequestParam("data_emisji") String dataEmisjiStr
    ) {
        LocalDate dataEmisji = LocalDate.parse(dataEmisjiStr);

        Audycje a = new Audycje();
        a.setTytul_audycji(tytul);
        a.setOpis(opis);
        a.setKategoria(kategoria);
        a.setId_studia(idStudia);
        a.setData_emisji(java.sql.Date.valueOf(dataEmisji));

        dataService.addAudycja(a);
        return "redirect:/admin/audycje";
    }

    @PostMapping("/admin/audycje/delete")
    public String deleteAudycja(@RequestParam("id_audycji") int idAudycji) {
        dataService.deleteAudycja(idAudycji);
        return "redirect:/admin/audycje";
    }

    @GetMapping("/admin/audycje/edit")
    public String editAudycjaForm(@RequestParam("id_audycji") int idAudycji, Model model) {
        model.addAttribute("audycja", dataService.getAudycja(idAudycji));
        model.addAttribute("listStudia", dataService.getStudia());
        return "admin/edit_audycje";
    }

    @PostMapping("/admin/audycje/update")
    public String updateAudycja(
            @RequestParam("id_audycji") int idAudycji,
            @RequestParam("tytul_audycji") String tytul,
            @RequestParam("opis") String opis,
            @RequestParam("kategoria") String kategoria,
            @RequestParam("id_studia") int idStudia,
            @RequestParam("data_emisji") String dataEmisjiStr
    ) {
        LocalDate dataEmisji = LocalDate.parse(dataEmisjiStr);

        Audycje a = new Audycje();
        a.setId_audycji(idAudycji);
        a.setTytul_audycji(tytul);
        a.setOpis(opis);
        a.setKategoria(kategoria);
        a.setId_studia(idStudia);
        a.setData_emisji(java.sql.Date.valueOf(dataEmisji));

        dataService.updateAudycja(a);
        return "redirect:/admin/audycje";
    }

    // =========================
    // ADRESY
    // =========================
    @GetMapping("/admin/adresy")
    public String manageAdresy(Model model) {
        model.addAttribute("listAdresy", dataService.getAdresy());
        return "admin/manage_adresy";
    }

    @PostMapping("/admin/adresy/add")
    public String addAdres(
            @RequestParam("miejscowosc") String miejscowosc,
            @RequestParam("ulica") String ulica,
            @RequestParam("nr_budynku") int nrBudynku,
            @RequestParam(value = "nr_lokalu", required = false) Integer nrLokalu,
            @RequestParam("kod_pocztowy") String kodPocztowy
    ) {
        Adresy a = new Adresy();
        a.setMiejscowosc(miejscowosc);
        a.setUlica(ulica);
        a.setNr_budynku(nrBudynku);
        a.setNr_lokalu(nrLokalu);
        a.setKod_pocztowy(kodPocztowy);

        dataService.addAdres(a);
        return "redirect:/admin/adresy";
    }

    @PostMapping("/admin/adresy/delete")
    public String deleteAdres(@RequestParam("id_adresu") int idAdresu) {
        dataService.deleteAdres(idAdresu);
        return "redirect:/admin/adresy";
    }

    // =========================
    // RADIOSTACJE
    // =========================
    @GetMapping("/admin/radiostacje")
    public String manageRadiostacje(Model model) {
        model.addAttribute("listRadiostacje", dataService.getRadiostacje()); // LISTA (JOIN)
        model.addAttribute("listAdresy", dataService.getAdresy());           // dropdown
        return "admin/manage_radiostacje";
    }

    @PostMapping("/admin/radiostacje/add")
    public String addRadiostacja(
            @RequestParam("nazwa") String nazwa,
            @RequestParam("id_adresu") int idAdresu
    ) {
        Radiostacje r = new Radiostacje();
        r.setNazwa(nazwa);
        r.setId_adresu(idAdresu);

        dataService.addRadiostacja(r);
        return "redirect:/admin/radiostacje";
    }

    @PostMapping("/admin/radiostacje/delete")
    public String deleteRadiostacja(@RequestParam("id_stacji") int idStacji) {
        dataService.deleteRadiostacja(idStacji);
        return "redirect:/admin/radiostacje";
    }

    @GetMapping("/admin/radiostacje/edit")
    public String editRadiostacjaForm(@RequestParam("id_stacji") int idStacji, Model model) {
        model.addAttribute("radiostacja", dataService.getRadiostacja(idStacji));
        model.addAttribute("listAdresy", dataService.getAdresy());
        return "admin/edit_radiostacje";
    }

    @PostMapping("/admin/radiostacje/update")
    public String updateRadiostacja(
            @RequestParam("id_stacji") int idStacji,
            @RequestParam("nazwa") String nazwa,
            @RequestParam("id_adresu") int idAdresu
    ) {
        Radiostacje r = new Radiostacje();
        r.setId_stacji(idStacji);
        r.setNazwa(nazwa);
        r.setId_adresu(idAdresu);

        dataService.updateRadiostacja(r);
        return "redirect:/admin/radiostacje";
    }

    // =========================
    // PLACEHOLDERY (na później)
    // =========================
    @RequestMapping("/admin/utwory")
    public String manageUtwory() {
        return "admin/manage_utwory";
    }

    @RequestMapping("/admin/prowadzacy")
    public String manageProwadzacy() {
        return "admin/manage_prowadzacy";
    }
    @GetMapping("/admin/studia")
    public String manageStudia(Model model) {
        model.addAttribute("listStudia", dataService.getStudiaView());
        model.addAttribute("listRadiostacje", dataService.getRadiostacje()); // do dropdowna stacji
        return "admin/manage_studia";
    }

    @PostMapping("/admin/studia/add")
    public String addStudio(
            @RequestParam("numer_pokoju") String numerPokoju,
            @RequestParam(value = "nazwa", required = false) String nazwa,
            @RequestParam("id_stacji") int idStacji
    ) {
        Studia s = new Studia();
        s.setNumer_pokoju(numerPokoju);
        s.setNazwa((nazwa != null && nazwa.isBlank()) ? null : nazwa);
        s.setId_stacji(idStacji);

        dataService.addStudio(s);
        return "redirect:/admin/studia";
    }

    @PostMapping("/admin/studia/delete")
    public String deleteStudio(@RequestParam("id_studia") int idStudia) {
        dataService.deleteStudio(idStudia);
        return "redirect:/admin/studia";
    }

    @GetMapping("/admin/studia/edit")
    public String editStudioForm(@RequestParam("id_studia") int idStudia, Model model) {
        model.addAttribute("studio", dataService.getStudio(idStudia));
        model.addAttribute("listRadiostacje", dataService.getRadiostacje());
        return "admin/edit_studia";
    }

    @PostMapping("/admin/studia/update")
    public String updateStudio(
            @RequestParam("id_studia") int idStudia,
            @RequestParam("numer_pokoju") String numerPokoju,
            @RequestParam(value = "nazwa", required = false) String nazwa,
            @RequestParam("id_stacji") int idStacji
    ) {
        Studia s = new Studia();
        s.setId_studia(idStudia);
        s.setNumer_pokoju(numerPokoju);
        s.setNazwa((nazwa != null && nazwa.isBlank()) ? null : nazwa);
        s.setId_stacji(idStacji);

        dataService.updateStudio(s);
        return "redirect:/admin/studia";
    }
    @GetMapping("/admin/utwory")
    public String manageUtwory(Model model) {
        model.addAttribute("listUtwory", dataService.getUtwory());
        return "admin/manage_utwory";
    }

    @PostMapping("/admin/utwory/delete")
    public String deleteUtwor(@RequestParam("id_utworu") int idUtworu) {
        dataService.deleteUtwor(idUtworu);
        return "redirect:/admin/utwory";
    }

    @GetMapping("/admin/utwory/edit")
    public String editUtworForm(@RequestParam("id_utworu") int idUtworu, Model model) {
        model.addAttribute("utwor", dataService.getUtwor(idUtworu));
        return "admin/edit_utwory";
    }
    @PostMapping("/admin/utwory/add")
    public String addUtwor(
            @RequestParam("tytul") String tytul,
            @RequestParam("id_albumu") int idAlbumu
    ) {
        Utwory u = new Utwory();
        u.setTytul(tytul);
        u.setId_albumu(idAlbumu);

        dataService.addUtwor(u);
        return "redirect:/admin/utwory";
    }

    @PostMapping("/admin/utwory/update")
    public String updateUtwor(
            @RequestParam("id_utworu") int idUtworu,
            @RequestParam("tytul") String tytul,
            @RequestParam("id_albumu") int idAlbumu
    ) {
        Utwory u = new Utwory();
        u.setId_utworu(idUtworu);
        u.setTytul(tytul);
        u.setId_albumu(idAlbumu);

        dataService.updateUtwor(u);
        return "redirect:/admin/utwory";
    }
    @GetMapping("/admin/emisje")
    public String manageEmisje(
            @RequestParam(value = "id_audycji", required = false) Integer idAudycji,
            Model model
    ) {
        model.addAttribute("listAudycje", dataService.getAudycje());
        model.addAttribute("listUtwory", dataService.getUtwory());
        model.addAttribute("selectedIdAudycji", idAudycji);

        if (idAudycji != null) {
            model.addAttribute("utworyWAudycji", dataService.getUtworyForAudycja(idAudycji));
        }
        return "admin/manage_emisje";
    }

    @PostMapping("/admin/emisje/add")
    public String addEmisja(
            @RequestParam("id_audycji") int idAudycji,
            @RequestParam("id_utworu") int idUtworu
    ) {
        dataService.addEmisja(idAudycji, idUtworu);
        return "redirect:/admin/emisje?id_audycji=" + idAudycji;
    }

    @PostMapping("/admin/emisje/delete")
    public String deleteEmisja(
            @RequestParam("id_audycji") int idAudycji,
            @RequestParam("id_utworu") int idUtworu
    ) {
        dataService.deleteEmisja(idAudycji, idUtworu);
        return "redirect:/admin/emisje?id_audycji=" + idAudycji;
    }



}