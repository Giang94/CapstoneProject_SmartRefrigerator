package org.rra.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Ingredient.class)
public abstract class Ingredient_ {

	public static volatile SingularAttribute<Ingredient, String> amount;
	public static volatile SingularAttribute<Ingredient, String> unit;
	public static volatile SingularAttribute<Ingredient, IngredientPK> ingredientPK;

}

