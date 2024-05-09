package com.nosql.mongodbsample.chat.service;

import com.nosql.mongodbsample.chat.domain.Chat;
import com.nosql.mongodbsample.chat.vo.ChatVo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChatService {

	Mono<Chat> sendChat(ChatVo chatVo);

	Flux<Chat> getChat(String sender, String receiver);

	Flux<Chat> getChatByRoomId(String roomId);
}
