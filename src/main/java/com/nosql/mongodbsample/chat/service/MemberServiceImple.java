package com.nosql.mongodbsample.chat.service;

import org.springframework.stereotype.Service;

import com.nosql.mongodbsample.chat.domain.Member;
import com.nosql.mongodbsample.chat.repository.MemberRepository;
import com.nosql.mongodbsample.chat.vo.MemberRes;
import com.nosql.mongodbsample.chat.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImple implements MemberService {

	private final MemberRepository memberRepository;

	@Override
	public void registerMember(MemberVo memberVo) {
		memberRepository.save(
			Member.builder()
				.email(memberVo.getEmail())
				.name(memberVo.getName())
				.phone(memberVo.getPhone())
				.build()
		);
	}

	@Override
	public MemberRes getMember(String email) {

		Member member = memberRepository.findByEmail(email).orElseThrow(
			() -> new IllegalArgumentException("해당 이메일이 존재하지 않습니다.")
		);
		return MemberRes.builder()
			.name(member.getName())
			.email(member.getEmail())
			.phone(member.getPhone())
			.build();

	}
}