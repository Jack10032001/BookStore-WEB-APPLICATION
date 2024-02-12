package com.spring3.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class MyBookService {
 
	@Autowired
	private MyBookRepository mybookrepo;
	public void savemybook(MyBookList book) {
		mybookrepo.save(book);
	}
	
	public List<MyBookList> getallbook(){
		return mybookrepo.findAll();
	}
	public void deletebyid(int id) {
		mybookrepo.deleteById(id);
	}
}
