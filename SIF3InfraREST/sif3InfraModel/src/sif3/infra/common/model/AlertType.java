
package sif3.infra.common.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Alerts form a system wide log that can be protected, as it may contain sensitive data. Ideally an Alert should contain as much identifying information about the problem being reported as possible.
 * 
 * <p>Java class for alertType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alertType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reporter" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="cause" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/>
 *         &lt;element name="exchange">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *               &lt;enumeration value="REQUEST"/>
 *               &lt;enumeration value="RESPONSE"/>
 *               &lt;enumeration value="EVENT"/>
 *               &lt;enumeration value="TIMEOUT"/>
 *               &lt;enumeration value="OTHER"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="level">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *               &lt;enumeration value=" INFO"/>
 *               &lt;enumeration value="STATECHANGE"/>
 *               &lt;enumeration value="WARNING"/>
 *               &lt;enumeration value="ERROR"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/>
 *         &lt;element name="messageID" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/>
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xpath" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="internal" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/>
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
@XmlType(name = "alertType", namespace = "http://www.sifassociation.org/infrastructure/3.2", propOrder = {
    "reporter",
    "cause",
    "exchange",
    "level",
    "description",
    "messageID",
    "body",
    "error",
    "xpath",
    "category",
    "code",
    "internal"
})
public class AlertType {

    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String reporter;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String cause;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String exchange;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String level;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String description;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String messageID;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    protected String body;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    protected String error;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String xpath;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlSchemaType(name = "unsignedInt")
    protected Long category;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlSchemaType(name = "unsignedInt")
    protected Long code;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String internal;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;

    /**
     * Gets the value of the reporter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * Sets the value of the reporter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReporter(String value) {
        this.reporter = value;
    }

    public boolean isSetReporter() {
        return (this.reporter!= null);
    }

    /**
     * Gets the value of the cause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCause() {
        return cause;
    }

    /**
     * Sets the value of the cause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCause(String value) {
        this.cause = value;
    }

    public boolean isSetCause() {
        return (this.cause!= null);
    }

    /**
     * Gets the value of the exchange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * Sets the value of the exchange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExchange(String value) {
        this.exchange = value;
    }

    public boolean isSetExchange() {
        return (this.exchange!= null);
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevel(String value) {
        this.level = value;
    }

    public boolean isSetLevel() {
        return (this.level!= null);
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return (this.description!= null);
    }

    /**
     * Gets the value of the messageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageID() {
        return messageID;
    }

    /**
     * Sets the value of the messageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageID(String value) {
        this.messageID = value;
    }

    public boolean isSetMessageID() {
        return (this.messageID!= null);
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBody(String value) {
        this.body = value;
    }

    public boolean isSetBody() {
        return (this.body!= null);
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }

    public boolean isSetError() {
        return (this.error!= null);
    }

    /**
     * Gets the value of the xpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * Sets the value of the xpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXpath(String value) {
        this.xpath = value;
    }

    public boolean isSetXpath() {
        return (this.xpath!= null);
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCategory(Long value) {
        this.category = value;
    }

    public boolean isSetCategory() {
        return (this.category!= null);
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCode(Long value) {
        this.code = value;
    }

    public boolean isSetCode() {
        return (this.code!= null);
    }

    /**
     * Gets the value of the internal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternal() {
        return internal;
    }

    /**
     * Sets the value of the internal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternal(String value) {
        this.internal = value;
    }

    public boolean isSetInternal() {
        return (this.internal!= null);
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
