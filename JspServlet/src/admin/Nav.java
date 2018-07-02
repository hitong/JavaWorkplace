package admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

@SuppressWarnings("serial")
public class Nav extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");
		String href = op.substring(4);
		String OP = op.substring(0,4);
		
		if(OP.compareTo("del ") == 0){
			try {
				Dao.delUser(href);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			OP = op.substring(0,5);
			href = op.substring(5);
			if(OP.compareTo("2del ") == 0){
				try {
					Dao.delBook(href);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		response.sendRedirect(request.getParameter("myUrl"));
	}
}
