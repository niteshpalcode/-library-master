package com.masai.library.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.library.entity.Book;
import com.masai.library.entity.Borrowing;
import com.masai.library.entity.Member;
import com.masai.library.exception.CustomException;
import com.masai.library.repo.BookRepository;
import com.masai.library.repo.BorrowingRepository;
import com.masai.library.repo.MemberRepository;
@Service
public class BorrowingServiceImpl implements BorrowingService {
	@Autowired
	private BorrowingRepository borrowingRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private MemberRepository memberRepository;

	@Override
	 public List<Borrowing> getBorrowingsForMember(Long memberId) {

	
		Optional<Member> member1 = memberRepository.findById(memberId);
				Member member=member1.get();
		return borrowingRepository.findByMember(member);
	
	}

	@Override
	  public void borrowBook(Long memberId, Long bookId){
		
		Optional<Member> member1 = memberRepository.findById(memberId);
		Member member=member1.get();
	        Optional<Book> book1 = bookRepository.findById(bookId);

	        Book book=book1.get();
		 Borrowing borrowing = new Borrowing();
	        borrowing.setMember(member);
	        borrowing.setBook(book);
	        borrowing.setBorrowDate(LocalDateTime.now());
	        borrowing.setReturnDate(null); 

	        book.setQuantity(book.getQuantity() - 1);

	        borrowingRepository.save(borrowing);
	        bookRepository.save(book);

	}

	@Override
	public void returnBook(Long borrowingId) {
		Optional<Borrowing> borrowing1 = borrowingRepository.findById(borrowingId);
		Borrowing borrowing = borrowing1.get();
		 borrowing.setReturnDate(LocalDateTime.now());
	        borrowingRepository.save(borrowing);

	        Book book = borrowing.getBook();
	        book.setQuantity(book.getQuantity() + 1);
	        bookRepository.save(book);

	}

}
