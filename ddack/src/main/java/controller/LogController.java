package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.LogOutAction;
import action.LoginAction;
import vo.ActionForward;

@WebServlet("*.check")
public class LogController extends HttpServlet{

	ActionForward forward = null;
	Action action = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
											throws ServletException, IOException {
		doProcess(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
											throws ServletException, IOException {
		doProcess(req, res);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse res) 
										throws ServletException, IOException{

		req.setCharacterEncoding("utf-8");
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("=====command====="+command);
		
		if(command.equals("/login.check")) {
			action = new LoginAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/logout.check")) {
			action = new LogOutAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getPath()); 
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, res);
			}
		}
	}
	
}
