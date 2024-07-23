<%@page import="com.example.model.Student" %>
<%
    // Retrieve the Student object from the request
    Student student = (Student) request.getAttribute("student");
%>
<html>
<body>
<h2>Hello Student View!</h2>
</body>
</html>
