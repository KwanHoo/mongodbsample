package com.nosql.mongodbsample.chat.service;

import com.nosql.mongodbsample.chat.vo.MemberRes;
import com.nosql.mongodbsample.chat.vo.MemberVo;



public interface MemberService {

	void registerMember(MemberVo memberVo);
	MemberRes getMember(String email);

}