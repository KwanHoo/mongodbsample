package com.nosql.mongodbsample.chat.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ChatVo {

	private String msg;
	private String sender;
	// private String receiver;
	private String roomId;
}
