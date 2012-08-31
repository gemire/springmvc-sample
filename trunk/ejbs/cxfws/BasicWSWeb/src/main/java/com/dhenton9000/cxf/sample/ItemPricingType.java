
package com.dhenton9000.cxf.sample;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemPricingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemPricingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="priceData" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}PriceDataType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemPricingType", propOrder = {
    "priceData"
})
public class ItemPricingType {

    @XmlElement(required = true)
    protected List<PriceDataType> priceData;

    /**
     * Gets the value of the priceData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriceData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceDataType }
     * 
     * 
     */
    public List<PriceDataType> getPriceData() {
        if (priceData == null) {
            priceData = new ArrayList<PriceDataType>();
        }
        return this.priceData;
    }

}
