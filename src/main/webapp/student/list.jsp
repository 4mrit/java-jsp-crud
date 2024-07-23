<%@page import="com.example.model.Student" %>
<%@page import="java.util.List" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<html>
<body>

<div align="center">
    <h2>
      Student List!
      <a href="students/add" >Add Student</a>
    </h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Fee</th>
            <th>Options</th>
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
                <td>
                  <%-- href="students/delete?id=2" --%>
                  <a href="students/update?id=<%= student.getId() %> ">Edit</a>
                  <a href="students/delete?id=<%= student.getId() %> ">Delete</a>
                </td>
            </tr>
        <% }
        } else 
        { %>
          <tr>
              <td colspan="4"> No Student found.</td>
          </tr>
        <% } %>
    </table>
</div>
</body>
</html>
