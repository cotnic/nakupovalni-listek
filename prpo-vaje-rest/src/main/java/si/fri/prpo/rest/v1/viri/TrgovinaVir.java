package si.fri.prpo.rest.v1.viri;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
import si.fri.prpo.ejb.zrna.UpravljalecTrgovinSBLocal;
import si.fri.prpo.jpa.entitete.Trgovina;
import si.fri.prpo.rest.TrgovinaREST;

@Path("/trgovine")
@Api(value = "/trgovine")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class TrgovinaVir implements TrgovinaREST{
	
	@EJB
	UpravljalecTrgovinSBLocal upravljalecTrgovin;

	@Override
	@GET
	@ApiOperation(value = "Vrne vse trgovine.", notes = "Vrne celoten seznam trgovin. Lahko ga tudi omejimo s ostranjevanjem.", response = Response.class)
	@Path("/")
	public Response vrniTrgovine(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
		if(limit > 0) {
			List<Trgovina> trgovine = upravljalecTrgovin.vrniVseTrgovine(offset, limit);
			return Response.ok(trgovine.toArray(new Trgovina[trgovine.size()])).build();
		}
		List<Trgovina> trgovine = upravljalecTrgovin.vrniVseTrgovine();
		return Response.ok(trgovine.toArray(new Trgovina[trgovine.size()])).build();
	}

	@Override
	@GET
	@ApiOperation(value = "Vrne trgovino glede na ID.", notes = "Vrne trgovino, ki si jo izberemo s pomočjo ID.", response = Response.class)
	@Path("/{id}")
	public Response vrniTrgovino(@PathParam("id") int id) {
		Trgovina trgovina = upravljalecTrgovin.vrniTrgovino(id);
		
		return Response.ok(trgovina).build();
	}

	@Override
	@POST
	@ApiOperation(value = "Ustvari novo trgovino.", notes = "Vrne izdelek, ki smo ga ustvarili v JSON formatu.", response = Response.class)
	@Path("/")
	public Response dodajTrgovino(Trgovina trgovina) {
		upravljalecTrgovin.shraniTrgovino(trgovina);

		return Response.ok("ok").build();
	}

	@Override
	@PUT
	@ApiOperation(value = "Uredi podano trgovino.", notes = "Vrne JSON trgovine, ki smo jo posodobili.", response = Response.class)
	@Path("/")
	public Response urediTrgovino(Trgovina trgovina) {
		upravljalecTrgovin.posodobiTrgovino(trgovina);
		
		return Response.ok("ok").build();
	}

	@Override
	@DELETE
	@ApiOperation(value = "Izbriše izbrano trgovino.", notes = "Vrne ID trgovine, ki smo jo izbrisali.", response = Response.class)
	@Path("/{id}")
	public Response izbrisiTrgovino(@PathParam("id") int id) {
		upravljalecTrgovin.zbrisiTrgovino(id);
		
		return Response.ok("ok").build();
	}

}
