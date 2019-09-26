package com.Inventory.Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Inventory.Register.UserRegisterModel;
import com.Inventory.utility.PasswordHash;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		boolean result = LoginDAO.isUserValid(email,PasswordHash.hashPassword(password));
		if(result) {
			UserLoginModel user = new UserLoginModel();
			user = LoginDAO.getUserData(email);
			HttpSession session =  request.getSession();
			session.setAttribute("isLogin","true");
			session.setAttribute("userName", user.getName());
			session.setAttribute("userEmail",user.getEmail());
			session.setAttribute("userId",user.getId());
			session.setAttribute("userPhone",user.getPhone());
			session.setAttribute("userState",user.getState());
			response.sendRedirect("UserDashboard.jsp");
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserLogin.jsp");
			request.setAttribute("status","Username or Password is Incorrect!");
			dispatcher.forward(request, response);
		}
	}

}
