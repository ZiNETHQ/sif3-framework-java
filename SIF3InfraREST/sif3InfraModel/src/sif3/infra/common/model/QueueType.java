
package sif3.infra.common.model;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Queues Service supports creation, deletion and querying of Queue (Instance) / Queue Messages Service pairs.
 * 
 * <p>Java class for queueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="polling" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="IMMEDIATE"/>
 *               &lt;enumeration value="LONG"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ownerId" type="{http://www.sifassociation.org/infrastructure/3.2}uuidType" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/>
 *         &lt;element name="queueUri" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="ownerUri" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="idleTimeout" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="minWaitTime" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="maxConcurrentConnections" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedInt">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastAccessed" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastModified" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="messageCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
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
@XmlType(name = "queueType", namespace = "http://www.sifassociation.org/infrastructure/3.2", propOrder = {
    "polling",
    "ownerId",
    "name",
    "queueUri",
    "ownerUri",
    "idleTimeout",
    "minWaitTime",
    "maxConcurrentConnections",
    "created",
    "lastAccessed",
    "lastModified",
    "messageCount"
})
public class QueueType {

    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    protected String polling;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ownerId;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String name;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlSchemaType(name = "anyURI")
    protected String queueUri;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlSchemaType(name = "anyURI")
    protected String ownerUri;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlSchemaType(name = "unsignedInt")
    protected Long idleTimeout;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlSchemaType(name = "unsignedInt")
    protected Long minWaitTime;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    protected Long maxConcurrentConnections;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar created;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar lastAccessed;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar lastModified;
    @XmlElement(namespace = "http://www.sifassociation.org/infrastructure/3.2")
    @XmlSchemaType(name = "unsignedInt")
    protected Long messageCount;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;

    /**
     * Gets the value of the polling property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolling() {
        return polling;
    }

    /**
     * Sets the value of the polling property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolling(String value) {
        this.polling = value;
    }

    public boolean isSetPolling() {
        return (this.polling!= null);
    }

    /**
     * Gets the value of the ownerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the value of the ownerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerId(String value) {
        this.ownerId = value;
    }

    public boolean isSetOwnerId() {
        return (this.ownerId!= null);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the queueUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueUri() {
        return queueUri;
    }

    /**
     * Sets the value of the queueUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueUri(String value) {
        this.queueUri = value;
    }

    public boolean isSetQueueUri() {
        return (this.queueUri!= null);
    }

    /**
     * Gets the value of the ownerUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerUri() {
        return ownerUri;
    }

    /**
     * Sets the value of the ownerUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerUri(String value) {
        this.ownerUri = value;
    }

    public boolean isSetOwnerUri() {
        return (this.ownerUri!= null);
    }

    /**
     * Gets the value of the idleTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdleTimeout() {
        return idleTimeout;
    }

    /**
     * Sets the value of the idleTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdleTimeout(Long value) {
        this.idleTimeout = value;
    }

    public boolean isSetIdleTimeout() {
        return (this.idleTimeout!= null);
    }

    /**
     * Gets the value of the minWaitTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinWaitTime() {
        return minWaitTime;
    }

    /**
     * Sets the value of the minWaitTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinWaitTime(Long value) {
        this.minWaitTime = value;
    }

    public boolean isSetMinWaitTime() {
        return (this.minWaitTime!= null);
    }

    /**
     * Gets the value of the maxConcurrentConnections property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxConcurrentConnections() {
        return maxConcurrentConnections;
    }

    /**
     * Sets the value of the maxConcurrentConnections property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxConcurrentConnections(Long value) {
        this.maxConcurrentConnections = value;
    }

    public boolean isSetMaxConcurrentConnections() {
        return (this.maxConcurrentConnections!= null);
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreated(Calendar value) {
        this.created = value;
    }

    public boolean isSetCreated() {
        return (this.created!= null);
    }

    /**
     * Gets the value of the lastAccessed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getLastAccessed() {
        return lastAccessed;
    }

    /**
     * Sets the value of the lastAccessed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastAccessed(Calendar value) {
        this.lastAccessed = value;
    }

    public boolean isSetLastAccessed() {
        return (this.lastAccessed!= null);
    }

    /**
     * Gets the value of the lastModified property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getLastModified() {
        return lastModified;
    }

    /**
     * Sets the value of the lastModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModified(Calendar value) {
        this.lastModified = value;
    }

    public boolean isSetLastModified() {
        return (this.lastModified!= null);
    }

    /**
     * Gets the value of the messageCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMessageCount() {
        return messageCount;
    }

    /**
     * Sets the value of the messageCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMessageCount(Long value) {
        this.messageCount = value;
    }

    public boolean isSetMessageCount() {
        return (this.messageCount!= null);
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
