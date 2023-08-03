package com.sri.restweb_pro.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.restweb_pro.entity.Product;
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
