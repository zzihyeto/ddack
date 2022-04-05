package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AddAction;
import action.Del_cart_Action;
import action.Delete_Action;
import action.Detail_FormAction;
import action.Modify_Action;
import action.ProductAction;
import action.ReviewAction;
import action.SearchListAction;
import action.WriteAction;

import action.Write_Form_Action;
import vo.ActionForward;

@WebServlet("*.show")
public class ShowController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ActionForward forward = null;
	Action action = null;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doProcess(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println("======command======"+command);
		
		if(command.equals("/product.show")) {
			action = new ProductAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/add.show")) {
			action = new AddAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/del_cart.show")) {
			action = new Del_cart_Action();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/review.show")){ //리뷰
			action = new ReviewAction();
			try	{
				forward = action.execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.contentEquals("/search.show")) { //리뷰검색
			action = new SearchListAction();
			try {
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/re_write_form.show")) { // 리뷰 쓰기폼에서 로그인확인
			action = new Write_Form_Action();
			try {
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/re_write.show")) { // 리뷰쓰고 등록하기
			action = new WriteAction();
			try {
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/re_detail_form.show")) { //리뷰 상세 내용 보기
			action = new Detail_FormAction();
			try {
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/re_modify.show")) { //리뷰 내용 수정
			action = new Modify_Action();
			try {
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if (command.contentEquals("/delete.show")) { //리뷰 내용 삭제
			action = new Delete_Action();
			try {
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getPath()); //셋팅하면 servlet으로 
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, res); //셋팅 안하면 jsp으로
			}
		}
		
	}
}

