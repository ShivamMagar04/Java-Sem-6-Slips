<%@ page language="java"%>

<html>
  <head>
    <title>Display Patient Details</title>
  </head>
  
  <body>
    <table border="1">
    <tr>
      <th>Pno</th>
      <th>PName</th>
      <th>Address</th>
      <th>Age</th>
      <th>Disease</th>
    </tr>
    
    <% 
      String[][] patient = {
        {"1", "ABC", "Alandi", "20", "abc"},
        {"2", "PQR", "Moshi", "21", "pqr"},
        {"3", "LMN", "Dighi", "22", "lmn"}
      };
      
      for(int i=0; i< patient.length; i++) {
    %> 
    
    <tr>
    <td><%= patient[i][0]%></td>
    <td><%= patient[i][1]%></td>
    <td><%= patient[i][2]%></td>
    <td><%= patient[i][3]%></td>
    <td><%= patient[i][4]%></td>
    
    <% } %>
    
    </table>
  </body>
</html>
