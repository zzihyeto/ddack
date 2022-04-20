package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import adminaction.BomdeleteAction;
import adminaction.BomdetailAction;
import adminaction.BomdupdateAction;
import adminaction.BominsertAction;
import adminaction.LinedetailAction;
import adminaction.LineinsertAction;
import adminaction.LineupdateAction;
import adminaction.Pro_cntlAction;
import adminaction.ProducdeleteAction;
import adminaction.ProducdetailAction;
import adminaction.ProducinsertAction;
import adminaction.ProducupdateAction;
import adminaction.StartinsertAction;
import adminaction.coninsertAction;
import adminaction.gocon_addjspAction;
import adminaction.stroedetailAction;
import adminaction.stroeupdateAction;
import vo.ActionForward;

@WebServlet("*.add")
public class AddController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6527192112123144753L;
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
		
		//System.out.println("====command====>"+command);
		
		if(command.equals("/adminpage/bominsert.add")) {
			action = new BominsertAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/bomdetail.add")) {
			action = new BomdetailAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/bomupdate.add")) {
			action = new BomdupdateAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/bomdelete.add")) {
			action = new BomdeleteAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/productinsert.add")) {
			action = new ProducinsertAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/productdetail.add")) {
			action = new ProducdetailAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/productupdate.add")) {
			action = new ProducupdateAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/productdelete.add")) {
			action = new ProducdeleteAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/lineinsert.add")) {
			action = new LineinsertAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/linedetail.add")) {
			action = new LinedetailAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/lineupdate.add")) {
			action = new LineupdateAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/con_ad_go.add")) {
			action = new gocon_addjspAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/con_insert.add")) {
			action = new coninsertAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/storedetail.add")) {
			action = new stroedetailAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/storeupdate.add")) {
			action = new stroeupdateAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/process_controll.add")) {
			action = new Pro_cntlAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/startinsert.add")) {
			action = new StartinsertAction();
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
