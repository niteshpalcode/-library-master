package com.masai.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.library.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
