package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import adminaction.BOMAction;
import adminaction.Line_stateAction;
import adminaction.MemberAction;
import adminaction.MemorderAction;
import adminaction.MemreivewAction;
import adminaction.Pro_stateAction;
import adminaction.Q_bomAction;
import adminaction.Q_bomInsertAction;
import adminaction.Q_chproAction;
import adminaction.Q_chpro_StartAction;
import adminaction.Q_lineAction;
import adminaction.Q_lineInsertAction;
import adminaction.Q_produInsertAction;
import adminaction.Q_productAction;
import adminaction.bomconAction;
import adminaction.storagAction;
import vo.ActionForward;

@WebServlet("*.admin")
public class AdminController extends HttpServlet {

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
		
		if(command.equals("/adminpage/memorder.admin")) {
			action = new MemorderAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/memreview.admin")) {
			action = new MemreivewAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/member.admin")) {
			action = new MemberAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/bomtable.admin")) {
			action = new BOMAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/product_state.admin")) {
			action = new Pro_stateAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/line_state.admin")) {
			action = new Line_stateAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/q_chpro.admin")) {
			action = new Q_chproAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/q_chpro_strt.admin")) {
			action = new Q_chpro_StartAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/q_line.admin")) {
			action = new Q_lineAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/q_line_insert.admin")) {
			action = new Q_lineInsertAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/q_product.admin")) {
			action = new Q_productAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/q_product_insert.admin")) {
			action = new Q_produInsertAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/q_bom.admin")) {
			action = new Q_bomAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/q_bom_insert.admin")) {
			action = new Q_bomInsertAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/bom_com.admin")) {
			action = new bomconAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminpage/storage.admin")) {
			action = new storagAction();
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
