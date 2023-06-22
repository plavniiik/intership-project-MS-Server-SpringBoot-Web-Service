package com.example.intership31conly.Reposiroty.dbtwo;

import com.example.intership31conly.Model.dbtwo.Product;
import com.example.intership31conly.Model.dbtwo.ProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductKey> {
}
