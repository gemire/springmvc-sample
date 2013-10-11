/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.orders;

import com.dhenton9000.orders.ws.WebServiceOrderService;
import com.dhenton9000.orders.persistence.DbPersistenceService;
import com.dhenton9000.orders.persistence.Orders;
import com.dhenton9000.orders.persistence.PersistenceException;
import com.dhenton9000.orders.ws.WebOrders;
import com.dhenton9000.orders.ws.WebServiceDownloadException;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 *
 * @author dyh
 */
public class OrderDownloader {

    private WebServiceOrderService wsDownloader  = null;
    private DbPersistenceService   dbPersistence = null;
    private static Logger log = LogManager.getLogger(OrderDownloader.class);
    
    public OrderDownloader(WebServiceOrderService ws, DbPersistenceService dbP)
    {
    	wsDownloader = ws;
    	dbPersistence = dbP;
    }
    
    public OrderDownloader() { }
    
    /**
     * @return the wsDownloader
     */
    public WebServiceOrderService getWsDownloader() {
        return wsDownloader;
    }

    /**
     * @param wsDownloader the wsDownloader to set
     */
    public void setWsDownloader(WebServiceOrderService wsDownloader) {
        this.wsDownloader = wsDownloader;
    }

    /**
     * @return the dbPersistance
     */
    public DbPersistenceService getDbPersistence() {
        return dbPersistence;
    }

    /**
     * @param dbPersistance the dbPersistance to set
     */
    public void setDbPersistence(DbPersistenceService dbPersistence) {
        this.dbPersistence = dbPersistence;
    }

    public void doOrderDownload()   {

        log.debug("ws order downloader "+getWsDownloader());
        log.debug("db persistence "+getDbPersistence());
        List<WebOrders> wOrders = null;
        //download the orders from the web service
        try {
            wOrders = getWsDownloader().getWebOrders();
        } catch (WebServiceDownloadException ex) {
            log.error("Web order download problem "+ex.getMessage());
            return;
        }
        // transform the web orders to orders, suitable for persistence

        List<Orders> orders = transformWebOrders(wOrders);
        List<Orders> failedOrders = null;
        try {
          failedOrders =   getDbPersistence().persistOrders(orders);
        } catch (PersistenceException ex) {
             // bailed out here

            log.error("Persistence problem "+ex.getMessage());
            return;
        }

        // now do something with the failed orders
        if (failedOrders != null && failedOrders.size() > 0)
            getWsDownloader().markWebOrderForResubmission(failedOrders);


    }

    private List<Orders> transformWebOrders(List<WebOrders> wOrders) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
