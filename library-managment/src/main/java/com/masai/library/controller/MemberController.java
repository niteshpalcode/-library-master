package com.masai.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.library.entity.Member;
import com.masai.library.service.MemberService;

public class MemberController {

	
	 @Autowired
	    private MemberService memberService;

	    @PostMapping("/register")
	    public ResponseEntity<Member> registerMember(@RequestBody Member member) {
	        Member registeredMember = memberService.registerMember(member);
	        return ResponseEntity.ok(registeredMember);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<?> updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
	        memberService.updateMember(id, updatedMember);
	        return ResponseEntity.ok("Member updated successfully.");
	    }

	    @PutMapping("/suspend/{id}")
	    public ResponseEntity<String> suspendMember(@PathVariable Long id) {
	        memberService.suspendMember(id);
	        return ResponseEntity.ok("Member suspended successfully.");
	    }

	    @PutMapping("/unsuspend/{id}")
	    public ResponseEntity<String> unsuspendMember(@PathVariable Long id) {
	        memberService.unsuspendMember(id);
	        return ResponseEntity.ok("Member unsuspended successfully.");
	    }
}
