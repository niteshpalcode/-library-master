package com.masai.library.service;

import java.util.List;

import com.masai.library.entity.Book;

public interface BookService {

	
	 public Book addBook(Book book);
	 public void removeBook(Long bookId);
	 public Book updateBook(Long bookId, Book updatedBook);
	  public List<Book> searchBooks(String keyword);
}
