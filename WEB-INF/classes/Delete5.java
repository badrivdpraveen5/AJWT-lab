import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class Delete5 extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
String rollno=request.getParameter("roll");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement ps=con.prepareStatement("delete from students where rno=?");
ps.setString(1,rollno);
int i = ps.executeUpdate();
if(i!=0)
pw.println("Deleting row...");
else if (i==0) 
{
pw.println("<br>Row has been deleted successfully.");
}
}
catch (Exception e2) {e2.printStackTrace();}
finally{pw.close();}
}
}