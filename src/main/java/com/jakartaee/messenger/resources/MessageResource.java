package com.jakartaee.messenger.resources;

import java.util.List;
import com.jakartaee.messenger.model.Message;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jakartaee.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages() {
		return this.messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return this.messageService.getMessage(messageId);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		Message msg = this.messageService.getMessage(messageId);
		this.messageService.removeMessage(this.messageService.getMessage(messageId));
		return msg;
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message createMessage(Message message) {
		this.messageService.addMessage(message);
		return message; 
		
	}
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId , Message message) {
		message.setId(messageId);
		this.messageService.updateMessage(message);
		return message; 
		
	}

}
