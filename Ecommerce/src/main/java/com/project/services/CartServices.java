package com.project.services;

import com.project.dao.Product;

public interface CartServices 
{
	public abstract void addProductToCart(Product product);
	public abstract void removeProductFromCart(Product product);
	public abstract void viewCart() throws InterruptedException;

}
