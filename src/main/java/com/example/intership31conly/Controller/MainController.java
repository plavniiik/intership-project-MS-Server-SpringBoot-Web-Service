package com.example.intership31conly.Controller;

import com.example.intership31conly.Model.dbone.Indicators;
import com.example.intership31conly.Model.dbtwo.Product;
import com.example.intership31conly.Service.IndicatorsService;
import com.example.intership31conly.Service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Validated
public class MainController {

    private final IndicatorsService firstService;
    private final ProductService secondService;

    public MainController(IndicatorsService firstService, ProductService secondService) {
        this.firstService = firstService;
        this.secondService = secondService;
    }

    @GetMapping("/indMain")
    public String printAllIndicators(Model model,@RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size)
    {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Product> productPage = secondService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("productPage", productPage);
        List<Product> allIndicators = secondService.findAll();
        if(allIndicators.size()==0){
            allIndicators=null;
        }
        model.addAttribute("product",allIndicators);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
//        List<Product> allIndicators = secondService.findAll();
//        if(allIndicators.size()==0){
//            allIndicators=null;
//        }
//        model.addAttribute("product",allIndicators);
//        for(int i =0; i<allIndicators.size();i++){
//            System.out.println(allIndicators.get(i).getProductKey().getUIDDocument());
//        }
//        return "indicators.html";

        return "indicators_page.html";
    }

    @GetMapping("/searchIndicator")
        public String openSearchPage(Model model){
        return "search_page.html";

    }

    @GetMapping("searchIndicatorAnswer")
    public String findObject(@RequestParam(name = "id_org") int id_org, @RequestParam(name = "id_stock") int id_stock, Model model){
        List<Product> searchProduct=  secondService.findProduct(id_org,id_stock);
        System.out.println("id_org"+id_org);
        model.addAttribute("product", searchProduct);
        String flag = "0";
//        if((Integer.TYPE.isInstance(id_org)==false)&&(Integer.TYPE.isInstance(id_stock)==false)){
if(((id_org>999)&&(id_org<100))&&((id_stock>999)&&(id_stock<100))){
             flag = "1";
    return "error.html";
        }
        model.addAttribute("flag",flag);
        return "search_page_object";
    }



}
