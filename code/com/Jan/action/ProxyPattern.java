//package com.Jan.action;
// import com.Jan.service.TicketCenter;
// import com.Jan.dao.Train;
// import com.Jan.dao.BuyTicket;

interface BuyTicket{
	public void showticket();
}

class Train implements BuyTicket{
	public void showticket(){
		System.out.println("一张火车票");
	}
}

class TicketCenter implements BuyTicket{
	private BuyTicket ticket;
	public TicketCenter(BuyTicket ticket){
		this.ticket=ticket;
	}

	public void showticket(){
		ticket.showticket();
		System.out.println("代理购票完成");
	}

	public void buy(){
		System.out.println("通过代理购得:");
		showticket();
	}
}

public class ProxyPattern{
	public static void main(String[] args){
		BuyTicket x=new Train();   //利用多态实现代理模式
		TicketCenter y=new TicketCenter(x);
		y.buy();
	}
}