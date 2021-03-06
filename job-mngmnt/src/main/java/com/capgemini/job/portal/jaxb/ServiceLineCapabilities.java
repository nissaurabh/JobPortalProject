//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.23 at 10:22:54 AM EST 
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
 *         &lt;element name="serviceLineCapability">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="serviceLineCapabilityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="serviceLineCapabilityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "serviceLineCapability"
})
public class ServiceLineCapabilities {

    protected List<ServiceLineCapabilities.ServiceLineCapability> serviceLineCapability;

    /**
     * Gets the value of the serviceLineCapability property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceLineCapability property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceLineCapability().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceLineCapabilities.ServiceLineCapability }
     * 
     * 
     */
    public List<ServiceLineCapabilities.ServiceLineCapability> getServiceLineCapability() {
        if (serviceLineCapability == null) {
            serviceLineCapability = new ArrayList<ServiceLineCapabilities.ServiceLineCapability>();
        }
        return this.serviceLineCapability;
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
     *         &lt;element name="serviceLineCapabilityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="serviceLineCapabilityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "serviceLineCapabilityId",
        "serviceLineCapabilityName",
        "serviceLineId"
    })
    public static class ServiceLineCapability {

        protected String serviceLineCapabilityId;
        protected String serviceLineCapabilityName;
        protected String serviceLineId;

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
         * Gets the value of the serviceLineCapabilityName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceLineCapabilityName() {
            return serviceLineCapabilityName;
        }

        /**
         * Sets the value of the serviceLineCapabilityName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceLineCapabilityName(String value) {
            this.serviceLineCapabilityName = value;
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

    }

}
