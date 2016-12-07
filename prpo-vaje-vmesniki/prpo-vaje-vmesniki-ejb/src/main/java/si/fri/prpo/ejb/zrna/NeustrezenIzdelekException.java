package si.fri.prpo.ejb.zrna;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class NeustrezenIzdelekException extends Exception {
	
	public NeustrezenIzdelekException() {
		super();
	}
	
	public NeustrezenIzdelekException(Exception exc) {
		super(exc);
	}
	
	public NeustrezenIzdelekException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
	
	public void printTraceIzdelekErr() {
		System.out.println("Exception of Izdelek was handled");
	}
}
