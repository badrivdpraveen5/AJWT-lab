import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
public class Exp42 extends HttpServlet 
{ 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
 throws ServletException, IOException 
 { 
 response.setContentType("text/html"); 
 PrintWriter out = response.getWriter(); 
 int flag=0; 
 String username=request.getParameter("username"); 
 String password=request.getParameter("password"); 
 Cookie ck[]=request.getCookies(); 
 for(int i=0;i<ck.length;i++){ 
 String a1=ck[i].getName(); 
 String a2=ck[i].getValue(); 
 if((username.equals(a1)) && (password.equals(a2))) 
 { 
 flag=1; 
 } 
 } 
 
 if (flag==1) 
 { 
 out.println("Your are the authenticated user <br>"); 
 out.println("Hello " + username +" "+password); 
 } 
 else 
 out.println("Unauthorized User"); 
 
 } 
} 