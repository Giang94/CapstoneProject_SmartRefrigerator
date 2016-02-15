package org.rra.entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Notification.class)
public abstract class Notification_ {

	public static volatile SingularAttribute<Notification, Integer> userID;
	public static volatile SingularAttribute<Notification, Integer> notificationID;
	public static volatile SingularAttribute<Notification, Boolean> isSent;
	public static volatile SingularAttribute<Notification, Date> sendingTime;
	public static volatile SingularAttribute<Notification, String> notificationContent;

}

