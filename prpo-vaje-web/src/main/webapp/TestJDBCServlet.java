package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.jdbc.Entiteta;
import si.fri.prpo.jdbc.Izdelek;
import si.fri.prpo.jdbc.IzdelekDaoImpl;


/**
 * Servlet implementation class TestJDBCServlet
 */
public class TestJDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IzdelekDaoImpl daoIzdelek;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJDBCServlet() {
        super();
        daoIzdelek = new IzdelekDaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Insert code to display all Izdelki
		List<Entiteta> izdelki = daoIzdelek.vrniVse();
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>Vsi izdelki</title></head>");
	    out.println("<body>");
	    out.println("<center><h1>Vsi izdelki</h1>");
	    out.println("<table border=\"1\" align=\"center\" style=\"width:50%\">");
	    out.println("<tr>"
	    		+ "<th>ID</th>"
	    		+ "<th>Naziv</th>"
	    		+ "<th>Kategorija</th>"
	    		+ "<th>Cena</th>"
	    		+ "</tr>");
		for (Entiteta temp : izdelki) {
			out.println("<tr>");
			System.out.println(temp.getId() + " ID Izdelka");
			out.print("<td>" + temp.getId() + "</td>");
	        out.print("<td>" + ((Izdelek) temp).getNaziv() + "</td>");
	        out.print("<td>" + ((Izdelek) temp).getKategorija() + "</td>");
	        out.print("<td>" + ((Izdelek) temp).getCena() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</center>");
	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
