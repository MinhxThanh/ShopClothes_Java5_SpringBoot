package edu.home.controller;

import edu.home.model.CategoriesInProduct;
import edu.home.model.ImageDescribe;
import edu.home.model.Product;
import edu.home.service.CategoriesInProductService;
import edu.home.service.ImageDescribeService;
import edu.home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ImageDescribeService imageDescribeService;

    @RequestMapping(value = "list")
    public String list(Model model, @RequestParam("category") Optional<String> name){

        if (name.isPresent()){
            System.out.println("category: " +name);
            List<Product> list = productService.findByCategoryName(name.get());
            model.addAttribute("items", list);
        }else {
            List<Product> list = productService.findAll();
            model.addAttribute("items", list);
        }
        return "product/list";
    }

    @RequestMapping(value = "detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        Product product = productService.findById(id);
        List<ImageDescribe> imageDescribes = imageDescribeService.findAllImageDescribeByProductID(id);
        model.addAttribute("imageDescribes" , imageDescribes);
        model.addAttribute("product", product);
        return "product/detail";
    }
}
