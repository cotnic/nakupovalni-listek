
package si.fri.prpo.soap.v1;

import javax.xml.bind.annotation.XmlRegistry;

import si.fri.prpo.sheme.izdelki.sporocila.v1.VrniIzdelekOdgovorSporocilo;
import si.fri.prpo.sheme.izdelki.sporocila.v1.VrniIzdelekRequest;
import si.fri.prpo.sheme.izdelki.sporocila.v1.VrniIzdelekResponse;
import si.fri.prpo.sheme.izdelki.sporocila.v1.VrniIzdelekZahtevaSporocilo;
import si.fri.prpo.sheme.izdelki.sporocila.v1.VrniIzdelkeOdgovorSporocilo;
import si.fri.prpo.sheme.izdelki.sporocila.v1.VrniIzdelkeRequest;
import si.fri.prpo.sheme.izdelki.sporocila.v1.VrniIzdelkeResponse;
import si.fri.prpo.sheme.izdelki.sporocila.v1.VrniIzdelkeZahtevaSporocilo;
import si.fri.prpo.sheme.izdelki.v1.IzdelkiListType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the si.fri.prpo.soap.v1 package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: si.fri.prpo.soap.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IzdelkiListType }
     * 
     */
    public IzdelkiListType createIzdelkiListType() {
        return new IzdelkiListType();
    }

    /**
     * Create an instance of {@link si.fri.prpo.sheme.izdelki.v1.IzdelekType }
     * 
     */
    public si.fri.prpo.sheme.izdelki.v1.IzdelekType createIzdelekType() {
        return new si.fri.prpo.sheme.izdelki.v1.IzdelekType();
    }

    /**
     * Create an instance of {@link VrniIzdelekZahtevaSporocilo }
     * 
     */
    public VrniIzdelekZahtevaSporocilo createVrniIzdelekZahtevaSporocilo() {
        return new VrniIzdelekZahtevaSporocilo();
    }

    /**
     * Create an instance of {@link VrniIzdelekOdgovorSporocilo }
     * 
     */
    public VrniIzdelekOdgovorSporocilo createVrniIzdelekOdgovorSporocilo() {
        return new VrniIzdelekOdgovorSporocilo();
    }

    /**
     * Create an instance of {@link VrniIzdelkeZahtevaSporocilo }
     * 
     */
    public VrniIzdelkeZahtevaSporocilo createVrniIzdelkeZahtevaSporocilo() {
        return new VrniIzdelkeZahtevaSporocilo();
    }

    /**
     * Create an instance of {@link VrniIzdelkeOdgovorSporocilo }
     * 
     */
    public VrniIzdelkeOdgovorSporocilo createVrniIzdelkeOdgovorSporocilo() {
        return new VrniIzdelkeOdgovorSporocilo();
    }

    /**
     * Create an instance of {@link VrniIzdelekRequest }
     * 
     */
    public VrniIzdelekRequest createVrniIzdelekRequest() {
        return new VrniIzdelekRequest();
    }

    /**
     * Create an instance of {@link VrniIzdelekResponse }
     * 
     */
    public VrniIzdelekResponse createVrniIzdelekResponse() {
        return new VrniIzdelekResponse();
    }

    /**
     * Create an instance of {@link VrniIzdelkeRequest }
     * 
     */
    public VrniIzdelkeRequest createVrniIzdelkeRequest() {
        return new VrniIzdelkeRequest();
    }

    /**
     * Create an instance of {@link VrniIzdelkeResponse }
     * 
     */
    public VrniIzdelkeResponse createVrniIzdelkeResponse() {
        return new VrniIzdelkeResponse();
    }

    /**
     * Create an instance of {@link IzdelkiListType.IzdelekType }
     * 
     */
    public IzdelkiListType.IzdelekType createIzdelkiListTypeIzdelekType() {
        return new IzdelkiListType.IzdelekType();
    }

}
