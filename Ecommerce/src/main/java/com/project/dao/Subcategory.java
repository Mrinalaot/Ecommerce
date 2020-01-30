package com.project.dao;

public class Subcategory 
{
	private int subcategoryID;
	private String subcategoryName;
	private int categoryID;
	
	public Subcategory(int subcategoryID, String subcategoryName, int categoryID) {
		super();
		this.subcategoryID = subcategoryID;
		this.subcategoryName = subcategoryName;
		this.categoryID = categoryID;
	}
	public int getSubcategoryID() {
		return subcategoryID;
	}
	public void setSubcategoryID(int subcategoryID) {
		this.subcategoryID = subcategoryID;
	}
	public String getSubcategoryName() {
		return subcategoryName;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	@Override
	public String toString() {
		return "Subcategory [subcategoryID=" + subcategoryID + ", subcategoryName=" + subcategoryName + ", categoryID="
				+ categoryID + "]";
	}
	
	
}
