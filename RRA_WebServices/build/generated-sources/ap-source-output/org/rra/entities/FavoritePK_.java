package org.rra.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(FavoritePK.class)
public abstract class FavoritePK_ {

	public static volatile SingularAttribute<FavoritePK, Integer> userID;
	public static volatile SingularAttribute<FavoritePK, Integer> recipeID;

}

