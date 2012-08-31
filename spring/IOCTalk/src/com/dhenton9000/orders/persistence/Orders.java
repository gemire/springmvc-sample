/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.orders.persistence;
import java.util.Date;

/**
 *
 * @author dyh
 */
public class Orders {
        private String orderNumber = null;
	private String sku = null;
	private float cost = 0.0f;
	private int numberOf = 0;
        private Date dateOfOrder = new Date();

    /**
     * @return the orderNumber
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * @return the cost
     */
    public float getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * @return the numberOf
     */
    public int getNumberOf() {
        return numberOf;
    }

    /**
     * @param numberOf the numberOf to set
     */
    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }

    /**
     * @return the dateOfOrder
     */
    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    /**
     * @param dateOfOrder the dateOfOrder to set
     */
    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

        
    @Override
    public String toString()
    {
        return "Order: "+ orderNumber+" sku "+sku+ " count "+this.numberOf;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orders other = (Orders) obj;
        if ((this.orderNumber == null) ? (other.orderNumber != null) : !this.orderNumber.equals(other.orderNumber)) {
            return false;
        }
        if ((this.sku == null) ? (other.sku != null) : !this.sku.equals(other.sku)) {
            return false;
        }
        if (this.numberOf != other.numberOf) {
            return false;
        }
        if (this.dateOfOrder != other.dateOfOrder && (this.dateOfOrder == null || !this.dateOfOrder.equals(other.dateOfOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.orderNumber != null ? this.orderNumber.hashCode() : 0);
        hash = 41 * hash + (this.sku != null ? this.sku.hashCode() : 0);
        hash = 41 * hash + this.numberOf;
        hash = 41 * hash + (this.dateOfOrder != null ? this.dateOfOrder.hashCode() : 0);
        return hash;
    }

   






}
