package com.example.bdbt_projekt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
public class AppController implements WebMvcConfigurer {
    private final AudycjeDAO dao;
    private final  RadiostacjeDAO radiostacje_dao;
    public AppController(AudycjeDAO dao, RadiostacjeDAO radiostacje_dao) {
        this.dao = dao;
        this.radiostacje_dao = radiostacje_dao;
    }
    @RequestMapping(value = {"/index","/"})
    public String viewHomePage(Model model){
        List<Audycje> listAudycje = dao.list();
        List<Radiostacje> listRadiostacje = radiostacje_dao.list();
        model.addAttribute("listAudycje",listAudycje);
        model.addAttribute("listRadiostacje",listRadiostacje);
        return "index";
    }

    public void addViewControllers(ViewControllerRegistry reqistry) {
        reqistry.addViewController("/index").setViewName("index");
        reqistry.addViewController("/").setViewName("index");
        reqistry.addViewController("/login").setViewName("login");
        reqistry.addViewController("/perspectives").setViewName("perspectives");
        reqistry.addViewController("/admin_main").setViewName("admin/admin_main");
        reqistry.addViewController("/prezenter_main").setViewName("prezenter/prezenter_main");

    }
    @Controller
    public static class DashboardController {
        @RequestMapping("/perspectives")
        public String defaultSuccessUrl (HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/admin_main";
            }
            else if(request.isUserInRole("PREZENTER")) {
                return "redirect:/prezenter_main";
            }
            else {
                return "redirect:/index";
            }
        }
    }
}
