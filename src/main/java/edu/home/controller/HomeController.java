package edu.home.controller;

import edu.home.model.Product;
import edu.home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @RequestMapping({"/", "/home/index"})
    public String home(Model model){
        List<Product> list = productService.findAll();
        model.addAttribute("items", list);
        return "home/index";
    }

    @RequestMapping({"/admin", "/admin/home/index"})
    public String admin(){
        return "redirect:/admin/index.html";
    }
}
