<%@ page import ="java.sql.*" %>
<%
try{
    String user=request.getParameter("txt");
String pass=request.getParameter("pwd");
	Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","manager");    
    Statement st = con.createStatement();
    ResultSet rs;

    rs = st.executeQuery("select * from login where un='" + user + "' and pw='" + pass + "'");
   if (rs.next()){

        session.setAttribute("userid", user);
      
        response.sendRedirect("exp-7-success.jsp");
    }
 else {
        out.println("Invalid User<br><a href='exp-7-auth.html'>try again</a>");
    }
}
catch(Exception e){
    System.out.println(e);
}
%>
