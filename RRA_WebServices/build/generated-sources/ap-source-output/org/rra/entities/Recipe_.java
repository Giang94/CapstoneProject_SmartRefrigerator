package org.rra.entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Recipe.class)
public abstract class Recipe_ {

	public static volatile SingularAttribute<Recipe, String> recipeName;
	public static volatile SingularAttribute<Recipe, Integer> recipeID;
	public static volatile SingularAttribute<Recipe, Integer> viewedNumber;
	public static volatile SingularAttribute<Recipe, Date> dateAdded;
	public static volatile SingularAttribute<Recipe, String> introduction;
	public static volatile SingularAttribute<Recipe, byte[]> recipeImage;

}

