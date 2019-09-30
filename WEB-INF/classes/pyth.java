import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.net.*;
public class pyth extends HttpServlet
{
	Connection con=null;
	Statement st=null;
	ResultSet rst=null;
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String sta="y";
		int f=0;
		
		try
		{
			//ip address
			InetAddress ip;
			ip=InetAddress.getLocalHost();
			NetworkInterface net=NetworkInterface.getByInetAddress(ip);
			String mac=ip.getHostAddress();
			//ip close
			
			//jdbc_conn.
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rishi","root","rishi1008");
			st=con.createStatement();
			String q="select * from html;";
			rst=st.executeQuery(q);
			while(rst.next())
			{
				if(sta.equals(rst.getString(4)))
				{

					pw.println("<html>");
					pw.println("<head>");
						pw.println("<title>java</title>");
						pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
						pw.println("<style>");
						pw.println("html{");
							pw.println("font-family:cursive;");
							pw.println("color:orange;");
						pw.println("}");
						pw.println("body{");
							pw.println("background-image:url('wt.jpg');");
							pw.println("background-size:100%;");
							pw.println("background-repeat:no-repeat;");
						pw.println("}");
						pw.println(".ip{");
							pw.println("margin-left:900px;");
						pw.println("}");
						pw.println("#Video1");
						pw.println("{");
							pw.println("margin-top: 90px;");
							pw.println("margin-left:340px;");
							pw.println("display:block;");
							pw.println("z-index:99;");
							pw.println("border:2px solid black;");
							pw.println("border-radius:5px;");
						pw.println("}");
						pw.println("#d");
						pw.println("{");
						pw.println("width:800px;");
						pw.println("height:10px;");
						pw.println("margin-left:200px;");
						pw.println("margin-top:100px;");
						pw.println("}");
						pw.println("input");
						pw.println("{");
						pw.println("background-color:black;");
						pw.println("color:orange;");
						pw.println("width:100px;");
						pw.println("height:30px;");
						pw.println("font-family:cursive;");
						pw.println("cursor:pointer;");
						pw.println("margin-left:10px;");
						pw.println("border-color:orange;");
						pw.println("padding-bottom:5px;");
						pw.println("}");
						pw.println("</style>");
					pw.println("</head>");
					pw.println("<body>");
						pw.println("<div class='ip'>");
						pw.println("<form action='logout' method='post'>");
						pw.println("<input type='submit' value='LOG OUT'></form>");
						pw.println("</div>");
						pw.println("<div id='d'>");
						pw.println("<marquee>ENJOY LEARNING!!!........HAPPY CODING!!!</marquee>");
						pw.println("</div>");
						pw.println("<iframe id='Video1' width='600' height='350' src='https://www.youtube.com/embed/5FOl1CoVS7A'>");
						pw.println("</iframe>");
					pw.println("</body>");
				pw.println("</html>");
				
				f++;
				}
			}
			if(f==0)
			{
				res.sendRedirect("redi");
			}
		}
		catch(Exception e)
		{
		}
	}
}