/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.orders.ws;

/**
 *
 * @author dyh
 */
public class WebOrders {

	private String webOrderNumber = null;
	private String sku = null;
	private float cost = 0.0f;
	private int numberOf = 0;
	
	public WebOrders()
	{
		
	}
	public WebOrders(String ordNum,String sku,float dollarCost,int count)
	{
		numberOf = count;
		cost = dollarCost;
		this.sku = sku;
		webOrderNumber = ordNum;
		
	}
	
	
	public String getWebOrderNumber() {
		return webOrderNumber;
	}
	public void setWebOrderNumber(String webOrderNumber) {
		this.webOrderNumber = webOrderNumber;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getNumberOf() {
		return numberOf;
	}
	public void setNumberOf(int numberOf) {
		this.numberOf = numberOf;
	}


  @Override
    public String toString()
    {
        return "Order: "+ webOrderNumber+" sku "+sku+ " count "+this.numberOf;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WebOrders other = (WebOrders) obj;
        if ((this.webOrderNumber == null) ? (other.webOrderNumber != null) : !this.webOrderNumber.equals(other.webOrderNumber)) {
            return false;
        }
        if ((this.sku == null) ? (other.sku != null) : !this.sku.equals(other.sku)) {
            return false;
        }
        if (this.numberOf != other.numberOf) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.webOrderNumber != null ? this.webOrderNumber.hashCode() : 0);
        hash = 29 * hash + (this.sku != null ? this.sku.hashCode() : 0);
        hash = 29 * hash + this.numberOf;
        return hash;
    }

	
	
}
