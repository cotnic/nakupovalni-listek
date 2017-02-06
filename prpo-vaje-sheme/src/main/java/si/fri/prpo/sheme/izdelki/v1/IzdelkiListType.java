
package si.fri.prpo.sheme.izdelki.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IzdelkiListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IzdelkiListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IzdelekType" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="idIzdelek" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *                   &lt;element name="cena" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *                   &lt;element name="kategorija" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IzdelkiListType", namespace = "http://prpo.fri.si/sheme/izdelki/v1", propOrder = {
    "izdelekType"
})
public class IzdelkiListType {

    @XmlElement(name = "IzdelekType")
    protected List<IzdelkiListType.IzdelekType> izdelekType;

    /**
     * Gets the value of the izdelekType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the izdelekType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIzdelekType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IzdelkiListType.IzdelekType }
     * 
     * 
     */
    public List<IzdelkiListType.IzdelekType> getIzdelekType() {
        if (izdelekType == null) {
            izdelekType = new ArrayList<IzdelkiListType.IzdelekType>();
        }
        return this.izdelekType;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="idIzdelek" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
     *         &lt;element name="cena" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
     *         &lt;element name="kategorija" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "idIzdelek",
        "cena",
        "kategorija",
        "naziv"
    })
    public static class IzdelekType {

        @XmlElement(namespace = "http://prpo.fri.si/sheme/izdelki/v1")
        protected Integer idIzdelek;
        @XmlElement(namespace = "http://prpo.fri.si/sheme/izdelki/v1")
        protected Double cena;
        @XmlElement(namespace = "http://prpo.fri.si/sheme/izdelki/v1")
        protected String kategorija;
        @XmlElement(namespace = "http://prpo.fri.si/sheme/izdelki/v1")
        protected String naziv;

        /**
         * Gets the value of the idIzdelek property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getIdIzdelek() {
            return idIzdelek;
        }

        /**
         * Sets the value of the idIzdelek property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setIdIzdelek(Integer value) {
            this.idIzdelek = value;
        }

        /**
         * Gets the value of the cena property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getCena() {
            return cena;
        }

        /**
         * Sets the value of the cena property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setCena(Double value) {
            this.cena = value;
        }

        /**
         * Gets the value of the kategorija property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKategorija() {
            return kategorija;
        }

        /**
         * Sets the value of the kategorija property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKategorija(String value) {
            this.kategorija = value;
        }

        /**
         * Gets the value of the naziv property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaziv() {
            return naziv;
        }

        /**
         * Sets the value of the naziv property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaziv(String value) {
            this.naziv = value;
        }

    }

}
