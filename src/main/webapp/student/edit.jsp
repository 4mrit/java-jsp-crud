<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.model.Student" %>
<%@page import="java.util.List" %>
<%
    Student student = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<body>
    <h2>Edit Student</h2>
    <form action="update" method="POST">
        <input type="text" name="id" value="<%=student.getId()%>" hidden required>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%=student.getName()%>" required>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address"  value="<%=student.getAddress()%>"required>

        <label for="fee">Fee:</label>
        <input type="number" id="fee" name="fee" value="<%=student.getFee()%>"required>

        <input type="submit" value="Save">
    </form>
</body>
</html>
