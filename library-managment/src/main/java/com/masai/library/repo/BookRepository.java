package com.masai.library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {


	List<Book> findByTitleContainingOrAuthorContainingOrGenreContainingOrIsbnContaining(String title, String author, String genre, String isbn);
}
