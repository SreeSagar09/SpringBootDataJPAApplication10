package com.app.service;

import java.util.List;

import com.app.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product saveProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public List<Product> saveProducts(List<Product> productList);
	
	public List<Product> updateProducts(List<Product> productList);
	
	public boolean deleteProduct(Integer productId);
	
	public void deleteProductByIds(List<Integer> productIds);
	
	public void deleteAllProducts();
}
