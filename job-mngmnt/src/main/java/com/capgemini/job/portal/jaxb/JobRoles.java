//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.23 at 10:44:50 AM EST 
//


package com.capgemini.job.portal.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="jobRole">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="jobRoleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="jobRoleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "jobRole"
})
public class JobRoles {

    protected List<JobRoles.JobRole> jobRole;

    /**
     * Gets the value of the jobRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jobRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJobRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JobRoles.JobRole }
     * 
     * 
     */
    public List<JobRoles.JobRole> getJobRole() {
        if (jobRole == null) {
            jobRole = new ArrayList<JobRoles.JobRole>();
        }
        return this.jobRole;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="jobRoleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="jobRoleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "jobRoleId",
        "jobRoleName"
    })
    public static class JobRole {

        protected String jobRoleId;
        protected String jobRoleName;

        /**
         * Gets the value of the jobRoleId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJobRoleId() {
            return jobRoleId;
        }

        /**
         * Sets the value of the jobRoleId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJobRoleId(String value) {
            this.jobRoleId = value;
        }

        /**
         * Gets the value of the jobRoleName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJobRoleName() {
            return jobRoleName;
        }

        /**
         * Sets the value of the jobRoleName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJobRoleName(String value) {
            this.jobRoleName = value;
        }

    }

}
