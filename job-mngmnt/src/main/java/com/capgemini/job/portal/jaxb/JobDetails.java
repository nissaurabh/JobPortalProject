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
 *       &lt;sequence>
 *         &lt;element name="requestedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="closureDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creatorRM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestorRM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="owningRM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requirementSpecifics" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resourceCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chargeOutRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contractorRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="travel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="presentedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceLineCapabilityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceLineId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobStageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employementTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobStatusId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "requestedDate",
    "closureDate",
    "creatorRM",
    "requestorRM",
    "owningRM",
    "requirementSpecifics",
    "resourceCount",
    "roleStartDate",
    "roleEndDate",
    "chargeOutRate",
    "contractorRate",
    "travel",
    "openDate",
    "presentedDate",
    "roleId",
    "serviceLineCapabilityId",
    "serviceLineId",
    "jobStageId",
    "accountId",
    "employementTypeId",
    "jobStatusId"
})
@XmlRootElement(name = "jobDetails")
public class JobDetails {

    protected String requestedDate;
    protected String closureDate;
    protected String creatorRM;
    protected String requestorRM;
    protected String owningRM;
    protected String requirementSpecifics;
    protected String resourceCount;
    protected String roleStartDate;
    protected String roleEndDate;
    protected String chargeOutRate;
    protected String contractorRate;
    protected String travel;
    protected String openDate;
    protected String presentedDate;
    protected String roleId;
    protected String serviceLineCapabilityId;
    protected String serviceLineId;
    protected String jobStageId;
    protected String accountId;
    protected String employementTypeId;
    protected String jobStatusId;

    /**
     * Gets the value of the requestedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedDate() {
        return requestedDate;
    }

    /**
     * Sets the value of the requestedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedDate(String value) {
        this.requestedDate = value;
    }

    /**
     * Gets the value of the closureDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClosureDate() {
        return closureDate;
    }

    /**
     * Sets the value of the closureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClosureDate(String value) {
        this.closureDate = value;
    }

    /**
     * Gets the value of the creatorRM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorRM() {
        return creatorRM;
    }

    /**
     * Sets the value of the creatorRM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorRM(String value) {
        this.creatorRM = value;
    }

    /**
     * Gets the value of the requestorRM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestorRM() {
        return requestorRM;
    }

    /**
     * Sets the value of the requestorRM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestorRM(String value) {
        this.requestorRM = value;
    }

    /**
     * Gets the value of the owningRM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwningRM() {
        return owningRM;
    }

    /**
     * Sets the value of the owningRM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwningRM(String value) {
        this.owningRM = value;
    }

    /**
     * Gets the value of the requirementSpecifics property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequirementSpecifics() {
        return requirementSpecifics;
    }

    /**
     * Sets the value of the requirementSpecifics property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequirementSpecifics(String value) {
        this.requirementSpecifics = value;
    }

    /**
     * Gets the value of the resourceCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceCount() {
        return resourceCount;
    }

    /**
     * Sets the value of the resourceCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceCount(String value) {
        this.resourceCount = value;
    }

    /**
     * Gets the value of the roleStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleStartDate() {
        return roleStartDate;
    }

    /**
     * Sets the value of the roleStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleStartDate(String value) {
        this.roleStartDate = value;
    }

    /**
     * Gets the value of the roleEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleEndDate() {
        return roleEndDate;
    }

    /**
     * Sets the value of the roleEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleEndDate(String value) {
        this.roleEndDate = value;
    }

    /**
     * Gets the value of the chargeOutRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeOutRate() {
        return chargeOutRate;
    }

    /**
     * Sets the value of the chargeOutRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeOutRate(String value) {
        this.chargeOutRate = value;
    }

    /**
     * Gets the value of the contractorRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractorRate() {
        return contractorRate;
    }

    /**
     * Sets the value of the contractorRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractorRate(String value) {
        this.contractorRate = value;
    }

    /**
     * Gets the value of the travel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravel() {
        return travel;
    }

    /**
     * Sets the value of the travel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravel(String value) {
        this.travel = value;
    }

    /**
     * Gets the value of the openDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenDate() {
        return openDate;
    }

    /**
     * Sets the value of the openDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenDate(String value) {
        this.openDate = value;
    }

    /**
     * Gets the value of the presentedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresentedDate() {
        return presentedDate;
    }

    /**
     * Sets the value of the presentedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresentedDate(String value) {
        this.presentedDate = value;
    }

    /**
     * Gets the value of the roleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the value of the roleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleId(String value) {
        this.roleId = value;
    }

    /**
     * Gets the value of the serviceLineCapabilityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceLineCapabilityId() {
        return serviceLineCapabilityId;
    }

    /**
     * Sets the value of the serviceLineCapabilityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceLineCapabilityId(String value) {
        this.serviceLineCapabilityId = value;
    }

    /**
     * Gets the value of the serviceLineId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceLineId() {
        return serviceLineId;
    }

    /**
     * Sets the value of the serviceLineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceLineId(String value) {
        this.serviceLineId = value;
    }

    /**
     * Gets the value of the jobStageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobStageId() {
        return jobStageId;
    }

    /**
     * Sets the value of the jobStageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobStageId(String value) {
        this.jobStageId = value;
    }

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId(String value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the employementTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployementTypeId() {
        return employementTypeId;
    }

    /**
     * Sets the value of the employementTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployementTypeId(String value) {
        this.employementTypeId = value;
    }

    /**
     * Gets the value of the jobStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobStatusId() {
        return jobStatusId;
    }

    /**
     * Sets the value of the jobStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobStatusId(String value) {
        this.jobStatusId = value;
    }

}
