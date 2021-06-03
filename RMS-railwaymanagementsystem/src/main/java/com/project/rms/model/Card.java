package com.project.rms.model;

import org.springframework.data.annotation.Id;

public class Card {
	
	@Id
	String cardId;
	
	String nameOnCard;
	String cardNo;
	String expiryDate;
	String cardCVV;
	
	public Card() {
		
	}
	
	public Card(String nameOnCard, String cardNo, String expiryDate, String cardCVV) {
		this.nameOnCard = nameOnCard;
		this.cardNo = cardNo;
		this.expiryDate = expiryDate;
		this.cardCVV = cardCVV;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", nameOnCard=" + nameOnCard + ", cardNo=" + cardNo + ", expiryDate="
				+ expiryDate + ", cardCVV=" + cardCVV + "]";
	}
	
}
