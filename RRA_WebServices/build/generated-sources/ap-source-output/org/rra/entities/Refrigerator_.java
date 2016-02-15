package org.rra.entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Refrigerator.class)
public abstract class Refrigerator_ {

	public static volatile SingularAttribute<Refrigerator, Integer> id;
	public static volatile SingularAttribute<Refrigerator, Integer> userID;
	public static volatile SingularAttribute<Refrigerator, Integer> notifyBefore;
	public static volatile SingularAttribute<Refrigerator, Integer> foodID;
	public static volatile SingularAttribute<Refrigerator, Date> dateAdded;
	public static volatile SingularAttribute<Refrigerator, Date> dateExpired;
	public static volatile SingularAttribute<Refrigerator, Boolean> isNotify;

}

