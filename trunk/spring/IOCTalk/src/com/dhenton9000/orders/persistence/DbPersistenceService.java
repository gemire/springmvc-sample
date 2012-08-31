/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.orders.persistence;

import java.util.List;

/**
 *
 * @author dyh
 */
public interface DbPersistenceService {

    /**
     * Returns the orders that were not successfully persisted
     * @param orders the orders to save
     * @return orders that weren't saved
     * @throws PersistenceException on any error that is not a simple insert failure
     */
    public List<Orders> persistOrders(List<Orders> orders) throws PersistenceException;



}
