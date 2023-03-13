import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
public class Exp3 extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException
{
ServletContext context = getServletContext();
String databasetype = context.getInitParameter("databasetype");
PrintWriter pw = response.getWriter();
pw.println("<html>");
pw.println("<h1> databasetype= "+databasetype +"</h1>");
pw.println("</html>");
}
}