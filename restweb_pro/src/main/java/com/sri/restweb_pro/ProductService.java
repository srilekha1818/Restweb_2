package com.sri.restweb_pro;

import java.util.List;

import com.sri.restweb_pro.entity.Product;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Consumes("application/json")
@Produces("application/json")
@Path("/productservice")
public interface ProductService {
	@Path("/products")
	@GET
	List<Product> getProducts();
	@Path("/product/{id}")
	@GET
	Product getProduct(@PathParam("id")int id);
	@Path("/products")
	@POST
	Response createProduct(Product product);
	@Path("/products")
	@PUT
	Response updateProduct(Product product);
	@Path("/product/{id}")
	@DELETE
	String deleteProduct(@PathParam("id") int id);
	
	
	

}
