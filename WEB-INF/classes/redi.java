import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.net.*;
public class redi extends HttpServlet
{
	Connection con=null;
	Statement st=null;
	ResultSet rst=null;
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int n=0;
		String sta="y";
		try
		{
			
			//jdbc_connec.
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi","root","rishi1008");
			st=con.createStatement();
			String q="select * from html;";
			rst=st.executeQuery(q);
			while(rst.next())
			{
				if(sta.equals(rst.getString(4)))
				{
					req.setAttribute("attributeName",rst.getString(1));
					RequestDispatcher rd = req.getRequestDispatcher("wel");
					rd.forward(req,res);
					n++;
					
				}
				
			}
			if(n==0)
			{
			pw.println("<html>");
					pw.println("<head>");
						pw.println("<title>login</title>");
						pw.println("<link rel='stylesheet' type='text/css' href='log.css'>");
						pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
					pw.println("</head>");
					pw.println("<body>");
						pw.println("<p>LOGIN!!!!!!!</p>");
						pw.println("<div id='lo'><marquee>CONTROLLING COMPLEXITY IS THE ESSENCE OF COMPUTER PROGRAMMING</marquee></div>");
						pw.println("<div class='a'>");
						pw.println("<form name='log' method='get' action ='log' class='b'>");
						pw.println("<input type='text' name='t1' placeholder='USERNAME' class='d'><br>");
						pw.println("<input type='password' name='p1' placeholder='PASSWORD' class='d'><br>");
						pw.println("<input type='submit' value='LOGIN' id='c'>");
						pw.println("</form>");
						pw.println("</div>");
					pw.println("</body>");
				pw.println("</html>");
				n++;
			}
			while(n>1)
			{
				pw.println("<html>");
					pw.println("<head>");
						pw.println("<title>login</title>");
						pw.println("<link rel='stylesheet' type='text/css' href='log.css'>");
						pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
					pw.println("</head>");
					pw.println("<body>");
						pw.println("<p>LOGIN!!!!!!!</p>");
						pw.println("<div id='lo'><marquee>CONTROLLING COMPLEXITY IS THE ESSENCE OF COMPUTER PROGRAMMING</marquee></div>");
						pw.println("<div class='a'>");
						pw.println("<p class='abvc'><b><i>***invalid username***</b></i></p>");
						pw.println("<form name='log' method='get' action ='log' class='b'>");
						pw.println("<input type='text' name='t1' placeholder='USERNAME' class='d'><br>");
						pw.println("<input type='password' name='p1' placeholder='PASSWORD' class='d'><br>");
						pw.println("<input type='submit' value='LOGIN' id='c'>");
						pw.println("</form>");
						pw.println("</div>");
					pw.println("</body>");
				pw.println("</html>");
			}
		}
		
		catch(Exception e)
		{
			
		}
	}
}