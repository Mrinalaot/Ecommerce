package com.project.drawings;

public class Animation 
{
	private Animation()
	{}
	
	public static void drawDots() throws InterruptedException
	{
		for(int i=0;i<50;i++)
    	{
    		Thread.sleep(40);
    		System.out.print(".");
    	}
	}
	
	
	public static void drawLine()
	{
		System.out.println("-----------------------------------------------------------------------");
	}
	
	public static void drawStraightLine()
	{
		System.out.println("_______________________________________________________________________");
	}
	
	public static void drawStars()
	{
		System.out.println("************************************************************************");
	}

}
