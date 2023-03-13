<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid")== "")) {
%>
You are not logged in<br/>
<a href="exp-7-auth.html">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("userid")%>
<br>
<a href='exp-7-logout.jsp'>Log out</a>
<%
    }
%>
