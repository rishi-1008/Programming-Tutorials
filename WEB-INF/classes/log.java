import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.*;
public class log extends HttpServlet
{
	Connection con=null;
	Statement st=null;
	ResultSet rst=null;
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		int f=0;
		
		String un=req.getParameter("t1");
		String ps=req.getParameter("p1");
		try
		{
			//id address
			String u=UUID.randomUUID().toString();
			//id close
			
			//jdbc_conn.
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi","root","rishi1008");
			st=con.createStatement();
			String q="select * from html;";
			rst=st.executeQuery(q);
			while(rst.next())
			{
				if(un.equals(rst.getString(1))&&ps.equals(rst.getString(3)))
				{
					
					String q2="update html set status='y' where user='"+un+"';";
					int n=st.executeUpdate(q2);
					String q3="update html set id='"+u+"' where user='"+un+"';";
					int n2=st.executeUpdate(q3);
					//req.setAttribute("attributeName",un);
					//RequestDispatcher rd = req.getRequestDispatcher("wel");
					//rd.forward(req,res);
					res.sendRedirect("redi");
					f++;
				}
		
			}
			if(f==0)
			{
				res.sendRedirect("log1.html");
			}
		}
		
		catch(Exception e)
		{
			//pw.println(e);
		}
	}
}