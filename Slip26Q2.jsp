<%@ page language="java"%>

<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Sum of First and Last Digit</h2>
    
    <% 
        // Get the number from the request parameter
        String numberStr = request.getParameter("number");
        int number = Integer.parseInt(numberStr);
        
        // Calculate the sum of first and last digits
        int firstDigit = Integer.parseInt(numberStr.substring(0, 1));
        int lastDigit = number % 10;
        int sum = firstDigit + lastDigit;
        
        // Display the sum in red color with font size 18
        %>
        <div style="color: red; font-size: 18px;">
            Sum of first and last digits of <%= number %> is <%= sum %>
        </div>
</body>
</html>
