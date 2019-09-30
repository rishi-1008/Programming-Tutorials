import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class reg extends HttpServlet
{
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String un=req.getParameter("t1");
		String em=req.getParameter("t3");
		String ps=req.getParameter("p1");
		String rps=req.getParameter("p2");
		String course="";
		String cour[] = req.getParameterValues("c") ;
		try
		{
			for(int i=0;i<cour.length;i++)
				course+=cour[i]+" ";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi","root","rishi1008");
			st=con.createStatement();
			String q="insert into html values("+"'"+un+"','"+em+"','"+ps+"','n','n','"+course+"');";
			int n=st.executeUpdate(q);
			if(n!=0)
			{
				pw.println("<script>alert('successfully registered');</script>");
				pw.println("<script>window.location='home.html';</script>");
				//res.sendRedirect("home.html");
			}
			
		}
		
		catch(Exception e)
		{
				pw.println("<script>alert('username already exists!...sry try_again!!');</script>");
				pw.println("<script>window.location='home.html';</script>");
		}
	}
}