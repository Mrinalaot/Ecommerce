package com.project.dao;

public class Product 
{
	private int productId;
	private Category productCategory;
	private Subcategory productSubcategory;
	private String name;
	private double price;
	private int quantity;
	private int stock;
	
	public Product(int productId, Category productCategory, Subcategory productSubcategoty, String name, double price, int quantity, int stock) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.productSubcategory = productSubcategoty;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.stock = stock;
	}
	
	public Product(Category productCategory, Subcategory productSubcategoty, String name, double price, int quantity, int stock) {
		super();
		this.productCategory = productCategory;
		this.productSubcategory = productSubcategoty;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.stock = stock;
	}
	public Category getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}
	public Subcategory getProductSubcategoty() {
		return productSubcategory;
	}
	public void setProductSubcategoty(Subcategory productSubcategoty) {
		this.productSubcategory = productSubcategoty;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [productCategory=" + productCategory + ", productSubcategoty=" + productSubcategory
				+ ", productId=" + productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", stock=" + stock + "]";
	}
	
	
}

