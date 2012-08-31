/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.orders.persistence;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author dyh
 */
public class PersistenceServiceImpl implements DbPersistenceService {

    private DataSource dataSource = null;

    public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Orders> persistOrders(List<Orders> orders) 
	throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
