package com.nosql.mongodbsample.chat.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Getter
@Document(collection = "chat")
public class Chat {
	@Id
	private String id;
	private String msg;
	private String sender;
	private String receiver;
	private LocalDateTime createdAt;

	@Builder
	public Chat(String msg, String sender, String receiver) {
		this.msg = msg;
		this.sender = sender;
		this.receiver = receiver;
		this.createdAt = LocalDateTime.now();
	}
}
