package com.masai.library.service;

import com.masai.library.entity.Member;

public interface MemberService {
	
	 public Member registerMember(Member member);
	 public void updateMember(Long memberId, Member updatedMember);
	 public void suspendMember(Long memberId);
	 public void unsuspendMember(Long memberId) ;
	 
	 

}
