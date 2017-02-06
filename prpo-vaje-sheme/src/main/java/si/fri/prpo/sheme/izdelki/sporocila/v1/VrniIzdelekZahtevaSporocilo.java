
package si.fri.prpo.sheme.izdelki.sporocila.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VrniIzdelekZahtevaSporocilo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VrniIzdelekZahtevaSporocilo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idIzdelek" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VrniIzdelekZahtevaSporocilo", propOrder = {
    "idIzdelek"
})
public class VrniIzdelekZahtevaSporocilo {

    protected int idIzdelek;

    /**
     * Gets the value of the idIzdelek property.
     * 
     */
    public int getIdIzdelek() {
        return idIzdelek;
    }

    /**
     * Sets the value of the idIzdelek property.
     * 
     */
    public void setIdIzdelek(int value) {
        this.idIzdelek = value;
    }

}
