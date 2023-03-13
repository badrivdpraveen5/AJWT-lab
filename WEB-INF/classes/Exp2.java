import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class Exp2 extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws
ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String name=req.getParameter("name");
pw.println("Hai "+name+"Welcome");
pw.close();
}
}