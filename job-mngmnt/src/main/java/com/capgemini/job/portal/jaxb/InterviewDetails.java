//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 09:56:45 AM EST 
//


package com.capgemini.job.portal.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "interviewDateTime",
    "interviewerPos",
    "intrvwrName",
    "intrvwrComments"
})
@XmlRootElement
public class InterviewDetails {

	@XmlSchemaType(name = "date")
    protected String interviewDateTime;
    protected String interviewerPos;
    protected String intrvwrName;
    protected String intrvwrComments;
	/**
	 * @return the interviewDateTime
	 */
	public String getInterviewDateTime() {
		return interviewDateTime;
	}
	/**
	 * @param interviewDateTime the interviewDateTime to set
	 */
	public void setInterviewDateTime(String interviewDateTime) {
		this.interviewDateTime = interviewDateTime;
	}
	/**
	 * @return the interviewerPos
	 */
	public String getInterviewerPos() {
		return interviewerPos;
	}
	/**
	 * @param interviewerPos the interviewerPos to set
	 */
	public void setInterviewerPos(String interviewerPos) {
		this.interviewerPos = interviewerPos;
	}
	/**
	 * @return the intrvwrName
	 */
	public String getIntrvwrName() {
		return intrvwrName;
	}
	/**
	 * @param intrvwrName the intrvwrName to set
	 */
	public void setIntrvwrName(String intrvwrName) {
		this.intrvwrName = intrvwrName;
	}
	/**
	 * @return the intrvwrComments
	 */
	public String getIntrvwrComments() {
		return intrvwrComments;
	}
	/**
	 * @param intrvwrComments the intrvwrComments to set
	 */
	public void setIntrvwrComments(String intrvwrComments) {
		this.intrvwrComments = intrvwrComments;
	}

   
}