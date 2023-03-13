import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Select5 extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter pw=res.getWriter();
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from students");
pw.println("<html><body><table border=1>");
pw.println("<tr><td>Rno</td><td>Sname</td><td>Branch</td><td>Percentage</td><td>Address</td>");
while(rs.next())
{
pw.println("<tr><td>");
pw.println(rs.getString("rno")+"</td><td>");
pw.println(rs.getString("sn")+"</td><td>");
pw.println(rs.getString("brn")+"</td><td>");
pw.println(rs.getInt("pg")+"</td><td>");
pw.println(rs.getString("adr")+"</td></tr>");
pw.println("</body>");
}
}
catch(Exception e)
{
pw.println(e);
}
}
}