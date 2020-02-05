package com.jakartaee.messenger.service;

import java.util.HashMap;
import java.util.Map;

import com.jakartaee.messenger.model.Message;

public class Database {
	
	private static Map<Long, Message> messages = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static void setMessages(Map<Long, Message> messages) {
		Database.messages = messages;
	}
	
	static {
		messages.put(1L, new Message(1, "Corona is serious disaster", "Kevin Nguyen"));
		messages.put(2L, new Message(2, "Donal Trump is the president of the United States", "Cooper Tran"));
		messages.put(3L, new Message(3, "Koh Yang Uei is the Chief of Synergix Technologies", "Watson Dinh"));
	}

}
