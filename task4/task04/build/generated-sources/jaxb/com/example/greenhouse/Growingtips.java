//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.15 at 01:57:20 PM FET 
//


package com.example.greenhouse;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Growingtips complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Growingtips">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="term" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="light" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="water" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Growingtips", propOrder = {
    "term",
    "light",
    "water"
})
public class Growingtips {

    @XmlElement(required = true)
    protected BigInteger term;
    @XmlElement(required = true)
    protected String light;
    @XmlElement(required = true)
    protected BigInteger water;

    /**
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTerm(BigInteger value) {
        this.term = value;
    }

    /**
     * Gets the value of the light property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLight() {
        return light;
    }

    /**
     * Sets the value of the light property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLight(String value) {
        this.light = value;
    }

    /**
     * Gets the value of the water property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWater() {
        return water;
    }

    /**
     * Sets the value of the water property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWater(BigInteger value) {
        this.water = value;
    }

}
