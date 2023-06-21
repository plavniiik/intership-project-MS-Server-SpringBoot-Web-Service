package com.example.intership31conly.Controller;

import com.example.intership31conly.Model.dbtwo.Product;
import com.example.intership31conly.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/mainPage")
    public String findAllIndicators(Model model, Product ind){
        int indicators = productService.findAll().size();
        model.addAttribute("indicators",indicators);
        List<Product> allIndicators = productService.findAll();
        model.addAttribute("product",allIndicators);
        return "indicators.html";
    }
}
