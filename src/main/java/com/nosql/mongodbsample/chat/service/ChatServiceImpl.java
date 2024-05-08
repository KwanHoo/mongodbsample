package com.nosql.mongodbsample.chat.service;

import org.springframework.stereotype.Service;

import com.nosql.mongodbsample.chat.domain.Chat;
import com.nosql.mongodbsample.chat.repository.ChatRepository;
import com.nosql.mongodbsample.chat.vo.ChatVo;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService{

	private final ChatRepository chatRepository;
	@Override
	public Mono<Chat> sendChat(ChatVo chatVo) {

		return chatRepository.save(Chat.builder()
			.msg(chatVo.getMsg())
			.sender(chatVo.getSender())
			.receiver(chatVo.getReceiver())
				// .createdAt(chatVo)
			.build());
	}

	@Override
	public Flux<Chat> getChat(String sender, String receiver) {
		return chatRepository.findChatBySenderAndReceiver(sender, receiver);
	}
}
