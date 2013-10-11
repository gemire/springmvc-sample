/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.orders.ws;

import com.dhenton9000.orders.persistence.Orders;
import java.util.List;

/**
 *
 * @author dyh
 */
public interface WebServiceOrderService {

    /**
     * Download orders
     * @return list of downloaded web orders
     * @throws WebServiceDownloadException
     */
    public List<WebOrders> getWebOrders() throws WebServiceDownloadException;

    /**
     * This function will take a list of transformed orders and mark them for
     * resubmission on the remote service via a web service.
     * @param failedOrders list of transformed orders for remarking
     */
    public void markWebOrderForResubmission(List<Orders> failedOrders);
}
