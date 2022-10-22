package edu.home.controller;

import edu.home.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "checkout")
    public String checkout(){
        return "order/checkout";
    }

    @GetMapping(value = "detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        model.addAttribute("order", orderService.findById(id));
        return "order/detail";
    }

    @RequestMapping(value = "list")
    public String list(Model model, HttpServletRequest request){
        String username = request.getRemoteUser();
        model.addAttribute("orders", orderService.findByUsername(username));
        return "order/list";
    }
}
