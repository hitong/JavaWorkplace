package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import been.Admin;
import dao.Dao;

@SuppressWarnings("serial")
public class AdminLogin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("adminname");
		String password = request.getParameter("adminpassword");
		Admin admin = Dao.getAdminMap().get(username);
		if (admin == null) {
			out.print("未找到指定账户");
			out.print("<a href = \"../AdminLogin.html\">请点击返回</a>");
			return ;
		}
		if (!admin.getPassword().equals(password)) {
			out.print("Your password is err");
			out.print("<a href = \"../AdminLogin.html\">请点击返回</a>");
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("adminId", username);
		response.sendRedirect("../Manager2.jsp");
		out.flush();
		out.close();
	}
}
