<%@ page language="java"%>

  <%
  	String str = request.getParameter("str");

  	StringBuilder sb = new StringBuilder(str).reverse();
  	
  	out.print("Original String : " + str);
  	out.print("\nReversed String : " + sb);
  %>
