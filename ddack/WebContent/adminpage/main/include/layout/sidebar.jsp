<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 사이드바 -->
<div class="sb-sidenav-menu">
	<div class="nav">
	
		<div class="sb-sidenav-menu-heading">HOME</div>
		<a class="nav-link" href="index.jsp">
			<div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i> </div>
			관리자 페이지
		</a>
			
		<div class="sb-sidenav-menu-heading">고객,주문</div>
		<!-- 고객/주문  -->
		<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
			<div class="sb-nav-link-icon">
				<i class="fas fa-columns"></i>
			</div>
			고객/주문
			<div class="sb-sidenav-collapse-arrow">
				<i class="fas fa-angle-down"></i>
			</div>
		</a>
		
		<div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
			<nav class="sb-sidenav-menu-nested nav">
				<a class="nav-link" href="memreview.admin">고객리뷰</a>
				<a class="nav-link" href="memorder.admin">주문상세</a> 
				<!--사이드바밝게 <a class="nav-link" href="layout-sidenav-light.jsp"></a> -->
				<a class="nav-link" href="member.admin">회원정보</a>
			</nav>
		</div>
		
		<div class="sb-sidenav-menu-heading">생산</div>
		
		<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
			<div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
			공정/공장
			<div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i>
			</div>
		</a>
		
		<div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
			<nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
			
				<!-- 재고정보 -->
				<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" 
				aria-expanded="false" aria-controls="pagesCollapseAuth">기본관리
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				
				<div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
					<nav class="sb-sidenav-menu-nested nav">
						<a class="nav-link" href="bomtable.admin">BOM 관리</a> 
						<a class="nav-link"	href="product_state.admin">완제품 관리</a> 
						<a class="nav-link" href="line_state.admin">라인 관리</a>
						<a class="nav-link" href="q_chpro.admin">불량 관리</a>
					</nav>
				</div>
				
				<!-- 거래처 정보 -->
				<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapse" 
				aria-expanded="false" aria-controls="pagesCollapse">생산관리
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				
				<div class="collapse" id="pagesCollapse" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
					<nav class="sb-sidenav-menu-nested nav">
						<a class="nav-link" href="process_manage.admin">공정관리</a>
						<a class="nav-link"	href="production_order.admin">생산 지시현황</a>
					</nav>
				</div>
				
				<!-- 위생 및 공정 -->
				<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" 
				aria-expanded="false" aria-controls="pagesCollapseError">자재/창고관리
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				
				<div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
					<nav class="sb-sidenav-menu-nested nav">
						<a class="nav-link" href="bom_com.admin">자재입출고 현황</a> 
						<a class="nav-link" href="storage.admin">창고 관리</a>
					</nav>
				</div>
				
			</nav>
		</div>
		
		<!-- 수요/공급예측 => 통계/분석 -->
		<div class="sb-sidenav-menu-heading">수요 예측</div>
		<!-- 수요예측 -->
		<a class="nav-link" href="charts.jsp">
			<div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>수요예측
		</a> 
	</div>
</div>

<!-- 사이드바 밑에 footer -->
<div class="sb-sidenav-footer">
	<div class="small">Logged in as:</div> DDACK's Admin Page.
</div>