package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAO.ProductDAO;
import entity.Product;

public class ProductService {

	public List<Product> getProduct() {

		List<Product> pro_list = new ArrayList<>();
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		pro_list = productDAO.getProduct();
		
		return pro_list;
	}

	public ArrayList<Product> addCart(ArrayList<Product> cart_list,String p_code, 
			String p_name,String p_pay, String p_kg, String p_life, int p_count) {

	 	Product product =null;
	 	
	 	if (cart_list == null ){
	 		cart_list = new ArrayList<Product>();
	 		
	 		product =new Product();
	 		product.setP_code(p_code);
		 	product.setP_name(p_name);
		 	product.setP_kg(p_kg);
		 	product.setP_pay(p_pay);
		 	product.setP_life(p_life);
		 	product.setP_count_pay(Integer.parseInt(p_pay) *p_count);
		 	product.setP_count(p_count);
		 	
		 	cart_list.add(product);
	 	}else {
	 		//우선 product에 정보 넣고
	 		product =new Product();
			product.setP_code(p_code);
			product.setP_name(p_name);
			product.setP_kg(p_kg);
			product.setP_pay(p_pay);
			product.setP_life(p_life);
			product.setP_count_pay(Integer.parseInt(p_pay) *p_count);
			product.setP_count(p_count);
			
			//같은게 있는지 검열
	 		String t_f_list[] = new String [cart_list.size()];
	 		int index=0;
	 		for (int i=0; i< cart_list.size(); i++) {
	 			//product랑 cart_list안에 product 끼리 비교
	 			//product에 equlas 오버라이드 적어놓은 상태
	 			t_f_list[i]=String.valueOf(product.equals(cart_list.get(i)));
	 			
	 			//true있다면 그인덱스 번호 index로 지정
	 			if (t_f_list[i].equals("true")) {
	 				index = i; 
	 			}
	 		}
	 		
	 		//배열중에 true를 가지고 있다면 index 지정한걸루 수정만 하기 	
 			if (Arrays.asList(t_f_list).contains("true")) {
 				cart_list.get(index).setP_count(cart_list.get(index).getP_count()+p_count);
 				cart_list.get(index).setP_count_pay((cart_list.get(index).getP_count_pay())+(Integer.parseInt(p_pay) *p_count));
 			}else {
 				// 배열중에 true 없으면 cart_list에 담기
 				cart_list.add(product);
 				
 			}
	 	}
	 	
	 	return cart_list;
	}

	

}
