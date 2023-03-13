<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<html>
<body bgcolor=lightblue>
<div align="center">
<table cellspacing=10 >
<form method="GET" action="./exp-8-insert-book.jsp">
<tr>
<td>BookName</td>
<td><input type="text" name="bn"><br></td>
</tr>
<tr>
<td>Price</td>
<td><input type="text" name="pr"><br></td>
</tr>
<tr>
<td>Author</td><td>
<input type="text" name="ar"></td>
		</tr>
<tr>
<td>Publisher</td>
<td><input type="text" name="pb"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="SUBMIT" >
			<input type="reset" value="RESET"></td>
</tr>
</form>
</table>
</div>
<%
String bnm,prc,ath,pub;
	bnm=(String)request.getParameter("bn");
	prc=(String)request.getParameter("pr");
	ath=(String)request.getParameter("ar");
	pub=(String)request.getParameter("pb");
	try{
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
Statement st=con.createStatement();
// PreparedStatementpst =(PreparedStatement) con.prepareStatement();
String sql="insert into books values('"+bnm+"','"+prc+"','"+ath+"','"+pub+"')" ;
int x=st.executeUpdate(sql);
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
	{e2.printStackTrace();}            
finally{out.close();}   
%>
