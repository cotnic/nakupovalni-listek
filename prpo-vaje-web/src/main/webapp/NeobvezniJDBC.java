package webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.jdbc.Izdelek;
import si.fri.prpo.jdbc.IzdelekDaoImpl;

/**
 * Servlet implementation class NeobvezniJDBC
 */
public class NeobvezniJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IzdelekDaoImpl daoIzdelek;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NeobvezniJDBC() {
        super();
        daoIzdelek = new IzdelekDaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Izdelek izdelek1 = new Izdelek(40, "Skodelica", "Posode", 1.52);
		Izdelek izdelek2 = new Izdelek(40, "Kozarec", "Posode", 0.82);
		daoIzdelek.vstaviDva(izdelek1, izdelek2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
