package si.fri.prpo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import si.fri.prpo.jpa.entitete.Trgovina;

@Path("/trgovine")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TrgovinaREST {

	@GET
	@Path("/")
	Response vrniTrgovine(@QueryParam("offset") int offset, @QueryParam("limit") int limit);
	
	@GET
	@Path("/{id}")
	public Response vrniTrgovino(@PathParam("id") int id);
	
	@POST
	@Path("/")
	public Response dodajTrgovino(Trgovina trgovina);
	
	@PUT
	@Path("/")
	public Response urediTrgovino(Trgovina trgovina);
	
	@DELETE
	@Path("/{id}")
	public Response izbrisiTrgovino(@PathParam("id") int id);
}
