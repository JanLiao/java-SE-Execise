package com.Jan.service;
import com.Jan.dao.BuyTicket;
public class TicketCenter implements BuyTicket{
	private BuyTicket ticket;
	public TicketCenter(BuyTicket ticket){
		this.ticket=ticket;
	}

	public void showticket(){
		ticket.showticket();
	}

	public void buy(){
		System.out.println("通过代理购得:");
		showticket();
	}
}