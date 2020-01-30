package com.project.dao;

import java.util.List;

import com.project.application.Cart;

public class Checkout 
{
	private List<Cart> cartList;

	public Checkout(List<Cart> cartList) {
		super();
		this.cartList = cartList;
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	@Override
	public String toString() {
		return "Checkout [cartList=" + cartList + "]";
	}
	
	
	
}

