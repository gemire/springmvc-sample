
package com.dhenton9000.admissions.components.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dhenton9000.admissions.components.ws package. 
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

    private final static QName _Patient_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "Patient");
    private final static QName _Lookup_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "Lookup");
    private final static QName _Referer_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "Referer");
    private final static QName _Referral_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "Referral");
    private final static QName _PatientId_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "PatientId");
    private final static QName _Bill_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "Bill");
    private final static QName _InsuranceCoverStatus_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "InsuranceCoverStatus");
    private final static QName _Transaction_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "Transaction");
    private final static QName _Episode_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "Episode");
    private final static QName _Subject_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "Subject");
    private final static QName _InsuranceCaseNumber_QNAME = new QName("http://www.mule-health.com/SOA/model/1.0", "InsuranceCaseNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dhenton9000.admissions.components.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpsertPatientResponse }
     * 
     */
    public UpsertPatientResponse createUpsertPatientResponse() {
        return new UpsertPatientResponse();
    }

    /**
     * Create an instance of {@link FindEpisodesResponse }
     * 
     */
    public FindEpisodesResponse createFindEpisodesResponse() {
        return new FindEpisodesResponse();
    }

    /**
     * Create an instance of {@link EpisodeType }
     * 
     */
    public EpisodeType createEpisodeType() {
        return new EpisodeType();
    }

    /**
     * Create an instance of {@link AdmitSubject }
     * 
     */
    public AdmitSubject createAdmitSubject() {
        return new AdmitSubject();
    }

    /**
     * Create an instance of {@link RefererType }
     * 
     */
    public RefererType createRefererType() {
        return new RefererType();
    }

    /**
     * Create an instance of {@link ReferralType }
     * 
     */
    public ReferralType createReferralType() {
        return new ReferralType();
    }

    /**
     * Create an instance of {@link DemographicType }
     * 
     */
    public DemographicType createDemographicType() {
        return new DemographicType();
    }

    /**
     * Create an instance of {@link GetPatientResponse }
     * 
     */
    public GetPatientResponse createGetPatientResponse() {
        return new GetPatientResponse();
    }

    /**
     * Create an instance of {@link PatientType }
     * 
     */
    public PatientType createPatientType() {
        return new PatientType();
    }

    /**
     * Create an instance of {@link CreateBill }
     * 
     */
    public CreateBill createCreateBill() {
        return new CreateBill();
    }

    /**
     * Create an instance of {@link AdmitSubjectResponse }
     * 
     */
    public AdmitSubjectResponse createAdmitSubjectResponse() {
        return new AdmitSubjectResponse();
    }

    /**
     * Create an instance of {@link BillType }
     * 
     */
    public BillType createBillType() {
        return new BillType();
    }

    /**
     * Create an instance of {@link GetPatient }
     * 
     */
    public GetPatient createGetPatient() {
        return new GetPatient();
    }

    /**
     * Create an instance of {@link CreateEpisodeResponse }
     * 
     */
    public CreateEpisodeResponse createCreateEpisodeResponse() {
        return new CreateEpisodeResponse();
    }

    /**
     * Create an instance of {@link AuditTransaction }
     * 
     */
    public AuditTransaction createAuditTransaction() {
        return new AuditTransaction();
    }

    /**
     * Create an instance of {@link TransactionType }
     * 
     */
    public TransactionType createTransactionType() {
        return new TransactionType();
    }

    /**
     * Create an instance of {@link UpsertPatient }
     * 
     */
    public UpsertPatient createUpsertPatient() {
        return new UpsertPatient();
    }

    /**
     * Create an instance of {@link CreateEpisode }
     * 
     */
    public CreateEpisode createCreateEpisode() {
        return new CreateEpisode();
    }

    /**
     * Create an instance of {@link AdmitSubjectLookup }
     * 
     */
    public AdmitSubjectLookup createAdmitSubjectLookup() {
        return new AdmitSubjectLookup();
    }

    /**
     * Create an instance of {@link FindEpisodes }
     * 
     */
    public FindEpisodes createFindEpisodes() {
        return new FindEpisodes();
    }

    /**
     * Create an instance of {@link CreateBillResponse }
     * 
     */
    public CreateBillResponse createCreateBillResponse() {
        return new CreateBillResponse();
    }

    /**
     * Create an instance of {@link ProcedureType }
     * 
     */
    public ProcedureType createProcedureType() {
        return new ProcedureType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "Patient")
    public JAXBElement<PatientType> createPatient(PatientType value) {
        return new JAXBElement<PatientType>(_Patient_QNAME, PatientType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "Lookup")
    public JAXBElement<String> createLookup(String value) {
        return new JAXBElement<String>(_Lookup_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefererType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "Referer")
    public JAXBElement<RefererType> createReferer(RefererType value) {
        return new JAXBElement<RefererType>(_Referer_QNAME, RefererType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferralType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "Referral")
    public JAXBElement<ReferralType> createReferral(ReferralType value) {
        return new JAXBElement<ReferralType>(_Referral_QNAME, ReferralType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "PatientId")
    public JAXBElement<String> createPatientId(String value) {
        return new JAXBElement<String>(_PatientId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "Bill")
    public JAXBElement<BillType> createBill(BillType value) {
        return new JAXBElement<BillType>(_Bill_QNAME, BillType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "InsuranceCoverStatus")
    public JAXBElement<String> createInsuranceCoverStatus(String value) {
        return new JAXBElement<String>(_InsuranceCoverStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "Transaction")
    public JAXBElement<TransactionType> createTransaction(TransactionType value) {
        return new JAXBElement<TransactionType>(_Transaction_QNAME, TransactionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EpisodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "Episode")
    public JAXBElement<EpisodeType> createEpisode(EpisodeType value) {
        return new JAXBElement<EpisodeType>(_Episode_QNAME, EpisodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DemographicType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "Subject")
    public JAXBElement<DemographicType> createSubject(DemographicType value) {
        return new JAXBElement<DemographicType>(_Subject_QNAME, DemographicType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mule-health.com/SOA/model/1.0", name = "InsuranceCaseNumber")
    public JAXBElement<String> createInsuranceCaseNumber(String value) {
        return new JAXBElement<String>(_InsuranceCaseNumber_QNAME, String.class, null, value);
    }

}
