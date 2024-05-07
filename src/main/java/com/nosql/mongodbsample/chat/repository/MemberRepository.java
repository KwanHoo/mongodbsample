package com.nosql.mongodbsample.chat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nosql.mongodbsample.chat.domain.Member;

public interface MemberRepository extends MongoRepository<Member, String> {
	Optional<Member> findByEmail(String email);

}
