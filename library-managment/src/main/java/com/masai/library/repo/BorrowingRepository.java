package com.masai.library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.library.entity.Borrowing;
import com.masai.library.entity.Member;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long>{
	 List<Borrowing> findByMember(Member member);
}
