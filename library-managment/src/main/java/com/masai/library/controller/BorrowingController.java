package com.masai.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.library.entity.Borrowing;
import com.masai.library.service.BorrowingService;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {
	 @Autowired
	    private BorrowingService borrowingService;

	    @GetMapping("/member/{memberId}")
	    public ResponseEntity<List<Borrowing>> getBorrowingsForMember(@PathVariable Long memberId) {
	        List<Borrowing> borrowings = borrowingService.getBorrowingsForMember(memberId);
	        return ResponseEntity.ok(borrowings);
	    }

	    @PostMapping("/borrow")
	    public ResponseEntity<String> borrowBook(@RequestParam Long memberId, @RequestParam Long bookId) {
	        borrowingService.borrowBook(memberId, bookId);
	        return ResponseEntity.ok("Book borrowed successfully.");
	    }

	    @PostMapping("/return")
	    public ResponseEntity<String> returnBook(@RequestParam Long borrowingId) {
	        borrowingService.returnBook(borrowingId);
	        return ResponseEntity.ok("Book returned successfully.");
	    }
}
