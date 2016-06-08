/**
 * 
 */
package com.capgemini.job.portal.entities;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author sryarlag
 *
 */
@StaticMetamodel(Need.class)
public class Need_ {
	
	public static volatile SingularAttribute<Need, Integer> wwsId;
    public static volatile SingularAttribute<Need, String> needStatus;
    public static volatile SingularAttribute<Need, Practice> practice;
    public static volatile SingularAttribute<Need, Location> location;
    public static volatile SingularAttribute<Need, Client> client;
    public static volatile SingularAttribute<Need, Grade> grade;
    public static volatile SingularAttribute<Need, Billability> billability;
    public static volatile SingularAttribute<Need, SkillProfile> skillProfile;
    public static volatile SingularAttribute<Need, NeedCloseReason> needCloseReason;
    public static volatile SingularAttribute<Need, String> closeComments;
    public static volatile SingularAttribute<Need, Date> projectStartDate;
    public static volatile SingularAttribute<Need, Date> projectEndDate;
    public static volatile SingularAttribute<Need, Date> needCloseDate;
    public static volatile SingularAttribute<Need, Date> createdDate;
    public static volatile SingularAttribute<Need, Date> updatedDate;
    public static volatile SingularAttribute<Need, String> shortDescription;
    
}
