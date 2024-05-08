package com.nosql.mongodbsample.chat.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import com.nosql.mongodbsample.chat.domain.Chat;

import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {
	@Tailable
	@Query("{ sender : ?0, receiver : ?1}")
	Flux<Chat> msgFindBySender(String sender, String receiver);

	@Tailable
	Flux<Chat> findChatBySenderAndReceiver(String sender, String receiver);
}
