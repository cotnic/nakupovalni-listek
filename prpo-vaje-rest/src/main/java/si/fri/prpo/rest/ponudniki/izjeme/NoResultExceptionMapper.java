package si.fri.prpo.rest.ponudniki.izjeme;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class NoResultExceptionMapper implements ExceptionMapper<NoResultException> {

	@Override
	public Response toResponse(NoResultException ex) {
		SporociloIzjeme izjema = new SporociloIzjeme(ex.getMessage(), 404, 
				"http://docs.oracle.com/cd/E24329_01/apirefs.1211/e24399/index.html?javax/persistence/NoResultException.html");
		return Response.status(Status.NOT_FOUND)
				.entity(izjema)
				.build();
	}

}
