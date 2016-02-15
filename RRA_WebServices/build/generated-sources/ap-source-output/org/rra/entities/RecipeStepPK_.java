package org.rra.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RecipeStepPK.class)
public abstract class RecipeStepPK_ {

	public static volatile SingularAttribute<RecipeStepPK, Integer> stepID;
	public static volatile SingularAttribute<RecipeStepPK, Integer> recipeID;

}

