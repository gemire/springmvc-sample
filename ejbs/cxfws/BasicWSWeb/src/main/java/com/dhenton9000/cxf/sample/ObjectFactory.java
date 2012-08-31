
package com.dhenton9000.cxf.sample;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dhenton9000.cxf.sample package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InventoryProcessResponseContents_QNAME = new QName("http://dhenton9000.inventory/schema/InventoryBusSchema", "InventoryProcessResponseContents");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dhenton9000.cxf.sample
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessRoutingRequest }
     * 
     */
    public ProcessRoutingRequest createProcessRoutingRequest() {
        return new ProcessRoutingRequest();
    }

    /**
     * Create an instance of {@link ProcessRoutingRequestResponse }
     * 
     */
    public ProcessRoutingRequestResponse createProcessRoutingRequestResponse() {
        return new ProcessRoutingRequestResponse();
    }

    /**
     * Create an instance of {@link MasonInventoryElement }
     * 
     */
    public MasonInventoryElement createMasonInventoryElement() {
        return new MasonInventoryElement();
    }

    /**
     * Create an instance of {@link RoutingInformationType }
     * 
     */
    public RoutingInformationType createRoutingInformationType() {
        return new RoutingInformationType();
    }

    /**
     * Create an instance of {@link StyleType }
     * 
     */
    public StyleType createStyleType() {
        return new StyleType();
    }

    /**
     * Create an instance of {@link InventoryProcessRequest }
     * 
     */
    public InventoryProcessRequest createInventoryProcessRequest() {
        return new InventoryProcessRequest();
    }

    /**
     * Create an instance of {@link InventoryRequestParametersType }
     * 
     */
    public InventoryRequestParametersType createInventoryRequestParametersType() {
        return new InventoryRequestParametersType();
    }

    /**
     * Create an instance of {@link InventoryProcessResponse }
     * 
     */
    public InventoryProcessResponse createInventoryProcessResponse() {
        return new InventoryProcessResponse();
    }

    /**
     * Create an instance of {@link SimpleWebServiceResponseType }
     * 
     */
    public SimpleWebServiceResponseType createSimpleWebServiceResponseType() {
        return new SimpleWebServiceResponseType();
    }

    /**
     * Create an instance of {@link PriceDataType }
     * 
     */
    public PriceDataType createPriceDataType() {
        return new PriceDataType();
    }

    /**
     * Create an instance of {@link MerchantCategoryType }
     * 
     */
    public MerchantCategoryType createMerchantCategoryType() {
        return new MerchantCategoryType();
    }

    /**
     * Create an instance of {@link RequestedServicesType }
     * 
     */
    public RequestedServicesType createRequestedServicesType() {
        return new RequestedServicesType();
    }

    /**
     * Create an instance of {@link MerchantCategoriesType }
     * 
     */
    public MerchantCategoriesType createMerchantCategoriesType() {
        return new MerchantCategoriesType();
    }

    /**
     * Create an instance of {@link ItemsType }
     * 
     */
    public ItemsType createItemsType() {
        return new ItemsType();
    }

    /**
     * Create an instance of {@link RoutingRequestType }
     * 
     */
    public RoutingRequestType createRoutingRequestType() {
        return new RoutingRequestType();
    }

    /**
     * Create an instance of {@link ColorDescriptionType }
     * 
     */
    public ColorDescriptionType createColorDescriptionType() {
        return new ColorDescriptionType();
    }

    /**
     * Create an instance of {@link ItemPricingType }
     * 
     */
    public ItemPricingType createItemPricingType() {
        return new ItemPricingType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link BatchInformationType }
     * 
     */
    public BatchInformationType createBatchInformationType() {
        return new BatchInformationType();
    }

    /**
     * Create an instance of {@link ItemAttributesType }
     * 
     */
    public ItemAttributesType createItemAttributesType() {
        return new ItemAttributesType();
    }

    /**
     * Create an instance of {@link ItemQuantityType }
     * 
     */
    public ItemQuantityType createItemQuantityType() {
        return new ItemQuantityType();
    }

    /**
     * Create an instance of {@link ServiceRequestsType }
     * 
     */
    public ServiceRequestsType createServiceRequestsType() {
        return new ServiceRequestsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryRequestParametersType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dhenton9000.inventory/schema/InventoryBusSchema", name = "InventoryProcessResponseContents")
    public JAXBElement<InventoryRequestParametersType> createInventoryProcessResponseContents(InventoryRequestParametersType value) {
        return new JAXBElement<InventoryRequestParametersType>(_InventoryProcessResponseContents_QNAME, InventoryRequestParametersType.class, null, value);
    }

}
