<%@ page language="java"%>


  <%
     String name = request.getParameter("name");
     
     int hr = java.time.LocalDateTime.now().getHour();
     
     String greeting;
     if(hr < 12)
       greeting = "Good Morning";
     else if(hr < 18)
       greeting = "Good Afternoon";
     else 
       greeting = "Good Evening";
       
     out.print(greeting + " " +  name);
  %>
