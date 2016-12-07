package si.fri.prpo.ejb.zrna;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Prestreznik {

	@AroundInvoke
	public Object zapisiKlic(InvocationContext kontekstProzenja) throws Exception {
		System.out.println("Prestrezen klic poslovne metode");
		System.out.println("Ime zrna: "
				+ kontekstProzenja.getClass().getName());
		System.out.println("Ime metode: "
				+ kontekstProzenja.getMethod().getName());
		
		return kontekstProzenja.proceed();
	}
}
