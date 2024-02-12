package com.spring3.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service

public class BookService {
    
	@Autowired
	private BookRepository bookrepo;
	public void save(Book b) {
		bookrepo.save(b);
	}
	
	public List<Book> getallbook(){
		
		return bookrepo.findAll();
	
		
	}
	
	public Book getbookbid(int id) {
		return bookrepo.findById(id).get();
	}
	
	public void deletebook(int id) {
		bookrepo.deleteById(id);
	}
}
