
package sif3.infra.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * All potentially accessible Services have an entry in the Providers Registry (including the Providers Registry Utility Service itself), although full or even partial Consumer access to that Service is determined by the access rights currently granted in the Consumerís Environment object, and is not guaranteed.
 * 
 * <p>Java class for providerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="providerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceType" type="{http://www.sifassociation.org/infrastructure/3.2}serviceTypeType"/>
 *         &lt;element name="serviceName" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="contextId" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="zoneId" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="providerName" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="querySupport" type="{http://www.sifassociation.org/infrastructure/3.2}querySupportType"/>
 *         &lt;element name="mimeTypes" type="{http://www.sifassociation.org/infrastructure/3.2}mediaTypesType" minOccurs="0"/>
 *         &lt;element name="endPoint" type="{http://www.sifassociation.org/infrastructure/3.2}protocolType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.sifassociation.org/infrastructure/3.2}uuidType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "providerType", namespace = "http://www.sifassociation.org/infrastructure/3.2", propOrder = {
    "serviceType",
    "serviceName",
    "contextId",
    "zoneId",
    "providerName",
    "querySupport",
    "mimeTypes",
    "endPoint"
})
public class ProviderType {

    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    protected ServiceTypeType serviceType;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String serviceName;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String contextId;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String zoneId;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String providerName;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    protected QuerySupportType querySupport;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    protected MediaTypesType mimeTypes;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    protected ProtocolType endPoint;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTypeType }
     *     
     */
    public ServiceTypeType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTypeType }
     *     
     */
    public void setServiceType(ServiceTypeType value) {
        this.serviceType = value;
    }

    public boolean isSetServiceType() {
        return (this.serviceType!= null);
    }

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    public boolean isSetServiceName() {
        return (this.serviceName!= null);
    }

    /**
     * Gets the value of the contextId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextId() {
        return contextId;
    }

    /**
     * Sets the value of the contextId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextId(String value) {
        this.contextId = value;
    }

    public boolean isSetContextId() {
        return (this.contextId!= null);
    }

    /**
     * Gets the value of the zoneId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneId() {
        return zoneId;
    }

    /**
     * Sets the value of the zoneId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneId(String value) {
        this.zoneId = value;
    }

    public boolean isSetZoneId() {
        return (this.zoneId!= null);
    }

    /**
     * Gets the value of the providerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the value of the providerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderName(String value) {
        this.providerName = value;
    }

    public boolean isSetProviderName() {
        return (this.providerName!= null);
    }

    /**
     * Gets the value of the querySupport property.
     * 
     * @return
     *     possible object is
     *     {@link QuerySupportType }
     *     
     */
    public QuerySupportType getQuerySupport() {
        return querySupport;
    }

    /**
     * Sets the value of the querySupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuerySupportType }
     *     
     */
    public void setQuerySupport(QuerySupportType value) {
        this.querySupport = value;
    }

    public boolean isSetQuerySupport() {
        return (this.querySupport!= null);
    }

    /**
     * Gets the value of the mimeTypes property.
     * 
     * @return
     *     possible object is
     *     {@link MediaTypesType }
     *     
     */
    public MediaTypesType getMimeTypes() {
        return mimeTypes;
    }

    /**
     * Sets the value of the mimeTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaTypesType }
     *     
     */
    public void setMimeTypes(MediaTypesType value) {
        this.mimeTypes = value;
    }

    public boolean isSetMimeTypes() {
        return (this.mimeTypes!= null);
    }

    /**
     * Gets the value of the endPoint property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolType }
     *     
     */
    public ProtocolType getEndPoint() {
        return endPoint;
    }

    /**
     * Sets the value of the endPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolType }
     *     
     */
    public void setEndPoint(ProtocolType value) {
        this.endPoint = value;
    }

    public boolean isSetEndPoint() {
        return (this.endPoint!= null);
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

}
