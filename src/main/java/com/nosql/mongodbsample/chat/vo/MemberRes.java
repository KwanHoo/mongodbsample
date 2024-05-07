package com.nosql.mongodbsample.chat.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class MemberRes {

	private String name;
	private String email;
	private String phone;

	@Builder
	public MemberRes(String name, String email, String phone){
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

}