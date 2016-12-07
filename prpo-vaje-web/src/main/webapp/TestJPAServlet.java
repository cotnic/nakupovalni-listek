package webapp;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import si.fri.prpo.jdbc.Entiteta;
import si.fri.prpo.jdbc.Izdelek;
import si.fri.prpo.jpa.entitete.Uporabnik;

/**
 * Servlet implementation class TestJPAServlet
 */
public class TestJPAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="prpo-vaje-jpa")
	EntityManager em;

	@Resource
	UserTransaction tx;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJPAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Test statičnih poizvedb
		Query q = em.createNamedQuery("Uporabnik.findId");
		q.setParameter("id", 2);
		Uporabnik upor = (Uporabnik)q.getSingleResult();
		response.getWriter().append("The user that is returned: " + upor.getIme() + " " + upor.getPriimek() + "<br/>");
		
		//Test UPDATE
		try {
			tx.begin();
			Query q1 = em.createQuery("UPDATE Uporabnik u SET u.email = 'spela@jurak.si' WHERE u.uporabniskoIme = 'sj0511'");
			q1.executeUpdate();
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		q.setParameter("id", 3);
		Uporabnik upor1 = (Uporabnik)q.getSingleResult();
		response.getWriter().append("The user that has changed: " + upor1.getEmail() + "<br/>");
		
		//Test Ostranjevanja
		int stZapisov = 2;
		int zacetek = 0;
		int st = 1;
		while(true) {
			Query q2 = em.createQuery("SELECT u FROM Uporabnik u");
			q2.setMaxResults(stZapisov);
			q2.setFirstResult(zacetek);
			List<Uporabnik> uporabniki = q2.getResultList();
			if(uporabniki.isEmpty())
				break;
			
			response.getWriter().append(st + ". number of select: " + upor1.getEmail() + "<br/>");
			for (Uporabnik uporabnik : uporabniki) {
				response.getWriter().append("User: " + uporabnik.getIme() + " " + uporabnik.getPriimek() + "<br/>");
			}
			st++;
			em.clear();
			zacetek += uporabniki.size();
		}
		
		//Test delete
		try {
			tx.begin();
			Query q3 = em.createQuery("DELETE FROM Izdelek i WHERE i.naziv = 'Nestea'");
			q3.executeUpdate();
			tx.commit();
			response.getWriter().append("Izdelek Nestea je bil uspešno izbrisan! <br/>");
			em.clear();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//TEST CRITERIA (Neobvezni del)
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Uporabnik> c = cb.createQuery(Uporabnik.class);
		Root<Uporabnik> uporabnik = c.from(Uporabnik.class);
		c.select(uporabnik).where(cb.and(cb.like(uporabnik.get("ime"), "%itj%"), cb.like(uporabnik.get("priimek"), "%otni%")));
		List<Uporabnik> users = em.createQuery(c).getResultList();
		for (Uporabnik user : users) {
			response.getWriter().append("User: " + user.getIme() + " " + user.getPriimek() + "<br/>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
