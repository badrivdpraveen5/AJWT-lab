import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class Insert5 extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String rno,sn,brn,pg,adr;
rno=(String)request.getParameter("rn");
sn=(String)request.getParameter("un");
brn=(String)request.getParameter("br");
pg=(String)request.getParameter("pr");
adr=(String)request.getParameter("ad");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","system","manager");
Statement st=con.createStatement();
// PreparedStatementpst=(PreparedStatement) con.prepareStatement();
String sql = "insert into students values('"+rno+"','"+sn+"','"+brn+"','"+pg+"','"+adr+"')" ;
int x = st.executeUpdate(sql);
if(x>0)
{
out.println("1 row inserted successfully");
}
else
{
out.println("not inserted");
}
st.close();
con.close();
}
catch (Exception e2)
{out.println(e2);}
finally{out.close();}
} }