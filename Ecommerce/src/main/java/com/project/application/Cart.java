package com.project.application;

import java.util.*;

import com.project.services.CartServices;
import com.project.dao.Checkout;
import com.project.dao.Product;
import com.project.drawings.Animation;

public class Cart implements CartServices
{
	private List<Product> productsInCart;
	private double totalPrice;
	private int orderID;
    
	
	public Cart(List<Product> productsInCart, double totalPrice, int orderID) {
		super();
		this.productsInCart = productsInCart;
		this.totalPrice = totalPrice;
		this.orderID = orderID;
	}
	
    @Override
	public void addProductToCart(Product product) 
	{
		System.out.println("How many quantity you want of "+product.getName()+" ? ");
		Scanner scan = new Scanner(System.in);
		int productQuantity = scan.nextInt();
		int newStock = product.getStock() - productQuantity;
		if(newStock<0)
		{
			System.out.println("Sorry! "+product.getName()+" is not availabe of qantity "+ productQuantity);
		}
		else
		{
			product.setStock(newStock);
			product.setQuantity(productQuantity);
			this.productsInCart.add(product);
			this.totalPrice+= (product.getPrice()*productQuantity);
			Animation.drawLine();
		    System.out.println("Hurray! You have added "+productQuantity+" item(s) of "+product.getName()+" to Cart");
		}
		
	}
    
    @Override
	public void removeProductFromCart(Product product) 
	{
		this.productsInCart.remove(product);
		this.totalPrice-= product.getPrice();
	}

    @Override
	public void viewCart() throws InterruptedException
	{
		System.out.println("\n Showing Your Cart \n");
		Animation.drawDots();
		
		if(this.getProductsInCart().size()==0)
			System.out.println("\nYou Have No Product in Cart! ");
		else
		{
			System.out.println("\nID   Product_Name  Price   Quantity");
			Animation.drawLine();
			for(Product product : productsInCart)
				System.out.println(product.getProductId()+"   "+product.getName()+"    "+product.getPrice()+" /-  " +product.getQuantity());
		
			System.out.println(" --------------------------------------------------------\n Your Total Price is "+ totalPrice);
		
			Animation.drawStraightLine();
			Cart.checkoutMenu();
			Scanner scan = new Scanner(System.in);
			int choice= scan.nextInt();
			if(choice==2)
				checkoutCart(this);
			else if(choice==0)
				System.exit(0);
		}
	}
	
   public static void checkoutCart(Cart cart)
   {
	   List<Cart> cartList = new ArrayList<>();
	   cartList.add(cart);
	   Checkout checkout = new Checkout(cartList);
	   System.out.println("Your Have Checked Out! \n please Pay "+checkout.getCartList().get(0).totalPrice +" /- for Order ID "+checkout.getCartList().get(0).orderID);
	    Animation.drawStars();
	    System.out.println("See you soon... Thanks for shopping ! ");
	    Animation.drawStars();
	    System.exit(0);
   }
   
   public static void checkoutMenu()
   {
   	System.out.println("\nPlease choose your option :");
   	System.out.println("Press 1: <- Go back to Main Menu");
   	System.out.println("Press 2 : To Checkout");
   	System.out.println("Press 0 : Exit ");
   }
	
	
	public List<Product> getProductsInCart() {
		return productsInCart;
	}
	public void setProductsInCart(List<Product> productsInCart) {
		this.productsInCart = productsInCart;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return "Cart [productsInCart=" + productsInCart + ", totalPrice=" + totalPrice + ", orderID=" + orderID + "]";
	}


}
