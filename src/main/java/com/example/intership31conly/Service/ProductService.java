package com.example.intership31conly.Service;

import com.example.intership31conly.Model.dbtwo.Product;
import com.example.intership31conly.Reposiroty.dbtwo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private static final String BASE_PACKAGE = "com.example.intership31conly";
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductService(){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        productRepository = context.getBean(ProductRepository.class);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
