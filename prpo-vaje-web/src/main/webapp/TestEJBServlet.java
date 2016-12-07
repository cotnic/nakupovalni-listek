package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.ejb.zrna.UpravljalecTrgovinSBLocal;
import si.fri.prpo.ejb.zrna.UpravljalecIzdelkovSBLocal;
import si.fri.prpo.ejb.zrna.UpravljalecUporabnikovSBLocal;
import si.fri.prpo.ejb.zrna.NakupovListekFacade;
import si.fri.prpo.jpa.entitete.Izdelek;
import si.fri.prpo.jpa.entitete.Trgovina;
import si.fri.prpo.jpa.entitete.Uporabnik;

/**
 * Servlet implementation class TestEJBServlet
 */
public class TestEJBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private NakupovListekFacade nakupi;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestEJBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Uporabnik> uporabniki = nakupi.vrniVseUporabnike();
		
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>Vsi uporabniki</title></head>");
	    out.println("<body>");
	    out.println("<center><h1>Vsi uporabniki</h1>");
	    out.println("<table border=\"1\" align=\"center\" style=\"width:50%\">");
	    out.println("<tr>"
	    		+ "<th>Uporabniško</th>"
	    		+ "<th>Ime</th>"
	    		+ "<th>Priimek</th>"
	    		+ "<th>email</th>"
	    		+ "</tr>");
		for (Uporabnik uporabnik : uporabniki) {
			out.println("<tr>");
			System.out.println(uporabnik.getUporabniskoIme() + " username Uporabnika");
			out.print("<td>" + uporabnik.getUporabniskoIme() + "</td>");
	        out.print("<td>" + uporabnik.getIme() + "</td>");
	        out.print("<td>" + uporabnik.getPriimek() + "</td>");
	        out.print("<td>" + uporabnik.getEmail() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</center>");
	    Trgovina trgovina = nakupi.vrniTrgovino(1);
	    out.println("<br/>" + trgovina.getNaziv() + "<br/>");
	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	    nakupi.shraniIzdelek(new Izdelek("Kinder Bueno", "Sladkarije", 0.85));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
