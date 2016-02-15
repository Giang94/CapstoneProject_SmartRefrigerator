package org.rra.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Integer> userID;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> password;

}

