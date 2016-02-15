package org.rra.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Member1.class)
public abstract class Member1_ {

	public static volatile SingularAttribute<Member1, String> username;
	public static volatile SingularAttribute<Member1, String> email;

}

