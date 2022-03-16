package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actionvo.Action;
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
		
		System.out.println(requestURI+"\n"+"==="+contextPath+"\n"+"===>"+command);
	}
	
}
