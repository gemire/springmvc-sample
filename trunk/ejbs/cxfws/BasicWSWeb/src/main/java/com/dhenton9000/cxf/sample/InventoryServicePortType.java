package com.dhenton9000.cxf.sample;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by Apache CXF 2.4.1
 * 2011-09-02T14:18:57.014-05:00
 * Generated source version: 2.4.1
 * 
 */
@WebService(targetNamespace = "http://dhenton9000.inventory/inventoryService/wsdl", name = "inventoryServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface InventoryServicePortType {

    @WebResult(name = "parameters", targetNamespace = "", partName = "parameters")
    @WebMethod
    public RoutingInformationType processRoutingRequest(
        @WebParam(partName = "parameters", name = "parameters", targetNamespace = "")
        RoutingRequestType parameters
    ) throws ProcessRoutingRequestFaultMsg1;

    @WebResult(name = "InventoryProcessResponse", targetNamespace = "http://dhenton9000.inventory/schema/InventoryBusSchema", partName = "inventoryProcessResponse")
    @WebMethod
    public InventoryProcessResponse inventoryServiceOperation(
        @WebParam(partName = "inventoryProcessRequest", name = "InventoryProcessRequest", targetNamespace = "http://dhenton9000.inventory/schema/InventoryBusSchema")
        InventoryProcessRequest inventoryProcessRequest
    ) throws InventoryServiceOperationFault;
}