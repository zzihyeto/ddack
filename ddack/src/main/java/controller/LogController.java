package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("*.check")
public class LogController extends HttpServlet{

	ActionForward forward = null;
	Action action = null;
}
