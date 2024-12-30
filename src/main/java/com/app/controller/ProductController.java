package com.app.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Product;
import com.app.service.ProductService;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		ResponseEntity<List<Product>> responseEntity = null;
		try {
			List<Product> productList = productService.getAllProducts();
			
			responseEntity = new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PostMapping(path = "/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		
		ResponseEntity<Product> responseEntity = null;
		try {
			Product newProduct = productService.saveProduct(product);
			
			responseEntity = new ResponseEntity<Product>(newProduct, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PutMapping(path = "updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		
		ResponseEntity<Product> responseEntity = null;
		try {
			Product newProduct = productService.updateProduct(product);
			
			responseEntity = new ResponseEntity<Product>(newProduct, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PostMapping(path = "/saveProducts")
	public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> productList){
		
		ResponseEntity<List<Product>> responseEntity = null;
		try {
			List<Product> newProductList = productService.saveProducts(productList);
			
			responseEntity = new ResponseEntity<List<Product>>(newProductList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@PutMapping(path = "/updateProducts")
	public ResponseEntity<List<Product>> updateProducts(@RequestBody List<Product> productList){
		
		ResponseEntity<List<Product>> responseEntity = null;
		try {
			List<Product> newProductList = productService.updateProducts(productList);
			
			responseEntity = new ResponseEntity<List<Product>>(newProductList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@DeleteMapping(path = "/deleteProduct")
	public ResponseEntity<Map<String, Object>> deleteProduct(@RequestParam Integer productId){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			boolean isProductDeleted = productService.deleteProduct(productId);
			
			Map<String, Object> responseMap = new LinkedHashMap<>();
			if(isProductDeleted) {
				responseMap.put("message", "Product is deleted.");
			}else {
				responseMap.put("message", "Product is not found.");
			}
			
			responseEntity = new ResponseEntity<Map<String,Object>>(responseMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@DeleteMapping(path = "/deleteProducts")
	public ResponseEntity<Map<String, Object>> deleteProducts(@RequestBody List<Integer> productIdList){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			productService.deleteProductByIds(productIdList);
			
			responseEntity = new ResponseEntity<Map<String,Object>>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@DeleteMapping(path = "/deleteAllProducts")
	public ResponseEntity<Map<String, Object>> deleteAllProducts(){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			productService.deleteAllProducts();
			
			responseEntity = new ResponseEntity<Map<String,Object>>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
}
