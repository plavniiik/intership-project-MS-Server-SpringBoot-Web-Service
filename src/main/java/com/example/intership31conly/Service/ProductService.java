package com.example.intership31conly.Service;

import com.example.intership31conly.Model.dbtwo.Product;
import com.example.intership31conly.Reposiroty.dbtwo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private static final String BASE_PACKAGE = "com.example.intership31conly";

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        productRepository = context.getBean(ProductRepository.class);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findProduct(int id_org, int id_stock) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> searchProduct = new ArrayList<>();

        if ((id_org == 0) && (id_stock != 0)) {
            int flag = 0;
            for (int i = 0; i < allProducts.size(); i++) {
                if (allProducts.get(i).getId_stock() == id_stock) {
                    searchProduct.add(allProducts.get(i));
                    flag++;
                }
            }
            if (flag == 0) {
                searchProduct = null;
            }
            return searchProduct;
        }
        if ((id_org != 0) && (id_stock == 0)) {
            int flag = 0;
            for (int i = 0; i < allProducts.size(); i++) {
                if (allProducts.get(i).getId_org() == id_org) {
                    searchProduct.add(allProducts.get(i));
                    flag++;
                }
            }
            if (flag == 0) {
                searchProduct = null;
            }
            return searchProduct;
        } else {
            int flag = 0;
            for (int i = 0; i < allProducts.size(); i++) {
                if ((allProducts.get(i).getId_stock() == id_stock) && (allProducts.get(i).getId_stock() == id_stock)) {
                    searchProduct.add(allProducts.get(i));
                    flag++;
                }
            }
            if (flag == 0) {
                searchProduct = null;
            }
            return searchProduct;
        }
    }

    public Page<Product> findPaginated(Pageable pageable){
        List<Product> products = productRepository.findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> list;

        if(products.size()<startItem) {
            list = Collections.emptyList();
        } else{
                int toIndex = Math.min(startItem + pageSize, products.size());
                list =products.subList(startItem, toIndex);
            }

        Page<Product> productPage
                = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), products.size());

        return productPage;
        }
}

