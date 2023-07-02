package com.example.intership31conly.Controller;

import com.example.intership31conly.Model.dbtwo.Product;
import com.example.intership31conly.Service.IndicatorsService;
import com.example.intership31conly.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("api")
public class ControllerLink {


    private final ProductService secondService;

    public ControllerLink(IndicatorsService firstService, ProductService secondService) {

        this.secondService = secondService;
    }
    @RequestMapping("indicators/{id_org}/{id_stock}")
    @ResponseBody
    public List<Product> findIndicator(@PathVariable int id_org, @PathVariable int id_stock) {
        return secondService.findProduct(id_org,id_stock);
    }

}
