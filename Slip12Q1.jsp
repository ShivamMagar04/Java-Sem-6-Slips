<%@ page language="java"%>
  <% 
        int n = Integer.parseInt(request.getParameter("num"));
        boolean isPerfect = false;
        int sum = 0;
        
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        
        if (sum == n) {
            isPerfect = true;
        }
        
        if (isPerfect) {
            out.print(n + " is a perfect number");
        } else {
            out.print(n + " is not a perfect number");
        }
    %>
