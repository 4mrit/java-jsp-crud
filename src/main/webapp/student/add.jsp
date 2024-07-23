<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
    <h2>Add New Student</h2>
    <form action="add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>

        <label for="fee">Fee:</label>
        <input type="number" id="fee" name="fee" required>

        <input type="submit" value="Add Student">
    </form>
</body>
</html>
