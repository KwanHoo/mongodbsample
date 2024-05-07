package com.nosql.mongodbsample.chat.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Document
public class Member {

	@Id
	private String id;
	private String name;
	@Indexed(unique = true)
	private String email;
	private String phone;
	private Gender gender;
	private Address address;

	@Builder
	public Member(String name, String email, String phone){
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
}