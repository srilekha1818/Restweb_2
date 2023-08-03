package com.sri.restweb_pro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sri.restweb_pro.entity.Product;

import jakarta.ws.rs.core.Response;
import com.sri.restweb_pro.repos.ProductRepository;

public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository repository;
	
	@Override
	public List<Product> getProducts() {
		
		return repository.findAll();
	}

	@Override
	public Product getProduct(int id) {
		return repository.findById(id).get();
	}



	@Override
	public Response updateProduct(Product product) {
		Product savedProduct= repository.save(product);
		return Response.ok(savedProduct).build();
	}
	
	@Override
	public Response createProduct(Product product) {
		Product savedProduct= repository.save(product);
		return Response.ok(savedProduct).build();
	}


	@Override
	public String deleteProduct(int id) {
        repository.deleteById(id);
        return "deleted " + id;
		
	}

	

}
