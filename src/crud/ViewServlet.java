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
		List<User> list= UserDao.getAll();
		out.println("<table border='1'>");
		out.println("<tr><th>User Name</th><th>Email</th><th>Full Name</th><th>Phone</th><th>Address</th><th colspan='2'>Action</th></tr>");
		for(User u : list) {
			out.println("<tr><td>"+u.getUsername()+"</td><td>"+u.getEmail()+"</td><td>"+u.getFullname()+"</td><td>"+u.getPhone()+"</td><td>"+u.getAddress()+"</td><td><a href='EditServlet?id="+u.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+u.getId()+"'>Delete</a></td></tr>");
				
		}
		out.println("</table>");
		out.close();
	}
}
