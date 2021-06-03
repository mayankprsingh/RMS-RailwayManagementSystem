package com.project.rms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tickets")
public class Ticket {
	
	@Id
	String ticketId;
	
	String pnrNumber;
	String ticketBookedDate;
	String journeyDate;
	User user;
	Trains train;
	String coachNumber;
	String seatNumber;
	String ticketFair;
	
	public Ticket() {
		
	}
	
	public Ticket(String pnrNumber, String ticketBookedDate, String journeyDate, User user, Trains train,
			String coachNumber, String seatNumber, String ticketFair) {
		this.pnrNumber = pnrNumber;
		this.ticketBookedDate = ticketBookedDate;
		this.journeyDate = journeyDate;
		this.user = user;
		this.train = train;
		this.coachNumber = coachNumber;
		this.seatNumber = seatNumber;
		this.ticketFair = ticketFair;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getTicketBookedDate() {
		return ticketBookedDate;
	}

	public void setTicketBookedDate(String ticketBookedDate) {
		this.ticketBookedDate = ticketBookedDate;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trains getTrain() {
		return train;
	}

	public void setTrain(Trains train) {
		this.train = train;
	}

	public String getCoachNumber() {
		return coachNumber;
	}

	public void setCoachNumber(String coachNumber) {
		this.coachNumber = coachNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getTicketFair() {
		return ticketFair;
	}

	public void setTicketFair(String ticketFair) {
		this.ticketFair = ticketFair;
	}
	
}
