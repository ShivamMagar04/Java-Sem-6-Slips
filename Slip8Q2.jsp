<%@ page language="java" %>

<%
    int n = Integer.parseInt(request.getParameter("num"));
    
    
    if(n<=1) {
      out.print(n + " is not prime");
    }
    
    boolean prime = true;
      
    for(int i=2; i< n; i++) {
      if(n%i==0) {
        prime = false;
        break;
      } 
    }
    
    if(prime)
      out.print(n + " is prime number");
    else 
      out.print(n + " is not prime number");
%>
