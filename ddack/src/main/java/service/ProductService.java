package service;

import java.util.ArrayList;
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

	public List<Product> getCartProduct(String p_code) {
		
		List<Product> cart_list = null;
		
		ProductDAO productDAO = ProductDAO.getInstance();
		cart_list = productDAO.getCartProduct(p_code);
		
		return cart_list;
	}

}
