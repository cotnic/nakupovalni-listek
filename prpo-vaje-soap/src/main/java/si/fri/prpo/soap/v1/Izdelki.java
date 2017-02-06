package si.fri.prpo.soap.v1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2017-01-08T19:34:57.312+01:00
 * Generated source version: 3.1.6
 * 
 */
@WebServiceClient(name = "Izdelki", 
                  wsdlLocation = "file:/home/cotnic/workdir/Git/skupina08/prpo-vaje-sheme/lib/si/fri/prpo/storitve/izdelki/v1/Izdelki.wsdl",
                  targetNamespace = "http://prpo.fri.si/storitve/izdelki/v1") 
public class Izdelki extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://prpo.fri.si/storitve/izdelki/v1", "Izdelki");
    public final static QName IzdelkiSOAP = new QName("http://prpo.fri.si/storitve/izdelki/v1", "IzdelkiSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/cotnic/workdir/Git/skupina08/prpo-vaje-sheme/lib/si/fri/prpo/storitve/izdelki/v1/Izdelki.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Izdelki.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/home/cotnic/workdir/Git/skupina08/prpo-vaje-sheme/lib/si/fri/prpo/storitve/izdelki/v1/Izdelki.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Izdelki(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Izdelki(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Izdelki() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public Izdelki(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public Izdelki(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public Izdelki(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns IzdelkiPort
     */
    @WebEndpoint(name = "IzdelkiSOAP")
    public IzdelkiPort getIzdelkiSOAP() {
        return super.getPort(IzdelkiSOAP, IzdelkiPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IzdelkiPort
     */
    @WebEndpoint(name = "IzdelkiSOAP")
    public IzdelkiPort getIzdelkiSOAP(WebServiceFeature... features) {
        return super.getPort(IzdelkiSOAP, IzdelkiPort.class, features);
    }

}
