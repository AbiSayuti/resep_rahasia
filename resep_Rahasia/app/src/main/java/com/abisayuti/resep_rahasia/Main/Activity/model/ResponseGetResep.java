package com.abisayuti.resep_rahasia.Main.Activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGetResep{

	@SerializedName("recipes")
	private List<RecipesItem> recipes;

	@SerializedName("count")
	private int count;

	public void setRecipes(List<RecipesItem> recipes){
		this.recipes = recipes;
	}

	public List<RecipesItem> getRecipes(){
		return recipes;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	@Override
 	public String toString(){
		return 
			"ResponseGetResep{" + 
			"recipes = '" + recipes + '\'' + 
			",count = '" + count + '\'' + 
			"}";
		}
}