package com.Inventory.utility;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContactMail")
public class ContactMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("mail");
		String Contact = request.getParameter("phone");
		String message = request.getParameter("msg");
		boolean res = SendEmail.SendMail("winwithaman@gmail.com","New Contact Mail","Name: "+fname+" "+lname + " | Email"+email+" | Contact: "+Contact+" | Message: "+message);
		response.sendRedirect("Contact.jsp");
	}

}
