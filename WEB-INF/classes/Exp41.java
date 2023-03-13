import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
public class Exp41 extends HttpServlet 
{ 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
 throws ServletException, IOException 
 { 
 response.setContentType("text/html"); 
 PrintWriter out = response.getWriter(); 
 Cookie ck[]=new Cookie[5]; 
 int i=0; 
 ServletConfig config=getServletConfig(); 
 Enumeration e=config.getInitParameterNames(); 
 while(e.hasMoreElements()) 
 { 
 String name = (String) e.nextElement(); 
 String value = config.getInitParameter(name); 
 ck[i]=new Cookie(name,value); 
 response.addCookie(ck[i]); 
 i++; 
 } 
 
 RequestDispatcher rd=request.getRequestDispatcher("exp42"); 
 rd.forward(request,response); 
 out.close(); 
 } 
} 