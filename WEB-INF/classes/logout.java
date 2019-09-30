import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.net.*;
public class logout extends HttpServlet
{
	Connection con=null;
	Statement st=null;
	ResultSet rst=null;
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		try
		{
			
			//jdbc_conn.
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi","root","rishi1008");
			st=con.createStatement();
			String q1="update html set status='n';";
			int n=st.executeUpdate(q1);
			res.sendRedirect("home.html");
		}
		catch(Exception e)
		{
		}
	}
}