package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;



@RequestMapping("/api")
@RestController
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping("/create-product")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	
	@PostMapping("/create-products")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productService.saveProducts(products);
	}

	
	
	@GetMapping("/get-all-products")
	public List<Product> addProduct() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/get-product-by-id/{id}")
	public Product findById(@PathVariable final int id) {
		return productService.getProductById(id);
	}
	
	
	@GetMapping("/get-product-by-name/{name}")
	public Product findById(@PathVariable final String name) {
		return productService.getProductByName(name);
	}
	
	

	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	
	
	
	@DeleteMapping("/delete-product/{id}")
	public String deleteProduct(@PathVariable final int id) {
		return productService.deleteProduct(id);
	}
	
}
