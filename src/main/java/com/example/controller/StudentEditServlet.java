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

public class StudentEditServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String idString = request.getParameter("id");

    if (idString.isEmpty()) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      PrintWriter printWriter = response.getWriter();
      printWriter.print("Id is Required !!");
      return;
    }

    try {
      int id = Integer.parseInt(idString);
      Student student = StudentDao.getStudent(id);
      request.setAttribute("student", student);
      RequestDispatcher student_edit_jsp = request.getRequestDispatcher("/student/edit.jsp");
      student_edit_jsp.forward(request, response);
    } catch (Exception e) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      response.getWriter().print("Error Updating Students !!");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String idString = request.getParameter("id");
    String name = request.getParameter("name");
    String address = request.getParameter("address");
    String feeStr = request.getParameter("fee");

    if (idString.isEmpty() || name.isEmpty() || address.isEmpty() || feeStr.isEmpty()) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      PrintWriter printWriter = response.getWriter();
      printWriter.print("All fields are required: id ,name,address, and fees.");
      return;
    }

    try {
      int id = Integer.parseInt(idString);
      double fee = Double.parseDouble(feeStr);
      Student student = new Student(name, address, fee);
      student.setId(id);

      StudentDao.updateStudent(student);
      response.sendRedirect("/crud/students");
    } catch (Exception e) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      response.getWriter().print("Error adding Students !!");
    }
  }
}
