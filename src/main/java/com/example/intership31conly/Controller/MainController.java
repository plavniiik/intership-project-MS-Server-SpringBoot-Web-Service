package com.example.intership31conly.Controller;

import com.example.intership31conly.Model.dbone.Indicators;
import com.example.intership31conly.Model.dbtwo.Product;
import com.example.intership31conly.Service.IndicatorsService;
import com.example.intership31conly.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class MainController {

    private final IndicatorsService firstService;
    private final ProductService secondService;

    public MainController(IndicatorsService firstService, ProductService secondService) {
        this.firstService = firstService;
        this.secondService = secondService;
    }

    @GetMapping("/indMain")
    public String printAllIndicators(Model model)
    {
        List<Indicators> indicatorsList = firstService.findAllIndicators();
        if(indicatorsList.size()==0){
            indicatorsList=null;
        }
        model.addAttribute("inds",indicatorsList);
        List<Product> allIndicators = secondService.findAll();

        if(allIndicators.size()==0){
            allIndicators=null;
        }
        model.addAttribute("product",allIndicators);
        return "indicators.html";
    }
}
