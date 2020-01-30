package com.project.services;

import com.project.drawings.Animation;

public interface MenuServices 
{
	public static void showMainMenu()
	{
		Animation.drawStraightLine();
    	System.out.println("\nPlease choose your option :");
    	System.out.println("Press 1 : Show Available Products");
    	System.out.println("Press 2 : Browse by Categories");
    	System.out.println("Press 3 : View Shopping Cart");
    	System.out.println("Press 4 : Add product to shopping Cart");
    	System.out.println("Press 5 : Remove Product from Cart");
    	System.out.println("Press 6 : Search a Product ");
    	System.out.println("Press 0 : Exit ");
	}

}
