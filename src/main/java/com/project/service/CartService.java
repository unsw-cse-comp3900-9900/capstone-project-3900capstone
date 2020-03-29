package com.project.service;

import com.project.pojo.Books;
import com.project.pojo.Cart;

import java.util.List;

public interface CartService{
	List<Books> queryCartByuserId(int id);
	
	Integer deleteCart(int id);
}