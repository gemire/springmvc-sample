/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krams.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 *
 * @author Don
 */
@Document
public class Orders {
    private String customerName;
    private List<LineItems> orderLines= new ArrayList<LineItems>();
    @Id
    private int orderId;

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the orderLines
     */
    public List<LineItems> getOrderLines() {
        return orderLines;
    }

    /**
     * @param orderLines the orderLines to set
     */
    public void setOrderLines(List<LineItems> orderLines) {
        this.orderLines = orderLines;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
