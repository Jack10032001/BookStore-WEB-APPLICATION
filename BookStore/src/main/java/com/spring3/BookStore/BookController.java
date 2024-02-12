package com.spring3.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
@Controller
public class BookController {

	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookService mybookservice;
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return  "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBooks() {
		List<Book> list=service.getallbook();
	//	ModelAndView mav=new ModelAndView();
		//mav.setViewName("bookList");
	//	mav.addObject("book", list);
		
		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBook(Model m1) {
		List<MyBookList> list=mybookservice.getallbook();
		m1.addAttribute("book", list);
		return "myBooks";
	}
	
	@RequestMapping("/mylist/{id}")
	
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getbookbid(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mybookservice.savemybook(mb);
		return "redirect:/my_books";
		
	}
	
	@RequestMapping("/editBook/{id}")
	
	public String editBook(@PathVariable("id") int id , Model m1) {
	Book b=service.getbookbid(id);
	m1.addAttribute("book", b);
		
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	
	
	public String deleteBook(@PathVariable("id") int id , Model m1) {
	service.deletebook(id);
		
		return "redirect:/available_books";
	}

	
	
	
	
	
	
	
}


