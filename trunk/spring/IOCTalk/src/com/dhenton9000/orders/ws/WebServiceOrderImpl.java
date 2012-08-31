/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.orders.ws;

import com.dhenton9000.orders.persistence.Orders;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author dyh
 */
public class WebServiceOrderImpl implements WebServiceOrderService {

	public List<WebOrders> getWebOrders() throws WebServiceDownloadException {

		ArrayList<WebOrders> orders = new ArrayList<WebOrders>();

		orders.add(new WebOrders("A10123", "23654634", 29.99f, 1));
		orders.add(new WebOrders("A10124", "23654634", 49.99f, 1));
		orders.add(new WebOrders("A10125", "236648634", 29.99f, 1));
		orders.add(new WebOrders("A10126", "23654634", 29.99f, 1));
		orders.add(new WebOrders("A10127", "23389734", 69.99f, 3));
		orders.add(new WebOrders("A10128", "23654534", 39.99f, 1));

		return orders;
	}

    public void markWebOrderForResubmission(List<Orders> failedOrders) {
       return;
    }




}
