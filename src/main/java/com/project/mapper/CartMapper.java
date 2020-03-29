package com.project.mapper;

import com.project.pojo.Books;
import com.project.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper{
	
	List<Books> queryCartByuserId(int id);
	
	Integer deleteCart(int id);
}
