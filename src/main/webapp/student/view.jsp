<%@page import="com.example.model.Student" %>
<%
    Student student = (Student) request.getAttribute("student");
%>
<html>
<body>
<div align="center">
  <h2>Student Details!</h2>
  <h3>Id: <%= student.getId() %><h3>
  <h3>Name : <%= student.getName() %><h3>
  <h3>Address: <%= student.getAddress() %><h3>
  <h3>Fee: <%= student.getFee() %><h3>
</div>
</body>
</html>
