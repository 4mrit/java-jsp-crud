package com.example.dao;

import com.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

  private static final String URL = "jdbc:postgresql://localhost:5555/mydatabase";
  private static final String USER = "postgres";
  private static final String PASSWORD = "Strong@Passw0rd";

  private static Connection getDbConnection() throws SQLException, ClassNotFoundException {
    Class.forName("org.postgresql.Driver");
    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
    System.out.println("Connection Sucessfull!");
    return connection;
  }

  public static void addStudent(Student student) {
    try {
      Connection connection = getDbConnection();
      PreparedStatement statement = connection.prepareStatement("INSERT INTO students"
          + "( Name ,Address, Fee )"
          + "VALUES"
          + "( ?, ?, ?);");

      statement.setString(1, student.getName());
      statement.setString(2, student.getAddress());
      statement.setDouble(3, student.getFee());

      int rowsAffected = statement.executeUpdate();
      System.out.println("Inserted " + rowsAffected + " rows successfully !!");
      connection.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static List<Student> getAllStudents() {
    List<Student> studentList = new ArrayList<>();
    try {
      Connection connection = getDbConnection();

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

      while (resultSet.next()) {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setAddress(resultSet.getString("address"));
        student.setFee(resultSet.getDouble("fee"));
        studentList.add(student);
      }
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return studentList;
  }

  public static Student getStudent(int studentId) {
    Student student = new Student();
    try {
      Connection connection = getDbConnection();
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE Id = ?;");

      statement.setInt(1, studentId);

      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setAddress(resultSet.getString("address"));
        student.setFee(resultSet.getDouble("fee"));
        connection.close();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return student;
  }

  public static void updateStudent(Student student) {
    try {
      Connection connection = getDbConnection();
      PreparedStatement statement = connection.prepareStatement("UPDATE student"
          + " SET name=?, address=?, fee=?"
          + " WHERE id=? ;");

      statement.setString(1, student.getName());
      statement.setString(2, student.getAddress());
      statement.setDouble(3, student.getFee());
      statement.setInt(4, student.getId());

      int rowsAffected = statement.executeUpdate();
      System.out.println("Updated" + rowsAffected + " rows successfully !!");
      connection.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void deleteStudent(int studentId) {
    try {
      Connection connection = getDbConnection();
      PreparedStatement statement = connection.prepareStatement("DELETE FROM students"
          + " WHERE id=? ;");

      statement.setInt(1, studentId);

      int rowsAffected = statement.executeUpdate();
      System.out.println("Deleted" + rowsAffected + " rows successfully !!");
      connection.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
