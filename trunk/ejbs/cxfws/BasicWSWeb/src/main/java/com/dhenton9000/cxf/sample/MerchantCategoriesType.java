
package com.dhenton9000.cxf.sample;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 1 to N categories to assign to this item in descending order
 *                 for example Mens -- Casual -- Oxford in order of exclusivity
 *             
 * 
 * <p>Java class for MerchantCategoriesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantCategoriesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantCategory" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}MerchantCategoryType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchantCategoriesType", propOrder = {
    "merchantCategory"
})
public class MerchantCategoriesType {

    @XmlElement(name = "MerchantCategory", required = true)
    protected List<MerchantCategoryType> merchantCategory;

    /**
     * Gets the value of the merchantCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the merchantCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMerchantCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MerchantCategoryType }
     * 
     * 
     */
    public List<MerchantCategoryType> getMerchantCategory() {
        if (merchantCategory == null) {
            merchantCategory = new ArrayList<MerchantCategoryType>();
        }
        return this.merchantCategory;
    }

}
