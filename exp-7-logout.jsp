<%
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("exp-7-auth.html");
%>
