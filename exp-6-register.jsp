<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<html>
         <body bgcolor=lightblue>
                 <div align="center">
                     <table cellspacing=10 >
                         <form method="GET" action="./exp-6-register.jsp">
                             <tr>
                                 <td>RollNo</td>
                                <td><input type="text" name="rn"><br></td>
                            </tr>
                            <tr>
                                   <td>User name</td>
                                   <td><input type="text" name="un"><br></td>
                          </tr>
                          <tr>
                                 <td>Branch</td><td>
                                <input type="password" name="br"></td>
		 </tr>
                         <tr>
                                <td>Percentage</td>
                               <td><input type="text" name="pr"></td>
                        </tr>
                         
                    <tr>
                           <td>Address</td>
                          <td><input type="text" name="ad"></td>
                   </tr>
                   <tr>
<td>Submit the data:</td>
<td><input type="submit" value="SUBMIT" >
			<input type="reset" value="RESET"></td>
      </tr>
            </form>
       </table>
  </div>
  <%
  String rno,sn,brn,pg,adr;
      rno=(String)request.getParameter("rn");
      sn=(String)request.getParameter("un");
      brn=(String)request.getParameter("br");
      pg=(String)request.getParameter("pr");
      adr=(String)request.getParameter("ad");
  try
  {
  Class.forName("oracle.jdbc.driver.OracleDriver");  
  Connection con=DriverManager.getConnection(  
  "jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
  Statement st=con.createStatement();
  // PreparedStatementpst =(PreparedStatement) con.prepareStatement();
  String sql="insert into students values('"+rno+"','"+sn+"','"+brn+"','"+pg+"','"+adr+"')" ;
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
  