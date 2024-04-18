<%@ page language="java"%>

  <%
     String num = request.getParameter("num");
     
     String[] nums = {"zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    
    for(int i=0; i< num.length(); i++) {
      char ch = num.charAt(i);
      int pos = Character.getNumericValue(ch);
      out.print(nums[pos] + " ");
    }
     
  %>
