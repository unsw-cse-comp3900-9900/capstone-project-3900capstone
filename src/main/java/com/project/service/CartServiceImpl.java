package com.project.service;

import com.project.mapper.CartMapper;
import com.project.pojo.Books;
import com.project.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartMapper mapper;
	
	@Override
	public List<Books> queryCartByuserId(int id) {
		return mapper.queryCartByuserId(id);
	}

	@Override
	public Integer deleteCart(int id) {
		return mapper.deleteCart(id);
	}
	
}
