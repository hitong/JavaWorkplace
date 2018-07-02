package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Person;
import dbService.PersonService;

/**
 * Servlet implementation class AddPerson
 */
@WebServlet("/AddPerson")
public class AddPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person person = new Person();
		request.setCharacterEncoding("UTF-8");
		person.setPersonName(request.getParameter("PersonName"));
		try {
			String[] tmp = request.getParameter("Birthday").split("-");
			person.setBirthday(
					new Date(Integer.parseInt(tmp[0]) - 1900, Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
			person.setSex((short) (request.getParameter("Sex").equals("male") ? 0 : 1));
			System.out.println(request.getParameter("Sex"));
			PersonService personService = PersonService.getInstanse();
			person.setPersonId(System.currentTimeMillis() + "");
			personService.addPerson(person);
			request.getSession().setAttribute("personId", person.getPersonId());
			response.sendRedirect("OperationInterval/AddResult.jsp");
		} catch (Exception e) {
			response.sendRedirect("OperationInterval/AddFalse.jsp");
		}

	}

}
