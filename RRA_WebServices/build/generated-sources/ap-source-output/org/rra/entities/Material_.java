package org.rra.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Material.class)
public abstract class Material_ {

	public static volatile SingularAttribute<Material, Integer> status;
	public static volatile SingularAttribute<Material, String> name;
	public static volatile SingularAttribute<Material, Integer> materialID;
	public static volatile SingularAttribute<Material, Integer> reference;

}

