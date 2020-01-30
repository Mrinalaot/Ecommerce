package com.project.services;

import java.util.List;

import com.project.application.ProductFeatures;
import com.project.dao.Product;

public interface ProductServices 
{
	
	public abstract List<Product> loadProducts();
	public abstract void showProducts(List<Product> productList) throws InterruptedException;
	public abstract void searchProducts(String searchedProduct, List<Product> productList, ProductFeatures ecommerce) throws InterruptedException;
	public abstract void deleteProduct();

}
