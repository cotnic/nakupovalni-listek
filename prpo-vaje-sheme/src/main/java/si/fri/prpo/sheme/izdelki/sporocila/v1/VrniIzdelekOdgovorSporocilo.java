
package si.fri.prpo.sheme.izdelki.sporocila.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import si.fri.prpo.sheme.izdelki.v1.IzdelekType;


/**
 * <p>Java class for VrniIzdelekOdgovorSporocilo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VrniIzdelekOdgovorSporocilo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="izdelek" type="{http://prpo.fri.si/sheme/izdelki/v1}IzdelekType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VrniIzdelekOdgovorSporocilo", propOrder = {
    "izdelek"
})
public class VrniIzdelekOdgovorSporocilo {

    @XmlElement(required = true)
    protected IzdelekType izdelek;

    /**
     * Gets the value of the izdelek property.
     * 
     * @return
     *     possible object is
     *     {@link IzdelekType }
     *     
     */
    public IzdelekType getIzdelek() {
        return izdelek;
    }

    /**
     * Sets the value of the izdelek property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzdelekType }
     *     
     */
    public void setIzdelek(IzdelekType value) {
        this.izdelek = value;
    }

}
