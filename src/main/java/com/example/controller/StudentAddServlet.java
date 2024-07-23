package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDao;
import com.example.model.Student;

public class StudentAddServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher student_add_jsp = request.getRequestDispatcher("/students/add.jsp");
    student_add_jsp.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String name = request.getParameter("name");
    String address = request.getParameter("address");
    String feeStr = request.getParameter("fee");

    if (name.isEmpty() || address.isEmpty() || feeStr.isEmpty()) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      PrintWriter printWriter = response.getWriter();
      printWriter.print("All fields are required: name, position, and salary.");
      return;
    }

    try {
      double fee = Double.parseDouble(feeStr);
      Student student = new Student(name, address, fee);
      StudentDao.addStudent(student);
      response.sendRedirect(request.getContextPath() + "/students");
    } catch (Exception e) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      response.getWriter().print("Error adding Students !!");
    }
  }
}
