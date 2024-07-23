package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDao;

public class StudentDeleteServlet extends HttpServlet {
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
      StudentDao.deleteStudent(id);
      response.sendRedirect("/crud/students");
    } catch (Exception e) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      response.getWriter().print("Error deleting Students !!");
    }
  }
}
