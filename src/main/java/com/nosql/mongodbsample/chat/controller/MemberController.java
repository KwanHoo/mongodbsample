package com.nosql.mongodbsample.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nosql.mongodbsample.chat.service.MemberService;
import com.nosql.mongodbsample.chat.vo.MemberRes;
import com.nosql.mongodbsample.chat.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public void createMember(@RequestBody MemberVo memberVo){
		log.info("memberVo: {}", memberVo);

		memberService.registerMember(memberVo);

	}

	@GetMapping("/{email}")
	public MemberRes getMember(@PathVariable String email){
		return memberService.getMember(email);
	}
}