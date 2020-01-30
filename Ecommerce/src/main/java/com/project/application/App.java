package com.project.application;
import com.project.dao.Category;
import com.project.dao.Product;
import com.project.dao.Subcategory;
import com.project.drawings.Animation;
import com.project.services.MenuServices;

import java.util.*;

public class App 
{
    private App()
    {}

	public static void start() throws InterruptedException
	{
		Scanner scan = new Scanner(System.in);
    	int choice=0;
        
        
        ProductFeatures ecommerce = new ProductFeatures();
        List<Product> productList = ecommerce.loadProducts();
        List<Product> blankProductList = new ArrayList<>();
        Set<Category> categorySet = new HashSet<>();
        Set<Subcategory> subcategorySet = new HashSet<>();
        int orderID = (int)(10000.0 * Math.random());
        Cart cart = new Cart(blankProductList,0.0,orderID);
    	
        
    	do
    	{
    		MenuServices.showMainMenu();
	    	choice = scan.nextInt();
	    	switch(choice)
	    	{
	    	case 0: 
	    		    Animation.drawStars();
	    		    System.out.println("See you soon... Thanks for shopping ! ");
	    		    Animation.drawStars();
	    		    System.exit(0);
	    		    break;
	    	case 1: 
	                ecommerce.showProducts(productList);
	                Thread.sleep(2000);
	    		    break;
	    		    
	    	case 2: //Browse by Categories
	    			
	    		    for(Product product : productList)
	    		    {
	    		    	categorySet.add(product.getProductCategory());
	    		    	subcategorySet.add(product.getProductSubcategoty());
	    		    }
				    findSelectedCategories(scan, productList, categorySet, subcategorySet);
	    		    Thread.sleep(2000);
	    		    break;
	    		    
	    	case 3 : cart.viewCart();
	    			 Thread.sleep(2000);
	    	         break;
	    		
	    	case 4:  //Add products to Cart
	    		     System.out.println("\nPlease Enter Product ID to ADD to Cart : ");
	    	         int productID = scan.nextInt();
	    	         addToCart(productList, cart, productID);
	    		     break;
	    		     
	    	case 5:  //Remove product from Cart
				     System.out.println("\nPlease Enter Product ID to REMOVE from Cart : ");
			         int removeProductID = scan.nextInt();
			         removeFromCart(cart, removeProductID);
				     break;
				     
	    	case 6:  //Search Product
	    		     scan.nextLine(); 
	    		     System.out.println("Please enter Product Name : ");
	    		     String searchProduct = scan.nextLine();
	    		     ecommerce.searchProducts(searchProduct,productList,ecommerce);
	    		     Thread.sleep(2000);
	    		     break;
			    		    
			 default : System.out.println("Invalid Choice! Try again...\n");
			 }
    	
    	} while(choice!=0);
	}

	private static void removeFromCart(Cart cart, int removeProductID) {
		Product productToBeRemove = null;
		 for(Product product: cart.getProductsInCart())
		 {
			 if(product.getProductId()==removeProductID)
			 {
				 productToBeRemove = product;
			     cart.removeProductFromCart(productToBeRemove);
			     System.out.println("Success! You have removed "+productToBeRemove.getName()+" from cart...");
			     return;
			 }
		 }
		if(productToBeRemove==null)
			System.out.println("Sorry! This product does not exist to your Cart...");
	}

	private static void addToCart(List<Product> productList, Cart cart, int productID)
	{
		Product productToBeAdd = null;
		 for(Product product: productList) 
		 {
			 if(product.getProductId()==productID)
			 {
				 productToBeAdd = product;
			     cart.addProductToCart(productToBeAdd);
			     return;
			 }
		 }
		if(productToBeAdd==null)
			System.out.println("Sorry! Your entered Product ID does not exist...");
	}

	private static void findSelectedCategories(Scanner scan, List<Product> productList, Set<Category> categorySet,
			Set<Subcategory> subcategorySet) 
	{
		System.out.println("***********  Available Categories  ***********\nCategory_ID\tName");
		Animation.drawLine();
		
		categorySet.stream().sorted((c1,c2)-> c1.getCategoryID() - c2.getCategoryID())
							.forEach((Category c) -> {
					                                    System.out.println(c.getCategoryID()+"\t"+c.getCategoryName());
					                                    Animation.drawLine();
														});
		                                    
		
		System.out.println("Please Select a Category : \nEnter Category ID - ");
		int subChoice = scan.nextInt();
		
		findSelectedSubcategories(scan, productList, subcategorySet, subChoice);
	}

	private static void findSelectedSubcategories(Scanner scan, List<Product> productList,
			Set<Subcategory> subcategorySet,final int subChoice) {
		System.out.println("***********  Available Subcategories  ***********\nSubcategory_ID\tName");
		Animation.drawLine();
		
		subcategorySet.stream().filter(s1 -> s1.getCategoryID() == subChoice)
							   .sorted((s1,s2)-> s1.getSubcategoryID() - s2.getSubcategoryID())
							   .forEach((Subcategory s)-> 
								{
									subcategorySet.add(s);
									System.out.println(s.getSubcategoryID()+"\t"+s.getSubcategoryName());
									Animation.drawLine();
									
								});
		
		System.out.println("Please Select a Category : \nEnter SubCategory ID - ");
		final int subChoice1 = scan.nextInt();
		
		findSelectedProducts(productList, subChoice1);
	}

	private static void findSelectedProducts(List<Product> productList,final int subChoice) {
		System.out.println("\nID\tPRODUCT_NAME\tPRICE\tSTOCK\tCATEGORY\tSUBCATEGORY");
		Animation.drawLine();
		
		productList.stream().filter(p -> p.getProductSubcategoty().getSubcategoryID()==subChoice)
		                    .forEach((Product p) -> System.out.println(p.getProductId()+ "\t"+ p.getName()+"\t"+p.getPrice()+"/- "
							     + p.getStock() + "  || "+  p.getProductCategory().getCategoryName()+" || "+p.getProductSubcategoty().getSubcategoryName()));
	}
   
    
}
