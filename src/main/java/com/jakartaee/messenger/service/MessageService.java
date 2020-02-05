package com.jakartaee.messenger.service;

import java.util.Map;
import java.util.List;

import com.jakartaee.messenger.model.Message;

import java.util.ArrayList;

public class MessageService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	public MessageService() {
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<> (this.messages.values());
	}
	
	public Message getMessage(long id) {
		return this.messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() +1);
		return this.messages.put(message.getId() , message);
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(Message message) {
		messages.remove(message.getId());
		System.out.println(this.messages.size());
		return message;
	}
	
}
