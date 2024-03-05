package com.masai.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.library.entity.Member;
import com.masai.library.repo.MemberRepository;

public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Member registerMember(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public void updateMember(Long memberId, Member updatedMember) {
		Optional<Member> member1 = memberRepository.findById(memberId);
		Member member = member1.get();
		member.setName(updatedMember.getName());
		member.setEmail(updatedMember.getEmail());
		member.setSuspended(updatedMember.isSuspended());

		memberRepository.save(member);

	}

	@Override
	public void suspendMember(Long memberId) {
		Optional<Member> member1 = memberRepository.findById(memberId);
		Member member = member1.get();

		member.setSuspended(true);
		memberRepository.save(member);

	}

	@Override
	public void unsuspendMember(Long memberId) {

		Optional<Member> member1 = memberRepository.findById(memberId);
		Member member = member1.get();
		member.setSuspended(false);
		memberRepository.save(member);

	}

}
