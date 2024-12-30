package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Product;
import com.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		try {
			List<Product> productList = productRepository.findAll();
			
			return productList;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Product saveProduct(Product product) {
		try {
			Product newProduct = productRepository.save(product);
			
			return newProduct;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Product updateProduct(Product product) {
		try {
			boolean isProductExists = productRepository.existsById(product.getProductId());
			
			Product newProduct = null;
			if(isProductExists) {
				newProduct = productRepository.save(product);
			}else {
				newProduct = new Product();
			}
			
			return newProduct;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<Product> saveProducts(List<Product> productList) {
		try {
			List<Product> newProductList = productRepository.saveAll(productList);
			
			return newProductList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<Product> updateProducts(List<Product> productList) {
		try {
			List<Product> newProductList = productRepository.saveAll(productList);
			
			return newProductList;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		try {
			boolean isProductDeleted = false;
			boolean isProductExists = productRepository.existsById(productId);
			
			if(isProductExists) {
				productRepository.deleteById(productId);
				isProductDeleted = true;
			}
			
			return isProductDeleted;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteProductByIds(List<Integer> productIds) {
		try {
			productRepository.deleteAllById(productIds);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteAllProducts() {
		try {
			productRepository.deleteAll();
		} catch (Exception e) {
			throw e;
		}
	}

}
