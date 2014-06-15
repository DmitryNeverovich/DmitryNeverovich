//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.15 at 01:57:20 PM FET 
//


package com.example.greenhouse;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Soil.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Soil">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="podzolic"/>
 *     &lt;enumeration value="sod-podzolic"/>
 *     &lt;enumeration value="dirt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Soil")
@XmlEnum
public enum Soil {

    @XmlEnumValue("podzolic")
    PODZOLIC("podzolic"),
    @XmlEnumValue("sod-podzolic")
    SOD_PODZOLIC("sod-podzolic"),
    @XmlEnumValue("dirt")
    DIRT("dirt");
    private final String value;

    Soil(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Soil fromValue(String v) {
        for (Soil c: Soil.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
