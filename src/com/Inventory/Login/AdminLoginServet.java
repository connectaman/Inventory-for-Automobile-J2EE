package com.Inventory.Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginServet
 */
@WebServlet("/AdminLoginServet")
public class AdminLoginServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminLoginServet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String user = request.getParameter("username");
	String password = request.getParameter("password");
	if(user.equals("admin")&& password.equals("admin")) {
		
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
		request.setAttribute("status","Username or Password is Incorrect!");
		dispatcher.forward(request, response);
	}
	
	}

}
