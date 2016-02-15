package org.rra.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MaterialStatus.class)
public abstract class MaterialStatus_ {

	public static volatile SingularAttribute<MaterialStatus, Integer> statusID;
	public static volatile SingularAttribute<MaterialStatus, String> status;

}

