package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDao;
import com.example.model.Student;

public class StudentListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String pathInfo = request.getPathInfo();
    if (pathInfo == null || pathInfo.equals("/")) {
      listStudents(request, response);
    } else {
      int studentId = Integer.parseInt(pathInfo.substring(0));
      getStudent(studentId, request, response);
    }
  }

  private void listStudents(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<Student> students;
    try {
      students = StudentDao.getAllStudents();
      request.setAttribute("students", students);
      RequestDispatcher surakshi_list_jsp = request.getRequestDispatcher("/student/list.jsp");
      surakshi_list_jsp.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      PrintWriter printWriter = response.getWriter();
      printWriter.print("Internal server Error !!\n" + e.getMessage());
    }
  }

  private void getStudent(int studentId, HttpServletRequest request, HttpServletResponse response) throws IOException {
    Student student;
    try {
      student = StudentDao.getStudent(studentId);
      request.setAttribute("student", student);
      RequestDispatcher student_view_jsp = request.getRequestDispatcher("/student/view.jsp");
      student_view_jsp.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      PrintWriter printWriter = response.getWriter();
      printWriter.print("Internal server Error !!\n" + e.getMessage());
    }
  }
}
