<%@page import="com.example.model.Student" %>
<%@page import="java.util.List" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<html>
<body>

<div align="center">
    <h2>Student List!</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Fee</th>
        </tr>
        <%
        if (students != null) {
          for (Student student: students) 
          { %>
            <tr>
                <td> <%= student.getId() %> </td>
                <td> <%= student.getName() %> </td>
                <td> <%= student.getAddress() %> </td>
                <td> <%= student.getFee() %> </td>
            </tr>
        <% }
        } else 
        { %>
          <tr>
              <td colspan="4"> No employees found.</td>
          </tr>
        <% } %>
    </table>
</div>
</body>
</html>
