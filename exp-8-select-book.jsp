<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%
  try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from books");
out.println("<html><body><table border=1>");
out.println("<tr><td>Bname</td><td>Price</td><td>Author</td><td>Publisher</td></tr>");
while(rs.next())
{
out.println("<tr><td>");
out.println(rs.getString("bnm")+"</td><td>");
out.println(rs.getInt("prc")+"</td><td>");
out.println(rs.getString("ath")+"</td><td>");
out.println(rs.getString("pub")+"</td></tr>");
out.println("</body>");
}
}
catch(Exception e)
{
out.println(e); 
}
%>
