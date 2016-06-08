/**
 * 
 */
package com.capgemini.wws.vo.staticmetamodel;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;

import com.capgemini.job.portal.entities.Billability;
import com.capgemini.job.portal.entities.Client;
import com.capgemini.job.portal.entities.Grade;
import com.capgemini.job.portal.entities.Location;
import com.capgemini.job.portal.entities.Need;
import com.capgemini.job.portal.entities.NeedCloseReason;
import com.capgemini.job.portal.entities.Practice;
import com.capgemini.job.portal.entities.SkillProfile;

/**
 * @author sryarlag
 *
 */
public class NeedSearchResVO_ {

	public static volatile SingularAttribute<Need, Long> wwsId;
    public static volatile SingularAttribute<Need, String> needStatus;
    public static volatile SingularAttribute<Need, Practice> practice;
    public static volatile SingularAttribute<Need, Location> location;
    public static volatile SingularAttribute<Need, Client> client;
    public static volatile SingularAttribute<Need, Grade> grade;
    public static volatile SingularAttribute<Need, Billability> billability;
    public static volatile SingularAttribute<Need, NeedCloseReason> needCloseReason;
    public static volatile SingularAttribute<Need, Date> projectStartDate;
    public static volatile SingularAttribute<Need, Date> projectEndDate;
    public static volatile SingularAttribute<Need, Date> needCloseDate;
    public static volatile SingularAttribute<Need, SkillProfile> skillProfile;	
}
