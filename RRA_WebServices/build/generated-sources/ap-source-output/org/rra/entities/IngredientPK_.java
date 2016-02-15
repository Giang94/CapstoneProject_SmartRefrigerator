package org.rra.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(IngredientPK.class)
public abstract class IngredientPK_ {

	public static volatile SingularAttribute<IngredientPK, Integer> recipeID;
	public static volatile SingularAttribute<IngredientPK, Integer> materialID;

}

