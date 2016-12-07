package si.fri.prpo.rest.v1.viri;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import si.fri.prpo.ejb.zrna.UpravljalecUporabnikovSBLocal;
import si.fri.prpo.jpa.entitete.Uporabnik;
import si.fri.prpo.rest.UporabnikREST;

@Path("/uporabniki")
@Api(value = "/uporabniki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class UporabnikVir implements UporabnikREST {
	
	@EJB
	UpravljalecUporabnikovSBLocal upravljalecUporabnikov;
	
	@Override
	@GET
	@ApiOperation(value = "Vrne vse uporabnike.", notes = "Vrne celoten seznam uporabnikov. Lahko ga tudi omejimo s ostranjevanjem.", response = Response.class)
	public Response vrniUporabnike(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		if(limit > 0) {
			List<Uporabnik> uporabniki = upravljalecUporabnikov.vrniVseUporabnike(offset, limit);
			return Response.ok(uporabniki.toArray(new Uporabnik[uporabniki.size()])).build();
		}
		List<Uporabnik> uporabniki = upravljalecUporabnikov.vrniVseUporabnike();
		return Response.ok(uporabniki.toArray(new Uporabnik[uporabniki.size()])).build();
	}

	@Override
	@GET
	@ApiOperation(value = "Vrne uporabnika glede na ID.", notes = "Vrne uporabnika, ki si ga izberemo s pomočjo ID.", response = Response.class)
	@Path("/{id}")
	public Response vrniUporabnika(@ApiParam(value = "ID uporabnika, ki ga izberemo", required = true) @PathParam("id") int id) {
		Uporabnik uporabnik = upravljalecUporabnikov.vrniUporabnika(id);
		
		return Response.ok(uporabnik).build();
	}

	@Override
	@POST
	@ApiOperation(value = "Ustvari novega uporabnika.", notes = "Vrne uporabnika, ki smo ga ustvarili, v JSON formatu.", response = Response.class)
	@Path("/")
	public Response dodajUporabnika(Uporabnik uporabnik) {
		upravljalecUporabnikov.shraniUporabnika(uporabnik);

		return Response.ok("ok").build();
	}

	@Override
	@PUT
	@ApiOperation(value = "Uredi podanega uporabnika.", notes = "Vrne JSON uporabnika, ki smo ga posodobili.", response = Response.class)
	@Path("/")
	public Response urediUporabnika(Uporabnik uporabnik) {
		upravljalecUporabnikov.posodobiUporabnika(uporabnik);
		
		return Response.ok("ok").build();
	}

	@Override
	@DELETE
	@ApiOperation(value = "Uredi podanega uporabnika.", notes = "Vrne JSON uporabnika, ki smo ga posodobili.", response = Response.class)
	@Path("/{id}")
	public Response izbrisiUporabnika(@ApiParam(value = "ID uporabnika, ki ga izbrišemo", required = true) @PathParam("id") int id) {
		upravljalecUporabnikov.zbrisiUporabnika(id);
		
		return Response.ok("ok").build();
	}

}
