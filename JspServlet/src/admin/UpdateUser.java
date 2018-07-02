package admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import been.User;
import dao.Dao;

@SuppressWarnings("serial")
public class UpdateUser extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPassWord(request.getParameter("password"));
		user.setSex(request.getParameter("sex"));
		user.setBirth(request.getParameter("date"));
		user.setTel(request.getParameter("tel"));
		user.setRealName(request.getParameter("realname"));
		user.setAd(request.getParameter("ad"));
		user.setNum(Integer.parseInt(request.getParameter("mailnum")));
		user.setMonney(request.getParameter("yu"));
		try {
			Dao.updateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getParameter("upUserUrl"));
	}
}
