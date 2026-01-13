package com.example.bdbt_projekt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Controller
public class AppController implements WebMvcConfigurer {
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
