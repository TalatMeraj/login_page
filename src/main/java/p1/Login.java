package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.xdevapi.Statement;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Login() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
	//	String mobile=request.getParameter("mobile");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		out.print("<table border='1'>");    //data back to html page from response..
//		out.print("<tr>");
//		out.print(" <td> ");
//		out.print(" Name ");
//		out.print("</td> ");
//		out.print(" <td> ");
//		out.print(" mobile ");
//		out.print("</td> ");
//		out.print(" <td> ");
//		out.print(" email ");
//		out.print("</td> ");
//		out.print(" <td> ");
//		out.print(" password ");
//		out.print("</td> ");
//		out.print("</tr>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_connection_1","root","Meraj@123");
		//	System.out.println(con);
			
			Statement stmnt=  con.createStatement();
			ResultSet result= stmnt.executeQuery("select * from login WHERE email='"+email+"' And password='"+password+"' ");
			if(result.next()) {
				out.print("<h2>");
				out.print("Welcome");
				out.print("</h2>");
				out.print("<tr>");
				out.print(" <td> ");
				out.print(" Name ");
				out.print("</td> ");
				out.print(" <td> ");
				out.print(" email ");
				out.print("</td> ");
				out.print(" <td> ");
				out.print(" password ");
				out.print("</td> ");
				out.print(" <td> ");
				out.print("mobile ");
				out.print("</td> ");
				out.print("</tr>");
				
				ResultSet result1=stmnt.executeQuery("select * from login where email='"+email+"'");
				while(result1.next()) {
				
				
				out.print("<tr>");
				out.print(" <td> ");
				out.print(result.getString(1));
				out.print("</td> ");
				out.print(" <td> ");
				out.print(result.getString(2));
				out.print("</td> ");
				out.print(" <td> ");
				out.print(result.getString(3));
				out.print("</td> ");
				out.print(" <td> ");
				out.print(result.getString(4));
				out.print("</td> ");
				out.print("</tr>");
				
				}
			}else {
				out.print("<h2>");
				out.print("Invalid email or password");
				out.print("</h2>");
			}
			out.print("</table>");
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
}
