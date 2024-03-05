package com.masai.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.library.entity.Book;
import com.masai.library.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	
	 @Autowired
	    private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		 return bookRepository.save(book);
	}

	@Override
	public void removeBook(Long bookId) {
		 bookRepository.deleteById(bookId);
		
	}

	@Override
	public Book updateBook(Long bookId, Book updatedBook) {
		   Optional<Book> book1 = bookRepository.findById(bookId);
		   Book book=book1.get();
	        
	        book.setTitle(updatedBook.getTitle());
	        book.setAuthor(updatedBook.getAuthor());
	        book.setGenre(updatedBook.getGenre());
	        book.setIsbn(updatedBook.getIsbn());
	        book.setQuantity(updatedBook.getQuantity());
	        
	        return bookRepository.save(book);
	}

	@Override
	public List<Book> searchBooks(String keyword) {
		  return bookRepository.findByTitleContainingOrAuthorContainingOrGenreContainingOrIsbnContaining(keyword, keyword, keyword, keyword);
	}
}
