<%@ page language="java"%>

  <% 
     String uname = request.getParameter("uname");
     String pass = request.getParameter("pass");
     
     if(uname.equals(pass))
       out.print("Login Succusful");
     else 
       out.print("Login Falied");
  %>
