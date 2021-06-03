package com.project.rms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Trains")
public class Trains {
	
	@Id
	String trainId;
	
	String trainNumber;
	String trainName;
	String trainBoardingStation;
	String trainDeboardingStation;
	String trainRunningDate;
	String trainArrivalTime;
	String trainDepartureTime;
	String numberOfSeats;
	String trainFare;
	
	public Trains() {
		
	}
	
	public Trains(String trainNumber, String trainName, String trainBoardingStation, String trainDeboardingStation,
			String trainRunningDate, String trainArrivalTime, String trainDepartureTime, String numberOfSeats,
			String trainFare) {
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.trainBoardingStation = trainBoardingStation;
		this.trainDeboardingStation = trainDeboardingStation;
		this.trainRunningDate = trainRunningDate;
		this.trainArrivalTime = trainArrivalTime;
		this.trainDepartureTime = trainDepartureTime;
		this.numberOfSeats = numberOfSeats;
		this.trainFare = trainFare;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainBoardingStation() {
		return trainBoardingStation;
	}

	public void setTrainBoardingStation(String trainBoardingStation) {
		this.trainBoardingStation = trainBoardingStation;
	}

	public String getTrainDeboardingStation() {
		return trainDeboardingStation;
	}

	public void setTrainDeboardingStation(String trainDeboardingStation) {
		this.trainDeboardingStation = trainDeboardingStation;
	}

	public String getTrainRunningDate() {
		return trainRunningDate;
	}

	public void setTrainRunningDate(String trainRunningDate) {
		this.trainRunningDate = trainRunningDate;
	}

	public String getTrainArrivalTime() {
		return trainArrivalTime;
	}

	public void setTrainArrivalTime(String trainArrivalTime) {
		this.trainArrivalTime = trainArrivalTime;
	}

	public String getTrainDepartureTime() {
		return trainDepartureTime;
	}

	public void setTrainDepartureTime(String trainDepartureTime) {
		this.trainDepartureTime = trainDepartureTime;
	}

	public String getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getTrainFare() {
		return trainFare;
	}

	public void setTrainFare(String trainFare) {
		this.trainFare = trainFare;
	}

	@Override
	public String toString() {
		return "Trains [trainId=" + trainId + ", trainNumber=" + trainNumber + ", trainName=" + trainName
				+ ", trainBoardingStation=" + trainBoardingStation + ", trainDeboardingStation="
				+ trainDeboardingStation + ", trainRunningDate=" + trainRunningDate + ", trainArrivalTime="
				+ trainArrivalTime + ", trainDepartureTime=" + trainDepartureTime + ", numberOfSeats=" + numberOfSeats
				+ ", trainFare=" + trainFare + "]";
	}

}
