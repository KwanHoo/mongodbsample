package com.nosql.mongodbsample.chat.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nosql.mongodbsample.chat.domain.Chat;
import com.nosql.mongodbsample.chat.service.ChatService;
import com.nosql.mongodbsample.chat.vo.ChatVo;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class ChatController {
	private final ChatService chatService;

	@GetMapping(value="/sender/{sender}/receiver/{receiver}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Chat> getChat(
		@PathVariable(value ="sender") String sender,
		@PathVariable(value ="receiver") String receiver
	){
		return chatService.getChat(sender, receiver)
			.subscribeOn(Schedulers.boundedElastic());
	}

	@GetMapping(value = "/room/{roomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Chat> getChatByRoomId(
		@PathVariable(value ="roomId") String roomId
	){
		return chatService.getChatByRoomId(roomId).subscribeOn(Schedulers.boundedElastic());
	}

	@PostMapping
	public Mono<Chat> sendChat(@RequestBody ChatVo chatVo){
		return chatService.sendChat(chatVo);
	}

}
