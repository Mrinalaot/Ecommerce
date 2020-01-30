package com.project.application;
import com.project.dao.Category;
import com.project.dao.Product;
import com.project.dao.Subcategory;
import com.project.drawings.Animation;
import com.project.services.ProductServices;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ProductFeatures implements ProductServices
{
	@Override
	public List<Product> loadProducts()
	{
		List<Category> categoryList = new ArrayList<>();
		List<Subcategory> subcategoryList = new ArrayList<>();
		List<Product> productList = new ArrayList<>();
		
        loadHardCodedProducts(categoryList, subcategoryList, productList);
        
        return productList;
	
	}

	private void loadHardCodedProducts(List<Category> categoryList, List<Subcategory> subcategoryList, List<Product> productList) {
		categoryList.add(new Category(10,"Electronics"));
        categoryList.add(new Category(20,"Fashion"));
        
        subcategoryList.add(new Subcategory(101,"Mobile",10));
        subcategoryList.add(new Subcategory(102,"Laptop/PC",10));
        subcategoryList.add(new Subcategory(103,"Home Appliance",10));
        
        subcategoryList.add(new Subcategory(201,"Men",20));
        subcategoryList.add(new Subcategory(202,"Women",20));
        subcategoryList.add(new Subcategory(203,"Kids",20));
		
        productList.add(new Product(111, categoryList.get(0),subcategoryList.get(0),"Samsung S7", 10999.9, 10, 10));
        productList.add(new Product(112, categoryList.get(0),subcategoryList.get(0),"iPhone X", 89999.9, 10, 10));
        productList.add(new Product(222, categoryList.get(0),subcategoryList.get(1),"Macbook Pro", 97999.8, 5, 5));
        productList.add(new Product(223, categoryList.get(0),subcategoryList.get(1),"Dell vostro", 80999.8, 5, 5));
        productList.add(new Product(333, categoryList.get(0),subcategoryList.get(2),"Bulb", 99.8, 20, 20));
        productList.add(new Product(334, categoryList.get(0),subcategoryList.get(2),"Lamp", 101.8, 20, 20));
        productList.add(new Product(444, categoryList.get(1),subcategoryList.get(3),"Polo T-shirt", 599.8, 5, 5));
        productList.add(new Product(445, categoryList.get(1),subcategoryList.get(3),"Men Jeans", 799.8, 5, 5));
        productList.add(new Product(555, categoryList.get(1),subcategoryList.get(4),"Makeup kit", 879.8, 7, 7));
        productList.add(new Product(556, categoryList.get(1),subcategoryList.get(4),"Sharee", 1279.8, 7, 7));
        productList.add(new Product(666, categoryList.get(1),subcategoryList.get(5),"Toys", 144.5, 5, 5));
        productList.add(new Product(667, categoryList.get(1),subcategoryList.get(5),"kinder joy", 99.5, 5, 5));
	}
	
	@Override
	public void showProducts(List<Product> productList) throws InterruptedException
	{
		System.out.println("\n Showing the list of Vailable Products");
		Animation.drawDots();
		System.out.println("\n\nID\tPRODUCT_NAME\tPRICE\tSTOCK\tCATEGORY\tSUBCATEGORY");
		for(Product obj : productList) 
		{
		  Animation.drawLine();
          System.out.println(obj.getProductId()+"\t"+ obj.getName()+"\t"+obj.getPrice()+"/- \t"+ obj.getStock() + "\t"+ 
		  obj.getProductCategory().getCategoryName()+"\t"+obj.getProductSubcategoty().getSubcategoryName());
		}  
		Animation.drawStraightLine();
	}
	
	@Override
	public void searchProducts(String searchedProduct, List<Product> productList, ProductFeatures ecommerce) throws InterruptedException
	{
		List<Product> matchedProductList = new ArrayList<>();
		String regex = String.format(".*%s.*", searchedProduct);
		for(Product product: productList)
		{
			if(Pattern.matches(regex, product.getName()))
				matchedProductList.add(product);
		}
		ecommerce.showProducts(matchedProductList);
		
	}
	
	@Override
	public void deleteProduct() 
	{
		/*
		 * This will done when JDBC connection will be done
		 */
	} 
	
}
