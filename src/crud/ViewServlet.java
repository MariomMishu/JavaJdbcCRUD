package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='index.html'>Add New User</a>");
		out.println("<h2>User List</h2>");
		//List<User> list= UserDao.getAll();
		out.println("<table border='1' width='100%'>");
		out.println("<tr><th>User Name</th><th>Email</th><th>Full Name</th><th>Full Name</th><th>Address</th><th>Address</th></tr>");
		out.println("</table>");
		out.close();
	}
}
