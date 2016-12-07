package si.fri.prpo.rest.v1.viri;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import si.fri.prpo.ejb.zrna.NeustrezenIzdelekException;
import si.fri.prpo.ejb.zrna.UpravljalecIzdelkovSBLocal;
import si.fri.prpo.jpa.entitete.Izdelek;
import si.fri.prpo.rest.IzdelekREST;

@Path("/izdelki")
@Api(value = "/izdelki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class IzdelekVir implements IzdelekREST {

	@EJB
	UpravljalecIzdelkovSBLocal upravljalecIzdelkov;

	@Override
	@GET
	@ApiOperation(value = "Vrne vse izdelke.", notes = "Vrne celoten seznam izdelkov. Lahko ga tudi omejimo s ostranjevanjem.", response = Response.class)
	@Path("/")
	public Response vrniIzdelke(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		if (limit > 0) {
			List<Izdelek> izdelki = upravljalecIzdelkov.vrniVseIzdelke(offset, limit);
			return Response.ok(izdelki.toArray(new Izdelek[izdelki.size()])).build();
		}
		List<Izdelek> izdelki = upravljalecIzdelkov.vrniVseIzdelke();
		return Response.ok(izdelki.toArray(new Izdelek[izdelki.size()])).build();
	}

	@Override
	@GET
	@ApiOperation(value = "Vrne izdelek glede na ID.", notes = "Vrne izdelek, ki si ga izberemo s pomočjo ID.", response = Response.class)
	@Path("/{id}")
	public Response vrniIzdelek(@PathParam("id") int id) {
		try {
			Izdelek izdelek = upravljalecIzdelkov.vrniIzdelek(id);

			return Response.ok(izdelek).build();
		} catch (NoResultException ex) {
			throw new NoResultException();
		}
	}

	@Override
	@POST
	@ApiOperation(value = "Ustvari nov izdelek.", notes = "Vrne izdelek, ki smo ga ustvarili v JSON formatu.", response = Response.class)
	@Path("/")
	public Response dodajIzdelek(Izdelek izdelek) {
		try {
			upravljalecIzdelkov.shraniIzdelek(izdelek);
		} catch (NeustrezenIzdelekException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(izdelek).build();
	}

	@Override
	@PUT
	@ApiOperation(value = "Uredi podani izdelek.", notes = "Vrne JSON izdelka, ki smo ga posodobili.", response = Response.class)
	@Path("/")
	public Response urediIzdelek(Izdelek izdelek) {
		upravljalecIzdelkov.posodobiIzdelek(izdelek);

		return Response.ok(izdelek).build();
	}

	@Override
	@DELETE
	@ApiOperation(value = "Izbriše izbrani izdelek.", notes = "Vrne ID izdelka, ki smo ga izbrisali.", response = Response.class)
	@Path("/{id}")
	public Response izbrisiIzdelek(@PathParam("id") int id) {
		upravljalecIzdelkov.izbrisiIzdelek(id);

		return Response.ok(id).build();
	}

}
