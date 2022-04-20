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
import adminaction.Sup_reg_formAction;
import adminaction.SupplierAction;
import adminaction.bomconAction;
import adminaction.change_dateAction;
import adminaction.pro_manageAction;
import adminaction.pro_order_Action;
import adminaction.pur_addformAction;
import adminaction.pur_choiceAction;
import adminaction.pur_detailAction;
import adminaction.pur_formAction;
import adminaction.pur_insert_Action;
import adminaction.pur_manage_Action;
import adminaction.storagAction;
import adminaction.sup_errorAction;
import vo.ActionForward;

@WebServlet("*.admin")
public class AdminController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2043897084964924850L;
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
		
		System.out.println("====command====>"+command);
		
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
		} else if(command.equals("/adminpage/supplier_info.admin")) { //외부거래처 정보 나타내기
			action = new SupplierAction();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		} else if(command.equals("/adminpage/sup_reg_form.admin")) { //신규거래처 등록
			action = new Sup_reg_formAction();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		} else if(command.equals("/adminpage/pur_form.admin")) { // 발주서 작성 등록
			action = new pur_formAction();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		} else if(command.equals("/adminpage/pur_manage.admin")) { // 발주내역 보기
			action = new pur_detailAction();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		} else if(command.equals("/adminpage/order_stock.admin")) { // 발주서2-> 재료코드에 해당하는 발주필요수량 나타내기
			action = new pur_choiceAction();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		} else if(command.equals("/adminpage/pur_modi.admin")) { // 발주관리_날짜 등록하고/불량개수확인하기 위해 폼에 불러온다.
			action = new pur_manage_Action();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		} else if(command.equals("/adminpage/pur_insert.admin")) { // 발주관리_수정폼불러오기
			action = new pur_insert_Action();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		} else if(command.equals("/adminpage/pur_addform.admin")) { // 발주서에 재료코드 pur_choice_form.jsp 가기
			action = new pur_addformAction();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/adminpage/production_order.admin")) { //생산관리-생산지시현황 DB에서 데이터 가져오기
			action = new pro_order_Action();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/adminpage/process_manage.admin")) { //생산관리 - 공정관리 테이블 가져오기 
			action = new pro_manageAction();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/adminpage/starorder_enddate.admin")) { //생산관리- 공정관리- 버튼-  생산지시 날짜추가
			action = new change_dateAction();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/adminpage/supplier_error.admin")) { //생산관리 - 생산지시 날짜추가
			action = new sup_errorAction();
			try	{
				forward = action.execute(req, res);
			} catch(Exception e) {
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
