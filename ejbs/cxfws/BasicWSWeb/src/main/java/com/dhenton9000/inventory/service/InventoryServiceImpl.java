package com.dhenton9000.inventory.service;

import java.math.BigInteger;

import com.dhenton9000.cxf.sample.BatchInformationType;
import com.dhenton9000.cxf.sample.InventoryProcessRequest;
import com.dhenton9000.cxf.sample.InventoryProcessResponse;
import com.dhenton9000.cxf.sample.InventoryServiceOperationFault;
import com.dhenton9000.cxf.sample.InventoryServicePortType;
import com.dhenton9000.cxf.sample.ProcessRoutingRequestFaultMsg1;
import com.dhenton9000.cxf.sample.RoutingInformationType;
import com.dhenton9000.cxf.sample.RoutingRequestType;
import org.apache.log4j.*;
import com.dhenton9000.cxf.sample.SimpleWebServiceResponseType;

public class InventoryServiceImpl implements InventoryServicePortType {
	private static Logger log = LogManager.getLogger(InventoryServiceImpl.class);
	
	public InventoryProcessResponse inventoryServiceOperation(
			InventoryProcessRequest inventoryProcessRequest)
			throws InventoryServiceOperationFault {
		 
		 log.info("hit 1");
		
		
		InventoryProcessResponse response = new InventoryProcessResponse();
		SimpleWebServiceResponseType value = new SimpleWebServiceResponseType();
		value.setSuccess(true);
		value.setMessage("get a job bozo!");
		response.setInventoryProcessResponseAck(value);
		return response ;
	}

	

	public RoutingInformationType processRoutingRequest(
			RoutingRequestType parameters)
			throws ProcessRoutingRequestFaultMsg1 {
		
		log.info("h1");
		RoutingInformationType rT = new RoutingInformationType();
		log.info("h2");
		
		BatchInformationType batchInfo = rT.getBatchInformation();
		int t = parameters.getSourceId().intValue();
		log.info("h1 "+t);

		if (t == 99)
			throw new ProcessRoutingRequestFaultMsg1("get a job");
		
		BigInteger ret = BigInteger.valueOf((t+100));
		log.info("h1 "+rT);

		rT.setProcessId(ret);
		return rT;
		
		
		
	}

	
	
	
}
