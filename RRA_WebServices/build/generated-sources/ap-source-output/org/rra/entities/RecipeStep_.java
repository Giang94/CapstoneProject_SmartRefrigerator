package org.rra.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RecipeStep.class)
public abstract class RecipeStep_ {

	public static volatile SingularAttribute<RecipeStep, String> stepDetail;
	public static volatile SingularAttribute<RecipeStep, String> stepImage;
	public static volatile SingularAttribute<RecipeStep, RecipeStepPK> recipeStepPK;

}

