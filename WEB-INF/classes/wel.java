import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.net.*;
public class wel extends HttpServlet
{
	Connection con=null;
	Statement st=null;
	ResultSet rst=null;
	ResultSet rest=null;
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String sta="y";
		int f=0;
		int co=0;
		
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
			String user = (String)req.getAttribute("attributeName");
			String us=user;
			user=user.toUpperCase();
			String q1="select courses from html where user='"+us+"';";
			rest=st.executeQuery(q1);
			rest.next();
			String cour=rest.getString(1);
			String[] courses=cour.split(" ");
			String q="select * from html;";
			rst=st.executeQuery(q);
			while(rst.next())
			{
				if(sta.equals(rst.getString(4)))
				{
				pw.println("<html>");
					pw.println("<head>");
						pw.println("<title>welcome</title>");
						pw.println("<link rel='stylesheet' type='text/css' href='wel.css'>");

					pw.println("</head>");
					pw.println("<body>");
						pw.println("<div class='ip'>");
							pw.println("<form action='logout' method='post'>");
							pw.println("<input type='submit' value='LOG OUT'></form>");
						pw.println("</div>");
						pw.println("<p>WELCOME "+user+"</p>");
						pw.println("<p class='h1'>"+user+" ,YOU HAVE OPTED FOR FOLLOWING COURSES</p>");
						pw.println("<div id='ma'><marquee>***SELECT THE IMAGE TO START THE RESPECTIVE COURSE***</marquee></div>");
						pw.println("<div id='slider' >");
						if(courses[co].equals("c")){
						pw.println("<a href='c' target='_blank'>");
						pw.println("<img src='Untitled-1.jpg'></a>");
						co++;}
						if(courses[co].equals("java")){
						pw.println("<a href='java' target='_blank'>");
						pw.println("<img src='maxresdefault.jpg'></a></br>");
						co++;}
						if(co==2)
							pw.println("<br>");
						if(courses[co].equals("html")){
						pw.println("<a href='html5' target='_blank'>");
						pw.println("<img src='minimalistic_logos_html5_desktop_2048x1200_hd-wallpaper-1125814.jpg'></a>");
						co++;}
						if(co==2)
							pw.println("<br>");						
						if(courses[co].equals("python")){
						pw.println("<a href='pyth' target='_blank'>");
						pw.println("<img src='Untitled-2.jpg'></a>");
						co++;}
						pw.println("</div>");
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
			//pw.println(e);
		}
	}
}