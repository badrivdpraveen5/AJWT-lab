import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
public class Update5 extends HttpServlet {    
public void doGet(HttpServletRequest request, HttpServletResponse response)  
throws ServletException, IOException {    
response.setContentType("text/html");  
PrintWriter pw = response.getWriter();            
String rollno=request.getParameter("roll");  
     Statement stmt = null;    
try{
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","system","manager");                
stmt = con.createStatement();
            String sql = "update table students set adr=? where rno=?";
            //count will give you how many records got updated
           //String sql = "update people set firstname=? ,lastname=? where id=?";
PreparedStatement preparedStatement = null;
preparedStatement  = con.prepareStatement(sql);
preparedStatement.setString(5, "nrt");
preparedStatement.addBatch();
int[] affectedRecords = preparedStatement.executeBatch();

}
catch (Exception e2) {e2.printStackTrace();}            
finally{pw.close();}   
}  }
