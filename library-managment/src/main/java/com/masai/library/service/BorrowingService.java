package com.masai.library.service;

import java.util.List;

import com.masai.library.entity.Book;
import com.masai.library.entity.Borrowing;
import com.masai.library.entity.Member;

public interface BorrowingService {
	 public List<Borrowing> getBorrowingsForMember(Long memberId);
	  public void borrowBook(Long memberId, Long bookId);
	 public void returnBook(Long borrowingId);
	 
}
