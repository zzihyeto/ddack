<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--리뷰 작성페이지 모달 -->
<button type="button" class="btn btn-outline-success" data-bs-toggle="modal"
			data-bs-target="#exampleModal" data-bs-whatever="write">write</button>
		
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content container" align="left">
	      
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">DDACK 리뷰 쓰기</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <div class="input-group m-4">
			<div class="input-group-prepend">			
				<span class="input-group-text" id="basic-addon1"><i class="bi bi-person-circle"></i>ID</span>
			</div>
			<input type="text" class="form-control" placeholder="Username"
				aria-label="Username" aria-describedby="basic-addon1">
		  </div>
		
	      <div class="modal-body">
	        <form>
	          <div class="mb-3">
	            <label for="recipient-name" class="col-form-label">회원ID</label>
	            <input type="text" class="form-control" id="recipient-name">
	          </div>

	          <div class="mb-3">
	            <label for="recipient-name" class="col-form-label">구매제품</label>
	            <input type="text" class="form-control" id="recipient-name">
	          </div>	          
	          
	          <div class="mb-3">
	            <label for="message-text" class="col-form-label">리뷰작성하기</label>
	            <textarea class="form-control" id="message-text"></textarea>
	          </div>
	        </form>
	      </div>
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button type="button" class="btn btn-primary">등록</button>
	      </div>
	      
	    </div>
	  </div>
	</div>
	
	
	</section>
	</div>	
</main>		
<%-- 
	<!-- layout폴더 > footer.jsp -->
	<jsp:include page="/layout/footer.jsp" />

</body>
</html> --%>
