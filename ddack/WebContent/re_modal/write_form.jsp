<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--리뷰 쓰기 모달 -->
	<button type="button" class="btn btn-outline-success" data-bs-toggle="modal"
			data-bs-target="#exampleModal" data-bs-whatever="write">write</button>
		
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content container" align="left">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">DDACK 리뷰 쓰기</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
		
	      <div class="modal-body">
	        <form>
			<!-- 회원ID/ 비활성화 -->
	       <div class="row mb-3">
	         <label for="m_id" class="col-sm-2 control-label">회원ID</label>
	       	<div class="col-sm-10">
		        <input type="text" class="form-control" id="m_id" readonly>
		    </div>
	       </div>
	          
			<!-- 구매제품명 -->
	          <div class="row mb-3">
	            <label for="p_name" class="col-sm-2 control-label">구매제품</label>
	          <div class="col-sm-10">
	            <input type="text" class="form-control" id="p_name">
	          </div>	          
	          </div>
	          
	         <!-- 리뷰작성칸 --> 
	          <div class="mb-3">
	            <label for="message-text" class="col-form-label">리뷰작성하기</label>
	            <textarea class="form-control" id="p_review"></textarea>
	          </div>
	        </form>
	      </div>
	      
	    <div class="modal-footer">
			<form action="re_write.show" method="post">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		        <input type="button" class="btn btn-primary" value="등록">
	    	</form>
	    </div>
	    
	    </div>
	  </div>
	</div>