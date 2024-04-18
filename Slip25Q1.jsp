<%@ page language="java"%>

  <%
    
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    
    if(age > 18)
      out.print("Registered Succesfully!");
    else 
      out.print("Register Failed Becuase invalid age!");
  %>
  
