package com.Inventory.Register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Inventory.utility.PasswordHash;
import com.Inventory.utility.SendEmail;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("name");
		String email = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String state = request.getParameter("state");
		String password = request.getParameter("pass");
		System.out.println("done");
		UserRegisterModel user = new UserRegisterModel();
		user.setName(fullname);
		user.setEmail(email);
		user.setPhone(phone);
		user.setState(state);
		user.setPassword(PasswordHash.hashPassword(password));
		boolean result = UserRegisterDAO.addUserRegister(user);
		if(result) {
			SendEmail.SendMail(email, "Welcome to IMA !", "Hello "+fullname+", \n We promise to fullfill your requirements. ");
			response.sendRedirect("UserLogin.jsp");
		}
		else {
			String status = " There was an error! Kindly Check back Later !";
			RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.forward(request, response);
		}
	}

}
