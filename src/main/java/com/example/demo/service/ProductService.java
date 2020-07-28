package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	
	
	
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	public Product saveProduct(Product product) {
	   return productRepository.save(product);
	}
	
	
	public List<Product> saveProducts(List<Product> products) {
		   return productRepository.saveAll(products);
		}
	
	
	
	
	public List<Product> getAllProducts() {
		   return productRepository.findAll();
		}
	
	
	public Product getProductById(int id) {
		   return productRepository.findById(id).orElse(null);
		}
	
	public Product getProductByName(String name) {
		   return productRepository.findByName(name).orElse(null);
		}
	
	
	
	public String deleteProduct(int id) {
		    productRepository.deleteById(id);
		    return "Delete Product Sucessfully";
		}
	
	
	
	public Product updateProduct(Product product) {
	    Product existingProduct = productRepository.findById(product.getId()).orElse(null);
	    existingProduct.setName(product.getName());
	  return productRepository.save(existingProduct);
	}
	
	
	
}
