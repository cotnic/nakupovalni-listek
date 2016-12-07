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

import si.fri.prpo.jpa.entitete.Izdelek;

@Path("/izdelki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IzdelekREST {

	@GET
	@Path("/")
	public Response vrniIzdelke(@QueryParam("offset") int offset, @QueryParam("limit") int limit);
	
	@GET
	@Path("/{id}")
	public Response vrniIzdelek(@PathParam("id") int id);
	
	@POST
	@Path("/")
	public Response dodajIzdelek(Izdelek izdelek);
	
	@PUT
	@Path("/")
	public Response urediIzdelek(Izdelek izdelek);
	
	@DELETE
	@Path("/{id}")
	public Response izbrisiIzdelek(@PathParam("id") int id);
}
